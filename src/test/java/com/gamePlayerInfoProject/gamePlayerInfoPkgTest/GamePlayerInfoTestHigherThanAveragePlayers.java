package com.gamePlayerInfoProject.gamePlayerInfoPkgTest;
import com.gamePlayerInfoProject.gamePlayerInfoPkgTest.GamePlayerInfo;
import com.gamePlayerInfoProject.gamePlayerInfoPkgTest.GamePlayerInfoBottomFivePerGameImpl;
import com.gamePlayerInfoProject.gamePlayerInfoPkgTest.GamePlayerInfoHigherAverageImpl;
import com.gamePlayerInfoProject.gamePlayerInfoPkgTest.GamePlayerInfoTopFivePerGameImpl;
import com.gamePlayerInfoProject.gamePlayerInfoPkgTest.IGamePlayerInfoBottomFivePerGame;
import com.gamePlayerInfoProject.gamePlayerInfoPkgTest.IGamePlayerInfoHigherAverage;
import com.gamePlayerInfoProject.gamePlayerInfoPkgTest.IGamePlayerInfoTopFivePerGame;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class GamePlayerInfoTestHigherThanAveragePlayers{

    @Test		
    public void testGamePlayerInfoHigherThanAveragePlayers()
    {           
    	List<GamePlayerInfo> gamePlayerInfoList = null;
    	IGamePlayerInfoHigherAverage gamePlayerInfoHigherAverage = null;
    	try
    	{
    		gamePlayerInfoList = new ArrayList<GamePlayerInfo>();
    		gamePlayerInfoHigherAverage = new GamePlayerInfoHigherAverageImpl();

    		GamePlayerInfo gamePlayerInfo1 = new GamePlayerInfo(1L,"Wed Aug 18 16:03:12 GST 2021",1L,150L);
    		GamePlayerInfo gamePlayerInfo2 = new GamePlayerInfo(1L,"Mon Aug 23 22:19:30 GST 2021",2L,140L);
    		GamePlayerInfo gamePlayerInfo3 = new GamePlayerInfo(1L,"Sat Aug 07 07:19:14 GST 2021",3L,130L);
    		GamePlayerInfo gamePlayerInfo4 = new GamePlayerInfo(1L,"Mon Aug 16 18:27:16 GST 2021",4L,120L);
    		GamePlayerInfo gamePlayerInfo5 = new GamePlayerInfo(1L,"Mon Aug 23 06:19:07 GST 2021",5L,110L);
    		GamePlayerInfo gamePlayerInfo6 = new GamePlayerInfo(1L,"Wed Aug 04 22:39:12 GST 2021",6L,100L);

    		gamePlayerInfoList.add(gamePlayerInfo1);
    		gamePlayerInfoList.add(gamePlayerInfo2);
    		gamePlayerInfoList.add(gamePlayerInfo3);
    		gamePlayerInfoList.add(gamePlayerInfo4);
    		gamePlayerInfoList.add(gamePlayerInfo5);
    		gamePlayerInfoList.add(gamePlayerInfo6);
    		

    		GamePlayerInfo gamePlayerInfo7 = new GamePlayerInfo(2L,"Wed Aug 04 13:37:14 GST 2021",1L,90L);
    		GamePlayerInfo gamePlayerInfo8 = new GamePlayerInfo(2L,"Mon Aug 16 10:34:57 GST 2021",2L,80L);
    		GamePlayerInfo gamePlayerInfo9 = new GamePlayerInfo(2L,"Sun Aug 08 21:20:12 GST 2021",3L,70L);
    		GamePlayerInfo gamePlayerInfo10 = new GamePlayerInfo(2L,"Wed Aug 11 19:38:37 GST 2021",4L,60L);
    		GamePlayerInfo gamePlayerInfo11= new GamePlayerInfo(2L,"Mon Aug 16 10:14:41 GST 2021",5L,50L);
    		GamePlayerInfo gamePlayerInfo12 = new GamePlayerInfo(2L,"Sat Aug 28 09:22:26 GST 2021",6L,40L);

    		
    		gamePlayerInfoList.add(gamePlayerInfo7);
    		gamePlayerInfoList.add(gamePlayerInfo8);
    		gamePlayerInfoList.add(gamePlayerInfo9);
    		gamePlayerInfoList.add(gamePlayerInfo10);
    		gamePlayerInfoList.add(gamePlayerInfo11);
    		gamePlayerInfoList.add(gamePlayerInfo12);
    		
    		GamePlayerInfo gamePlayerInfo13 = new GamePlayerInfo(3L,"Sun Aug 15 00:33:22 GST 2021",1L,200L);
    		GamePlayerInfo gamePlayerInfo14 = new GamePlayerInfo(3L,"Mon Aug 02 12:48:40 GST 2021",2L,190L);
    		GamePlayerInfo gamePlayerInfo15 = new GamePlayerInfo(3L,"Sat Aug 14 04:26:54 GST 2021",3L,180L);
    		GamePlayerInfo gamePlayerInfo16 = new GamePlayerInfo(3L,"Sun Aug 01 22:46:42 GST 2021",4L,170L);
    		GamePlayerInfo gamePlayerInfo17 = new GamePlayerInfo(3L,"Mon Aug 02 18:54:16 GST 2021",5L,160L);
    		GamePlayerInfo gamePlayerInfo18 = new GamePlayerInfo(3L,"Fri Aug 27 13:50:49 GST 2021",6L,150L);

    		gamePlayerInfoList.add(gamePlayerInfo13);
    		gamePlayerInfoList.add(gamePlayerInfo14);
    		gamePlayerInfoList.add(gamePlayerInfo15);
    		gamePlayerInfoList.add(gamePlayerInfo16);
    		gamePlayerInfoList.add(gamePlayerInfo17);
    		gamePlayerInfoList.add(gamePlayerInfo18);
    		
    		//retrieve the top five players higher than average for each game 
    		Map<Long, Map<Long, Long>> gamePlayerInfoMapHigherAverage = 
    				gamePlayerInfoHigherAverage.findPlayersHigherThanAverage(gamePlayerInfoList);
    		
    		Map<Long, Long> mapPlayerHigherThanAveragePoints = gamePlayerInfoMapHigherAverage.get(1L);

    		List<Long> higherThanAveragePointsList = mapPlayerHigherThanAveragePoints.values().stream().collect(Collectors.toList());
    		assertEquals(Long.valueOf(150L), higherThanAveragePointsList.get(0));
    		assertEquals(Long.valueOf(140L), higherThanAveragePointsList.get(1));
    		assertEquals(Long.valueOf(130L), higherThanAveragePointsList.get(2));

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
