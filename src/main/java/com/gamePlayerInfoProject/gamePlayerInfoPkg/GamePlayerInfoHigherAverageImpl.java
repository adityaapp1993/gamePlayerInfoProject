package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GamePlayerInfoHigherAverageImpl implements IGamePlayerInfoHigherAverage
{
	@Override
	public Map<Long, Map<Long, Long>> findPlayersHigherThanAverage(List<GamePlayerInfo> gamePlayerInfoList) {
		// TODO Auto-generated method stub
		
		Map<Long, Map<Long, Long>> gamePlayerInfoBottomMap = new HashMap<Long, Map<Long, Long>>();

		if (gamePlayerInfoList !=null && gamePlayerInfoList.size() > 0)
		{		
    		//group the data by game id, player id, and points (player id and total points 
			//for each player per game)
			Map<Long, Map<Long, Long>> gamePlayerInfoMap = groupGamePlayerInfo(gamePlayerInfoList);
			
			//find game player info higher than average per game
			gamePlayerInfoBottomMap = findHigherThanAverage(gamePlayerInfoMap);
			
		}
		return gamePlayerInfoBottomMap;
	}

	private Map<Long, Map<Long, Long>> findHigherThanAverage(Map<Long, Map<Long, Long>> gamePlayerInfoMap) {
		// TODO Auto-generated method stub
		Map<Long, Map<Long, Long>> gamePlayerInfoBottomMap = new HashMap<Long, Map<Long, Long>>();
		
		//iterating the game player info map obtained for each game id
		gamePlayerInfoMap.keySet().stream().forEach(gameId -> {		
			LinkedHashMap<Long, Long> playerPointsInfoSortedMap = new LinkedHashMap<>();
			
			//calculate average points for each player per game
			Double average = calculateAverage(gamePlayerInfoMap, gameId);
			
			//obtain top five players higher than average points
			gamePlayerInfoMap.get(gameId).entrySet().stream()
			  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5)
			  .forEach(playerPoints -> {
				  if (playerPoints.getValue() > average)
				  {
					  playerPointsInfoSortedMap.put(playerPoints.getKey(), playerPoints.getValue());
					  gamePlayerInfoBottomMap.put(gameId, playerPointsInfoSortedMap);
				  }
			  }); 
		});
		return gamePlayerInfoBottomMap;
	}

	private Double calculateAverage(Map<Long, Map<Long, Long>> gamePlayerInfoMap, Long gameId) {
		// TODO Auto-generated method stub
		Double average = gamePlayerInfoMap.get(gameId).values().stream().
				mapToDouble(m -> m).average().orElse(0.0);
		return average;
	}

	private Map<Long, Map<Long, Long>> groupGamePlayerInfo(List<GamePlayerInfo> gamePlayerInfoList) {
		// TODO Auto-generated method stub
		Map<Long, Map<Long, Long>> gamePlayerInfoMap = new HashMap<Long, Map<Long, Long>>();
		gamePlayerInfoMap = gamePlayerInfoList.stream().collect(
				Collectors.groupingBy(GamePlayerInfo::getGameId, 
						Collectors.groupingBy(GamePlayerInfo::getPlayerId, 
								Collectors.summingLong(GamePlayerInfo::getPoints))));
		return gamePlayerInfoMap;
	}

}
