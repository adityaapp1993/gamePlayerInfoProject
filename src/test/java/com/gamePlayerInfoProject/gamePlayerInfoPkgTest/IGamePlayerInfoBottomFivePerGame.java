package com.gamePlayerInfoProject.gamePlayerInfoPkgTest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IGamePlayerInfoBottomFivePerGame {

	public Map<Long, Map<Long, Long>> findBottomFivePerGame(List<GamePlayerInfo> gamePlayerInfoList);

}
