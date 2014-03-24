package com.wildwolf.model;

public class TeamrecordsView extends Teamrecords{
	private String TeamName;
	private String OpponentName;
	
	public String getOpponentName() {
		return OpponentName;
	}
	public void setOpponentName(String opponentName) {
		OpponentName = opponentName;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
}
