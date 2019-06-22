package controller.states;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;
import controller.LoeseTicket;
import model.AboDBS;
import model.TicketDBS;

public class BilanzAnzeigeState extends ServletState {

	public BilanzAnzeigeState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		String req = request.getParameter("method");
		if (req.equals("Tagesbilanz")) {
			Date akt = new Date();
			int sum = TicketDBS.getAbList().stream()
					.filter(tickets -> tickets.getEnt().getDay()==akt.getDay()
					&&tickets.getEnt().getMonth()==akt.getMonth()
					&&tickets.getEnt().getYear()==akt.getYear())
					.mapToInt(tickets -> tickets.getPreis())
					.reduce(0, Integer::sum);
			System.out.println(sum);
					
		}else if(req.equals("Monatsbilanz")) {
			Date akt = new Date();
			int sum = TicketDBS.getAbList().stream()
					.filter(tickets -> tickets.getEnt().getMonth()==akt.getMonth()
					&&tickets.getEnt().getYear()==akt.getYear())
					.mapToInt(tickets -> tickets.getPreis())
					.reduce(0, Integer::sum);
			System.out.println(sum);
		}else if(req.equals("Jahresbilanz")) {
			Date akt = new Date();
			int sum = TicketDBS.getAbList().stream()
					.filter(tickets -> tickets.getEnt().getYear()==akt.getYear())
					.mapToInt(tickets -> tickets.getPreis())
					.reduce(0, Integer::sum);
			System.out.println(sum);
			
		}

	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
}
