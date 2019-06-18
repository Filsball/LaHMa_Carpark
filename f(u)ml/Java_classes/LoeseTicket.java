
public class LoeseTicket {
	
	/* -getTicket() prüft per FreeSpots ob Plätze frei sind. 
	 *  Falls ja wird die newTicket() Methode der TicketDBS ausgeführt. */

	public static Ticket getTicket() {
		
		if(FreeSpots.checkIfFree()) {
			Ticket t = TicketDBS.newTicket();
			System.out.println("Das Ticket mit der ID: " + t.getId() + " wurde gedruckt");
			
			oeffneSchranke();
			return t;
			
		}else {
			System.out.println("Derzeit sind keine Parkplätze verfügbar");
			return null;
		}
	}
	
	public static void oeffneSchranke() {
		System.out.println("Schranke öffnet");
		
	}
}
