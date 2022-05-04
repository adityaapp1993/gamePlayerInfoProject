package com.gamePlayerInfoProject.gamePlayerInfoPkgTest;
import java.util.List;
import java.util.Map;

public interface IGamePlayerInfoHigherAverage {

	public Map<Long, Map<Long, Long>>findPlayersHigherThanAverage(List<GamePlayerInfo> gamePlayerInfoList);

}
