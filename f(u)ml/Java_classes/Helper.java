import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class Helper {
	
	public static void main (String[]args) throws InterruptedException {
		
		Parkhaus p = Parkhaus.getInstance();
		
		Ticket t1 = LoeseTicket.getTicket();
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
		
		toString(TicketDBS.getAbList());
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
