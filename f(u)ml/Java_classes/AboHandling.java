import java.util.Scanner;

public class AboHandling {
	
	public static Abo aboAbschließen(String username, String password) {	//Später mit System.in??
																			//Was ist mit bezahlung
		//Abos verfügbar?
		if(AboDBS.getFreeAbos()>0) {							
			Abo a = AboDBS.newAbo(username, password);		//Abo erstellen
			System.out.println("Ticketinhaber:	Ticket ID: ");
			System.out.println(a.getName()+"	"+ a.getId());
			return a;
		}else {
			System.err.println("Derzeit keine Abos verfügbar");
			return null;
		}
	}
	
	//Kündigt Abo
	public static void aboKuendingen(Abo abo) {
		
		AboDBS.setAboCanceled(abo);
		System.out.println("Ihr Abo wurde gekündigt");
		
	}
	
	
	public static void aboVerloren() {
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
		
		
		
	}
	

}
