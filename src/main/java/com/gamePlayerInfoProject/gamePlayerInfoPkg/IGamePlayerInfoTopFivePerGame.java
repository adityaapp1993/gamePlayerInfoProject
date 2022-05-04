package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IGamePlayerInfoTopFivePerGame {

	public Map<Long, Map<Long, Long>>findTopFivePerGame(List<GamePlayerInfo> gamePlayerInfoList);
}
