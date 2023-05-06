/*
    Author: Gage Ruf
    Date: 04/25/2023
    File: AggregateStatGui.java
    Purpose: Player Stat GUI
*/
package com.csd2522.UI;

import com.csd2522.DB.BatterDB;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Gage Ruf 04/24/2023
 * Aggregate stats GUI
 */
public class AggregateStatGui extends Application{

    /* LABELS */
    private Label teamIDLabel = new Label("Select Team to Generate stats");
    private Label gameLabel = new Label("Select Game by date for Report");
    private Label seasonLabel = new Label("Generate Stats by season");
    
    /* DATEPICKER */
    private DatePicker startDatePicker = new DatePicker();
    private DatePicker endDatePicker = new DatePicker();
    
    /* COMBO BOXES */
    private ComboBox<String> teamIDBox = new ComboBox<String>();
    private ComboBox<String> seasonBox = new ComboBox<String>();
    
    @Override
    public void start(Stage statStage) {
        
        // Sets the title
        statStage.setTitle("Generate Aggregate Stats");
        
        // Used to align elements easy
        GridPane grid = new GridPane();
        
         // Scene
        Scene scene = new Scene(grid, 800, 150);
        
        // We want it to be alligned to the top left of the window
        grid.setAlignment(Pos.TOP_LEFT);
        // Same padding as other windows to keep it uniform
        grid.setPadding(new Insets(25, 25, 25, 25)); 
        
        // Fills the ComboBoxes
        fillTeamID();
        fillSeasons();
        
        /* BUTTONS */
        Button gameButton = new Button("Generate Stats by date and Team");
        gameButton.setOnAction(event -> gameButtonClicked());
        
        Button seasonButton = new Button("Generate Stats by Season and Team");
        seasonButton.setOnAction(event -> seasonButtonClicked());
        
        // Sets the label for the DatePickers
        startDatePicker.setPromptText("Start Date");
        endDatePicker.setPromptText("End Date");
         
        // Sets the default value of teamIDBox
        teamIDBox.getSelectionModel().select(0);
        // Sets the default value of seasonBox
        seasonBox.getSelectionModel().select(0);
        
        HBox teamBox = new HBox(10);
        teamBox.getChildren().add(teamIDLabel);
        teamBox.getChildren().add(teamIDBox);
        
        HBox gameBox = new HBox(10);
        gameBox.getChildren().add(gameLabel);
        gameBox.getChildren().add(startDatePicker);
        gameBox.getChildren().add(endDatePicker);
        gameBox.getChildren().add(gameButton);
        
        HBox seasonHBox = new HBox(10);
        seasonHBox.getChildren().add(seasonLabel);
        seasonHBox.getChildren().add(seasonBox);
        seasonHBox.getChildren().add(seasonButton);
        
        VBox appBox = new VBox(10);
        appBox.getChildren().add(teamBox);
        appBox.getChildren().add(gameBox);
        appBox.getChildren().add(seasonHBox);
        
        grid.add(appBox, 0, 0);
        
        // adds scene to stage to display it
        statStage.setScene(scene);
        
        // displays the stage
        statStage.show();
    }
    
    
    private void gameButtonClicked(){
        // Does nothing for now
        // Will need to generate stats from the player by team name and date
    }
    
    private void seasonButtonClicked(){
        // Does nothing for now
        // Will need to generate stats from the player by team name and season
    }
    
    // Adds all of the teamIDs into the combo Box
    private void fillTeamID(){
        ArrayList<String> teamIDs = BatterDB.getTeamIDs();
        teamIDBox.getItems().add("TeamID");
        for(String x: teamIDs){
            teamIDBox.getItems().add(x);
        }
    }
    
    private void fillSeasons(){
        ArrayList<String> seasons = BatterDB.getSeasons();
        
        seasonBox.getItems().add("Year");
        for(String x: seasons){
            seasonBox.getItems().add(x);
        }
    }
    
}
