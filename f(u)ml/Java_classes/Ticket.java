import java.util.Date;

public class Ticket {

	private int id;
	private Date startZeit;
	private Date entwertZeit;
	private boolean entwertet = false;
	
	public Ticket(int id, Date startZeit) {
		this.id = id;
		this.startZeit = startZeit;
		
		
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
	
	public void setEntZeit(Date e) {
		entwertZeit = e;
	}
	
	public void setboolean(Ticket t) {
		entwertet = true;
	}
	
}
