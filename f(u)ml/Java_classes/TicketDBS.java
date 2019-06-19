import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* -Arbeitet mit Instanz des Parkhauses.
   -Hat Listen f�r aktuelle und abgeschlossene Tickets
   -newTicket() erstellt und liefert ein Ticket. Ruft platzBelegen() auf und f�gt das Ticket
    der Liste f�r aktuelle Tickets Hinzu. Wird von der Klasse "LoeseTicket" aufgerufen.
   -ticketIstAusgefahren() f�gt ein Ticket der Liste der abgeschlossenen Tickets hinzu und 
    entfernt es aus der der aktuellen. Ruft platzFreigeben() auf. 
    Wird von der Klasse "Verification" aufgerufen.
 */

public class TicketDBS {

	private static  Parkhaus p = Parkhaus.getInstance();
	
	private static List<Ticket> aktiveTickets = new ArrayList<Ticket>();
	
	private static List<Ticket> abgeschlosseneTickets = new ArrayList<Ticket>();
	
	
	//Gibt die aktuell freien Pl�tze zur�ck
	public static int getTicketZahl() {
		return p.getSpots();
	}
	
	//Neues Ticket wird erstellt
	public static Ticket newTicket() {
		Ticket t = new Ticket();	
		p.platzBelegen();		//Freie Pl�tze--
		aktiveTickets.add(t);	//Ticket der Liste hinzuf�gen
		return t;
	}
	
	//Brauch ich das??!! JA!
	public static void setEndZeit(Ticket t) {
		
		t.setEntZeit(new Date());	
	}
	
	//Wird aufgerufen bei Verification wenn Ticket korrekt entwertet ist
	public static void ticketIstAusgefahren(Ticket t) {
		
		abgeschlosseneTickets.add(t);	//Ticket wird den Abgeschlossenen hinzugegf�gt
		aktiveTickets.remove(t);		//Ticket wird aus aktiver Liste entfernt
		p.platzFreigeben();				//freie Pl�tze++
	}
	
	//gibt den Stundensatz zur�ck
	public static int getPricePerHour() {
		return p.getPrice();
	}
	
	//Gibt Liste Aktiver Tickets zur�ck
	public static List getAktList() {
		return aktiveTickets;
	}
	
	//Gibt Liste abgeschlossener Tickets zur�ck
	public static List getAbList() {
		return abgeschlosseneTickets;
	}	
	
	//Wird nach Bezahlung des ErsatzTicket aufgerufen
	//Gibt ErsatzTicket zur�ck
	public static Ticket lostTicket() {
		p.platzFreigeben();			//Freie Pl�tze++
		Ticket t = newTicket();		//Neues Ticket
		setEndZeit(t);				//Entwertzeit wird direkt gesetzt, weil bezahlt
		t.setPreis(3000);			//Instanzvariable Preis wird gesetzt (TagesSatz + Geb�hr)
		
		return t;
		
	}
}
