package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class GamePlayerInfo {
	
	@CsvBindByName(column = "gameId")
	private Long gameId;
	
	@CsvBindByName(column = "playerId")
	private Long playerId;
	
	@CsvBindByName(column = "playedDate")
	private String playedDate;
	
	@CsvBindByName(column = "points")
	private Long points;
	
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public String getPlayedDate() {
		return playedDate;
	}
	public void setPlayedDate(String playedDate) {
		this.playedDate = playedDate;
	}
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	public GamePlayerInfo(Long gameId, String playedDate, Long playerId, Long points) {
		super();
		this.gameId = gameId;
		this.playedDate = playedDate;
		this.playerId = playerId;
		this.points = points;
	}
	
	
	
}
