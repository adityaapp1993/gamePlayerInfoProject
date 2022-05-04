package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class GamePlayerInfoManagement {
    private static final String GAME_PLAYER_INFO_FILE = "/home/aditya/Documents/gamePlayerInfo.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
    	List<GamePlayerInfo> gamePlayerInfoList = null;
    	IGamePlayerInfoGenerate gamePlayerInfoGenerate = null;
    	IGamePlayerInfoWriter gamePlayerInfoWriter = null;
    	IGamePlayerInfoReader gamePlayerInfoReader = null;
    	IGamePlayerInfoTopFivePerGame gamePlayerInfoTopFivePerGame  = null;
    	IGamePlayerInfoBottomFivePerGame gamePlayerInfoBottomFivePerGame = null;
    	IGamePlayerInfoHigherAverage gamePlayerInfoHigherAverage = null;

    	try
    	{
    		gamePlayerInfoWriter = new GamePlayerInfoWriterImpl();
    		gamePlayerInfoReader = new GamePlayerInfoReaderImpl();
    		gamePlayerInfoGenerate = new GamePlayerInfoGenerateImpl();
    		gamePlayerInfoTopFivePerGame = new GamePlayerInfoTopFivePerGameImpl();
    		gamePlayerInfoBottomFivePerGame = new GamePlayerInfoBottomFivePerGameImpl();
    		gamePlayerInfoHigherAverage = new GamePlayerInfoHigherAverageImpl();
    		
    		//generate the random data for game id, player id, played date, and points
    		gamePlayerInfoList = gamePlayerInfoGenerate.generateGamePlayerInfo();
    		
    		//displaying the random generated game player info list
			System.out.println("random generated game player info list: ");
    		for (GamePlayerInfo gamePlayerInfo : gamePlayerInfoList)
    		{
    			System.out.println("Game id: " + gamePlayerInfo.getGameId());
    			System.out.println("Player id: " + gamePlayerInfo.getPlayerId());
    			System.out.println("Played Date: " + gamePlayerInfo.getPlayedDate());
    			System.out.println("Points: " + gamePlayerInfo.getPoints());
    		}
    		
    		//write the data to a csv file
    		if (gamePlayerInfoList != null && gamePlayerInfoList.size() > 0)
    		{
    			gamePlayerInfoWriter.writeFromGamePlayerInfoList(GAME_PLAYER_INFO_FILE, gamePlayerInfoList);
    		}
    		
    		//read the data from the csv file
    		gamePlayerInfoList = gamePlayerInfoReader.readGamePlayerInfoListFromFile(GAME_PLAYER_INFO_FILE);
    		
			//displaying the read game player info list
			System.out.println("Total game player info list: ");
    		for (GamePlayerInfo gamePlayerInfo : gamePlayerInfoList)
    		{
    			System.out.println("Game id: " + gamePlayerInfo.getGameId());
    			System.out.println("Player id: " + gamePlayerInfo.getPlayerId());
    			System.out.println("Played Date: " + gamePlayerInfo.getPlayedDate());
    			System.out.println("Points: " + gamePlayerInfo.getPoints());
    		}
    		
    		//retrieve the top five players for each game 
    		Map<Long, Map<Long, Long>> gamePlayerInfoMapTopFive = 
    				gamePlayerInfoTopFivePerGame.findTopFivePerGame(gamePlayerInfoList);
    		
    		//displaying the top five game player info per game
			System.out.println("Top five game player info list: ");
    		for (Long gameId : gamePlayerInfoMapTopFive.keySet())
    		{
    			Map<Long, Long> mapPlayerPoints = gamePlayerInfoMapTopFive.get(gameId);
    			for (Long playerId : mapPlayerPoints.keySet())
    			{
        			System.out.println("Game id: " + gameId);
        			System.out.println("Player id: " + playerId);
        			System.out.println("Points: " + mapPlayerPoints.get(playerId));
    			}
    		}
			
    		//retrieve the bottom five players for each game 
    		Map<Long, Map<Long, Long>> gamePlayerInfoMapBottomFive = 
    				gamePlayerInfoBottomFivePerGame.findBottomFivePerGame(gamePlayerInfoList);
    		
    		//displaying the bottom five game player info per game
			System.out.println("Bottom five game player info list: ");
			for (Long gameId : gamePlayerInfoMapBottomFive.keySet())
    		{
    			Map<Long, Long> mapPlayerPoints = gamePlayerInfoMapBottomFive.get(gameId);
    			for (Long playerId : mapPlayerPoints.keySet())
    			{
        			System.out.println("Game id: " + gameId);
        			System.out.println("Player id: " + playerId);
        			System.out.println("Points: " + mapPlayerPoints.get(playerId));
    			}
    		}
			
    		//retrieve the top five players higher than average for each game 
    		Map<Long, Map<Long, Long>> gamePlayerInfoMapHigherAverage = 
    				gamePlayerInfoHigherAverage.findPlayersHigherThanAverage(gamePlayerInfoList);
    		
    		//displaying the top five game player info list higher than average per game
			System.out.println("Top five game player info list higher than average per game: ");
			for (Long gameId : gamePlayerInfoMapHigherAverage.keySet())
    		{
    			Map<Long, Long> mapPlayerPoints = gamePlayerInfoMapHigherAverage.get(gameId);
    			for (Long playerId : mapPlayerPoints.keySet())
    			{
        			System.out.println("Game id: " + gameId);
        			System.out.println("Player id: " + playerId);
        			System.out.println("Points: " + mapPlayerPoints.get(playerId));
    			}
    		}
			
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	finally
    	{
    		
    	}        
    }
}
