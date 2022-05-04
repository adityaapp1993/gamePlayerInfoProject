package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.util.List;
import java.util.Map;

public interface IGamePlayerInfoByWeekly {

	public Map<Long, Map<Long, Long>> findGamePlayerInfoByWeekly(List<GamePlayerInfo> gamePlayerInfoList);

}
