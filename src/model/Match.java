package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;


import collections.ILinkedList;
import collections.List;
import exception.PlayerNotAddedMatchException;

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
		randomPlayers();
	}
	 
	 public void randomPlayers() {
		 
			
		 try {
			 File playerFile= new File("./data/randomPlayer.txt");
			playerFile.createNewFile();
			 FileOutputStream outPlayer= new FileOutputStream(playerFile);
			 ObjectOutputStream objectPlayer= new ObjectOutputStream(outPlayer);
			for (int i = 0; i < 10001; i++) {
				objectPlayer.writeObject(generatorPlayer()+"\n");
				
			}
			objectPlayer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
	 }


public void addPlayerMatch(Player p1) throws PlayerNotAddedMatchException {
		 
		 
		 if(p1!=null) {
			 players.add(p1);
			 
			 
		 }else {
			 
			 	new  PlayerNotAddedMatchException("player not added to game");
			 
		 }
		 
}


		private Player generatorPlayer() {
			Player p1=null;
			int m=(int)(Math.random()*3)+1;
			
			if(m==1) {
		 p1= new Player( "", Player.PS4, "");
			}else if(m==2) {
				p1= new Player( "",Player.SWITCH, "");				
			}else if(m==3) {
				p1= new Player( "",Player.XBOX, "");		
				}
		
		return p1;
	}
		public String generatorName() {
			String m="";
			for (int i = 0; i < 100; i++) {
				
			}
			return m;
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
