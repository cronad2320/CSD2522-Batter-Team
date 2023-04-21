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
}