/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csd2522.DB;


import java.sql.*;
/**
 *
 * @author Locke
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
//    
//    // this method should print all completed tasks
//    public void printCompletedTasks() {
//         try(PreparedStatement ps = connection.prepareStatement("SELECT *FROM Task WHERE completed = ?"))            
//        {
//            // tell us that ? parameter will take one, we are doing this since pending are 0 completed are 1
//            ps.setInt(1, 1);
//            // create ResultSet object
//            ResultSet rs = ps.executeQuery();
//            
//            //set count to 1 so we can sequentially number the tasks that are pending
//            int count = 1;
//            
//            //as long as there is a result in result set we will continue going
//            while (rs.next())
//            {
//                //use column names and result set to get data for code, description price from first record
//                int TaskId = rs.getInt(1);
//                String description = rs.getString(2);
//                int completeInt = rs.getInt(3);
//                
//                boolean complete = false;
//                // convert completeInt to boolean
//                if(completeInt != 0)
//                {
//                    //if value int is not 0, then we have a true value so set 
//                    // complete to true
//                    complete = true;
//                }
//                
//                // now build product instance with this info
//                //Task t = new Task(TaskId,description, complete);
//                // print description for task
//               // System.out.println(count+ ". " + t.getDescription() + " (DONE!)");
//                //increase count
//                count++;
//            }
//            
//            rs.close();
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }    
//    }
//    
//     // add new task to the database, only need description
//    public void insertTask(int t) { 
//        //String to build sql insert for PreparedStatement
//        String insertTask = "INSERT INTO Task (description, completed)"
//                + "VALUES(?,?)";
//        // build PreparedStatement object with string above
//        try(PreparedStatement ps = connection.prepareStatement(insertTask))            
//        {
//            
//            // define paramter values then execute SQL statement
//            ps.setString(1, t);
//            
//            int complete = 0;
//            //get value from bool set integer based on result
//            if(t.isCompleted())
//            {
//                //this should never happen by default, but in case it does
//                // we will want to make complete equal to 1
//                complete = 0;
//            }
//            // set complete field to result of complete int
//            ps.setInt(2, complete);
//            // execute insert based on task t data variables
//            ps.executeUpdate();
//            //add line whitespace
//            System.out.println();
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }    
//        
//    }
//    // want function to get the numTasks that are pending
//    public int numPendingTasks()
//    {
//        //we will use count in order to see the amount of rows in result set (which counts the pending items
//        int count = 0;
//        try(PreparedStatement ps = connection.prepareStatement("SELECT *FROM Task WHERE completed = ?"))            
//        {
//            // tell us that ? parameter will take zero, we are doing this since pending are 0 completed are 1
//            ps.setInt(1, 0);
//            // create ResultSet object
//            ResultSet rs = ps.executeQuery();
//                        
//            //as long as there is a result in result set we will continue going
//            while (rs.next())
//            {
//                count++;
//            }
//            rs.close();
//            
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }
//        // this is the count of pending items in Task table, will use this max for some of the other functions
//        return count;
//    }
//    
//        // want function to get the numTasks that are completed
//    public static int numCompletedTasks()
//    {
//        //we will use count in order to see the amount of rows in result set (which counts the pending items
//        int count = 0;
//        try(PreparedStatement ps = connection.prepareStatement("SELECT *FROM Task WHERE completed = ?"))            
//        {
//            // tell us that ? parameter will take zero, we are doing this since pending are 0 completed are 1
//            ps.setInt(1, 1);
//            // create ResultSet object
//            ResultSet rs = ps.executeQuery();
//                        
//            //as long as there is a result in result set we will continue going
//            while (rs.next())
//            {
//                count++;
//            }
//            rs.close();
//            
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }
//        // this is the count of completed items in Task table, will use this max for some of the other functions
//        return count;
//    }
//    // change item from pending to completed based on integer passed to this function
//    public void completeTask(int stop) {
//        //set task and count variable
//        //set count to 1 so we can sequentially number the tasks that are pending
//        int count = 1;
//        // define task object
//        Task t = new Task();
//        try(PreparedStatement ps = connection.prepareStatement("SELECT *FROM Task WHERE completed = ?"))            
//        {
//            // tell us that ? parameter will take zero, we are doing this since pending are 0 completed are 1
//            ps.setInt(1, 0);
//            // create ResultSet object
//            ResultSet rs = ps.executeQuery();
//            
//            //as long as there is a result in result set we will continue going as long as count <= stop
//            while (rs.next() && count <= stop)
//            {
//                if(count == stop)
//                {
//                    //use column names and result set to get data for code, description price from first record
//                    int TaskId = rs.getInt(1);
//                    String description = rs.getString(2);
//                    int completeInt = rs.getInt(3);
//                    
//                      
//                    boolean complete = false;
//                    // convert completeInt to boolean
//                    if(completeInt != 0)
//                    {
//                        //if value int is not 0, then we have a true value so set 
//                        // complete to true
//                        complete = true;
//                    }
//                
//                    // now build product instance with this info
//                    t.setTaskId(TaskId);
//                    t.setDescription(description);
//                    t.setCompleted(complete);
//                }  
//                //increase count
//                count++;
//            }
//            rs.close();
//            // now call setComplete passing TaskId to function
//            setComplete(t.getTaskId());
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }    
//    }
//    
//    public void setComplete(int TaskId)
//    {
//        //perform update statement, set field completed to 1 where taskId equal paramter value
//        try(PreparedStatement ps = connection.prepareStatement("UPDATE Task SET completed = 1 WHERE taskId = ?"))            
//        {
//            // tell us that ? parameter will take TaskId
//            ps.setInt(1, TaskId);
//            // execute update
//            ps.executeUpdate(); 
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }    
//    }
//    
//    // delete item based on int passed to this function, this number should match to the sequential number for items listed in history
//    public  void deleteTask(int stop) {
//        //set task and count variable
//        //set count to 1 so we can sequentially number the tasks that are pending
//        int count = 1;
//        // define task object
//        Task t = new Task();
//        try(PreparedStatement ps = connection.prepareStatement("SELECT *FROM Task WHERE completed = ?"))            
//        {
//            // tell us that ? parameter will take 1, we are doing this since pending are 0 completed are 1
//            ps.setInt(1, 1);
//            // create ResultSet object
//            ResultSet rs = ps.executeQuery();
//            
//            //as long as there is a result in result set and count less than or equal to stop we will continue going
//            while (rs.next() && count <= stop)
//            {
//                if(count == stop)
//                {
//                    //use column names and result set to get data for code, description price from first record
//                    int TaskId = rs.getInt(1);
//                    String description = rs.getString(2);
//                    int completeInt = rs.getInt(3);
//                    
//                      
//                    boolean complete = false;
//                    
//                    // convert completeInt to boolean
//                    if(completeInt != 0)
//                    {
//                        //if value int is not 0, then we have a true value so set 
//                        // complete to true
//                        complete = true;
//                    }
//                
//                    // now build product instance with this info
//                    t.setTaskId(TaskId);
//                    t.setDescription(description);
//                    t.setCompleted(complete);
//                }  
//                //increase count
//                count++;
//            }
//            rs.close();
//            // now call setComplete passing TaskId to function
//            setDelete(t.getTaskId());
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }    
//    }
//    
//    public void setDelete(int TaskId)
//    {
//        //perform delete statement, delete records that have taskId = ?
//        try(PreparedStatement ps = connection.prepareStatement("DELETE FROM Task WHERE taskId = ?"))            
//        {
//            // tell us that ? parameter will take TaskId
//            ps.setInt(1, TaskId);
//            // execute delete
//            ps.executeUpdate(); 
//        }
//        catch (SQLException e)
//        {        
//            System.out.println(e);
//        }    
//    }
}


