/*
Author: Batter Team Daniel Cronauer, Michael Mowad, Andrew McKee, Gage Ruf
Date: 4/21/2023 added to project
File: Console.java
Purpose: Driver App, starts main window for App
Update: Micael Mowad 4/25/2023 new GUI format for whole driver app
 */

package com.csd2522.baseballbatterstatsapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;

import com.csd2522.ValidationFormat.StringUtil;
import com.csd2522.DB.BatterDB;
import com.csd2522.UI.GameReportGui;
import javafx.geometry.Insets;



/**
 * JavaFX BatterGUIApp
 */
public class BatterGUIApp extends Application {
    //define instance of BatterDB DC 4/25/2023
    BatterDB db = new BatterDB();

    // define games hashmap to populate list DC 4/25/2023
    private HashMap<String, Integer> games = db.getTeams();
    @Override
    public void start(Stage stage) {
        //GridPane to attach items to
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.TOP_LEFT);
        mainPane.setPadding(new Insets(10, 25, 25, 25));
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        
        // ComboBox Set Up
        ComboBox<String> gameSelect = new ComboBox<>();
        
        //fill gameSelect combo box DC 4/25/2023
        fillGameCombo(gameSelect,games);
        
        gameSelect.setPromptText("Select Game");
        
        // Buttons Set up
        Button newGameButton = new Button("Create New Game");
        // newGameButton.setOnAction(event -> );
        
        Button batterStatsButton = new Button("Enter Batter Game Stats");
        // batterStatsButton.setOnAction(event -> );
        
        Button gameReportButton = new Button("Generate Game Report");
        gameReportButton.setOnAction(event -> new GameReportGui().start(stage));
        
        Button aggregateButton = new Button("Generate Aggregate Player Data");
        // aggregateButton.setOnAction(event -> ); 
        
        Button addPlayersButton = new Button("Add New Players");
        // addPlayersButton.setOnAction(event -> );
      
        // Add to grid
        mainPane.add(new Label("Game:"), 0, 0);
        mainPane.add(gameSelect, 0, 1);
        mainPane.add(newGameButton, 1, 1);
        mainPane.add(new Label("Enter Stats and Players:"), 0, 2);
        mainPane.add(batterStatsButton, 0, 3);
        mainPane.add(addPlayersButton, 1, 3);
        mainPane.add(new Label("Generate Reports:"), 0, 4);
        mainPane.add(gameReportButton, 0, 5);
        mainPane.add(aggregateButton, 1, 5);
        
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setTitle("Batter Stats Application");
        stage.show();
    }
    
    public static void main(String[] args) {
    
        launch();
    }
    
     // this method will take in a comboBox and fill it with the player positions in array playerPositions DC 4/25/2023
    public static ComboBox<String> fillGameCombo(ComboBox<String> iterateBox, HashMap<String, Integer> game) {
        // loop through each element in game hashmap to fill the comboBox we pass to this function DC 4/25/2023
        for ( HashMap.Entry<String,Integer> element : game.entrySet()) {
            iterateBox.getItems().add(element.getKey());
        }
        
        return iterateBox;
    }
    
}