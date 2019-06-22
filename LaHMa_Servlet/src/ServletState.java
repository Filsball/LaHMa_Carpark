import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletState {
	LaHMa_Controller controller;
	HashMap<String, ServletState> eventsToStates; // Map of Events with corresponding States. Example: "loeseTicket" -> EinfahrenState
	
	public ServletState(LaHMa_Controller controller) {
		this.controller = controller;		
	}
	
	public abstract void processGetRequest(HttpServletRequest request, HttpServletResponse response);
	public abstract void processPostRequest(HttpServletRequest request, HttpServletResponse response);
	
	public ServletState nextState(String event) {
		return eventsToStates.get(event);
	}
}
