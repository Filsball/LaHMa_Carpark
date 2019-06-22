package controller;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

import model.Abo;
import model.Parkhaus;
import model.Ticket;

public class Helper {
	
	public static void main (String[]args) throws InterruptedException {
		
		Parkhaus p = Parkhaus.getInstance();
		
	/*	Ticket t1 = LoeseTicket.getTicket();
		Thread.sleep(2000);
		Verification.checkTicket(t1);
		Ticket t2 = LoeseTicket.getTicket();
		Thread.sleep(61000);	
		Ticket t3 = LoeseTicket.getTicket();
		Thread.sleep(1000);
		Ticket t4 = LoeseTicket.getTicket();
		Thread.sleep(1000);
		System.out.println("******Ticket 2 entwertet sich");
		TicketEntwertung.entwerteTicket(t2);
		Thread.sleep(10000);
		System.out.println("******Ticket zwei f�hrt aus");
		Verification.checkTicket(t2);
		Thread.sleep(2000);
		System.out.println("******Ein ersatz Ticket wird angefordert");
		Ticket lost = Lost.createNewTicket();
		Thread.sleep(2000);
		System.out.println("******das ersatzTicket f�hrt aus");
		Verification.checkTicket(lost);
		
		System.out.println("");
		System.out.println("Freie pl�tze: " + TicketDBS.getTicketZahl());
		System.out.println("");
		System.out.println("aktive Tickets: "+ TicketDBS.getAktList().size() + "	davon eine TicketLeiche");
		System.out.println("");
		System.out.println("abgeschlossene Tickets: " + TicketDBS.getAbList().size());
		
		*/
		
		
		
		
		Abo a1 = AboHandling.aboAbschliessen("LarsWiebach", "1234");
		Thread.sleep(1000);
		Abo a2 = AboHandling.aboAbschliessen("hans raderrscheid", "siebenAuge93");
		Thread.sleep(1000);
		Abo a3 = AboHandling.aboAbschliessen("felix b�chner", "kopfnuss1");
		Thread.sleep(1000);
		Abo a4 = AboHandling.aboAbschliessen("michael klein", "234123");
		Thread.sleep(1000);
		Abo a5 = AboHandling.aboAbschliessen("Feser Max", "rini786");
		Thread.sleep(1000);
		AboHandling.aboKuendingen(a2);
		Thread.sleep(1000);
		
		Abo a6 = AboHandling.aboAbschliessen("domian haderfeld", "dodo2");
		AboHandling.aboVerloren(); 
		
		Verification.checkAboId(4);
		
	/*	Ticket t1 = LoeseTicket.getTicket();
		Thread.sleep(2000);
		Ticket t2 = LoeseTicket.getTicket();
		Thread.sleep(61000);	
		Ticket t3 = LoeseTicket.getTicket();
		Thread.sleep(1000);
		Ticket t4 = LoeseTicket.getTicket();
		Thread.sleep(1000);
		
		System.out.println("");
		
		toString(TicketDBS.getAktList());
		
		System.out.println("");
		
		TicketEntwertung.entwerteTicket(t2);
		
		toString(TicketDBS.getAktList());
		
		System.out.println("");
		
		toString(TicketDBS.getAbList()); */
	}
	
	public static void toString(List<Ticket> t) {
		for(Ticket a: t ) {
			System.out.println(a.getId());
			System.out.println(a.getStart());
			System.out.println(a.getEnt());
			System.out.println(a.getPreis());
		}
	}
	
	
	

}
