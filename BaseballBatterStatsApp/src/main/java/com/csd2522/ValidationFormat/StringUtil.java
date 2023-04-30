/*
Author: Daniel Cronauer
Date: 4/21/2023 added to project
File: StringUtil.java
Purpose: this class provides one static method padWithSpaces that pads string
with blank spaces to desired size
*/
package com.csd2522.ValidationFormat;

/**
 *
 * @author Daniel Cronauer 4/21/2023 added to project
 * Class to provide class for working with Strings
 * Update: 4/26/2023 added padWithSpacesReverse this way you can right align text
 */
public class StringUtil {
    /**
     * @param s String that we we want to pad with spaces
     * @param length int that represents total size of string
     * @return String, which is the original string padded with blank
     * spaces if length parameter is greater than length of string passed.
     * This will pass blank spaces to end of string. Note if string is wider 
     * than length, then string returned will return a sub-string of string passed.
     */
    public static String padWithSpaces(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
    /**
     * @param s String that we we want to pad with spaces
     * @param length int that represents total size of string
     * @return String, which is the original string padded with blank
     * spaces if length parameter is greater than length of string passed.
     * This will pass blank spaces to end of string. Note if string is wider 
     * than length, then string returned will return a sub-string of string passed.
     */
    public static String padWithSpacesReverse(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            while (count < length - s.length()) {
                sb.append(" ");
                count++;
            }
            sb.append(s);
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
    
    /**
     * @param s String that we we want to repeat
     * @param length int that represents number of times to repeat
     * @return String, this string will repeat however many times you specify
     */
    public static String repeatString(String s, int repeats) {
       
            StringBuilder sb = new StringBuilder(s.length()*repeats);
            int count = 0;
            while (count < repeats) {
                sb.append(s);
                count++;
            }
            return sb.toString();
        
    }
}