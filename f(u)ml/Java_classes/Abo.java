
public class Abo {
	
	private static int idCounter = 1;
	private int id;
	private String username;
	private String password;
	
	public Abo(String u, String p) {
		id = idCounter;
		username = u;
		password = p;
		idCounter++;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	

}
