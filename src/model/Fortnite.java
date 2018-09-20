package model;

import collections.*;

public class Fortnite {
	
	private ILinkedList<Match> matches;
	private IQueue<Player> playerInQueue;
	private IHashTable<Integer, Player> players;
	private Player actualPlayer;
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

	public IHashTable<Integer, Player> getPlayers() {
		return players;
	}

	public void setPlayers(IHashTable<Integer, Player> players) {
		this.players = players;
	}
	
	
	public void addPlayersHash(Player playerToAdd) {
		int hashKey = playerToAdd.getPing();
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
	public void continueMatching(Match m, Player playerToAdd) {
		double skill = playerToAdd.getSkill();
		int pingMin = m.getPingMin();
		int pingMax = m.getPingMax();
		boolean exit = false;
		
		while (m.getSize()<=100) {
			for (int i = pingMin; i < pingMax && !exit; i++) {
				
				if (m.getSize()==100) exit = true;
				else {
					ILinkedList<HashEntry<Integer, Player>> list = players.tableRetrieve(i);
					if (list.size()>0) {
						for (int j = 0; j < list.size(); j++) {
							if (m.getSize()==100) exit = true;
							if (list.get(i).getValue().getSkill()>=skill-50 && list.get(i).getValue().getSkill()<=skill+50) {
								m.addPlayers(list.get(i).getValue());
							}
						}
					}
				}
					
				
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
		actualPlayer= new Player(username, platform, Player.NORMAL);
	}
	public Player getActualPlayer() {
		return actualPlayer;
	}
	
	

}
