package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.MultiValueMap;

public class GamePlayerInfoGenerateImpl implements IGamePlayerInfoGenerate{
	
	private long randomTimeDifference = 0;
	long startPlayedDate = Timestamp.valueOf("2021-08-01 00:00:00").getTime();
	long endPlayedDate = Timestamp.valueOf("2021-08-31 00:00:00").getTime();
    long timeDifference = endPlayedDate - startPlayedDate + 1;
    
	@Override
	public List<GamePlayerInfo> generateGamePlayerInfo() throws ParseException {
    	List<GamePlayerInfo> gamePlayerInfoList = new ArrayList<GamePlayerInfo>();

        MultiValueMap playerPlayedDateMap = new MultiValueMap();
        long randomTimeDifference = 0;
        Date playedDate = null;
    	//considering 5 games in total
    	for (int gameId = 1; gameId <= 5; gameId++)
    	{
    		//considering 80 players per game
    		for (int playerId = 1; playerId <= 80; playerId++) 
    		{
    	        List<Integer> dayOfYearList=new ArrayList<Integer>();
    	        
    			Calendar calendarGamePlayDate = Calendar.getInstance();

    	        //calculate the random played date
    	        calendarGamePlayDate = calculateRandomPlayedDate(calendarGamePlayDate, startPlayedDate, timeDifference);
    	        
    	        //check if date is not tuesday, generate another random date
    	        calendarGamePlayDate = checkRandomPlayedDate(calendarGamePlayDate, startPlayedDate, timeDifference);
    	        
    	        playedDate = calendarGamePlayDate.getTime();
    	        
    	        //obtain the day of the year the player will be playing on
	        	Integer playDayOfYear = findDayOfYear(calendarGamePlayDate);
	        			
	        	//check if same player is not playing in same day after game 1
	        	if (gameId != 1)
	        	{
		        	//find the appropriate game played date
		        	playedDate = findAppropriatePlayedDate(playedDate,gameId, playerPlayedDateMap,
		        			playerId, playDayOfYear, calendarGamePlayDate);
	        	}

    	        //assign the player to the played dates
    	        playerPlayedDateMap.put(Long.valueOf(playerId), playedDate);

    	        GamePlayerInfo gamePlayerInfo = createNewGamePlayerInfo(gameId, playedDate,
    	        		playerId);
    	        
    	        System.out.println(gamePlayerInfo);
    			
    			gamePlayerInfoList.add(gamePlayerInfo);
    		}
    	}
    	return gamePlayerInfoList;
		// TODO Auto-generated method stub
		
	}

	private Date findAppropriatePlayedDate(Date playedDate, int gameId, MultiValueMap playerPlayedDateMap, int playerId,
			Integer playDayOfYear, Calendar calendarGamePlayDate) {
		// TODO Auto-generated method stub
		
		List<Integer> playDayOfYearList = new ArrayList<Integer>();
    	
    	//obtain the list of dates that the player has currently played on
    	List<Date> playerDateList = findListOfPlayedDates(playerPlayedDateMap, playerId);
    			
    	//obtain the days of year list that the player has played on
    	playDayOfYearList = findPlayDayOfYearList(playerDateList);
    	
    	//check if the played date is not one of the other played dates
    	playedDate = findPlayDatePlayer(playedDate, playDayOfYearList,playDayOfYear,
    			calendarGamePlayDate);   	    
        
		return playedDate;
	}

	private GamePlayerInfo createNewGamePlayerInfo(int gameId, Date playedDate, int playerId) {
		// TODO Auto-generated method stub
		
		//generating random values between 75 and 200 for points per player
		Long points = (long) (75 + (int)(Math.random() * ((200-75) + 1)));
		GamePlayerInfo gamePlayerInfo = new GamePlayerInfo(Long.valueOf(gameId), String.valueOf(playedDate), Long.valueOf(playerId), points);
		return gamePlayerInfo;
	}

	private Date findPlayDatePlayer(Date playedDate, List<Integer> playDayOfYearList, Integer playDayOfYear,
			Calendar calendarGamePlayDate) {
		// TODO Auto-generated method stub
		while (playDayOfYearList.contains(playDayOfYear))
        {
        	randomTimeDifference = startPlayedDate + (long) (Math.random() * timeDifference);
	        playedDate = new Date(randomTimeDifference);
	        calendarGamePlayDate.setTime(playedDate);
	        playDayOfYear = calendarGamePlayDate.get(Calendar.DAY_OF_YEAR);
	        
	        //check if date is not tuesday, generate another random date
	        while (calendarGamePlayDate.get(Calendar.DAY_OF_WEEK) == 3)
	        {
	        	randomTimeDifference = startPlayedDate + (long) (Math.random() * timeDifference);
    	        playedDate = new Date(randomTimeDifference);
    	        calendarGamePlayDate.setTime(playedDate);
    	        playDayOfYear = calendarGamePlayDate.get(Calendar.DAY_OF_YEAR);
	        }
        }	
		return playedDate;
	}

	private List<Date> findListOfPlayedDates(MultiValueMap playerPlayedDateMap, int playerId) {
		// TODO Auto-generated method stub
		List<Date> listOfPlayedDated = (List<Date>) playerPlayedDateMap.get(Long.valueOf(playerId));
		return listOfPlayedDated;
	}

	private List<Integer> findPlayDayOfYearList(List<Date> playerDateList) {
		// TODO Auto-generated method stub
		List<Integer> playDayOfYearList = new ArrayList<Integer>();
		playerDateList.stream().forEach(playDate -> {
    		Calendar calendarGameDate = Calendar.getInstance();
        	calendarGameDate.setTime(playDate);
        	playDayOfYearList.add(calendarGameDate.get(Calendar.DAY_OF_YEAR));
    	});
		return playDayOfYearList;
	}

	private Integer findDayOfYear(Calendar calendarGamePlayDate) {
		// TODO Auto-generated method stub
		return calendarGamePlayDate.get(Calendar.DAY_OF_YEAR);
	}

	private Calendar checkRandomPlayedDate(Calendar calendarGamePlayDate, long startPlayedDate, long timeDifference) {
		// TODO Auto-generated method stub
		while (calendarGamePlayDate.get(Calendar.DAY_OF_WEEK) == 3)
        {
        	randomTimeDifference = startPlayedDate + (long) (Math.random() * timeDifference);
        	Date playedDate = new Date(randomTimeDifference);
	        calendarGamePlayDate.setTime(playedDate);
        }
		return calendarGamePlayDate;
	}

	private Calendar calculateRandomPlayedDate(Calendar calendarGamePlayDate, long startPlayedDate, long timeDifference) {
		// TODO Auto-generated method stub
		randomTimeDifference = startPlayedDate + (long) (Math.random() * timeDifference);
		Date playedDate = new Date(randomTimeDifference);
        calendarGamePlayDate.setTime(playedDate);
        return calendarGamePlayDate;
	}
}
