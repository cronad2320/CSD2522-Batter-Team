/*
Author: Daniel Cronauer
Date: 4/21/2023 added to project
File: Console.java
Purpose: validate input
Update: 4/17/2023 added new getString with 6 options to force one of the six options as a choice
 */
package com.csd2522.ValidationFormat;

// import to create instance of scanner class
import java.util.Scanner;

/**
 *
 * @author Locke
 * The console class provides different methods to validate user input.
 */
public class Console {
    // create scanner object when this class creates an instance
    private static Scanner sc = new Scanner(System.in);
    
    
    /****** IMPLEMENT Input methods *****/
    
    /**
     @param prompt; provide message to prompt input from user
     @return; returns the string that was entered
     */
    public static String getString(String prompt){
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
    
    
    /**
     @param prompt; pass prompt to function to prompt user for type of input
     @param reqChoice; pass string to potentially force it to validate to a certain string
     @param reqChoice2; have a second option here so you can pass things like y and n 
     @return return a string that is input from user inside this function after validation.
     Will require string to not be empty and to match either reqChoice or reqChoice2
     */
    public static String getString(String prompt, String reqChoice, String reqChoice2)
        {
        // declare string variable to validate
        String choice = "";
        
        // boolean variables one for while loop in this method
        // other to return to app so we know whether to continue or not
        boolean continueLoop = true; 
        

        while(continueLoop) 
        {
            // ask user for output call getString
            choice = getString(prompt);

            // if input is equal to reqChoice (case insensitive) exit loop and return
            if (choice.equalsIgnoreCase(reqChoice))
            {
                // set flag to leave loop and return true 
                continueLoop = false;
            } 
            // if input is equal to reqChoice (case insensitive)exit loop and return
            else if(choice.equalsIgnoreCase(reqChoice2))
            {
                // exit loop and return false for continueApp (no need to change set to false above)
                continueLoop = false;
            }
             // if we enter blank
            else if(choice.equals("\n"))
            {
                // let user know entry is required
                System.out.println("Error! This entry is required. Try again.");
            }
            else
            {
                // getting here means that we had an undersired entry, force user to validate
                System.out.println("Error! entry must be " + reqChoice + " or " + reqChoice2 + ". Try again." );
            }

        }
        return choice;
        }
    
     /**
     @param prompt pass prompt to function to prompt user for type of input
     @param reqChoice pass string to potentially force it to validate to a certain string
     @param reqChoice2 have a second option here so you can pass things like y and n 
     @param reqChoice3 allows multiple required options
     @param reqChoice4 allows multiple required options
     @param reqChoice5 allows multiple required options
     @param reqChoice6 allows multiple required options
     @return return a string that is input from user inside this function after validation.
     Will require string to not be empty and to match either reqChoice or reqChoice2
     */
    public static String getString(String prompt, String reqChoice, String reqChoice2, String reqChoice3, String reqChoice4, String reqChoice5, String reqChoice6)
        {
        // declare string variable to validate
        String choice = "";
        
        // boolean variables one for while loop in this method
        // other to return to app so we know whether to continue or not
        boolean continueLoop = true; 
        

        while(continueLoop) 
        {
            // ask user for output call getString
            choice = getString(prompt);

            // if input is equal to reqChoice (case insensitive) exit loop and return
            if (choice.equalsIgnoreCase(reqChoice))
            {
                // set flag to leave loop and return true 
                continueLoop = false;
            } 
            // if input is equal to reqChoice (case insensitive)exit loop and return
            else if(choice.equalsIgnoreCase(reqChoice2))
            {
                // exit loop and return false for continueApp (no need to change set to false above)
                continueLoop = false;
            }
             else if(choice.equalsIgnoreCase(reqChoice3))
            {
                // exit loop and return false for continueApp (no need to change set to false above)
                continueLoop = false;
            }
              else if(choice.equalsIgnoreCase(reqChoice4))
            {
                // exit loop and return false for continueApp (no need to change set to false above)
                continueLoop = false;
            }
            else if(choice.equalsIgnoreCase(reqChoice5))
            {
                // exit loop and return false for continueApp (no need to change set to false above)
                continueLoop = false;
            }
             else if(choice.equalsIgnoreCase(reqChoice6))
            {
                // exit loop and return false for continueApp (no need to change set to false above)
                continueLoop = false;
            }
             // if we enter blank
            else if(choice.equals("\n"))
            {
                // let user know entry is required
                System.out.println("Error! This entry is required. Try again.");
            }
            else
            {
                // getting here means that we had an undersired entry, force user to validate
                System.out.println("Error! entry must be a menu choice please try again." );
            }

        }
        return choice;
        }

    /**
     @param prompt; provides message to prompt input from user
     @return returns a validated integer 
     Take user prompt and validate that a int is passed to input1
     */  
    public static int getInt(String prompt)
    {
           while(true)
           {
                   System.out.print(prompt);
                   try
                   {
                       return Integer.parseInt(sc.nextLine());
                   } catch(NumberFormatException e)
                   {
                       System.out.println("Error! Invalid integer value.");
                   }
           }
    }

    /**
     @param prompt; provides message to prompt input from user
     @param min; int to provide lowest acceptable integer
     @param max; int to provide highest acceptable integer
     @return returns a validated integer 
     * This method takes in a min and max. Then it validates the input 
     * using getInt(prompt). Once validated it will check that the input
     * also falls in the desired range or else it will continue
     */  
    public static int getInt(String prompt, int min, int max)
    {
            
           while(true)
           {
                   int value = getInt(prompt);
                   if(value >= min && value <= max)
                   {
                           return value;
                   } else if (value < min)
                   {
                        System.out.println("Error! Number must be greater than " + (min -1) );
                   } else if (value > max)
                   {
                        System.out.println("Error! Number must be less than " + (max + 1) );
                   }
           }
    }

    // same concet as getInt, validate for valid double from user input

    /**
     @param prompt; provides message to prompt input from user
     @return returns a validated double  
     Take user prompt and validate that a double is passed to input
     */  
    public static double getDouble(String prompt)
    {
    while(true)
    {
           System.out.print(prompt);
           try
           {
                   return Double.parseDouble(sc.nextLine());
           } catch(NumberFormatException e)
           {
                   System.out.println("Error! Invalid number value.");
           }
    }
    }


    /**
     @param prompt; provides message to prompt input from user
     @param min; double to provide lowest acceptable double
     @param max; double to provide highest acceptable double
     @return returns a validated integer 
     * This method takes in a min and max. Then it validates the input 
     * using getDouble(prompt). Once validated it will check that the input
     * also falls in the desired range or else it will continue
     */  
    public static double getDouble(String prompt, double min, double max)
    {
           while(true)
           {
                double value = getDouble(prompt);
                 if(value >= min && value <= max)
                   {
                           return value;
                   } else if (value < min)
                   {
                        System.out.println("Error! Number must be greater than " + min );
                   } else if (value > max)
                   {
                        System.out.println("Error! Number must be less than " + max );
                   }
           }
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

    
    
}


