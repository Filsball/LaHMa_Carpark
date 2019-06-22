import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LaHMa_TicketTest {
	
	Parkhaus LaHMaPark;
	
	@Before
	public void set() {
		LaHMaPark = Parkhaus.getInstance();		
	}
	@Test
	public void testFreiePlaetze1() {
		assertEquals(20, Parkhaus.getSpots());
	}	
	@Test
	public void testFreiePlaetze2() {
		LoeseTicket.getTicket();
		assertEquals(19, Parkhaus.getSpots());
	}	
	@Test
	public void testFreiePlaetze3() {
		for (int i = 0; i < 18; i++) {
			LoeseTicket.getTicket();
		}
		assertEquals(null, LoeseTicket.getTicket());
	}
	@Test
	public void testFreiePlaetze4() {
		assertEquals(1, Parkhaus.getSpots());	//Toleranz für Schlecht-Parker, dicke Autos & Frauen
	}	
	@Test
	public void testTicketEntwerten1() {
		if(!FreeSpots.checkIfFree()) {
			List<Ticket> list = TicketDBS.getAktList();
			Ticket ticket = list.get(0);
			TicketEntwertung.entwerteTicket(ticket);
			assertTrue(Verification.checkTicket(ticket));
		}else {
			Ticket ticket = LoeseTicket.getTicket();
			TicketEntwertung.entwerteTicket(ticket);
			assertTrue(Verification.checkTicket(ticket));
		}		
	}
	@Test
	public void testTicketEntwerten2() {
		Ticket ticket = LoeseTicket.getTicket();
		assertFalse(Verification.checkTicket(ticket));
	}
}
