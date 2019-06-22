package states;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;

public class AbozahlAnpassungState extends ServletState {
	public final String view = "AbozahlAnpassung";

	public AbozahlAnpassungState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
