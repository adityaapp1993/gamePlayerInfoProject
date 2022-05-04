package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GamePlayerInfoReaderImpl implements IGamePlayerInfoReader{
	@Override
    public List<GamePlayerInfo> readGamePlayerInfoListFromFile(String gamePlayerInfoFile) throws IOException {
		// TODO Auto-generated method stub
    	List<GamePlayerInfo> gamePlayerInfoList = new ArrayList<GamePlayerInfo>();
    	Reader reader = null;
        CSVReader csvReader = null;
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
    	try 
    	{
            br = new BufferedReader(new FileReader(gamePlayerInfoFile));
            br.readLine();
            while ((line = br.readLine()) != null)
            {
            	String[] gamePlayerInfoArray = line.split(splitBy);
            	GamePlayerInfo gamePlayerInfo = new GamePlayerInfo(Long.parseLong(gamePlayerInfoArray[0]),
            		  gamePlayerInfoArray[1],Long.parseLong(gamePlayerInfoArray[2]),
            		  Long.parseLong(gamePlayerInfoArray[3]));
            	gamePlayerInfoList.add(gamePlayerInfo);
            }
        }
    	finally
    	{
    		br.close();
    	}
    	return gamePlayerInfoList;
		
	}

}
