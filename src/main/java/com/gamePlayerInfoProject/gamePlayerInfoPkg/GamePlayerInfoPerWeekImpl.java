package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GamePlayerInfoPerWeekImpl implements IGamePlayerInfoPerWeek{

	@Override
	public Map<Long, Map<Long, Long>> findGamePlayerInfoPerWeek(List<GamePlayerInfo> gamePlayerInfoList) {
		// TODO Auto-generated method stub
		Map<Long, Map<Long, Long>> gamePlayerInfoTopMap = new HashMap<Long, Map<Long, Long>>();

		if (gamePlayerInfoList !=null && gamePlayerInfoList.size() > 0)
		{		
    		//group the data by game id, player id, and points (player id and total points 
			//of each player per game)
			Map<Long, Map<Long, Long>> gamePlayerInfoMap = gamePlayerInfoList.stream().collect(
					Collectors.groupingBy(GamePlayerInfo::getGameId, 
							Collectors.groupingBy(GamePlayerInfo::getPlayerId, 
									Collectors.summingLong(GamePlayerInfo::getPoints))));
			
			gamePlayerInfoList.stream().collect(
					Collectors.groupingBy(GamePlayerInfo::getGameId, 
							Collectors.groupingBy(GamePlayerInfo::getPlayerId, 
									Collectors.summingLong(GamePlayerInfo::getPoints))));
						
			//iterating the game player info map obtained for each game id
			gamePlayerInfoMap.keySet().stream().forEach(gameId -> {		
				
				LinkedHashMap<Long, Long> playerPointsInfoSortedMap = new LinkedHashMap<>();
				
				//obtain the top 5 players per game
				gamePlayerInfoMap.get(gameId).entrySet().stream().limit(5)
				  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				  .forEach(playerPoints -> playerPointsInfoSortedMap.put(playerPoints.getKey(), 
						  playerPoints.getValue()));
				
				//adding the top 5 players and points for each game to map
				gamePlayerInfoTopMap.put(gameId, playerPointsInfoSortedMap);
			});
		}
		return gamePlayerInfoTopMap;
	}
	

}
