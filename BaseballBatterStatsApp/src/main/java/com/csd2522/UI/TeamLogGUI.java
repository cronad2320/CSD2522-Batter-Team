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
    private Label homeTeamLabel = new Label("Home Team");
    private ComboBox<String> homeComboBox = new ComboBox<>();
    private Label awayTeamLabel = new Label("Away Team");
    private ComboBox<String> awayComboBox = new ComboBox<>();
    
    private Label homeScoreLabel = new Label("Home Score");
    private TextField homeScoreTextField = new TextField();
    private Label awayScoreLabel = new Label("Away Score");
    private TextField awayScoreTextField = new TextField();
    
    private Label gameDateLabel = new Label("Game Date");
    private DatePicker gameDateBox = new DatePicker();
    private Button createGameButton = new Button("Create Game");
    
    @Override
    public void start(Stage primaryStage) {
        
        // Sets window properties
        primaryStage.setTitle("Log Scores");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        Scene scene = new Scene(grid, 625, 200);
        
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
        
        // Adds the team labels and team combo boxes to the first row
        /*
        HBox topRow = new HBox();
        topRow.getChildren().add(homeTeamLabel);
        topRow.getChildren().add(homeComboBox);
        topRow.getChildren().add(awayTeamLabel);
        topRow.getChildren().add(awayComboBox);
        */
        grid.add(homeTeamLabel, 0, 0);
        grid.add(homeComboBox, 1, 0);
        grid.add(awayTeamLabel, 2, 0);
        grid.add(awayComboBox, 3, 0);
       
        // Adds the score labels and score text fields to the middle row
        /*
        HBox middleRow = new HBox();
        middleRow.getChildren().add(homeScoreLabel);
        middleRow.getChildren().add(homeScoreTextField);
        middleRow.getChildren().add(awayScoreLabel);
        middleRow.getChildren().add(awayScoreTextField);
        */
        grid.add(homeScoreLabel, 0, 1);
        grid.add(homeScoreTextField, 1, 1);
        grid.add(awayScoreLabel, 2, 1);
        grid.add(awayScoreTextField, 3, 1);
        
        // Adds the game date label, game date date box, and create game button to the bottom row.
        // Also creates an event listener for the create game button. Calls createGameButtonClicked() when clicked.
        /*
        HBox bottomRow = new HBox();
        bottomRow.getChildren().add(gameDateLabel);
        bottomRow.getChildren().add(gameDateBox);
        createGameButton.setOnAction(event -> createGameButtonClicked());
        bottomRow.getChildren().add(createGameButton);
        */
        grid.add(gameDateLabel, 0, 2);
        grid.add(gameDateBox, 1, 2);
        createGameButton.setOnAction(event -> createGameButtonClicked());
        grid.add(createGameButton, 2, 2);
       
        /*
        // Adds the rows to the window
        grid.add(topRow,0,0);
        grid.add(middleRow,0,1);
        grid.add(bottomRow,0,2);
        */
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }//start
    
    private void createGameButtonClicked() {
        
        // Creates a new validation object
        Validation v = new Validation();
        
        // Checks if all of the boxes are filled.
        if (!(awayComboBox.getSelectionModel().getSelectedItem().isEmpty()) && !(homeComboBox.getSelectionModel().getSelectedItem().isEmpty())
            && v.isPresent(awayScoreTextField.getText()) && v.isPresent(homeScoreTextField.getText())
                ) {
            
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
                String formattedDate = date.getYear() + "-" + date.getDayOfMonth() + "-" + date.getMonthValue();

                // Send the information to the insertGame method of BatterDB to add the information to the Games table
                //batterdb.insertGame(awayChoice, homeChoice, awayScore, homeScore, formattedDate);

                // Clear the fields
                homeComboBox.getSelectionModel().clearSelection();
                awayComboBox.getSelectionModel().clearSelection();
                homeScoreTextField.clear();
                awayScoreTextField.clear();
                homeScoreTextField.clear();
                awayScoreTextField.clear();
                gameDateBox.getEditor().clear();

                // Close connection when done
                batterdb.closeConnection();
            } else {
                v.displayAlertError("Fill all scores with unique scores", "Fill all scores with unique scores");
            }
        } else {
            
            v.displayAlertError("Incomplete", "Please fill in all options.");
        }
    }//createGameButtonClicked
    
    
}//class
