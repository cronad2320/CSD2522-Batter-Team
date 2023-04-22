/*
    Author: Daniel Cronauer
    Date: 2/3/2023
    File: Validation.java
    Purpose: This will handle validation of inputs.
    Update: Initial upload of validation class 
*/
package com.csd2522.ValidationFormat;

/**
 *
 * @author Locke
 */
import java.util.List;

// class to provide validation
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
    // check is the list of strings passed to this method has a string with
    // contents of value in it. Doesnt need to be total match, just a match 
    // within some part of the string passed.
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
     @param s; pass section string to attempt to parse
     @return returns true if integer else false 
     Attempt to parse string to integer if no error return true, else return false
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
}
