package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class GamePlayerInfoWriterImpl implements IGamePlayerInfoWriter{
	
    @Override
    public void writeFromGamePlayerInfoList(String file, List<GamePlayerInfo> gamePlayerInfoList) 
    		throws IOException, CsvDataTypeMismatchException,CsvRequiredFieldEmptyException {
		try 
		{    
		    
		    Writer writer = Files.newBufferedWriter(Paths.get(file));
		    
		    // create a csv writer
		    StatefulBeanToCsv<GamePlayerInfo> csvWriter = new StatefulBeanToCsvBuilder<GamePlayerInfo>(writer)
		            .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
		            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
		            .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
		            .withLineEnd(CSVWriter.DEFAULT_LINE_END)
		            .withOrderedResults(false)
		            .build();
		    
		    // write list of objects
		    csvWriter.write(gamePlayerInfoList);

		    // close the writer
		    writer.close();
		}
		finally {
			
		}
    }
}
