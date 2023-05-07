/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csd2522.DB;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.TreeMap;
import com.csd2522.Batter.Batter;
import com.csd2522.FileOutput.FileOutPut;
import com.csd2522.ValidationFormat.StringUtil;

/**
 *
 * @author Daniel Cronauer 4/22/2023 Carried over DB from chapter 19 and used for this project
 */
public class BatterDB {
    // define instance of Connection object
    private static Connection connection;
    //default constructor just creates a connection to the task_list database
    public BatterDB()
    {
        this.getConnection();
    }
    //create a connection to the task_list database
    public void getConnection()
    {
        try 
        {
            String dbUrl = "jdbc:sqlite:Batter.sqlite";
            connection = DriverManager.getConnection(dbUrl);
        } 
        catch (SQLException e) 
        {
            System.out.println("Connection Failed");
            System.err.println(e);   
        }    
        
    }
    // close connection of static variable connection
    public void closeConnection()
    {
        // close connection
        try 
        {
            connection.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e);            
        }
    }
    
    public void printPlayers() {
         try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM TEST"))            
        {
            
            // create ResultSet object
            ResultSet rs = ps.executeQuery();
            
            
            //as long as there is a result in result set we will continue going
            while (rs.next())
            {
                //use column names and result set to get data for code, description price from first record
                int ID = rs.getInt(1);
                String name = rs.getString(2);
                
                
                System.out.println(name);
            }
            
            rs.close();
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query");
            System.out.println(e);
        }    
    }
    // method to return an arraylist of positions based on positions entered in Positions table in database. This way our positions stay standardized between pages DC 5/4/2023
    public ArrayList<String> getPositions() {
        ArrayList<String> positions = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM Positions"))            
        {
            
            // create ResultSet object
            ResultSet rs = ps.executeQuery();
            
            
            //as long as there is a result in result set we will continue going
            while (rs.next())
            {
                //use column names and result set to get data for code, description price from first record
                
                String pos = rs.getString(1);
                
                
                System.out.println(pos);
                positions.add(pos);
            }
            
            rs.close();
            
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query");
            System.out.println(e);
        }    
        
        return positions;
    }
    
    // return Batter object with player id, player last name, and player first name, and player team based on player id passed to this function DC 4/26/2023
    public Batter returnPlayer(int playerID)
    {
        Batter player = null;
           try(PreparedStatement ps = connection.prepareStatement("SELECT Player_id, Player_last_name, Player_first_name, Player_team_id FROM Players "
                 + "WHERE Player_id =? "))            
        {
            
            //tell us what the ? paramter will take value of teamId passed to this method this should filter players to ones assigned to team DC 4/26/2023
            ps.setInt(1,playerID);
            
            // create ResultSet object DC 4/26/2023
            ResultSet rs = ps.executeQuery();
            
            
            rs.next();
            // get variables to build Batter object 4/26/2023
            int PlayerID = rs.getInt(1);
            String lastName = rs.getString(2);
            String firstName = rs.getString(3);
            String team = rs.getString(4);
            
            //make batter object
            player = new Batter(PlayerID,firstName, lastName, team);
            
            
            rs.close();
            
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query filling players");
            System.out.println(e);
        } 
        return player;
    }
    
    // return array team 1 in index zero and team 2 in index 1 on DC 4/30/2023
    public ArrayList<String> returnTeams(int gameID)
    {
        ArrayList<String> teams = new ArrayList<>();
           try(PreparedStatement ps = connection.prepareStatement("SELECT Game_team_one_id FROM Games "
                 + "WHERE Game_id =? "))            
        {
            
            //tell us what the ? paramter will take value of teamId passed to this method this should filter players to ones assigned to team DC 4/30/2023
            ps.setInt(1,gameID);
            
            // create ResultSet object DC 4/30/2023
            ResultSet rs = ps.executeQuery();
            
            
            rs.next();
            // get variables to build get team object DC 4/30/2023
            
            String team = rs.getString(1);
            
            //add string to empty array list at index zero
            teams.add(0,team);
            
            rs.close();
            
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query filling team one");
            System.out.println(e);
        } 
        
          try(PreparedStatement ps = connection.prepareStatement("SELECT Game_team_two_id FROM Games "
                 + "WHERE Game_id =? "))            
        {
            
            //tell us what the ? paramter will take value of teamId passed to this method this should filter players to ones assigned to team DC 4/30/2023
            ps.setInt(1,gameID);
            
            // create ResultSet object DC 4/30/2023
            ResultSet rs = ps.executeQuery();
            
            
            rs.next();
            // get variables to build get team object DC 4/30/2023
            
            String team = rs.getString(1);
            
            //add string to empty array list at index one
            teams.add(1,team);
            
            rs.close();
            
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query filling team two");
            System.out.println(e);
        }    
        return teams;  
    }
    
    
    // This method will link to database and attach teams to HashMap, then return HashMap
    // filled with string for team game and game ID as value pair. DC 4/25/2023
    public HashMap<String,Integer> getTeams() 
    {
        // create hash map filled with game information as key and game id as value DC 4/25/2023
        HashMap<String, Integer> games = new HashMap<>();
         try(PreparedStatement ps = connection.prepareStatement("SELECT Game_id, Game_team_one_id, Game_team_two_id, Game_date FROM Games "))            
        {
            
            // create ResultSet object DC 4/25/2023
            ResultSet rs = ps.executeQuery();
            
            
            //as long as there is a result in result set we will continue going DC 4/25/2023
            while (rs.next())
            {
                // want to get variables for each column from select statement to build games HashMap up DC 4/25/2023
                int gameID = rs.getInt(1);
                String awayTeam = rs.getString(2);
                String homeTeam = rs.getString(3);
                String gameDate = rs.getString(4);
                
                // build string for key DC 4/25/2023
                String key = awayTeam + " vs " + homeTeam + " " + gameDate;
                // add new element to HashMap DC 4/25/2023
                games.put(key, gameID);
                
            }
            
            rs.close();
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query filling teams");
            System.out.println(e);
        }    
         
        //return filled HashMap DC 4/25/2023
        return games;
    }
    
     // This method will link to database and attach players to TreeMap, then return treeMap
    // filled with string player full name as key and player id as value. DC 4/26/2023
    public TreeMap<String,Integer> getPlayers(String teamID) 
    {
//        try(PreparedStatement ps = connection.prepareStatement("SELECT Game_team_one_id, Game_team_two_id, Game_win_id, Game_team_one_score, Game_team_two_score, Game_date "
//                 + "FROM Games WHERE Game_id =?"))  
        // create hash map filled with game information as key and game id as value DC 4/26/2023
        TreeMap<String, Integer> players = new TreeMap<>();
        
         try(PreparedStatement ps = connection.prepareStatement("SELECT Player_id, Player_last_name, Player_first_name, Player_team_id FROM Players "
                 + "WHERE Player_team_id =? ORDER BY 2"))            
        {
            
            //tell us what the ? paramter will take value of teamId passed to this method this should filter players to ones assigned to team DC 4/26/2023
            ps.setString(1,teamID);
            
            // create ResultSet object DC 4/25/2023
            ResultSet rs = ps.executeQuery();
            
            
            //as long as there is a result in result set we will continue going DC 4/26/2023
            while (rs.next())
            {
                // want to get variables for each column from select statement to build players treeMap up DC 4/26/2023
                int playerID = rs.getInt(1);
                String playerLast = rs.getString(2);
                String playerFirst = rs.getString(3);
                String teamText = rs.getString(4);
                
                // build string for key DC 4/26/2023
                
                String key = playerLast + ", " + playerFirst;
                
                // add new element to TreeMap DC 4/26/2023
                players.put(key, playerID);
                
            }
            
            rs.close();
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query filling players");
            System.out.println(e);
        }    
         
        //return filled treeMap DC 4/25/2023
        return players;
    }
    
    public static ArrayList<String> getTeamIDs(){
        ArrayList<String> teamIDList = new ArrayList<>();
        
        try(Statement statement = connection.createStatement())            
        {
            ResultSet rs = statement.executeQuery("SELECT Team_id FROM Teams");
            
            while(rs.next()){
                teamIDList.add(rs.getString(1));
            }
            
            rs.close();
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query filling teams");
            System.out.println(e);
        }    
        // sort so teams list is nicely sorted DC 4/26/2023.
        Collections.sort(teamIDList);
        return teamIDList;
    }    
    // this method will start as test, print game information to console, then when complete, I will 
    // have it print to a file, just like the project requires DC 4/25/2023
    public StringBuilder printGameToFile(int gameId) {
       
        // build nest array list, iv cndex 0 holds team one/away teams batters, index 1 holds team two/home teams batters DC 4/30/2023
        ArrayList<ArrayList<Batter>> playersByTeam = batterStatsOneGame(gameId);
        ArrayList<Batter> awayTeamPlayers = playersByTeam.get(0);
        ArrayList<Batter> homeTeamPlayers = playersByTeam.get(1);
        StringBuilder fileSB = new StringBuilder(2000);
        String awayTeam = "";
        String homeTeam = "";
        String gameDate = "";
        try(PreparedStatement ps = connection.prepareStatement("SELECT Game_team_one_id, Game_team_two_id, Game_win_id, Game_team_one_score, Game_team_two_score, Game_date "
                 + "FROM Games WHERE Game_id =?"))            
        {
            //tell us what the ? paramter will take value of gameId passed to this method DC 4/25/2023
            ps.setInt(1,gameId);
            // create ResultSet object DC 4/25/2023
            ResultSet rs = ps.executeQuery();
            
            //define stringbuilder object here so we can effiecinetly build string to print to console and later print to file
            
            
            //as long as there is a result in result set we will continue going DC 4/25/2023
            while (rs.next())
            {
                //use define variables for all the columns from select statement above DC 4/25/2023
                awayTeam = rs.getString(1);
                homeTeam = rs.getString(2);
                String winTeam = rs.getString(3);
                int awayScore = rs.getInt(4);
                int homeScore = rs.getInt(5);
                gameDate = rs.getString(6);
                
                fileSB.append("The away team is:").append(awayTeam).append("\nThe home team is: ").append(homeTeam).append("\nThe winning team is: ").append(winTeam).append("\nThe away team scored: ").append(awayScore).append("\nThe home team scored: ").append(homeScore).append("\nThe game was on: ").append(gameDate);
            }
            
            rs.close();
            
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query");
            System.out.println(e);
        }
        
        //Start with header for player stats build as string DC 4/30/2023
        String headerLineStats =  "\nTeam Batting Stats for "+ awayTeam + StringUtil.padWithSpaces("\nPlayer",35) + "ab " + " r " + " h " + "rbi " + "bb " + "so " + "hp " + "1B " + "2B " + "3B "+ "HR\n";
        fileSB.append(headerLineStats).append(StringUtil.repeatString("_", 72) + "\n");
        
        //now want to iterate over the away team DC 4/30/2023
        for(Batter player : awayTeamPlayers)
        {
            // headline is first part
            String playerHeadline = player.getLastName() + ", " + player.getFirstName() + " " + player.getPosition();
            fileSB.append(StringUtil.padWithSpaces(playerHeadline, 35));
            // build stats string based on batter instance DC 4/30/2023
            String playerStats = StringUtil.padWithSpacesReverse(""+player.getAB(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getRuns(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getHits(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getRbi(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getBb(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getSo(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getHp(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getFB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getSB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getTB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getHR(), 2) + " \n";
            fileSB.append(playerStats);
        }
        //End away team
        fileSB.append(StringUtil.repeatString("_", 72) + "\n");
        
        String headerLineStatsHome =  "\nTeam Batting Stats for "+ homeTeam + StringUtil.padWithSpaces("\nPlayer",35) + "ab " + " r " + " h " + "rbi " + "bb " + "so " + "hp " + "1B " + "2B " + "3B "+ "HR\n";
        fileSB.append(headerLineStatsHome).append(StringUtil.repeatString("_", 72) + "\n");
        
        // fill home team/team two stats
        for(Batter player : homeTeamPlayers)
        {
            // headline is first part
            String playerHeadline = player.getLastName() + ", " + player.getFirstName() + " " + player.getPosition();
            fileSB.append(StringUtil.padWithSpaces(playerHeadline, 35));
            // build stats string based on batter instance DC 4/30/2023
            String playerStats = StringUtil.padWithSpacesReverse(""+player.getAB(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getRuns(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getHits(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getRbi(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getBb(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getSo(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getHp(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getFB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getSB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getTB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getHR(), 2) + " \n";
            fileSB.append(playerStats);
        }
        fileSB.append(StringUtil.repeatString("_", 72) + "\n");
        
        //print string build object to console as test, in future we will just print this whole string to the file
        System.out.println(fileSB.toString());
        
        // create file name
        String fileName = awayTeam + " vs " + homeTeam + " " + gameDate;
        
        //create file
        FileOutPut.writeFile(fileSB.toString(),fileName);
        
        return fileSB;
    }
    

    // add player to DB DC 4/27/2023
    public void insertPlayer(Batter playerUpdate) { 
        //String to build sql insert for PreparedStatement
        String insertTask = "INSERT INTO Players (Player_last_name, Player_first_name, Player_team_id)"
                + " VALUES(?,?,?)";
        
        // get player information from Batter class to perform insert on Players table DC 4/27/2023
        String playerFirst = playerUpdate.getFirstName();
        String playerLast = playerUpdate.getLastName();
        String team = playerUpdate.getTeam();
        // build PreparedStatement object with string above
        try(PreparedStatement ps = connection.prepareStatement(insertTask))            
        {
            
            // define paramter values then execute SQL statement DC 4/27/2023
            ps.setString(1, playerLast);
            ps.setString(2, playerFirst);
            ps.setString(3, team);
            
           
            ps.executeUpdate();
            
        }
        catch (SQLException e)
        {        
            System.out.println(e);
        }    
        
    }
        // this will update player id attached Batter instance with the other information attached to object DC 4/27/2023
        public void updatePlayer(Batter playerUpdate) { 
        //String to build sql insert for PreparedStatement
        String updatePlayer = "UPDATE Players SET Player_last_name =?, Player_first_name=?, Player_team_id=?"
                + " WHERE Player_id =?";
        // get player information from Batter class to perform update on Players table DC 4/27/2023
        int playerID = playerUpdate.getPlayerID();
        String playerFirst = playerUpdate.getFirstName();
        String playerLast = playerUpdate.getLastName();
        String team = playerUpdate.getTeam();
        
        // build PreparedStatement object with string above
        try(PreparedStatement ps = connection.prepareStatement(updatePlayer))            
        {
            
            // define paramter values then execute SQL statement 4/27/2023
            ps.setString(1, playerLast);
            ps.setString(2, playerFirst);
            ps.setString(3, team);
            ps.setInt(4, playerID);
            
           
            ps.executeUpdate();
            
        }
        catch (SQLException e)
        {        
            System.out.println(e);
        }    
        
    }

    // delete player from database based on Batter instance passed to this method DC 4/28/2023    
    public void deletePlayer(Batter player)
    {
        //perform delete statement, delete records that have Player_id = ?
        try(PreparedStatement ps = connection.prepareStatement("DELETE FROM Players WHERE Player_id = ?"))            
        {
            // get player_id from batter object
            int playerID = player.getPlayerID();
            // tell us that ? parameter will take TaskId
            ps.setInt(1, playerID);
            // execute delete
            ps.executeUpdate(); 
        }
        catch (SQLException e)
        {        
            System.out.println(e);
        }    
    }
    
    //insert batter with all fields when filling out BatterStatsGui DC 5/4/2023
    public void insertBatterStats(Batter currentBatter, int gameID)
    {
        

        String team = currentBatter.getTeam();
        String pos = currentBatter.getPosition();
        int PlayerID = currentBatter.getPlayerID();
        int ab = currentBatter.getAB();
        int runs = currentBatter.getRuns();
        int hits = currentBatter.getHits();
        int rbi = currentBatter.getRbi();
        int bb = currentBatter.getBb();
        int so = currentBatter.getSo();
        int hp = currentBatter.getHp();
        int fb = currentBatter.getFB();
        int sb = currentBatter.getSB();
        int tb = currentBatter.getTB();
        int hr = currentBatter.getHR();
        int total = currentBatter.calculateBases();
        
        
       
        
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO Batter_Stats "
                + "(Batter_stat_team_id, Batter_stat_player_id, Batter_stat_pos_id, "
                + "Batter_stat_ab, Batter_stat_runs, Batter_stat_hits, Batter_stat_rbi, Batter_stat_bb, Batter_stat_so, Batter_stat_hbp,"
                + " Batter_stat_FB, Batter_stat_SB, Batter_stat_TB, Batter_stat_hr, Batter_stat_total_bases, Batter_stat_game_id)"
                +" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"))            
        {    
                //use take variables derived from batter passed to method above to define the value to insert for each field in insert statement DC 5/4/2023
                ps.setString(1,team);
                ps.setInt(2,PlayerID);
                ps.setString(3,pos);
                ps.setInt(4,ab);
                ps.setInt(5,runs);
                ps.setInt(6,hits);
                ps.setInt(7,rbi);
                ps.setInt(8,bb);
                ps.setInt(9,so);
                ps.setInt(10,hp);
                ps.setInt(11,fb);
                ps.setInt(12,sb);
                ps.setInt(13,tb);
                ps.setInt(14,hr);
                ps.setInt(15,total);
                ps.setInt(16, gameID);
                
             ps.executeQuery();   
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query away teams batter one");
            System.out.println(e);
        }
    }
    
      // returns an ArrayList of all the seasons(years) in the Games table GAGE 
    public static ArrayList<String> getSeasons(){
        ArrayList<String> seasonsList = new ArrayList<>();
        boolean matchFound = false;

        try(Statement statement = connection.createStatement())            
        {
            ResultSet rs = statement.executeQuery("SELECT Game_date FROM Games");

            while(rs.next()){
                String unsplit = rs.getString(1);

                String[] split = unsplit.split("-");
                matchFound = false;
                if(seasonsList.size() > 0){
                    for(String x : seasonsList){
                        if(x.equals(split[0])){
                            matchFound = true;
                            break;
                        }
                    }
                }

                if(matchFound == false){
                    seasonsList.add(split[0]);
                }
            }

            rs.close();
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query filling seasons");
            System.out.println(e);
        }    
        // sort so teams list is nicely sorted DC 4/26/2023.
        Collections.sort(seasonsList);
        return seasonsList;
    } 
    /** 
     * 
     * @param gameID game id
     * @param awayTeamID id of away team
     * @param homeTeamID id of home team
     * @return ArrayList with two away lists of Batters. One array holds away teams in zero index other holds home teams in index 1
     * This method will take in a gameId and then provide an arraylist of two array lists that store the batter instances
     * of each team. So we can iterator over this later to build the game id report
     */
    public ArrayList<ArrayList<Batter>> batterStatsOneGame(int gameID)
    {
        // need to define both teams in their own list to catch the players in the correct team for the report DC 4/30/2023.
        ArrayList<Batter> awayTeamPlayers = new ArrayList<>();
        ArrayList<Batter> homeTeamPlayers = new ArrayList<>();
        ArrayList<ArrayList<Batter>> awayHomeArray = new ArrayList<>();
        ArrayList<String> teams = returnTeams(gameID);
        System.out.println(teams.get(0));
        // first start with filling awayTeamPlayers DC 4/30/2023
        try(PreparedStatement ps = connection.prepareStatement("SELECT Batter_stat_team_id, Batter_stat_player_id, Batter_stat_pos_id, "
                + "Batter_stat_ab, Batter_stat_runs, Batter_stat_hits, Batter_stat_rbi, Batter_stat_bb, Batter_stat_so, Batter_stat_hbp,"
                + " Batter_stat_FB, Batter_stat_SB, Batter_stat_TB, Batter_stat_hr, Batter_stat_total_bases"
                 + " FROM Batter_Stats WHERE Batter_stat_game_id =? AND Batter_stat_team_id=?"))            
        {
            
            //tell us what the ? paramter will take value of gameID and awayTeam passed to this method DC 4/30/2023
            ps.setInt(1,gameID);
            ps.setString(2, teams.get(0)); // away team is in team one id, else if nuetral game get team at index zero
            // create ResultSet object DC 4/30/2023
            ResultSet rs = ps.executeQuery();
            
            
            
            //as long as there is a result in result set we will continue going DC 4/30/2023
            while (rs.next())
            {
                //use define variables for all the columns from select statement above DC 4/30/2023
                String batterTeam = rs.getString(1);
                int batterID = rs.getInt(2);
                String position = rs.getString(3);
                int atBat = rs.getInt(4);
                int runs = rs.getInt(5);
                int hits = rs.getInt(6);
                int rbi = rs.getInt(7);
                int bb = rs.getInt(8);
                int so = rs.getInt(9);
                int hbp = rs.getInt(10);
                int fb = rs.getInt(11);
                int sb = rs.getInt(12);
                int tb = rs.getInt(13);
                int hr = rs.getInt(14);
                int totalBase = rs.getInt(15);
                
                //Build batter object based on player Id by using returnPlayer DC 4/20/2023
                Batter currentBatter = this.returnPlayer(batterID);
                
                //now want to set various properties of batter based on results from select statement DC 4/30/2023
                currentBatter.setTeam(batterTeam);
                currentBatter.setPosition(position);
                currentBatter.setAB(atBat);
                currentBatter.setRuns(runs);
                currentBatter.setHits(hits);
                currentBatter.setRbi(rbi);
                currentBatter.setBb(bb);
                currentBatter.setSo(so);
                currentBatter.setHp(hbp);
                currentBatter.setFB(fb);
                currentBatter.setSB(sb);
                currentBatter.setTB(tb);
                currentBatter.setHR(hr);
                currentBatter.setTotalBase(totalBase);
                
                awayTeamPlayers.add(currentBatter);
                
                
            }
            
            rs.close();
            
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query away teams batter one");
            System.out.println(e);
        }
        // this will add home team players and log their stats to batter instances DC 4/30/2023
        try(PreparedStatement ps = connection.prepareStatement("SELECT Batter_stat_team_id, Batter_stat_player_id, Batter_stat_pos_id, "
                + "Batter_stat_ab, Batter_stat_runs, Batter_stat_hits, Batter_stat_rbi, Batter_stat_bb, Batter_stat_so, Batter_stat_hbp, "
                + "Batter_stat_FB, Batter_stat_SB, Batter_stat_TB, Batter_stat_hr, Batter_stat_total_bases "
                 + "FROM Batter_Stats WHERE Batter_stat_game_id =? AND Batter_stat_team_id=?"))            
        {
            
            //tell us what the ? paramter will take value of gameID and awayTeam passed to this method DC 4/30/2023
            ps.setInt(1,gameID);
            ps.setString(2, teams.get(1)); // get second element in teams array this represents home team or team two in nuetral game
            // create ResultSet object DC 4/30/2023
            ResultSet rs = ps.executeQuery();
            
            
            
            //as long as there is a result in result set we will continue going DC 4/30/2023
            while (rs.next())
            {
                //use define variables for all the columns from select statement above DC 4/30/2023
                String batterTeam = rs.getString(1);
                int batterID = rs.getInt(2);
                String position = rs.getString(3);
                int atBat = rs.getInt(4);
                int runs = rs.getInt(5);
                int hits = rs.getInt(6);
                int rbi = rs.getInt(7);
                int bb = rs.getInt(8);
                int so = rs.getInt(9);
                int hbp = rs.getInt(10);
                int fb = rs.getInt(11);
                int sb = rs.getInt(12);
                int tb = rs.getInt(13);
                int hr = rs.getInt(14);
                int totalBase = rs.getInt(15);
                
                //Build batter object based on player Id by using returnPlayer DC 4/20/2023
                Batter currentBatter = this.returnPlayer(batterID);
                
                //now want to set various properties of batter based on results from select statement DC 4/30/2023
                currentBatter.setTeam(batterTeam);
                currentBatter.setPosition(position);
                currentBatter.setAB(atBat);
                currentBatter.setRuns(runs);
                currentBatter.setHits(hits);
                currentBatter.setRbi(rbi);
                currentBatter.setBb(bb);
                currentBatter.setSo(so);
                currentBatter.setHp(hbp);
                currentBatter.setFB(fb);
                currentBatter.setSB(sb);
                currentBatter.setTB(tb);
                currentBatter.setHR(hr);
                currentBatter.setTotalBase(totalBase);
                
                homeTeamPlayers.add(currentBatter);
                
                
            }
            
            rs.close();
            
            
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query home teams batter one ");
            System.out.println(e);
        }
        awayHomeArray.add(0,awayTeamPlayers);
        awayHomeArray.add(1,homeTeamPlayers);
        
        
        return awayHomeArray;
    }
    
    /*
    Author: Andrew McKee
    Added: 5/1/2023
    Purpose: Takes information entered by the user and enters it into Games
    */
    public void insertGame(String awayTeam, String homeTeam, int awayScore, int homeScore, String date) {
        
        // Makes a prepared statement
        String sql = "INSERT INTO Games (Game_team_one_id, Game_team_two_id, Game_win_id, Game_team_one_score, Game_team_two_score, Game_date) "
                + "VALUES (?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql))            
        {
            
            // Compares scores and declares the winner
            String winningTeamName;
            if (awayScore > homeScore) {
                winningTeamName = awayTeam;
            } else {
                winningTeamName = homeTeam;
            }
           
            // Enters information into Games
            ps.setString(1, awayTeam);
            ps.setString(2, homeTeam);
            ps.setString(3, winningTeamName);
            ps.setInt(4, awayScore);
            ps.setInt(5, homeScore);
            ps.setString(6, date);
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e)
        {        
            System.out.println(e);
        }
    }
    
    public ArrayList<Batter> statsByGame(String startDate, String endDate, String teamID){
        String byGame = 
        "SELECT DISTINCT Batter_stat_player_id FROM Batter_Stats, Games WHERE "
        + "Batter_stat_game_id = Game_id AND (Game_date Between ? AND ?)  AND "
        + "Batter_stat_team_id = ?";
        
        ArrayList<Batter> batterList = new ArrayList<>();
        
        try(PreparedStatement ps = connection.prepareStatement(byGame)){
                ps.setString(1, startDate);
                ps.setString(2, endDate);
                ps.setString(3, teamID);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    
                    Batter player = returnPlayer(rs.getInt(1));
                    
                    batterList.add(player);
                }
        }
        catch (SQLException e)
        {        
            System.out.println(e);
        }
                
        for(Batter ply : batterList){
            byGame = "SELECT SUM(Batter_stat_ab), Sum(Batter_stat_runs), Sum(Batter_stat_hits), Sum(Batter_stat_rbi), Sum(Batter_stat_bb), Sum(Batter_stat_so),"
                    + "Sum(Batter_stat_po), Sum(Batter_stat_lob), Sum(Batter_stat_hbp), Sum(Batter_stat_FB), Sum(Batter_stat_SB), Sum(Batter_stat_TB), Sum(Batter_stat_hr),"
                    + "Sum(Batter_stat_total_bases) FROM "
                    + "Batter_stats, Games WHERE Batter_stat_game_id = Game_id  "
                    + "AND Batter_stat_team_id = ? AND Batter_stat_player_id = ? "
                    + "AND (Game_date Between ? AND ?)";
            
            try(PreparedStatement ps = connection.prepareStatement(byGame)){
                ps.setString(1, teamID);
                ps.setInt(2, ply.getPlayerID());
                ps.setString(3, startDate);
                ps.setString(4, endDate);
                
                ResultSet rs = ps.executeQuery();
                // Gets all the stats
                int atBat = rs.getInt(1);
                int runs = rs.getInt(2);
                int hits = rs.getInt(3);
                int rbi = rs.getInt(4);
                int bb = rs.getInt(5);
                int so = rs.getInt(6);
                int hbp = rs.getInt(7);
                int fb = rs.getInt(8);
                int sb = rs.getInt(9);
                int tb = rs.getInt(10);
                int hr = rs.getInt(11);
                int totalBase = rs.getInt(13);
                
                // sets all the stats
                ply.setAB(atBat);
                ply.setRuns(runs);
                ply.setHits(hits);
                ply.setRbi(rbi);
                ply.setBb(bb);
                ply.setSo(so);
                ply.setHp(hbp);
                ply.setFB(fb);
                ply.setSB(sb);
                ply.setTB(tb);
                ply.setHR(hr);
                ply.setTotalBase(totalBase);          
            }
            catch (SQLException e)
            {        
                System.out.println(e);
            }
        }
        return batterList;
    }
    
    public  ArrayList<Batter> statsBySeason(String teamID, String year){
        String byGame = 
        "SELECT DISTINCT Batter_stat_player_id FROM Batter_Stats, Games WHERE "
        + "Batter_stat_game_id = Game_id AND (Game_date >= ?)  AND "
        + "Batter_stat_team_id = ?";
        
        ArrayList<Batter> batterList = new ArrayList<>();
        
        try(PreparedStatement ps = connection.prepareStatement(byGame)){
                ps.setString(1, year + "-01-01");
                ps.setString(2, teamID);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    
                    Batter player = returnPlayer(rs.getInt(1));
                    
                    batterList.add(player);
                }
        }
        catch (SQLException e)
        {        
            System.out.println(e);
        }
        ArrayList<Batter> updatedBatterList = new ArrayList<>();
        for(Batter ply : batterList){
            byGame = "SELECT SUM(Batter_stat_ab), Sum(Batter_stat_runs), Sum(Batter_stat_hits), Sum(Batter_stat_rbi), Sum(Batter_stat_bb), Sum(Batter_stat_so),"
                    + "Sum(Batter_stat_po), Sum(Batter_stat_lob), Sum(Batter_stat_hbp), Sum(Batter_stat_FB), Sum(Batter_stat_SB), Sum(Batter_stat_TB), Sum(Batter_stat_hr),"
                    + "Sum(Batter_stat_total_bases) FROM "
                    + "Batter_stats, Games WHERE Batter_stat_game_id = Game_id  "
                    + "AND Batter_stat_team_id = ? AND Batter_stat_player_id = ? "
                    + "AND (Game_date >= ?)";
            
            try(PreparedStatement ps = connection.prepareStatement(byGame)){
                ps.setString(1, teamID);
                ps.setInt(2, ply.getPlayerID());
                ps.setString(3, year + "01-01");
                
                ResultSet rs = ps.executeQuery();
                // Gets all the stats
                int atBat = rs.getInt(1);
                int runs = rs.getInt(2);
                int hits = rs.getInt(3);
                int rbi = rs.getInt(4);
                int bb = rs.getInt(5);
                int so = rs.getInt(6);
                int hbp = rs.getInt(7);
                int fb = rs.getInt(8);
                int sb = rs.getInt(9);
                int tb = rs.getInt(10);
                int hr = rs.getInt(11);
                int totalBase = rs.getInt(13);
                
                // sets all the stats
                ply.setAB(atBat);
                ply.setRuns(runs);
                ply.setHits(hits);
                ply.setRbi(rbi);
                ply.setBb(bb);
                ply.setSo(so);
                ply.setHp(hbp);
                ply.setFB(fb);
                ply.setSB(sb);
                ply.setTB(tb);
                ply.setHR(hr);
                ply.setTotalBase(totalBase);    
                
                updatedBatterList.add(ply);
            }
            catch (SQLException e)
            {        
                System.out.println(e);
            }
        }
        return updatedBatterList;
    }
    
    public StringBuilder printStatsToFile(ArrayList<Batter> batterList, String teamID , String type) {
        StringBuilder fileSB = new StringBuilder(2000);
        
        //Start with header for player stats build as string DC 4/30/2023
        String headerLineStats =  "\nAggregate Batting Stats for "+ teamID + StringUtil.padWithSpaces("\nPlayer",35) + "slg" + "ab " + " r " + " h " + "rbi " + "bb " + "so " + "hp " + "1B " + "2B " + "3B "+ "HR\n";
        fileSB.append(headerLineStats).append(StringUtil.repeatString("_", 72) + "\n");
        
        //now want to iterate over the away team DC 4/30/2023
        for(Batter player : batterList)
        {
            // headline is first part
            String playerHeadline = player.getLastName() + ", " + player.getFirstName() + " " + player.getPosition();
            fileSB.append(StringUtil.padWithSpaces(playerHeadline, 35));
            // build stats string based on batter instance DC 4/30/2023
            String playerStats = 
                      StringUtil.padWithSpacesReverse(""+player.getSLG(), 1) + "% "
                    + StringUtil.padWithSpacesReverse(""+player.getOBP(), 1) + "% "
                    + StringUtil.padWithSpacesReverse(""+player.getAB(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getRuns(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getHits(), 1) + "  "
                    + StringUtil.padWithSpacesReverse(""+player.getRbi(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getBb(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getSo(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getHp(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getFB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getSB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getTB(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getHR(), 2) + " "
                    + StringUtil.padWithSpacesReverse(""+player.getTotalBase() , 2) + " \n";
            fileSB.append(playerStats);
        }
        //End away team
        fileSB.append(StringUtil.repeatString("_", 72) + "\n");
        
        //print string build object to console as test, in future we will just print this whole string to the file
        System.out.println(fileSB.toString());
        
        // create file name
        String fileName = teamID.replace(" ", "_") + "_Aggregate_Stats_" + type + ".txt";
        
        //create file
        FileOutPut.writeFile(fileSB.toString(),fileName);
        
        return fileSB;
    }
}
