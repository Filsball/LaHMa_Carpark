package controller.states;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;
import controller.LoeseTicket;

public class EinfahrState extends ServletState {

	public EinfahrState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		String req = request.getParameter("method");
		if (req.equals("getTicket")) {
			LoeseTicket.getTicket();			
		}
	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {

	}


}
