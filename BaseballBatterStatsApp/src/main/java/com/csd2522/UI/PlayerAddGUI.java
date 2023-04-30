/*
    Author: Daniel Cronauer
    Date: 4/25/2023
    File: PlayerAddGUI.java
    Purpose: Testing gui class for each window
*/
package com.csd2522.UI;



import com.csd2522.Batter.Batter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import com.csd2522.DB.BatterDB;
import java.util.ArrayList;
import com.csd2522.ValidationFormat.*;
import java.util.Map;
import java.util.TreeMap;


/**
 *
 * @author team
 * Starting Daniel Cronauer 4/25/2023
 * Updates : 4/26/2023 DC added elements to fill GUI and built some fill methods to fill combo boxes
 * Updates: 4/27/2023 DC Got Insert and Update into DB to work, added some validation with display error boxes
 * Updates: 4/28/2023 DC Add header labels to help user know what the current player selection is. This will help when 
 * they try to update or delete to know exactly who they are updating, and what their status is. Also, added team option.
 * Updates: 4/29/2023 DC finished up validation on processPlayer method. This way we do not send empty
 * player names to the database
 */
public class PlayerAddGUI extends Application {
    //set String for Select Team string
    String selectTeamLabelString = StringUtil.padWithSpacesReverse("Select Team and click button to fill box of players:",60);
    String selectPlayerLabelString = StringUtil.padWithSpacesReverse("SELECT PLAYER and hit button to update:", selectTeamLabelString.length());
    String teamSelectButtonString = "Pull Players By Team";
    String playerSelectButtonString = StringUtil.padWithSpaces("SELECT Player",teamSelectButtonString.length()+4);
    String playerFirstLabelString = StringUtil.padWithSpacesReverse("First Name", 25);
    String playerLastLabelString = StringUtil.padWithSpacesReverse("Last Name", 25);
    String defaultID = StringUtil.padWithSpaces("\t\tPlayer ID: NONE", 70); //formatted to get right
    String defaultName = StringUtil.padWithSpaces("Player Name: NONE", 60);
    String defaultProcessButtonString = StringUtil.padWithSpaces("Process Entry", teamSelectButtonString.length()+5);
    String insertPlayerString = StringUtil.padWithSpaces("Insert Player", teamSelectButtonString.length()+5);
    String updatePlayerString = StringUtil.padWithSpaces("Update Player", teamSelectButtonString.length()+5);
    String processEntry = StringUtil.padWithSpaces("Process Entry", teamSelectButtonString.length()+5);
    String teamIDLabelString = StringUtil.padWithSpacesReverse("Team List Selected: None", 140);
    
    // get DB instance
    private BatterDB db = new BatterDB();
    
    // create different gui controls DC 4/28/2023
    private Label teamPromptLabel = new Label(selectTeamLabelString);
    private Label playerLabel = new Label(selectPlayerLabelString);
    private static ComboBox<String> playerCB = new ComboBox<>();
    private static ComboBox<String> teamCB = new ComboBox<>();
    private static TextField playerFirst = new TextField();
    private static TextField playerLast = new TextField();
    private Label playerIDLabel = new Label(defaultID);
    private Label playerNameLabel = new Label(defaultName);
    private Label teamIDLabel = new Label(teamIDLabelString);
    
    
    private Button processButton = new Button(defaultProcessButtonString);
    // data structures to hold players and teams (will use these for getting values for SQL later)
    private static TreeMap<String,Integer> players = new TreeMap<>();
    private ArrayList<String> teams = db.getTeamIDs();
    
