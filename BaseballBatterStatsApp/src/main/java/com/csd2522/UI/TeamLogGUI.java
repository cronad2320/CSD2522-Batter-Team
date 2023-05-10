/*
Name: Andrew McKee
Date: 4/30/2023
Purpose: The user enters the team names, their scores, and the date of the game, and enters it into Games
*/
package com.csd2522.UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import com.csd2522.DB.BatterDB;
import com.csd2522.ValidationFormat.Validation;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TeamLogGUI extends Application {
    
    // Creating labels, combo boxes, text fields, date picker, and button
    private Label teamInstructionsLabel = new Label("Choose the home team and away team from the two combo boxes:");
    private Label homeTeamLabel = new Label("Home Team");
    private ComboBox<String> homeComboBox = new ComboBox<>();
    private Label awayTeamLabel = new Label("Away Team");
    private ComboBox<String> awayComboBox = new ComboBox<>();
    
    private Label scoreInstructionsLabel = new Label("Enter the score for both teams (enter integers that aren't the same):");
    private Label homeScoreLabel = new Label("Home Score");
    private TextField homeScoreTextField = new TextField();
    private Label awayScoreLabel = new Label("Away Score");
    private TextField awayScoreTextField = new TextField();
    
    private Label dateInstructionsLabel = new Label ("Enter the game's date by clicking the date from the calendar box:");
    private Label buttonsInstructionsLabel = new Label ("Press submit to enter entered info, or press clear to clear all boxes:");
    private Label gameDateLabel = new Label("Game Date");
    private DatePicker gameDateBox = new DatePicker();
    private Button createGameButton = new Button("Create Game");
    private Button clearButton = new Button("Clear");
    
    @Override
    public void start(Stage primaryStage) {
        
        // Sets window properties
        primaryStage.setTitle("Log Scores");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        Scene scene = new Scene(grid, 600, 275);
        
        // Sets the prompt text of the combo boxes
        homeComboBox.setPromptText("Select Home Team");
        awayComboBox.setPromptText("Select Away Team");
        
        // Creates a BatterDB object, gets an ArrayList of the team names, and closes the connection
        BatterDB db = new BatterDB();
        ArrayList<String> teamIDs = db.getTeamIDs();
        db.closeConnection();
        
        // Fills the home combo box with team names
        for (String team : teamIDs) {
            homeComboBox.getItems().add(team);
        }
        
        // Fills the away combo box with team names
        for (String team : teamIDs) {
            awayComboBox.getItems().add(team);
        }
        
        // Adds the combo box instructions
        HBox comboInstructionsRow = new HBox(10);
        comboInstructionsRow.getChildren().add(teamInstructionsLabel);
        grid.add(comboInstructionsRow, 0, 0);
        
        // Adds the team labels and team combo boxes
        HBox teamBoxesRow = new HBox(20);
        teamBoxesRow.getChildren().add(homeTeamLabel);
        teamBoxesRow.getChildren().add(homeComboBox);
        teamBoxesRow.getChildren().add(awayTeamLabel);
        teamBoxesRow.getChildren().add(awayComboBox);
        grid.add(teamBoxesRow, 0, 1);
        
        // Adds the score instructions
        HBox scoreInstructionsRow = new HBox();
        scoreInstructionsRow.getChildren().add(scoreInstructionsLabel);
        grid.add(scoreInstructionsRow, 0, 3);
       
        // Adds the score labels and score text fields
        HBox scoreBoxesRow = new HBox(20);
        scoreBoxesRow.getChildren().add(homeScoreLabel);
        scoreBoxesRow.getChildren().add(homeScoreTextField);
        scoreBoxesRow.getChildren().add(awayScoreLabel);
        scoreBoxesRow.getChildren().add(awayScoreTextField);
        grid.add(scoreBoxesRow, 0, 4);
        
        // Adds the instructions for the date box, submit button, and clear button
        HBox dateInstructionsRow = new HBox();
        dateInstructionsRow.getChildren().add(dateInstructionsLabel);
        grid.add(dateInstructionsRow, 0, 6);
        HBox buttonInstructionsRow = new HBox();
        buttonInstructionsRow.getChildren().add(buttonsInstructionsLabel);
        grid.add(buttonInstructionsRow, 0, 7);
        
        // Adds the game date label, game date date box, create game button, and clear button
        // Also creates an event listener for the create game button and clear button.
        HBox dateAndButtonsRow = new HBox(20);
        dateAndButtonsRow.getChildren().add(gameDateLabel);
        dateAndButtonsRow.getChildren().add(gameDateBox);
        createGameButton.setOnAction(event -> createGameButtonClicked());
        dateAndButtonsRow.getChildren().add(createGameButton);
        clearButton.setOnAction(event -> clearButtonClicked());
        dateAndButtonsRow.getChildren().add(clearButton);
        grid.add(dateAndButtonsRow, 0, 8);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }//start
    
    private void createGameButtonClicked() {
        
        // Creates a new validation object
        Validation v = new Validation();
        
        // Checks if all of the boxes are filled.
        if (!(awayComboBox.getSelectionModel().isEmpty()) && !(homeComboBox.getSelectionModel().isEmpty()) 
            && v.isPresent(awayScoreTextField.getText()) && v.isPresent(homeScoreTextField.getText())
            && gameDateBox.getValue() != null) {
            
            // Checks if the user didn't choose the same team
            if (!(awayComboBox.getSelectionModel().getSelectedItem().equals(homeComboBox.getSelectionModel().getSelectedItem()))) {
            
                // Checks if the user entered unique integers for scores
                if (v.isInteger(awayScoreTextField.getText()) && v.isInteger(homeScoreTextField.getText()) && !(awayScoreTextField.getText().equals(homeScoreTextField.getText()))) {

                    // Creates a BatterDB object
                    BatterDB batterdb = new BatterDB();

                    // Gets the user's team choices
                    String awayChoice = awayComboBox.getSelectionModel().getSelectedItem();
                    String homeChoice = homeComboBox.getSelectionModel().getSelectedItem();

                    // get score from text fields
                    int awayScore = Integer.parseInt(awayScoreTextField.getText());
                    int homeScore = Integer.parseInt(homeScoreTextField.getText());

                    // Get the date   
                    LocalDate date = gameDateBox.getValue();
                    String formattedDate = date.format(DateTimeFormatter.ISO_DATE);

                    // Send the information to the insertGame method of BatterDB to add the information to the Games table
                    batterdb.insertGame(awayChoice, homeChoice, awayScore, homeScore, formattedDate);

                    // Clear the fields
                    clearButtonClicked();

                    // Close connection when done
                    batterdb.closeConnection();

                } else {
                    if((awayScoreTextField.getText().equals(homeScoreTextField.getText())))
                    {
                        // Pops up an error message if the user enters the same score for both teams
                        v.displayAlertError("Fill all scores with unique scores", "Fill all scores with unique scores");
                    } else if (!(v.isInteger(awayScoreTextField.getText()) && v.isInteger(homeScoreTextField.getText())))
                    {
                        // Let us know the integers are invalid
                        v.displayAlertError("One of the scores is not a valid integer", "Use valid and unique integers");
                    }
                }
            } else {
                // Pops up an error message if the user chooses the same team
                v.displayAlertError("Please enter two seperate teams.", "Same teams");
            }
        } else {
           
            // Checks what isn't filled in and displays the error popup.
            if (awayComboBox.getSelectionModel().isEmpty() || homeComboBox.getSelectionModel().isEmpty()
               || !(v.isPresent(awayScoreTextField.getText())) || !(v.isPresent(homeScoreTextField.getText()))) {
                v.displayAlertError("Please fill in all options with valid data", "Incomplete");
            } else if (gameDateBox.getValue() == null) {
                v.displayAlertError("Please select a valid date with the date picker", "Must use date picker calendar option to select date");
            }
        }
    }//createGameButtonClicked
    
    // Clears information entered by user when called
    private void clearButtonClicked() {
        
        homeComboBox.getSelectionModel().clearSelection();
        homeComboBox.setPromptText("Select Home Team");
        awayComboBox.getSelectionModel().clearSelection();
        awayComboBox.setPromptText("Select Away Team");

        homeScoreTextField.clear();
        awayScoreTextField.clear();
        
        gameDateBox.getEditor().clear();
        gameDateBox.setValue(null);
    }
}//class
