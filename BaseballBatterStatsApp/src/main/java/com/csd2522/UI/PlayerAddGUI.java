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
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import com.csd2522.baseballbatterstatsapp.*;
import java.util.HashMap;
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
 */
public class PlayerAddGUI extends Application {
    //set String for Select Team string
    String selectTeamLabelString = StringUtil.padWithSpacesReverse("Select Team and click button to fill box of players:",60);
    String selectPlayerLabelString = StringUtil.padWithSpacesReverse("SELECT PLAYER and hit button to update:", selectTeamLabelString.length());
    String teamSelectButtonString = "Pull Players By Team";
    String playerSelectButtonString = StringUtil.padWithSpaces("SELECT Player",teamSelectButtonString.length()+4);
    String playerFirstLabelString = StringUtil.padWithSpacesReverse("First Name", 25);
    String playerLastLabelString = StringUtil.padWithSpacesReverse("Last Name", 25);
    
    // get DB instance
    private BatterDB db = new BatterDB();
    
    // create different gui controls
    private Label teamPromptLabel = new Label(selectTeamLabelString);
    private Label playerLabel = new Label(selectPlayerLabelString);
    private static ComboBox<String> playerCB = new ComboBox<>();
    private static ComboBox<String> teamCB = new ComboBox<>();
    private static TextField playerFirst = new TextField();
    private TextField playerLast = new TextField();
    
    private Button processButton = new Button(StringUtil.padWithSpaces("Process Entry", teamSelectButtonString.length()+5));
    // data structures to hold players and teams (will use these for getting values for SQL later)
    private static TreeMap<String,Integer> players = new TreeMap<>();
    private ArrayList<String> teams = db.getTeamIDs();
    
