
public class Lost {

	public static Ticket createNewTicket() {
		
		System.out.println("Sie Haben ihr Ticket verloren? Echt jetz? /n Das ist ja super!");
		System.out.println("Zu zahlen ist der Tagessatz plus Gebühr");
		//Hier dann BezahlVorgang
		Ticket t = TicketDBS.lostTicket();
		System.out.println("Ihr Ticket mit der ID: " + t.getId() + " wurde gedruckt.");
		System.out.println("Der Preis betrug: " + t.getPreis() + "Cents");
		return t;
		 
		
		
		
		
	}
	
	public void getAboErsatz(Abo abo) {
		
	}
}
