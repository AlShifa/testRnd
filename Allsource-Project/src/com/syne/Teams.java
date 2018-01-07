package com.syne;
import java.io.Serializable;
import java.util.Set;

public class Teams implements Serializable {
	private int teamId;
	private String teamName;
	private Set players;//one-to-many association.

	public Teams() {
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Set getPlayers() {
		return players;
	}

	public void setPlayers(Set players) {
		this.players = players;
	}

}
