/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csd2522.Batter;

/**
 *
 * @author Locke
 * Daniel Cronauer created basic functionality for Batter class so I can pass the Batter around 4/26/2023
 */
public class Batter {
    //define instance variables
    private int PlayerID;
    private String firstName;
    private String lastName;
    private String team;
    
    public Batter(int PlayerID, String firstName, String lastName, String team)
    {
        this.PlayerID = PlayerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        
        
    }

    /**
     * @return the PlayerID
     */
    public int getPlayerID() {
        return PlayerID;
    }

    /**
     * @param PlayerID the PlayerID to set
     */
    public void setPlayerID(int PlayerID) {
        this.PlayerID = PlayerID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }
}
