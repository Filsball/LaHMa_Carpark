import java.util.Date;


/*	-calcIfEntwertet() bekommt die Entwertungszeit eines Ticketsübergeben
 *  und verrechnet diese mit der aktuellen Zeit. Ist die Differenz 
 *  kleiner als 20 min (1.200.00 ms) wird ein true zurückgegeben.
 *	-checkTicket() bekommt ein Ticket übergeben. Ist die Entwertungszeit des
 *	Tickets != null und calcIfEntwertet == true wird die Ausfahrt zugelassen 
 *	und ruft ticketIstAusgefahren() in der TicketDBS auf.
 */


public class Verification {

	//Ausfahrt NormalKunde
	public static boolean checkTicket(Ticket t) {

		if(t.getEnt()!=null) {
			if(calcIfEntwertet(t.getEnt())) {
				TicketDBS.ticketIstAusgefahren(t);
				System.out.println("Ticket ist entwertet. Schranke öffnet. Auf Wiedersehen :)");
				return true;
			}else {
				System.out.println("Ticket bitte neu entwerten lassen");
				return false;
			}
		}else {
			System.out.println("Ticket bitte entwerten lassen");
			return false;
		}
	}
	
	//Berechnet ob das Zeitintervall zwischen Entwertung und Ausfahrt überschritten ist
	public static boolean calcIfEntwertet( Date ticket) {

		Date aktuell = new Date(System.currentTimeMillis());
		long aktuellL = aktuell.getTime();
		
		return (aktuellL-ticket.getTime())<1_200_000.0;
	}

	
	//An Ein- und Ausfahrt, checkt ob ID einem Abo zugehörig ist.
	public static boolean checkAboId(int i) {
		
		System.out.println("Abo-Ticket scannen");
		
		for(Abo j: AboDBS.getAktuelleAbos()) {
			if(j.getId()==i) {
				System.out.println("Abo-Ticket gültig.");
				return true;
			}
		}
		System.out.println("Ticket ungültig");
		return false;
		
	}
	
	public int getAboByIdentity(){
		
		return 0;
	}
	
	public void gatherIdentity() {
		
	}
	
	
}
