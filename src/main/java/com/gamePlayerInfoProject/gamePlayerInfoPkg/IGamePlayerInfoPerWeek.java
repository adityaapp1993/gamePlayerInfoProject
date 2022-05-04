package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.util.List;
import java.util.Map;

public interface IGamePlayerInfoPerWeek {

	public Map<Long, Map<Long, Long>> findGamePlayerInfoPerWeek(List<GamePlayerInfo> gamePlayerInfoList);

}
