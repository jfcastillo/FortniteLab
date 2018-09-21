package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import collections.*;

public class Fortnite {
	
	public static final int NUMBER_PLAYER=10000;
	private ILinkedList<Match> matches;
	private IQueue<Player> playerInQueue;
	private IHashTable<Integer, Player> players;
	private Player actualPlayer;
	private Player[] players2;
	
	
	//------------------------------------------------------------------------------------

	public Fortnite() {
		
		matches = new List<>();
		playerInQueue = new Queue<>();
		players = new HashTable<>();
		actualPlayer = null;
		players2= new Player[NUMBER_PLAYER];
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
		System.out.println("Inicio de emparejamiento");
		Match newMatch = null;
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
			System.out.println("Tamaño igual a 0");
			newMatch = new Match(idMatch, pingMin, pingMax);
			newMatch.addPlayers(playerToAdd);
			matches.add(newMatch);			
		}
		else {
			Match m = searchMatch(pingMin);
			System.out.println("Tamaño diferente a 0");
			if (m == null) {
				newMatch = new Match(idMatch, pingMin, pingMax);
				newMatch.addPlayers(playerToAdd);
				matches.add(newMatch);	
			}
			else {
				m.addPlayers(playerToAdd);
			}
			
		}
		continueMatching(newMatch, playerToAdd);
		
		
	}
	public void continueMatching(Match m, Player playerToAdd) {
		double skill = playerToAdd.getSkill();
		int pingMin = m.getPingMin();
		int pingMax = m.getPingMax();
		System.out.println("pingmin "+pingMin);
		System.out.println("pingmin "+pingMax);
		boolean exit = false;
		System.out.println("continue matchmaking");
		System.out.println("Empezó a buscar los 100 jugadores");
		while (m.getSize()<100) {
			
			for (int i = pingMin; i < pingMax && !exit; i++) {
				System.out.println(i);
				if (m.getSize()==100) {
					exit = true;
					System.out.println("sali tamaño = 0");
				}
				else {
					ILinkedList<HashEntry<Integer, Player>> list = players.tableRetrieve(i);
					if (list.size()>0) {
						for (int j = 0; j < list.size(); j++) {
							double skillMin = list.get(j).getValue().getSkill()-4;
							double skillMax = list.get(j).getValue().getSkill()+4;
							System.out.println("list "+j );
							if (m.getSize()==100) {
								exit = true;
							}
							
							else if (skill>=skillMin && skill<=skillMax) {
								System.out.println("entra a evaluar skills");
								m.addPlayers(list.get(j).getValue());
							}
						}
					}
				}
					
				
			}
			System.out.println("sigo recorriendo");
		}
		System.out.println("Terminó de encontrar los 100 jugadores");
		for (int i = 0; i < m.getSize(); i++) {
			System.out.println("E   M   P   A   R   E   J   A   M   I   E   N   T   O");
			System.out.println(i+": "+m.getPlayers().get(i).toString());
		}
	}
	
	public void addPlayerToMatchPlatform(Player playerToAdd, int idMatch) {
		
	}
	public void continueMatchingPlatform(Match m, Player playerToAdd) {
		
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
	
	public void setActualPlayer(String name, String platform, String status) {
		actualPlayer = new Player(name, platform, status);
	}
	
	//Metodos para probar
	public Player generatorPlayer() {
		Player p1=null;
		int m=(int)(Math.random()*3)+1;
		
		if(m==1) {
			p1= new Player(generatorName() , Player.PS4, Player.IN_QUEUE);
		}else if(m==2) {
			p1= new Player( generatorName(),Player.SWITCH, Player.NORMAL);				
		}else if(m==3) {
			p1= new Player(generatorName(),Player.XBOX, Player.NORMAL);		
			}
	
	return p1;
}
	public String generatorName() {
		String m="";
		for (int i = 0; i < 6; i++) {
			char s= (char)(Math.random()*26+'a');
			m+=s;
		}
		return m;
	}
	
	public void mergeSort(Player[] playersToRank, int n) {
		
		int curr_size; 
        
        int left_start;

        for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size){
             
            for (left_start = 0; left_start < n-1;left_start += 2*curr_size){
               
                int mid = left_start + curr_size - 1;
         
                int right_end = Math.min(left_start 
                             + 2*curr_size - 1, n-1);
                
                if(mid > playersToRank.length-1) {
                	mid = left_start + (playersToRank.length-left_start)/2;
                }

                merge(playersToRank, left_start, mid, right_end);
            }
        }
	}
		
	public void merge(Player arr[], int l, int m, int r){
		
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
     
        Player[] L = new Player[n1];
        Player[] R = new Player[n2];

        for (i = 0; i < n1; i++) {
        	L[i] = arr[l+i];
        }
            
        for (j = 0; j < n2; j++) {
        	R[j] = arr[m + 1+ j];
        }
            
        i = 0;
        j = 0;
        k = l;
        
        while (i < n1 && j < n2)
        {
        	if(L[i].compareTo(R[j])==-1) {
        		arr[k] = L[i];
                i++;
        	} else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
     
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
     
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	public void leerTxt() throws IOException, ClassNotFoundException{
		
		
		
			FileInputStream fis =new FileInputStream( "./data/randomPlayer.txt" );
			ObjectInputStream leerObjeto =  new ObjectInputStream( fis );
			int i=0;
			while(i<10000){
				Player m  = (Player) leerObjeto.readObject();
				addPlayerQueue(m);
				addPlayersHash(m);
				players2[i]=m;
				i++;
			}
			
			leerObjeto.close();	
	}
	public void randomPlayers() {

		try {
			File playerFile = new File("./data/randomPlayer.txt");
			playerFile.createNewFile();
			FileOutputStream outPlayer = new FileOutputStream(playerFile);
			ObjectOutputStream objectPlayer = new ObjectOutputStream(outPlayer);
			for (int i = 0; i < 10001; i++) {
				objectPlayer.writeObject(generatorPlayer() + "\n");

			}
			objectPlayer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	
	
	

}
