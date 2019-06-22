
import java.util.Scanner;

public class AboHandling {
	
	public static Abo aboAbschliessen(String username, String password) {	//Sp�ter mit System.in??
																			//Was ist mit bezahlung
		//Abos verf�gbar?
		if(AboDBS.getFreeAbos()>0) {							
			Abo a = AboDBS.newAbo(username, password);		//Abo erstellen
			System.out.println("Ticketinhaber:	Ticket ID: ");
			System.out.println(a.getName()+"	"+ a.getId());
			return a;
		}else {
			System.err.println("Derzeit keine Abos verf�gbar");
			return null;
		}
	}
	
	//K�ndigt Abo
	public static void aboKuendingen(Abo abo) {
		
		AboDBS.setAboCanceled(abo);
		System.out.println("Ihr Abo wurde gek�ndigt");
		
	}
	
	
	public static Abo aboVerloren() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie Ihren Usernamen ein");
		String username = sc.next();
		System.out.println("Geben Sie Ihr Passwort ein");
		String password = sc.next();
		sc.close();
		Abo lost = AboDBS.getAbo(username, password);	//Gleiches Abo wie Eintrag
		
		if(lost!= null) {
			System.out.println("Ihr Ticket mit der ID: " + lost.getId() + " wurde gedruckt");
		}
		
		return lost;
		
	}
	

}
