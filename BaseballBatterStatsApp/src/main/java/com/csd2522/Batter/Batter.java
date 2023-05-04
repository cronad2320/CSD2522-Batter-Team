/*
 *  Author: Daniel Cronauer
    Date: 4/26/2023
    File: Batter.java
    Purpose: Testing gui class for each window
 */
package com.csd2522.Batter;

/**
 *
 * @author Locke
 * Daniel Cronauer created basic functionality for Batter class so I can pass the Batter around 4/26/2023
 * Update 4/30/2023 added more instance variables to Batter class, along with getter and setter methods
 */
public class Batter {
    //define instance variables
    private int PlayerID;
    private String firstName;
    private String lastName;
    private String team;
    private int FB;
    private int SB;
    private int TB;
    private int HR;
    private int AB;
    private int runs;
    private int hits;
    private int bb;
    private int so;
    private int hp;
    private int rbi;
    private int totalbase;
    private String position;
    
    public Batter(int PlayerID, String firstName, String lastName, String team)
    {
        this.PlayerID = PlayerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.AB = 0;
        this.FB = 0;
        this.TB = 0;
        this.HR = 0;
        this.AB = 0;
        this.runs = 0;
        this.hits = 0;
        this.bb = 0;
        this.so = 0;
        this.hp = 0;
        this.rbi = 0;
        this. totalbase = 0;
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

    /**
     * @return the FB
     */
    public int getFB() {
        return FB;
    }

    /**
     * @param FB the FB to set
     */
    public void setFB(int FB) {
        this.FB = FB;
    }

    /**
     * @return the SB
     */
    public int getSB() {
        return SB;
    }

    /**
     * @param SB the SB to set
     */
    public void setSB(int SB) {
        this.SB = SB;
    }

    /**
     * @return the TB
     */
    public int getTB() {
        return TB;
    }

    /**
     * @param TB the TB to set
     */
    public void setTB(int TB) {
        this.TB = TB;
    }

    /**
     * @return the HR
     */
    public int getHR() {
        return HR;
    }

    /**
     * @param HR the HR to set
     */
    public void setHR(int HR) {
        this.HR = HR;
    }

    /**
     * @return the AB
     */
    public int getAB() {
        return AB;
    }

    /**
     * @param AB the AB to set
     */
    public void setAB(int AB) {
        this.AB = AB;
    }

    /**
     * @return the runs
     */
    public int getRuns() {
        return runs;
    }

    /**
     * @param runs the runs to set
     */
    public void setRuns(int runs) {
        this.runs = runs;
    }

    /**
     * @return the hits
     */
    public int getHits() {
        return hits;
    }

    /**
     * @param hits the hits to set
     */
    public void setHits(int hits) {
        this.hits = hits;
    }

    /**
     * @return the bb
     */
    public int getBb() {
        return bb;
    }

    /**
     * @param bb the bb to set
     */
    public void setBb(int bb) {
        this.bb = bb;
    }

    /**
     * @return the so
     */
    public int getSo() {
        return so;
    }

    /**
     * @param so the so to set
     */
    public void setSo(int so) {
        this.so = so;
    }

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return the rbi
     */
    public int getRbi() {
        return rbi;
    }

    /**
     * @param rbi the rbi to set
     */
    public void setRbi(int rbi) {
        this.rbi = rbi;
    }

    /**
     * @return the tb
     */
    public int getTotalBase() {
        return totalbase;
    }

    /**
     * @param tb the tb to set
     */
    public void setTotalBase(int tb) {
        this.totalbase = tb;
    }
    
     /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
    
    /**
     * @return double return a double that is 3 digits. It represents the slg%
     * DC 4/30/2023
     */
    public double getSLG()
    {
       // sum up values for numberator
       int sumBaseHits = this.getFB() + this.getSB() * 2 + this.getTB() * 3 + this.getHR()* 4;
       // only calculate if values are greater than zero for both to avoid run time errors or incorrect negative numbers
       if(sumBaseHits > 0 && this.getAB() > 0)
       {
           return (double) Math.round((sumBaseHits/this.getAB()) * 100)/100.0;
       }
       else
       {
           return -1; // this number is not allowed so we will know something is wrong. 
       }
    }
    
    /**
     * @return double return a double that is 3 digits. It represents the obp%
     * DC 4/30/2023
     */
    public double getOBP()
    {
       // sum up values for numberator
       int numerator = this.getHits() + this.getBb() + this.getHp();
       int denominator = this.getAB() + this.getBb() + this.getHp() + this.getSo();
       // only calculate if values are greater than zero for both to avoid run time errors or incorrect negative numbers
       if(numerator > 0 && denominator > 0)
       {
           return (double) Math.round((numerator/denominator) * 100)/100.0;
       }
       else
       {
           return -1; // this number is not allowed so we will know something is wrong. 
       }
    }
    // calculate total bases then set total base with the value DC 5/4/2023
    public int calculateBases()
    {
        int total = this.getFB() + this.getSB() + this.getTB() + this.getHR();
        
        this.setTotalBase(total);
        
        return total;
    }
   

   
}
