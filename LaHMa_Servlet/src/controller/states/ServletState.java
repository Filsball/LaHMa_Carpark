package controller.states;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.FreeSpots;
import controller.LaHMa_Controller;
import model.Parkhaus;

public abstract class ServletState {
	public String viewName = "";
	
	LaHMa_Controller controller;
	Map<String, ServletState> eventsToStates; // Map of Events with corresponding States. Example: "loeseTicket" -> EinfahrenState
	
	public ServletState(LaHMa_Controller controller, String viewName) {
		this.controller = controller;		
		this.viewName = viewName;
	}
	
	public void setStateMap(Map<String,ServletState> map) {
		this.eventsToStates = map;
	}

	public void processGetRequestAndChangeState(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		processGetRequest(request,response);
		
		
		String event = request.getParameter("method");
		ServletState s = this;
		if(event != null) {
			s = changeState(event);
			System.out.println("trying to swap to :"+s);
			if(s == null) {
				s = this;
				controller.setState(this);
			}
		}
		request.setAttribute("freeSpots", FreeSpots.getFreeSpots());
		if(event != null && event.equals("Playground"))
			request.getRequestDispatcher("/WEB-INF/Playground.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/WEB-INF/"+s.viewName+".jsp").forward(request, response);
	}

	public abstract void processGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
	public abstract void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
	
	
	public ServletState changeState(String event) {
		return controller.setState(eventsToStates.get(event.toUpperCase()));
	}
	
	public String toString() {
		return viewName+".jsp";
	}
}
