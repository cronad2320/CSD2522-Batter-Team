/*
    Author: Daniel Cronauer
    Date: 2/3/2023
    File: Validation.java
    Purpose: This will handle validation of inputs.
    Update: Initial upload of validation class 
    Update: 4/29/2023 DC added a method isAlpha in order to test 
    that a string exists and that the string
*/
package com.csd2522.ValidationFormat;

/**
 *
 * @author Locke
 */
import java.util.List;
import javafx.scene.control.Alert;

/**
 * This class will provide validation for input controls. Either check that it 
 * has a value, is a digit, or is a string of alphabet characters
 */
public class Validation {
    /** 
     * @param value pass string to method we are checking for empty status
     * @return return blank if string was not empty, otherwise return message
    */
    public String isPresent(String value, String name) {
        // declare variable was missing msg
        String msg = "";
        //check if string passed to this app is empty, if so add message
        if (value.isEmpty()) {
            msg = name + " is required. \n";
        }
        return msg;
    }
    
    /** 
     * @param value pass string to method we are checking for empty status
     * @return return true if string was not empty, otherwise return false
    */
    public Boolean isPresent(String value) {
        // declare boolean default to true
        boolean msg = true; 
        //check if string passed to this app is empty, if so turn false
        if (value.isEmpty()) {
            msg = false;
        }
        return msg;
    }
    
    /**
     * @param list is a List string passed that we will check if it contains
     * the value of the next param passed
     * @param name this string is the search value that we will check list for
     * @return a string notifying user that the player already exists
     */
    public String listHasValue(List<String> list, String value, String name) {
        // declare variable was missing msg
        String msg = "";
        if (list.contains(value)) {
            msg = name + " already has a player for " + value +"\n";
        }
        return msg;
    }

    /**
     @param s; pass section string to attempt to parse
     @return returns true if double else false 
     Attempt to parse string to double is no error return true, else return false
     */  
    public static boolean isDouble(String s)
    {
           boolean doubleStatus = false;
           // if successful we will return parsed double else give error
           try
           {
                 Double.parseDouble(s);
                 doubleStatus = true;
           } catch(NumberFormatException e)
           {
                System.out.println("Attempted push value was not a valid double.\n");
                doubleStatus = false;
           }
           return doubleStatus;
    
    }
    
    
     /**
     @param s; pass section string then check to make sure characters are alpha
     @return returns true if string contains all alpha
     Check string for all characters to be blank or alphabetic
     */    
    public static boolean isAlpha(String s)
    {
           boolean alphaStatus = false;
           int count = 0;
           // if successful we will return parsed double else give error
           try
           {
              
              // if length is >0 set to true, then for loop will test for false 
              if(s.length() > 0)
              {
                  alphaStatus = true;
              }
                char check = 0;
                // first check if string greater than 0 in length 
                // can add two conditions to for loop dc 4/29/2023
                for (int i = 0; s.length() > 0 && i < s.length(); i++)
                {
                    
                    // store value of character at current index in string dc 4/29/2023
                    check = s.charAt(i);
                    
                    //use if statement to check if current character is alphabetic or space
                    if( !(Character.isAlphabetic(check) || check == 32))
                    {
                        //if either condition is met then make true, not will make false
                        // so we will skip unless character was not a alphabetic or blank space
                        // at this point we should return false
                        return false;
                    }
                    
                    if(Character.isAlphabetic(check))
                    {
                        count++; // check for alphabetic alone so cant enter blank spaces only
                    }
                    
                }
                
                 
           } catch(NumberFormatException e)
           {
                System.out.println("Attempted push value was not a valid string.\n");
                alphaStatus = false;
                
           }
           // if we got here it means that all characters were alphabetic or blanks spaces
           // we also want to make sure that count >0 or else it means that we only had blank spaces
           // make false if count is 0
           if (count == 0)
           {
               alphaStatus = false;
           }
           return alphaStatus;
    }

     /**
     @param s; pass section string then check to parse string for integer
     @return returns true if string successfully converts
     Return true or false based on whether string can parse to integer
     */  
    public static boolean isInteger(String s)
    {
           boolean integerStatus = false;
           // if successful we will return parsed double else give error
           try
           {
                 Integer.parseInt(s);
                 integerStatus = true;
           } catch(NumberFormatException e)
           {
                System.out.println("Attempted push value was not a valid integer.\n");
                integerStatus = false;
           }
           return integerStatus;
    
    }
    //returns an valid integer
    public static int returnInteger(String s) {
        int s1 = 0;
        try
           {
             s1 =  Integer.parseInt(s);
           } catch(NumberFormatException e)
           {
                System.out.println("Attempted push value was not a valid integer.\n");
           }
        return s1;
    }
    
    // this will displayAlertError if needed DC 4/27/2023
    public void displayAlertError(String err, String header)
    {
        // create Alert error type, set header and content, then show
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(err);
        alert.showAndWait(); 
    }
}
