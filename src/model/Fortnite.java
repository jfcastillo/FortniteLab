package model;

import collections.*;

public class Fortnite {
	
	private ILinkedList<Match> matches;
	private IQueue<Player> playerInQueue;
	private IHashTable<Double, Player> players;
	//------------------------------------------------------------------------------------

	public Fortnite() {
		matches = new List<>();
		playerInQueue = new Queue<>();
		players = new HashTable<>();
	}

	public ILinkedList<Match> getMatches() {
		return matches;
	}

	public void setMatches(ILinkedList<Match> matches) {
		this.matches = matches;
	}

	public IQueue<Player> getPlayerInQueue() {
		return playerInQueue;
	}

	public void setPlayerInQueue(IQueue<Player> playerInQueue) {
		this.playerInQueue = playerInQueue;
	}

	public IHashTable<Double, Player> getPlayers() {
		return players;
	}

	public void setPlayers(IHashTable<Double, Player> players) {
		this.players = players;
	}
	
	
	public void addPlayersHash(Player playerToAdd) {
		double hashKey = playerToAdd.getSkill();
		if (playerToAdd.getStatus().equals(Player.IN_QUEUE)) {
			players.tableInsert(hashKey, playerToAdd);
		}		
	}
	public void addPlayerQueue(Player playerToAdd) {
		if (playerToAdd.getStatus().equals(Player.IN_QUEUE)) {
			playerInQueue.enQueue(playerToAdd);
		}
	}
	public void addPlayerToMatch(Player playerToAdd, int idMatch) {
		int pingMin = 0;
		int pingMax = 0;
		int playerPing = playerToAdd.getPing();
		if (playerPing >= 0 && playerPing<100) {
			pingMin = 0;
			pingMax = 99;
		}
		else if (playerPing >= 100 && playerPing<200) {
			pingMin = 100;
			pingMax = 199;
		}
		else if (playerPing >= 200 && playerPing<300) {
			pingMin = 200;
			pingMax = 299;
		}
		else {
			pingMin = 300;
			pingMax = 400;
		}
		if (matches.size()==0) {
			Match newMatch = new Match(idMatch, pingMin, pingMax);
			newMatch.addPlayers(playerToAdd);
			matches.add(newMatch);			
		}
		else {
			Match m = searchMatch(pingMin);
			if (m == null) {
				Match newMatch = new Match(idMatch, pingMin, pingMax);
				newMatch.addPlayers(playerToAdd);
				matches.add(newMatch);	
			}
			else {
				m.addPlayers(playerToAdd);
			}
		}
		
	}
	public Match searchMatch(int pingMin) {
		Match matchFound = null;
		for (int i = 0; i < matches.size(); i++) {
			if (matches.get(i).getPingMin() == pingMin) {
				matchFound = matches.get(i);
			}
		}
		return matchFound;
		
	}
	public void createPlayer(String username, String platform) {
		Player p1= new Player(username, platform,(int)(Math.random()*1000)+1, (int)(Math.random()*1000)+1, (int)(Math.random()*1000)+1, (int)(Math.random()*1000)+1, (int)(Math.random()*1000)+1, "");
	}
	

}
