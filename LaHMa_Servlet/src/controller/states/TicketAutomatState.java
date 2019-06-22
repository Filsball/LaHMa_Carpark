package controller.states;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;
import controller.TicketEntwertung;
import model.Ticket;

public class TicketAutomatState extends ServletState {

	public TicketAutomatState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		String event = request.getParameter("method");
		System.out.println("Ticketautomat.process");
		switch(event) {
			case "selectTicket" : 
				request.setAttribute("answereMethod", "entwerteTicket");
			break;
			case "entwerteTicket" : 
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
