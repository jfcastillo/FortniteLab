package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.PlayerNotAddedMatchException;
import model.Fortnite;
import model.Match;
import model.Player;

public class TestMatch {
	
	Match match;
	
	void escenario1() {
		match = new Match(123, 50, 100);
		
	}
	@Test
	void testAddPlayerMatch() {
		escenario1() ;
		Player player = new Player("Sergio", Player.SWITCH, Player.NORMAL);
		try {
			match.addPlayerMatch(player);
			
			
			match.getPlayers().get(0);
			
			assertTrue(player==match.getPlayers().get(0));
		} catch (PlayerNotAddedMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
