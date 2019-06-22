package model;

/* -Pattern: singleton. Zugriff mit "Parkhaus p = Parkhaus.getInstance();"
   -Die Methoden platzBelegen() und platzFreigeben in- bzwe decrementieren die Klassenvariable 
    spots und werden in der Klasse TicketDBS aufgerufen wenn ein Ticket erstellt wird, 
    bzw eines Ausf�hrt/verifiziert wird.
 */

public class Parkhaus {
	
	private static int spots;
	private static int maxAbo;
	private static int aboPreis;
	private static int ticketPreis;
	private static Parkhaus instance = new Parkhaus();
	
	private Parkhaus() {
		spots = 20;
		maxAbo = 5;
		aboPreis = 10000;
		ticketPreis = 100;	
	}
	
	 public static Parkhaus getInstance () {
		    if (Parkhaus.instance == null) {
		      Parkhaus.instance = new Parkhaus ();
		    }
		    return Parkhaus.instance;
		  }
	public static int getSpots() {
		return spots;
	}
	
	public static void platzBelegen() {
		spots--;
	}
	
	public static void platzFreigeben() {
		spots++;
	}
	
	public static int getMaxAbo() {
		return maxAbo;
	}
	
	public static int getPrice() {
		return ticketPreis;
	}
	public static int getAboPrice() {
		return aboPreis;
	}

	
	

}
