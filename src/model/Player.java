package model;

public class Player {
	public static final String IN_QUEUE = "inQueue";
	public static final String NORMAL = "normal";
	private String id;
	private String name;
	private String platform;
	private int kills;
	private int deaths;
	private int winMatchs;
	private int matchsPlayed;
	private int ping;
	private double skill;
	private String status;
	
	public Player(String id, String name, String platform, int kills, int deaths, int winMatchs, int matchsPlayed, int ping, String status) {		
		this.id = id;
		this.name = name;
		this.platform = platform;
		this.kills = kills;
		this.deaths = deaths;
		this.winMatchs = winMatchs;
		this.matchsPlayed = matchsPlayed;
		this.ping = ping;
		this.status = status;
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

	public int getMatchsPlayed() {
		return matchsPlayed;
	}

	public void setMatchsPlayed(int loseMatchs) {
		this.matchsPlayed = loseMatchs;
	}

	public double getSkill() {
		return skill;
	}

	public void setSkill(double skill) {
		this.skill = skill;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void calculateSkill() {
		skill = (kills/deaths) +(winMatchs/matchsPlayed);
	}
	
	
	

	

}