    // This is the start method for JavaFX it handles creation of scene, stage
    // and controls DC 4//26/2023
    @Override
    public void start(Stage primaryStage) {
        Validation v = new Validation();
               
        // title set
        primaryStage.setTitle("Insert or Update Player by Team");
        
        // we are using the grid object as root for scene. All other layout 
        // controls will go into grid DC 4//26/2023
        GridPane grid = new GridPane();
        // set alignment
        grid.setAlignment(Pos.TOP_LEFT);
        // set padding
        grid.setPadding(new Insets(25, 25, 25, 25));
        // set horizontal and vertical gaps between compoents in grid DC 4//26/2023
        grid.setHgap(10);
        grid.setVgap(10);
        
        // create scene object and add grid layout to it added size of window DC 4//26/2023
        Scene scene = new Scene(grid, 1000,300);
        
        // create vbox 10 px padding between controls DC 4//26/2023
        VBox appContainer = new VBox(10);
        
        // create Hbox with 10px padding between controls DC 4//26/2023
        HBox teamBox = new HBox(10);
        
        // fill tem combo with teams in db DC 4//26/2023
        fillTeamCombo(teamCB, teams);
        
        teamCB.setPromptText(StringUtil.padWithSpaces("SELECT TEAM", 50));
        playerCB.setPromptText(StringUtil.padWithSpaces("SELECT PLAYER", 50));
        
        // create button control with text Pull player by team DC 4//26/2023
        Button selectTeamButton = new Button(teamSelectButtonString);
        
        
        // add label, comboBox and selectTeamButton to itemBox (Hbox) DC 4//26/2023
        teamBox.getChildren().add(teamPromptLabel);
        teamBox.getChildren().add(teamCB);
        teamBox.getChildren().add(selectTeamButton);
        // first fill hash dictionary of players based on teamSelected, then fill combo box DC 4//26/2023
        selectTeamButton.setOnAction(event -> {players = fillPlayersHash(teamCB); fillPlayerCombo(playerCB,players); });
        
        //create team label HBox so we know status of players pulls DC 4/28/2023
        HBox teamPulledBox = new HBox(10);
        
        // add label to hbox DC 4/28/2023
        teamPulledBox.getChildren().add(teamIDLabel);
        
        // create new Hbox playerSelectBox DC 4//26/2023
        HBox playerSelectBox = new HBox(10);        
      
        Button selectPlayerButton = new Button(playerSelectButtonString);
        selectPlayerButton.setOnAction(event -> fillTextBoxes());
        
        // add label and combobox and button to playerSelectBox (Hbox) DC 4//26/2023
        playerSelectBox.getChildren().add(playerLabel);
        playerSelectBox.getChildren().add(playerCB);
        playerSelectBox.getChildren().add(selectPlayerButton);
        
        //default to add Insert New Player
        playerCB.getItems().add("Insert New Player");
        
        // new HBOX to give user idea of player currently selected DC 4/26/2023
        HBox playerChosen = new HBox(10);
        
        playerChosen.getChildren().add(playerIDLabel);
        playerChosen.getChildren().add(playerNameLabel);
        
        // new HBOX for rows of data to enter DC 4//26/2023
        HBox playerDataBox = new HBox(10);
        
//        //set text to text boxes 4//26/2023
//        playerFirst.setText(StringUtil.padWithSpaces("First Name", 28));
//        playerLast.setText(StringUtil.padWithSpaces("Last Name", 28));
        
        
        
        // add labels and input fields DC 4//26/2023
        playerDataBox.getChildren().add(new Label(playerFirstLabelString));
        playerDataBox.getChildren().add(playerFirst);
        playerDataBox.getChildren().add(new Label(playerLastLabelString));
        playerDataBox.getChildren().add(playerLast);
        playerDataBox.getChildren().add(processButton);
        
        processButton.setOnAction(event-> processPlayer());
        
        // create the final hbox to hold the buttons clear and remove
        // 10 px padding between controls DC 4//26/2023
        HBox buttonBox = new HBox(10);
        // create clearButton with text Clear DC 4//26/2023
        Button clearButton = new Button("Clear");
        //set event handler to call method resetForm when clearButton
        // is clicked
        clearButton.setOnAction(event -> resetForm());
        
        // create removeButton with text Remove DC 4//26/2023
        Button removeButton = new Button("DELETE"); 
        //this line was not orinally here, but we need event handler
        // to call removeButtonClcked when the remove button is clicked DC 4//26/2023
        removeButton.setOnAction(event -> deletePlayer());
        
        // mispelled buttonBx fixed to buttonBox this adds the two buttons
        // to buttonBox(hbox) DC 4//26/2023
        buttonBox.getChildren().add(clearButton);
        buttonBox.getChildren().add(removeButton);
        
        // now we add the three hboxes to the vbox we made up top
        appContainer.getChildren().add(teamBox);
        appContainer.getChildren().add(teamPulledBox);
        appContainer.getChildren().add(playerSelectBox);
        appContainer.getChildren().add(playerChosen);
        appContainer.getChildren().add(playerDataBox);
        appContainer.getChildren().add(buttonBox);
        
        // now we add vbox appContainer to GridPane object grid at col 0 
        // and row 0. Also we are defining the column span as 2 and row span as 1 DC 4//26/2023
        grid.add(appContainer, 0, 0, 2, 1);
        
        // lower case s to set stage with scene object created above
        primaryStage.setScene(scene);
        // show the stage now that we have created scene, added root container layout
        // and added all the desired sub layout objects and controls. DC 4//26/2023
        primaryStage.show();        
    }   
    
