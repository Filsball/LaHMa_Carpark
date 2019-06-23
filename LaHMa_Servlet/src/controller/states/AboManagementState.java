package controller.states;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AboHandling;
import controller.LaHMa_Controller;
import controller.TicketEntwertung;
import model.Ticket;

public class AboManagementState extends ServletState {

	public AboManagementState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		String event = request.getParameter("method");
		
		switch(event) {
			case "abschliessen" : 
				AboHandling.aboAbschliessen("Hanna", "Freudenberger");
			break;
			case "cancel" : 
				Ticket t = (Ticket) request.getAttribute("ticket");
				TicketEntwertung.entwerteTicket(t);
				System.out.println("Setting entwertet Ticket: ");
				request.setAttribute("ticket", t);
			break;
			
		}
		
	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {

	}

}
