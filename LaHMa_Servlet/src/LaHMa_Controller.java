import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LaHMa_Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LaHMa_DB bean;
	
	public void init() throws ServletException{
		bean = new LaHMa_DB();
		update();
	}	
	public void update() {
		getServletContext().setAttribute("Bean", bean);
	}
	public void doGet(	HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException{
		
		System.out.println("getbekommen");
		String ergebnis = request.getParameter("method");
		System.out.println(ergebnis);
		if(ergebnis == null) {request.getRequestDispatcher("/WEB-INF/Startseite.jsp").forward(request, response);return;}
		switch(ergebnis) {
			case "einfahren" : System.out.println("hi"); break;
			
			default : request.getRequestDispatcher("/WEB-INF/Startseite.jsp").forward(request, response); 
		}
		
		request.setAttribute("result", "This is the result of the servlet call");
		request.getRequestDispatcher("/WEB-INF/Startseite.jsp").forward(request, response);
		
		
	}

}
