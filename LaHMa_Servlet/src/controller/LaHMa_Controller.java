package controller;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.states.AboManagementState;
import controller.states.AbozahlAnpassungState;
import controller.states.AnsichtsAuswahlState;
import controller.states.BilanzAnzeigeState;
import controller.states.EinfahrState;
import controller.states.ManagerAnsichtState;
import controller.states.PreisAnpassungState;
import controller.states.SelectingTicketState;
import controller.states.ServletState;
import controller.states.TicketAutomatState;
import model.LaHMa_DB;

public class LaHMa_Controller extends HttpServlet {

	class Pair {
		public String event;
		public ServletState state;
		
		public Pair(String event, ServletState state) {
			this.event = event;
			this.state = state;
		}
	}
	
	private ServletState state;
	
	private static final long serialVersionUID = 1L;
	private LaHMa_DB bean;
	
	public void init() throws ServletException{
		bean = new LaHMa_DB();
		update();
		
		System.out.println("initializing state pattern...");
		AbozahlAnpassungState editAbo = new AbozahlAnpassungState(this,"EditAbo");
		AboManagementState manageAbo = new AboManagementState(this,"ManageAbo");
		TicketAutomatState ticketAutomat = new TicketAutomatState(this,"Ticketautomat");
		AnsichtsAuswahlState ansicht = new AnsichtsAuswahlState(this,"Startseite");
		BilanzAnzeigeState bilanz = new BilanzAnzeigeState(this,"Bilanz");
		EinfahrState einfahr = new EinfahrState(this,"Einfahrautomat");
		SelectingTicketState selectTicket = new SelectingTicketState(this,"Entwerten");
		ManagerAnsichtState manager = new ManagerAnsichtState(this,"Manager");
		PreisAnpassungState preis  = new PreisAnpassungState(this,"Preisanpassung");
		
		ansicht.setStateMap( generateStateMap( 
				new Pair("einfahren",einfahr),
				new Pair("manager",manager),
				new Pair("ticketAutomat",ticketAutomat)
		));
		
		ticketAutomat.setStateMap( generateStateMap( 
				new Pair("updatePrice",ticketAutomat),
				new Pair("beglichen", ansicht),
				new Pair("back",ansicht)
		));
		
		manager.setStateMap( generateStateMap( 
				new Pair("bilanz",bilanz),
				new Pair("abo", editAbo),
				new Pair("preis",preis),
				new Pair("back",ansicht)				
		));

		bilanz.setStateMap( generateStateMap( 
				new Pair("updateBilanzType",bilanz),
				new Pair("back",manager)				
		));
		
		preis.setStateMap( generateStateMap( 
				new Pair("setPreis",preis),
				new Pair("back",manager)				
		));

		editAbo.setStateMap( generateStateMap( 
				new Pair("setPreis",preis),
				new Pair("back",manager)				
		));

		einfahr.setStateMap( generateStateMap( 
				new Pair("scanneAbo",einfahr),
				new Pair("getTicket",einfahr),
				new Pair("back",ansicht)				
		));

		ticketAutomat.setStateMap( generateStateMap( 
				new Pair("entwerten",selectTicket),
				new Pair("abo",manageAbo),
				new Pair("back",ansicht)		
		));

		selectTicket.setStateMap( generateStateMap( 
				new Pair("entwerteTicket",ticketAutomat)		
		));
		
		manageAbo.setStateMap( generateStateMap( 
				new Pair("cancel",manageAbo),
				new Pair("abschließen",manageAbo),
				new Pair("back",ticketAutomat)				
		));

		selectTicket.setStateMap( generateStateMap( 
				new Pair("updatePreis",selectTicket),
				new Pair("back",ticketAutomat)				
		));
		AnsichtsAuswahlState.startSeitePointer = ansicht;
		state = ansicht;
		
		System.out.println("inizailizing complete.");
	}	
	
	public Map<String,ServletState> generateStateMap(Pair... pairs) {
		Map<String,ServletState> map = new HashMap<>();
		Arrays.asList(pairs).forEach(pair -> map.put(pair.event.toUpperCase(), pair.state));;
		return map;
	}
	
	public void update() {
		getServletContext().setAttribute("Bean", bean);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		if(request.getQueryString() == null || request.getQueryString().isEmpty()) {
			state = AnsichtsAuswahlState.startSeitePointer;
		}
		System.out.println("State: "+state);
		String event = request.getParameter("method");	
		System.out.println(event);
		state.processGetRequestAndChangeState(request, response);
	}

	public ServletState setState(ServletState servletState) {
		return (state = servletState);
	}

}
