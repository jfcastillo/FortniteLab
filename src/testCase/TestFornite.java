package testCase;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class TestFornite {
	
	Fortnite fortn;
	
	
	
	void escenario1() {
		fortn = new Fortnite();
		
	}

	
//	void testAddPlayerToMatch() {
//		escenario1();
//		Player player = new Player("Sergio", Player.PS4, Player.IN_QUEUE);
//		fortn.addPlayerToMatch(player, 12333);
//		
//		
//		
//	}
	@Test
	void testSearchMatch(){
		escenario1();
		Match m= new Match(1234,100,200);
		fortn.getMatches().add(m);
		
		assertTrue(fortn.searchMatch(100)==m);
	}
	@Test
	void testCreatePlayer() {
		escenario1();
		Player player = new Player("Sergio", Player.SWITCH, Player.NORMAL);
		
		fortn.createPlayer("Sergio", Player.SWITCH);
		
		assertNotEquals(fortn.getActualPlayer(), player);
		
		
	}

}