    // This is the start method for JavaFX it handles creation of scene, stage
    // and controls DC 4//26/2023
    @Override
    public void start(Stage primaryStage) {
        
        
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
        
        // new HBOX for rows of data to enter DC 4//26/2023
        HBox playerDataBox = new HBox(10);
        
        //set text to text boxes 4//26/2023
        playerFirst.setText(StringUtil.padWithSpaces("First Name", 28));
        playerLast.setText(StringUtil.padWithSpaces("Last Name", 28));
        
        
        
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
        //set event handler to call method clearButtonClicked when clearButton
        // is clicked
        //clearButton.setOnAction(event -> clearButtonClicked());
        
        // create removeButton with text Remove DC 4//26/2023
        Button removeButton = new Button("Remove"); 
        //this line was not orinally here, but we need event handler
        // to call removeButtonClcked when the remove button is clicked DC 4//26/2023
        //removeButton.setOnAction(event -> removeButtonClicked());
        
        // mispelled buttonBx fixed to buttonBox this adds the two buttons
        // to buttonBox(hbox) DC 4//26/2023
        buttonBox.getChildren().add(clearButton);
        buttonBox.getChildren().add(removeButton);
        
        // now we add the three hboxes to the vbox we made up top
        appContainer.getChildren().add(teamBox);
        appContainer.getChildren().add(playerSelectBox);
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
    public static ComboBox<String> fillPlayerCombo(ComboBox<String> iterateBox, TreeMap<String, Integer> players) {
        
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
        }
        else
        {
            // getting here meant that player hash was empty which means either the team selected has no players added to DB yet, or no team was picked
            // provide a displayAlert based on either condition! 4/27/2023
            if(teamCB.getSelectionModel().getSelectedItem() != null)
            {
                PlayerAddGUI.displayAlertError("Team selection has no players, start by entering a player!", "No team players");
                // since we picked an empty team want to clear combo box, then re add Insert New Player so we can start adding player if desired.
                playerCB.getItems().clear();
                playerCB.getItems().add("Insert New Player");
            }
            else
            {
                PlayerAddGUI.displayAlertError("Make a team selection then click pull players by team !", "Make a team selection");
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
        BatterDB nb = new BatterDB();
        // get player string
        String playerString = ""; 
        
        if(this.playerCB.getSelectionModel().getSelectedItem() != null)
        {
            playerString = this.playerCB.getSelectionModel().getSelectedItem();
        } else
        {
            // prompt user to select either a player or insert new player
            PlayerAddGUI.displayAlertError("Either select Insert new player if you want to add new player to team, or select current player to update their information!", "Make a player selection!");
        }
        
        if(playerString.equalsIgnoreCase("Insert New Player"))
        {
            // if new player want to fill text fields with enter new player first name and last name
            this.playerFirst.setText("Enter new player's first name");
            this.playerLast.setText("Enter new player's last name");
            this.processButton.setText("Insert Player");
        }
        else if (!playerString.equals(""))
        {
            int playerID = this.players.get(playerString);
            
            Batter player = nb.returnPlayer(playerID);
            if(player != null)
            {
                this.playerFirst.setText(player.getFirstName());
                this.playerLast.setText(player.getLastName());
                this.processButton.setText("Update Player");
            }
            
        }
    }
    //this function will validate and perform either insert or update statement
    public void processPlayer()
    {
        if(this.processButton.getText().equals(StringUtil.padWithSpaces("Process Entry", teamSelectButtonString.length()+5)))
        {
            PlayerAddGUI.displayAlertError("Make sure to pick team you want to add player to or update to, then select player entry type!","Incomplete Entry");
        }
        else
        {
            String fName = playerFirst.getText();
            String lName = playerLast.getText();
            String team = teamCB.getSelectionModel().getSelectedItem();

            //check if label equals update player
            if(processButton.getText().equalsIgnoreCase("Update Player"))
            {
                String key = playerCB.getSelectionModel().getSelectedItem();

                int playerID = players.get(key);
                
                // create instance Batter with data from GUI
                Batter updatePlayer = new Batter(playerID, fName, lName, team);
                db.updatePlayer(updatePlayer);
            } else if(processButton.getText().equalsIgnoreCase("Insert Player"))
            {
                
                // create batter instance then pass to insertPlayer to add to db
                Batter updatePlayer = new Batter(0, fName, lName, team);
                
                db.insertPlayer(updatePlayer);
                
                processButton.setText(StringUtil.padWithSpaces("Process Entry", teamSelectButtonString.length()+5));
            }
        }
    }
    
    
    // this will displayAlertError if needed DC 4/27/2023
    public static void displayAlertError(String err, String header)
    {
        // create Alert error type, set header and content, then show
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(err);
        alert.showAndWait(); 
    }
    // handle clearButtonClicked when clear button is clicked and calls this
//    private void clearButtonClicked() {
//        // simple, call getItems() to return the list, then call clear to empty contents
//        groceryListView.getItems().clear();
//    }
    
//    private void removeButtonClicked() {
//        // this creates a List of string type to collect the values of the selected items
//        // for ListView
//        List<String> selectedItems = groceryListView.getSelectionModel().getSelectedItems();
//        //System.out.println(selectedItems);
//        // also need to know the list of all items in ListView whether selected or not
//        List<String> allItems = groceryListView.getItems();
//        //System.out.println("This is the list of items existing: " + allItems);
//        //if there are no selected items or if there are no items at all in ListView
//        // then display an alert box
//        if(selectedItems.isEmpty() || allItems.isEmpty()) {
//            // cant have alert upper case for name of alert object
//            // this creates Alert of Error type
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            // set header to Invalid Remove
//            alert.setHeaderText("Invalid Remove");
//            // tell us an item must be selected before hitting remove button
//            alert.setContentText("Must select an item before removing.");
//            // display and wait for user to close
//            alert.showAndWait(); 
//        } else { 
//            Object [] arrayString = selectedItems.toArray();
//            // ran into issue when using enhanced loop got inex out of bounds exception
//            // I believe this is because we were removing items from List somehow, this was causing iterator
//            // to skip over next item somehow. So I decided to take list and use toArray() method to create 
//            // an array of the string, then iterate over that and remove from groceryListView control that way
//            for(Object item : arrayString) {
//                
//                groceryListView.getItems().remove(item);
//                
//            }
//        }
//    }
//    // this handles clicking the addButton
//    private void addButtonClicked() {
//        // first we need to get the text typed in the input text field
//        String item = itemField.getText();
//        // then we create a list string and getitems on groceryListView
//        // this will get us the list of items already selected
//        List<String> items = groceryListView.getItems();
//        
//        // now we want to validate the entry create validation instance
//        // make it lower case v
//        Validation v = new Validation();  
//        // check for whether there is some text present in input text field
//        String errorMsg = v.isPresent(item, "Item");
//        // check it the item to be added is already in the items list, if
//        // so we do not want to add it again so inform us of this by adding
//        // text to errorMsg string
//        errorMsg += v.listHasValue(items, item, "Grocery List");
//        
//        // if both tests above pass, then errorMsg will remain empty and we 
//        // are safe to add the item to the ListView
//        if(errorMsg.isEmpty()) {
//            // add item to list view
//            items.add(item);
//            // clear out input text field by setting to "" to await another entry
//            itemField.setText("");
//        } else {
//            // otherwise if errorMsg had some kind of content then we want to 
//            // display an aler with the appropriate error msg alert name needs
//            // to be lowercase again so as not to confuse with the Alert object
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText("Invalid Entry");
//            alert.setContentText(errorMsg);
//            alert.showAndWait(); 
//        }
//    }
//    // this is the driver main method for the whole GUI class here
//    // need to call launch here so it calls start with a stage
//    public static void main(String[] args) {
//        // start gui app
//        launch();
//    }
}

