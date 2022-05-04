package com.gamePlayerInfoProject.gamePlayerInfoPkg;
import java.io.IOException;
import java.util.List;

public interface IGamePlayerInfoReader {

	public List<GamePlayerInfo> readGamePlayerInfoListFromFile(String gamePlayerInfoFile) throws IOException;
}
