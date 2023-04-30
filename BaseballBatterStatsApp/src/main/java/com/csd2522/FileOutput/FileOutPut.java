/*
    Author: Daniel Cronauer
    Date: 4/30/2023
    File: FileOutPut.java
    Purpose: Handle File Output
*/
package com.csd2522.FileOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 *
 * @author Locke
 */
public class FileOutPut {
      
   
   
    public static void writeFile(String fileContent, String fileName) {
       try(PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileName))))
       {
           
        out.println(fileContent);
        out.close(); // without try catch need to close resource if no errors
       } catch (IOException e)
       {
           System.out.println(e);
       }
        
    }
    
    
}