     // this method will take in a comboBox and fill it with the player positions in treemap players DC 4/26/2023
    public ComboBox<String> fillPlayerCombo(ComboBox<String> iterateBox, TreeMap<String, Integer> players) {
        Validation v = new Validation();
        //get team name in string
        String teamName = teamCB.getSelectionModel().getSelectedItem();
        
        // added validation using diplay boxes to prompt user for correct sequence and entry of material DC 4/27/2023
        if(players.size() != 0)    
        {    
            // first want to clear the combobox 4/27/2023
            iterateBox.getItems().clear();


            //fill in new player at top DC 4/27/2023
            iterateBox.getItems().add("Insert New Player");
            // loop through each element in game treemap to fill the comboBox we pass to this function DC 4/26/2023
            // first add New Player as an option, then fill rest of combo box with players from DB

            for ( Map.Entry<String,Integer> element : players.entrySet()) {
                iterateBox.getItems().add(element.getKey());
            }
            // if size greater than zero want to display team
            teamIDLabel.setText(StringUtil.padWithSpacesReverse("Team List Selected: "+ teamName + "\tTeam size: " + players.size(), 140));
            
            
        }
        else
        {
            // getting here meant that player hash was empty which means either the team selected has no players added to DB yet, or no team was picked
            // provide a displayAlert based on either condition! 4/27/2023
            if(teamCB.getSelectionModel().getSelectedItem() != null)
            {
                v.displayAlertError("Team selection has no players, start by entering a player!", "No team players");
                // since we picked an empty team want to clear combo box, then re add Insert New Player so we can start adding player if desired.
                playerCB.getItems().clear();
                playerCB.getItems().add("Insert New Player");
                
                // if size is zero, but we have valid team then still want to let us know
                teamIDLabel.setText(StringUtil.padWithSpacesReverse("Team List Selected: "+ teamName + "\tTeam size: " + players.size(), 140));
            }
            else
            {
                v.displayAlertError("Make a team selection then click pull players by team !", "Make a team selection");
            }
        }
        
        
        
        return iterateBox;
    }
    
    // this method will take in a comboBox and fill it with the teams given an ArrayList DC 4/26/2023
    public static ComboBox<String> fillTeamCombo(ComboBox<String> iterateBox, ArrayList<String> teams) {
        // loop through each element in team ArrayList to fill the comboBox we pass to this function DC 4/26/2023
        for ( String element : teams) {
            iterateBox.getItems().add(element);
        }
        
        return iterateBox;
    }
    
     // this method will create hash map, fill it based on id in teamBox and then return filled treemap DC 4/26/2023
    public static TreeMap<String,Integer> fillPlayersHash( ComboBox<String> teamBox ) {
        BatterDB nb = new BatterDB();
        String teamID = teamBox.getSelectionModel().getSelectedItem();
       
        TreeMap<String, Integer> newTreeMap = nb.getPlayers(teamID);
        
        return newTreeMap;
    }
    
