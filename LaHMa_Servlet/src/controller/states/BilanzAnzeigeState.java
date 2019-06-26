package controller.states;



import java.util.Date;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LaHMa_Controller;
import model.TicketDBS;

public class BilanzAnzeigeState extends ServletState {

	public BilanzAnzeigeState(LaHMa_Controller controller, String viewName) {
		super(controller, viewName);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		String req = request.getParameter("method");
		if (req.equals("Tagesbilanz")) {
			int[]hours= new int[24];
			Date akt = new Date();
			IntStream.range(0, 24).forEach( i -> {hours[i] = TicketDBS.getAbList().stream()
					.filter(tickets -> tickets.getEnt().getYear()==akt.getYear()
					&&tickets.getEnt().getMonth()==akt.getMonth()
					&&tickets.getEnt().getDate()==akt.getDate()
					&&tickets.getEnt().getHours()==i)
					.mapToInt(tickets -> tickets.getPreis())
					.reduce(0, Integer::sum);
					System.out.println(hours[i]);});
					
		}else if(req.equals("Monatsbilanz")) {
			int[]days= new int[31];
			Date akt = new Date();
			IntStream.range(0, 31).forEach( i -> {days[i] = TicketDBS.getAbList().stream()
					.filter(tickets -> tickets.getEnt().getYear()==akt.getYear()
					&&tickets.getEnt().getMonth()==akt.getMonth()
					&&tickets.getEnt().getDate()==i+1)
					.mapToInt(tickets -> tickets.getPreis())
					.reduce(0, Integer::sum);
					System.out.println(days[i]);});
		}else if(req.equals("Jahresbilanz")) {
			int[]months= new int[12];
			Date akt = new Date();
			IntStream.range(0, 12).forEach( i -> {months[i] = TicketDBS.getAbList().stream()
					.filter(tickets -> tickets.getEnt().getYear()==akt.getYear()
					&&tickets.getEnt().getMonth()==i)
					.mapToInt(tickets -> tickets.getPreis())
					.reduce(0, Integer::sum);
					System.out.println(months[i]);
			});
		}
	}

	@Override
	public void processPostRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
}
