package com.gamePlayerInfoProject.gamePlayerInfoPkgTest;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GamePlayerInfoBottomFivePerGameImpl implements IGamePlayerInfoBottomFivePerGame{

	@Override
	public Map<Long, Map<Long, Long>> findBottomFivePerGame(List<GamePlayerInfo> gamePlayerInfoList) {
		// TODO Auto-generated method stub
		Map<Long, Map<Long, Long>> gamePlayerInfoBottomMap = new HashMap<Long, Map<Long, Long>>();
		Map<Long, Map<Long, Long>> gamePlayerInfoMap  = new HashMap<Long, Map<Long, Long>>();

		if (gamePlayerInfoList !=null && gamePlayerInfoList.size() > 0)
		{		
    		//group the data by game id, player id, and points (player id and total points 
			//for each player per game)
			gamePlayerInfoMap = groupGamePlayerInfo(gamePlayerInfoList);
			
			//find bottom five players per game
			gamePlayerInfoBottomMap = findBottomFivePerGame(gamePlayerInfoMap);
		}
		return gamePlayerInfoBottomMap;
	}
	
	private Map<Long, Map<Long, Long>> findBottomFivePerGame(Map<Long, Map<Long, Long>> gamePlayerInfoMap) {
		// TODO Auto-generated method stub
		
		Map<Long, Map<Long, Long>> gamePlayerInfoBottomMap = new HashMap<Long, Map<Long, Long>>();

		//iterating the game player info map obtained for each game id
		gamePlayerInfoMap.keySet().stream().forEach(gameId -> {
			LinkedHashMap<Long, Long> playerPointsInfoSortedMap = new LinkedHashMap<>();
			
			//obtain the bottom 5 players per game
			gamePlayerInfoMap.get(gameId).entrySet().stream()
			  .sorted(Map.Entry.comparingByValue()).limit(5)
			  .forEach(playerPoints -> playerPointsInfoSortedMap.put(playerPoints.getKey(), 
					  playerPoints.getValue()));
			
			//adding the top 5 players and points for each game to map
			gamePlayerInfoBottomMap.put(gameId, playerPointsInfoSortedMap);
		});
		return gamePlayerInfoBottomMap;
	}

	private Map<Long, Map<Long, Long>> groupGamePlayerInfo(List<GamePlayerInfo> gamePlayerInfoList) {
		// TODO Auto-generated method stub
		Map<Long, Map<Long, Long>> gamePlayerInfoMap = gamePlayerInfoList.stream().collect(
				Collectors.groupingBy(GamePlayerInfo::getGameId, 
						Collectors.groupingBy(GamePlayerInfo::getPlayerId, 
								Collectors.summingLong(GamePlayerInfo::getPoints))));
		return gamePlayerInfoMap;
	}
}
