package model;

public class Player implements Comparable<Player>{
	public static final String IN_QUEUE = "inQueue";
	public static final String NORMAL = "normal";
	public static final String PS4="PS4";
	public static final String SWITCH="Switch";
	public static final String XBOX="Xbox";
	
	private String name;
	private String platform;
	private int kills;
	private int deaths;
	private int winMatchs;
	private int matchsPlayed;
	private int ping;
	private double skill;
	private String status;
	
	public Player( String name, String platform,String status) {		
		
		this.name = name;
		this.platform = platform;
		this.kills=(int)(Math.random()*100);
		this.deaths=(int)(Math.random()*100)+1;
		this.winMatchs=(int)(Math.random()*50);
		this.matchsPlayed= (int)(Math.random()*100)+1;
		this.ping= (int)(Math.random()*300)+1;		
		this.status = status;
		calculateSkill();
	}

	public int getPing() {
		return ping;
	}

	public void setPing(int ping) {
		this.ping = ping;
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
		skill = (kills/(Match.MAX_KILLS_PER_MATCH*matchsPlayed)) +(winMatchs/matchsPlayed);
	}
	
	@Override
	public String toString() {
		return name+", "+platform+", Kills: "+kills+", Deaths: "+deaths+", win matchs: "+winMatchs+", matchs Played "+matchsPlayed+", Ping: "+ping+", Skill: "+skill+", "+status;
	}
}
