package controller.states;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;
import controller.TicketEntwertung;
import model.Ticket;
import model.TicketDBS;

public class SelectingTicketState extends ServletState {

	public SelectingTicketState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {
		int ticketID = Integer.parseInt(request.getParameter("ticketID"));
		Ticket ticket = TicketDBS.getAktList().stream().filter(t -> t.getId() == ticketID).findFirst().get();
		request.setAttribute("ticket", ticket);
		String answereMethod = request.getParameter("method");
		changeState(answereMethod);
	}


}
