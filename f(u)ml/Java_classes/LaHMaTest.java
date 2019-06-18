import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class LaHMaTest {

	
	Parkhaus laHMa = Parkhaus.getInstance();
	
	
	
	@Test
	void test() throws InterruptedException {
		Ticket ticket1 = LoeseTicket.getTicket();
		Thread.sleep(61000);
		Ticket ticket2 = LoeseTicket.getTicket();
	//	Thread.sleep(1000);
		Ticket ticket3 = LoeseTicket.getTicket();
	//	Thread.sleep(2000);
		Ticket ticket4 = LoeseTicket.getTicket();
	//	Thread.sleep(1000);
		Ticket ticket5 = LoeseTicket.getTicket();
	//	Thread.sleep(1000);
		
		TicketEntwertung.entwerteTicket(ticket1);


		assertEquals(true,FreeSpots.checkIfFree() );
	}

}
