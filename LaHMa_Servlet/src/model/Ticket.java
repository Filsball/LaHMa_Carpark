package model;
import java.util.Date;

public class Ticket {

	private static int idCounter = 1;
	private int id;
	private Date startZeit;
	private Date entwertZeit;
	private int preis;
	
	
	public Ticket() {
		this.startZeit = new Date(System.currentTimeMillis()); 	//System.currentTimeMillis()
		id = idCounter;
		idCounter++;
		preis = 0;
		
		
	}
	
	public int getId() {
		return id;
	}
	
	public Date getStart() {
		return startZeit;
	}
	
	public Date getEnt() {
		return entwertZeit;
	}
	
	public int getPreis() {
		return preis;
	}
	
	public void setEntZeit(Date e) {
		entwertZeit = e;
	}
	
	public void setPreis(int preis) {
		this.preis = preis;
	}
	
	
	
}
