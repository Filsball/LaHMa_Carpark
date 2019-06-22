package states;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;

public class AnsichtsAuswahlState extends ServletState {
	public static AnsichtsAuswahlState startSeitePointer;
	
	public AnsichtsAuswahlState(LaHMa_Controller controller, String viewName) {
		super(controller,viewName);
	}

	
	
	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {

	}

}
