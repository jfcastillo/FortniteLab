package model;

import collections.ILinkedList;
import collections.List;

public class Match {
	private int id;	
	private int pingMin;
	private int pingMax;
	private int size;
	//Jugadores de lista enlazada
	private ILinkedList<Player> players;
	
	
	 public Match(int id, int pingMin, int pingMax) {
		this.id = id;
		this.pingMin = pingMin;
		this.pingMax = pingMax;
		this.size = 0;
		players = new List();
	}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getPingMin() {
			return pingMin;
		}


		public void setPingMin(int pingMin) {
			this.pingMin = pingMin;
		}


		public int getPingMax() {
			return pingMax;
		}


		public void setPingMax(int pingMax) {
			this.pingMax = pingMax;
		}


		public ILinkedList<Player> getPlayers() {
			return players;
		}


		public void addPlayers(Player playersToAdd) {
			players.add(playersToAdd);			
		}
		
		
		public int getSize() {
			return size;
		}


		public void setSize(int size) {
			this.size += size;
		}


		public int factorial(int num) {
			int factorial=1;
			
			for (int i = num; i > 0; i--) {
	            factorial = factorial * i;
	        }
			
			
			return factorial;
			
		}
		
		
		public double probablyPoisson(int k) {
			double probably=0;
			double  u=0;
			probably=(Math.pow(u, k)*Math.pow(Math.E,-u))/factorial(k);
			
			
			
			return probably;
		}
	

}
