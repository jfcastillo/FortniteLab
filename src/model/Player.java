package model;

public class Player {
	
	private String id;
	private String name;
	private String platform;
	private int kills;
	private int deaths;
	private int winMatchs;
	private int loseMatchs;
	private int ping;
	
	public Player(String id, String name, String platform, int kills, int deaths, int winMatchs, int loseMatchs, int ping) {		
		this.id = id;
		this.name = name;
		this.platform = platform;
		this.kills = kills;
		this.deaths = deaths;
		this.winMatchs = winMatchs;
		this.loseMatchs = loseMatchs;
		this.ping = ping;
	}

	public int getPing() {
		return ping;
	}

	public void setPing(int ping) {
		this.ping = ping;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getWinMatchs() {
		return winMatchs;
	}

	public void setWinMatchs(int winMatchs) {
		this.winMatchs = winMatchs;
	}

	public int getLoseMatchs() {
		return loseMatchs;
	}

	public void setLoseMatchs(int loseMatchs) {
		this.loseMatchs = loseMatchs;
	}
	
	

	

}