    //this method handles when select player button is clicked DC 4/26/2023
    public void fillTextBoxes()
    {
        Validation v = new Validation();
        BatterDB nb = new BatterDB();
        // get player string
        String playerString = ""; 
        
        if(this.playerCB.getSelectionModel().getSelectedItem() != null)
        {
            playerString = this.playerCB.getSelectionModel().getSelectedItem();
        } else
        {
            // prompt user to select either a player or insert new player
            v.displayAlertError("Either select Insert new player if you want to add new player to team.\n Or select current player to update their information!", "Make a player selection!");
        }
        
        if(playerString.equalsIgnoreCase("Insert New Player"))
        {
            // build text string for new player DC 4/27/2023
            String playerStringID = StringUtil.padWithSpaces("\t\tNew ID to be created on insert", 70); 
            String playerStringName = StringUtil.padWithSpaces("Insert Player First and Last Name then process", 60); 
            // if new player want to fill text fields with enter new player first name and last name
            this.playerFirst.setPromptText("Enter new player's first name");
            this.playerLast.setPromptText("Enter new player's last name");
            this.processButton.setText(insertPlayerString);
            playerNameLabel.setText(playerStringName);
            playerIDLabel.setText(playerStringID);
        }
        else if (!playerString.equals(""))
        {
            int playerID = this.players.get(playerString);
            
            Batter player = nb.returnPlayer(playerID);
            if(player != null)
            {
                this.playerFirst.setText(player.getFirstName());
                this.playerLast.setText(player.getLastName());
                this.processButton.setText(updatePlayerString);
                 // build text string for new player, then add to labels DC 4/27/2023
                String playerStringID = StringUtil.padWithSpaces("\t\tPlayer ID: " + player.getPlayerID() + " Current Team: " + player.getTeam(), 70); 
                String playerStringName = StringUtil.padWithSpaces("Player Name: " + player.getFirstName() + " " + player.getLastName(), 60);
                playerNameLabel.setText(playerStringName);
                playerIDLabel.setText(playerStringID);
            }
            
        }
    }
    //this function will validate and perform either insert or update statement
    public void processPlayer()
    {
        Validation v = new Validation();
        String fName = playerFirst.getText();
        String lName = playerLast.getText();
        String team = teamCB.getSelectionModel().getSelectedItem();
        if(this.processButton.getText().equals(processEntry))
        {
            v.displayAlertError("Make sure to pick team you want to add player to or update to, then select player entry type!","Incomplete Entry");
        }
        // if first and last text field contain alpabet characters or blanks (size has to be over zero)
        // and make sure that team has a value as well, if so continue processing
        else if (v.isAlpha(fName) && v.isAlpha(lName) && v.isPresent(team))
        {
            //check if label equals update player
            if(processButton.getText().equalsIgnoreCase(updatePlayerString))
            {
                String key = playerCB.getSelectionModel().getSelectedItem();

                int playerID = players.get(key);
                
                // create instance Batter with data from GUI
                Batter updatePlayer = new Batter(playerID, fName, lName, team);
                db.updatePlayer(updatePlayer);
                // reset form after update DC 4/28/2023
                resetForm();
            } else if(processButton.getText().equalsIgnoreCase(insertPlayerString))
            {
                
                // create batter instance then pass to insertPlayer to add to db
                Batter updatePlayer = new Batter(0, fName, lName, team);
                
                db.insertPlayer(updatePlayer);
                // reset form after insert DC 4/28/2023
                resetForm();
            }
        } else // otherwise display alert
        {
             v.displayAlertError("Fill name fields(alphabet and blanks only)\n and team must be selected", "Missing or incorrect entry");
        }
    }
    // this will delete selected player
    public void deletePlayer()
    {
        Validation v = new Validation();
        // pull information, then use name entered in system to get key DC 4/28/2023
        String fName = playerFirst.getText();
        String lName = playerLast.getText();
        String team = teamCB.getSelectionModel().getSelectedItem();
        String key = playerLast.getText() + ", " + playerFirst.getText();
        System.out.println("key: " + key);
        // if player key we built is in players hash we have a match and are good to build the batter instance and pass to deletePlayer
        // DC 4/28/2023
        if(players.containsKey(key))
        {
            //build batter object
            Batter delete = new Batter(players.get(key),fName,lName,team);
            
            //call delete
            db.deletePlayer(delete);
            //reset form
            resetForm();
        }
        else
        {
            v.displayAlertError("Player name must match the one listed\n on the label above. Try selecting player again to reset fields;\nthen delete.", "Incorrect name");
        }
        
    }
    
    
    // simple reset everything DC 4/28/2027
    public void resetForm()
    {
        // reset selections in player combo box then add Insert New Player
        // in case we run into tem with no players added. DC 4/28/2023
        playerCB.getItems().clear();
        
        playerCB.getItems().add("Insert New Player");
        
        playerCB.getSelectionModel().clearSelection();
        
        //reset the input text boxes with player name info DC 4/28/2023
        playerFirst.setText("");
        playerLast.setText("");
        
        // set player selection labels to default DC 4/28/2023
        playerIDLabel.setText(defaultID);
        playerNameLabel.setText(defaultName);
        
        //set  processButton back to process entry text
        processButton.setText(defaultProcessButtonString);
        
        teamCB.getSelectionModel().select(null);
        
        teamIDLabel.setText(teamIDLabelString);
        
        teamCB.getSelectionModel().clearSelection();
        
    }
    
    
}

