import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* -Arbeitet mit Instanz des Parkhauses.
   -Hat Listen für aktuelle und abgeschlossene Tickets
   -newTicket() erstellt und liefert ein Ticket. Ruft platzBelegen() auf und fügt das Ticket
    der Liste für aktuelle Tickets Hinzu. Wird von der Klasse "LoeseTicket" aufgerufen.
   -ticketIstAusgefahren() fügt ein Ticket der Liste der abgeschlossenen Tickets hinzu und 
    entfernt es aus der der aktuellen. Ruft platzFreigeben() auf. 
    Wird von der Klasse "Verification" aufgerufen.
 */

public class TicketDBS {

	private static  Parkhaus p = Parkhaus.getInstance();
	
	private static List<Ticket> aktiveTickets = new ArrayList<Ticket>();
	
	private static List<Ticket> abgeschlosseneTickets = new ArrayList<Ticket>();
	
	public static int getTicketZahl() {
		return p.getSpots();
	}
	
	public static Ticket newTicket() {
		Ticket t = new Ticket();
		p.platzBelegen();
		aktiveTickets.add(t);
		return t;
	}
	
	//Brauch ich das??!!
	public static void setEndZeit(Ticket t) {
		
		t.setEntZeit(new Date());	
	}
	
	public static void ticketIstAusgefahren(Ticket t) {
		
		abgeschlosseneTickets.add(t);
		aktiveTickets.remove(t);
		p.platzFreigeben();
	}
	
	public static int getPricePerHour() {
		return p.getPrice();
	}
	
	public static List getAktList() {
		return aktiveTickets;
	}
	
	public static List getAbList() {
		return abgeschlosseneTickets;
	}	
}
