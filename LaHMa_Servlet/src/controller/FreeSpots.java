package controller;
import model.AboDBS;
import model.TicketDBS;

/*    -calcSpots() rechnet FreieParkpl�tzeminus aktuell aktive Abos * 0.95 (Archslochtoleranz)
	   -checkIfFree() berechnet mit Hilfe der AboDBS die Anzahl an derzeit aktiven Abos und
	    ruft anschlie�end calcSpots mit diesem und mit dem Wert der absolut freien Pl�tze
	    auf und liefert einen boolean je nach dem ob > 0.
 */

public class FreeSpots {
	


	public static  boolean checkIfFree() {
		int aktiveAbos = AboDBS.getMaxAbos()-AboDBS.getFreeAbos();
		return (calcSpots(TicketDBS.getTicketZahl(),aktiveAbos))>0;
	}
	
	public static int calcSpots(int free, int aktiveAbos) {
		
		return (int)((free-aktiveAbos)*0.95);
	}
}
