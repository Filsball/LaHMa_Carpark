import java.util.ArrayList;
import java.util.List;

public class AboDBS {
	
	private static Parkhaus p = Parkhaus.getInstance();
	
	private static List<Abo> abos = new ArrayList<Abo>();
	
	private static List<Abo> canceledAbos = new ArrayList<Abo>();
	
	public static Abo newAbo(String username, String password) {
		Abo a = new Abo(username, password);
		abos.add(a);
		return a;
	}
	

	public boolean hasAbo(int AboId) {
		return false;
	}
	
	public static Abo getAbo(String username, String password) {
		
		Abo lost = null;
		for(Abo a : abos) {
			if (a.getName().equals(username)){
				if(a.getPassword().equals(password)) {
					lost = a;
					break;
				}else {
					System.out.println("Passwort falsch");
					return null;
				}
			}else {
				System.out.println("Username falsch");
				return null;
			}
		}
		
		return lost;
	}
	
	public static void setAboCanceled(Abo a) {
		canceledAbos.add(a);
		abos.remove(a);
		
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
	
	public static List<Abo> getAktuelleAbos(){
		return abos;
	}
}
