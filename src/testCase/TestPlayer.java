package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Match;
import model.Player;

class TestPlayer {

Player player;
	
	void escenario1() {
		player = new Player("Sergio", Player.SWITCH, Player.NORMAL);
		
	}
	
	@Test
	void testCompareTo() {
		escenario1();
		Player p= new Player("sergio", Player.PS4, Player.IN_QUEUE);
		player.compareTo(p);
		assertTrue(player.compareTo(p)==1||player.compareTo(p)==-1);
	}
	

}
