/*
    Author: Daniel Cronauer
    Date: 4/25/2023
    File: PlayerAddGUI.java
    Purpose: Testing gui class for each window
*/
package com.csd2522.UI;



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
import com.csd2522.ValidationFormat.Validation;
import com.csd2522.baseballbatterstatsapp.*;

/**
 *
 * @author team
 * Starting Daniel Cronauer 4/25/2023
 */
public class PlayerAddGUI extends Application {
    private Label teamPromptLabel = new Label("Select Team to Generate Stats: ");
    private TextField itemField = new TextField();
    private Label listViewLabel = new Label("List: ");
    private ListView<String> groceryListView = new ListView<>();
    
    // This is the start method for JavaFX it handles creation of scene, stage
    // and controls
    @Override
    public void start(Stage primaryStage) {
        // title set
        primaryStage.setTitle("Generate Game Report");
        
        // we are using the grid object as root for scene. All other layout
        // controls will go into grid
        GridPane grid = new GridPane();
        // set alignment
        grid.setAlignment(Pos.TOP_LEFT);
        // set padding
        grid.setPadding(new Insets(25, 25, 25, 25));
        // set horizontal and vertical gaps between compoents in grid
        grid.setHgap(10);
        grid.setVgap(10);
        
        // create scene object and add grid layout to it added size of window
        Scene scene = new Scene(grid);
        
        // create vbox 10 px padding between controls
        VBox appContainer = new VBox(10);
        
        // create Hbox with 10px padding between controls
        HBox itemBox = new HBox(10);
        
        // create button control with text Add
        Button addButton = new Button("Generate Report");
        // set event handler for cliking Button control to call addButtonClicked method
        addButton.setOnAction(event-> addButtonClicked());
        
        // add label, text input field and addButton to itemBox (Hbox)
        itemBox.getChildren().add(teamPromptLabel);
        itemBox.getChildren().add(itemField);
        itemBox.getChildren().add(addButton);
        
        // create new Hbox listViewBox
        HBox listViewBox = new HBox(10);        
        // groceryListView is a ListView here we set its preferred height
        // to handle 5 items at 24px height for each
        groceryListView.setPrefHeight(24 * 5);
        // here we enable multiple selection for ListView
        groceryListView.getSelectionModel()
             .setSelectionMode(SelectionMode.MULTIPLE);
        
        // add label and ListView to listViewBox (Hbox)
        listViewBox.getChildren().add(listViewLabel);
        listViewBox.getChildren().add(groceryListView);
        
        // create the final hbox to hold the buttons clear and remove
        // 10 px padding between controls
        HBox buttonBox = new HBox(10);
        // create clearButton with text Clear
        Button clearButton = new Button("Clear");
        //set event handler to call method clearButtonClicked when clearButton
        // is clicked
        clearButton.setOnAction(event -> clearButtonClicked());
        
        // create removeButton with text Remove
        Button removeButton = new Button("Remove");
        //this line was not orinally here, but we need event handler
        // to call removeButtonClcked when the remove button is clicked
        removeButton.setOnAction(event -> removeButtonClicked());
        
        // mispelled buttonBx fixed to buttonBox this adds the two buttons
        // to buttonBox(hbox)
        buttonBox.getChildren().add(clearButton);
        buttonBox.getChildren().add(removeButton);
        
        // now we add the three hboxes to the vbox we made up top
        appContainer.getChildren().add(itemBox);
        appContainer.getChildren().add(listViewBox);
        appContainer.getChildren().add(buttonBox);
        
        // now we add vbox appContainer to GridPane object grid at col 0 
        // and row 0. Also we are defining the column span as 2 and row span as 1
        grid.add(appContainer, 0, 0, 2, 1);
        
        // lower case s to set stage with scene object created above
        primaryStage.setScene(scene);
        // show the stage now that we have created scene, added root container layout
        // and added all the desired sub layout objects and controls.
        primaryStage.show();        
    }   
    
    // handle clearButtonClicked when clear button is clicked and calls this
    private void clearButtonClicked() {
        // simple, call getItems() to return the list, then call clear to empty contents
        groceryListView.getItems().clear();
    }
    
    private void removeButtonClicked() {
        // this creates a List of string type to collect the values of the selected items
        // for ListView
        List<String> selectedItems = groceryListView.getSelectionModel().getSelectedItems();
        //System.out.println(selectedItems);
        // also need to know the list of all items in ListView whether selected or not
        List<String> allItems = groceryListView.getItems();
        //System.out.println("This is the list of items existing: " + allItems);
        //if there are no selected items or if there are no items at all in ListView
        // then display an alert box
        if(selectedItems.isEmpty() || allItems.isEmpty()) {
            // cant have alert upper case for name of alert object
            // this creates Alert of Error type
            Alert alert = new Alert(Alert.AlertType.ERROR);
            // set header to Invalid Remove
            alert.setHeaderText("Invalid Remove");
            // tell us an item must be selected before hitting remove button
            alert.setContentText("Must select an item before removing.");
            // display and wait for user to close
            alert.showAndWait(); 
        } else { 
            Object [] arrayString = selectedItems.toArray();
            // ran into issue when using enhanced loop got inex out of bounds exception
            // I believe this is because we were removing items from List somehow, this was causing iterator
            // to skip over next item somehow. So I decided to take list and use toArray() method to create 
            // an array of the string, then iterate over that and remove from groceryListView control that way
            for(Object item : arrayString) {
                
                groceryListView.getItems().remove(item);
                
            }
        }
    }
    // this handles clicking the addButton
    private void addButtonClicked() {
        // first we need to get the text typed in the input text field
        String item = itemField.getText();
        // then we create a list string and getitems on groceryListView
        // this will get us the list of items already selected
        List<String> items = groceryListView.getItems();
        
        // now we want to validate the entry create validation instance
        // make it lower case v
        Validation v = new Validation();  
        // check for whether there is some text present in input text field
        String errorMsg = v.isPresent(item, "Item");
        // check it the item to be added is already in the items list, if
        // so we do not want to add it again so inform us of this by adding
        // text to errorMsg string
        errorMsg += v.listHasValue(items, item, "Grocery List");
        
        // if both tests above pass, then errorMsg will remain empty and we 
        // are safe to add the item to the ListView
        if(errorMsg.isEmpty()) {
            // add item to list view
            items.add(item);
            // clear out input text field by setting to "" to await another entry
            itemField.setText("");
        } else {
            // otherwise if errorMsg had some kind of content then we want to 
            // display an aler with the appropriate error msg alert name needs
            // to be lowercase again so as not to confuse with the Alert object
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Entry");
            alert.setContentText(errorMsg);
            alert.showAndWait(); 
        }
    }
//    // this is the driver main method for the whole GUI class here
//    // need to call launch here so it calls start with a stage
//    public static void main(String[] args) {
//        // start gui app
//        launch();
//    }
}

