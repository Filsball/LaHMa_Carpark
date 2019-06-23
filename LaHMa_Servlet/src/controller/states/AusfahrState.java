package controller.states;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;
import controller.Verification;
import model.Ticket;

public class AusfahrState extends ServletState {

	public AusfahrState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String event = request.getParameter("method");
		System.out.println("Processing Ausfahren with "+event);
		
		switch(event) {
			case "selectTicket" : 
				request.setAttribute("answereMethod", "fahreTicketAus");
			break;
			case "fahreTicketAus" : 
				Ticket t = (Ticket) request.getAttribute("ticket");
				Verification.checkTicket(t);
				request.setAttribute("ticket", t);
			break;
		}
	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

}
