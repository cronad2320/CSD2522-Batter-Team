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
    public void printGameToFile(int gameId) {
         try(PreparedStatement ps = connection.prepareStatement("SELECT Game_team_one_id, Game_team_two_id, Game_win_id, Game_team_one_score, Game_team_two_score, Game_date "
                 + "FROM Games WHERE Game_id =?"))            
        {
            //tell us what the ? paramter will take value of gameId passed to this method DC 4/25/2023
            ps.setInt(1,gameId);
            // create ResultSet object DC 4/25/2023
            ResultSet rs = ps.executeQuery();
            
            //define stringbuilder object here so we can effiecinetly build string to print to console and later print to file
            StringBuilder fileSB = new StringBuilder(500);
            
            //as long as there is a result in result set we will continue going DC 4/25/2023
            while (rs.next())
            {
                //use define variables for all the columns from select statement above DC 4/25/2023
                String awayTeam = rs.getString(1);
                String homeTeam = rs.getString(2);
                String winTeam = rs.getString(3);
                int awayScore = rs.getInt(4);
                int homeScore = rs.getInt(5);
                String gameDate = rs.getString(6);
                
                fileSB.append("The away team is:" + awayTeam + "\nThe home team is: " +homeTeam + "\nThe winning team is: " +winTeam + "\nThe away team scored: " + awayScore
                + "\nThe home team scored: " +homeScore + "\nThe game was on: " + gameDate);
            }
            
            rs.close();
            
            //print string build object to console as test, in future we will just print this whole string to the file
            System.out.println(fileSB.toString());
        }
        catch (SQLException e)
        {       
            System.out.println("Error in query");
            System.out.println(e);
        }    
    }
    

    // add player to DB DC 4/27/2023
    public void insertPlayer(Batter playerUpdate) { 
        //String to build sql insert for PreparedStatement
        String insertTask = "INSERT INTO Players (Player_last_name, Player_first_name, Player_team_id)"
                + "VALUES(?,?,?)";
        
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
}
