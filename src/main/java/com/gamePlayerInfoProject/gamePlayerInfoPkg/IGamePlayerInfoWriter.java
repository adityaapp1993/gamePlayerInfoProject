package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public interface IGamePlayerInfoWriter
{
	public void writeFromGamePlayerInfoList(String file, List<GamePlayerInfo> gamePlayerInfoList) throws IOException,
    CsvDataTypeMismatchException,CsvRequiredFieldEmptyException ;

}
