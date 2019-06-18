import java.util.ArrayList;
import java.util.List;

public class AboDBS {
	
	private static Parkhaus p = Parkhaus.getInstance();
	
	private static List<Abo> abos = new ArrayList<Abo>();
	
	private static List<Abo> canceledAbos = new ArrayList<Abo>();
	
	
	

	public boolean hasAbo(int AboId) {
		return false;
	}
	
	public int getId(String username, String password) {
		return 0;
	}
	
	public void setAboCanceled(int AboId) {
		
	}
	
	public static int getFreeAbos() {
		
		return getMaxAbos()-abos.size();
	}
	
	public static int getMaxAbos() {
		return p.getMaxAbo();
	}
	
	public void newEntry(Abo abo) {
		abos.add(abo);
	}
}
