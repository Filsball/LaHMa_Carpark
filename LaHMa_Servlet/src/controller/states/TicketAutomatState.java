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

	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {
		String event = request.getParameter("method").toLowerCase();
		switch(event) {
			case "entwerten" : 
				request.setAttribute("answereMethod", "entwerteTicket");
			break;
			case "entwerteTicket" : 
				Ticket t = (Ticket) request.getAttribute("ticket");
				TicketEntwertung.entwerteTicket(t);
				request.setAttribute("ticket", t);
			break;
		}
	}


}
