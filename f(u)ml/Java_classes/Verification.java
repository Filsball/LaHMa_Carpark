import java.util.Date;
import java.util.concurrent.SynchronousQueue;


/*	-calcIfEntwertet() bekommt die Entwertungszeit eines Ticketsübergeben
 *  und verrechnet diese mit der aktuellen Zeit. Ist die Differenz 
 *  kleiner als 20 min (1.200.00 ms) wird ein true zurückgegeben.
 *	-checkTicket() bekommt ein Ticket übergeben. Ist die Entwertungszeit des
 *	Tickets != null und calcIfEntwertet == true wird die Ausfahrt zugelassen 
 *	und ruft ticketIstAusgefahren() in der TicketDBS auf.
 */


public class Verification {

	public static void checkTicket(Ticket t) {

		if(t.getEnt()!=null) {
			if(calcIfEntwertet(t.getEnt())) {
				TicketDBS.ticketIstAusgefahren(t);
				System.out.println("Ticket ist entwertet. Schranke öffnet. Auf Wiedersehen :)");
				
			}else {
				System.out.println("Ticket bitte neu entwerten lassen");
			}
		}else {
			System.out.println("Ticket bitte entwerten lassen");
		}
	}

	public static boolean calcIfEntwertet( Date ticket) {

		Date aktuell = new Date();
		long aktuellL = aktuell.getTime();
		
		return (aktuellL-ticket.getTime())<1_200_000.0;
	}

	public boolean checkAboId(int id) {

		return false;
	}
	
	public int getAboByIdentity(){
		
		return 0;
	}
	
	public void gatherIdentity() {
		
	}
	
	
}
