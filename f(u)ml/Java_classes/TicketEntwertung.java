import java.util.Date;

/* -calcTicketPreis() berechnet wie viele Stunden die Parkdauer betrug und verrechnet
 *  diese mit dem Stundensatz und gibt den Preis in Euro-Cents zur�ck.
 *  aktuell nicht f�r jede angebrochene Stunde ein fester Satz sondern...naja halt anders*
 * -entwerteTicket() bekommt ein Ticket �bergeben und setzt dessen EntwertungZeit. 
 *  Mit der Start- und Entwertungszeit wird calcTicketPreis()  aufgrufen. Es wird die 
 *  Instanzvariable Preis des Tickets gesetzt und payTicket() wird ausgef�hrt. 
    
******Aktuell gibt payTicket nur einen String aus.******

******Aktuell ist es so implementiert dass das Ticket hier auch direkt ausf�hrt. 
      Sp�tter wird das in die Verification Klasse verschoben*****

 *  */

public class TicketEntwertung {

	public static void payTicket(int preis) {

		System.out.println("Der Preis des Tickets betr�gt: " + preis + " Cents");

	}

	public static void entwerteTicket(Ticket t) {

		TicketDBS.setEndZeit(t);
		Date[] d = { t.getStart(), t.getEnt() };
		int preis = calcTicketPrice(d);
		payTicket(preis);
		t.setPreis(preis);
		TicketDBS.ticketIstAusgefahren(t);

	}

	// Brauch ich das?
	public Date getTicketTime(Ticket t) {

		return null;

	}

	public static int calcTicketPrice(Date[] d) { // [start, entwerttime]

		double interval = d[1].getTime() - d[0].getTime();
		interval = interval / 3_600_000;

		return (int) (interval * TicketDBS.getPricePerHour());
	}
}
