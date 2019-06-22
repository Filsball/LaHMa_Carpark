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
	
	
	//Gibt die aktuell freien Plätze zurück
	public static int getTicketZahl() {
		return Parkhaus.getSpots();
	}
	
	//Neues Ticket wird erstellt
	public static Ticket newTicket() {
		Ticket t = new Ticket();	
		Parkhaus.platzBelegen();		//Freie Plätze--
		aktiveTickets.add(t);	//Ticket der Liste hinzufügen
		return t;
	}
	
	//Brauch ich das??!! JA!
	public static void setEndZeit(Ticket t, Date ende) {
		
		t.setEntZeit(ende);	
	}
	
	//Wird aufgerufen bei Verification wenn Ticket korrekt entwertet ist
	public static void ticketIstAusgefahren(Ticket t) {
		
		abgeschlosseneTickets.add(t);	//Ticket wird den Abgeschlossenen hinzugegfügt
		aktiveTickets.remove(t);		//Ticket wird aus aktiver Liste entfernt
		Parkhaus.platzFreigeben();				//freie Plätze++
	}
	
	//gibt den Stundensatz zurück
	public static int getPricePerHour() {
		return Parkhaus.getPrice();
	}
	
	//Gibt Liste Aktiver Tickets zurück
	public static List<Ticket> getAktList() {
		return aktiveTickets;
	}
	
	//Gibt Liste abgeschlossener Tickets zurück
	public static List<Ticket> getAbList() {
		return abgeschlosseneTickets;
	}	
	
	//Wird nach Bezahlung des ErsatzTicket aufgerufen
	//Gibt ErsatzTicket zurück
	public static Ticket lostTicket() {
		Parkhaus.platzFreigeben();			//Freie Plätze++
		Ticket t = newTicket();		//Neues Ticket
		setEndZeit(t, new Date(System.currentTimeMillis()));				//Entwertzeit wird direkt gesetzt, weil bezahlt
		t.setPreis(3000);			//Instanzvariable Preis wird gesetzt (TagesSatz + Gebühr)
		
		return t;
		
	}
}
