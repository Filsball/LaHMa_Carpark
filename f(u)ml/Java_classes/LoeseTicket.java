
public class LoeseTicket {
	
	/* -getTicket() pr�ft per FreeSpots ob Pl�tze frei sind. 
	 *  Falls ja wird die newTicket() Methode der TicketDBS ausgef�hrt. */

	public static Ticket getTicket() {
		
		if(FreeSpots.checkIfFree()) {
			Ticket t = TicketDBS.newTicket();
			System.out.println("Das Ticket mit der ID: " + t.getId() + " wurde gedruckt");
			
			oeffneSchranke();
			return t;
			
		}else {
			System.out.println("Derzeit sind keine Parkpl�tze verf�gbar");
			return null;
		}
	}
	
	public static void oeffneSchranke() {
		System.out.println("Schranke �ffnet");
		
	}
}
