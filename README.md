This project involves a game system that consists of a certain number of players in each game, the date in which the games are played, and the points recorded by each player per game. 
It contains the following fields:

gameId, playerId, playedDate, points


1) In this case, there are 5 games played, and by default, there are 80 players per game. After, the date in which the game is played is randomly generated, where 
the games are played in August 2021, and games are not played on Tuesdays. The same player can play multiple times but not on the same day. Finally, points for each player per game 
is randomly generated between 75 and 200. 
An object of type 'GamePlayerInfo' will be created and used to store the game id, player id, played date, and points.

GamePlayerInfoManagement.java is the starting point for the project, and will refer to the functionalities to be executed
-generating the random data
-writing to csv file
-read from csv file and perform required analysis of data
 
 
2) After each game player information (GamePlayerInfo) is recorded, the data is sent to a csv file.

3) The data is reach from the csv file for the below analysis.
-The top 5 players in points for each game is recorded.
-The bottom 5 players in points for each game is recorded.
-The top 5 players higher than the average points per game is recorded.
-The top 5 players in points for each game per week is recorded (to-do).
-The top 5 players in points for each game per 2 weeks is recorded (to-do).

4) Test cases are performed for the game.
-Checking and verifying certain data of top 5 players for each game.
-Checking and verifying certain data of bottom 5 players for each game.
-Checking and verifying certain data of top 5 players higher than average for each game.
-Checking and verifying certain data of top 5 players per week for each game (to-do).
-Checking and verifying certain data of top 5 players per 2 weeks for each game (to-do).
