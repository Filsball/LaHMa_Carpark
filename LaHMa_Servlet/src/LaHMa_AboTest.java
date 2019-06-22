import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LaHMa_AboTest {
	
Parkhaus LaHMaPark;
	
	@Before
	public void set() {
		LaHMaPark = Parkhaus.getInstance();		
	}

	@Test
	public void test() {
		AboHandling.aboAbschließen("XxXMaximusxXx", "password");
		assertEquals(4, AboDBS.getFreeAbos());
	}
	@Test
	public void test2() {
		List<Abo> abos = AboDBS.getAktuelleAbos();
		AboHandling.aboKuendingen(abos.get(0));
		assertEquals(5, AboDBS.getFreeAbos());
	}
	@Test
	public void test3() {
		AboHandling.aboAbschließen("User", "password");
		AboHandling.aboAbschließen("CleanCodeDeveloper4711", "xtremelysafepw");
		AboHandling.aboAbschließen("BayesIsBest", "bayesianer123");
		AboHandling.aboAbschließen("Rudi", "test");
		AboHandling.aboAbschließen("NochEinUsername", "12345678");
		assertEquals(null, AboHandling.aboAbschließen("LeiderZuSpaet", "meehh"));
	}
	@Test 
	public void test4() {		
		String username = "User\npassword";
		InputStream var = new ByteArrayInputStream(username.getBytes());
		System.setIn(var);
		assertNotNull(AboHandling.aboVerloren());
	}
	@Test 
	public void test5() {
		String username = "NichtExistenterUser\npassword";
		InputStream var = new ByteArrayInputStream(username.getBytes());
		System.setIn(var);
		assertNull(AboHandling.aboVerloren());
	}

}
