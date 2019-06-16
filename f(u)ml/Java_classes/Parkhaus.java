
public class Parkhaus {
	
	private static int spots = 2;
	private static Parkhaus instance = new Parkhaus();
	
	private Parkhaus() {
		
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

	
	

}
