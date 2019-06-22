package states;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;

public class AboManagementState extends ServletState {

	public AboManagementState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		
	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {

	}

}
