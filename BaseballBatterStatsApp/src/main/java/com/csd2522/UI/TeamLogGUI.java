/*
Name: Andrew McKee
Date: 4/30/2023
Purpose: Logs teams' scores
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
import java.sql.*;

public class TeamLogGUI extends Application {
    
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
        
        primaryStage.setTitle("Log Scores");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        Scene scene = new Scene(grid, 1000,300);
        
        HBox topRow = new HBox();
        topRow.getChildren().add(homeTeamLabel);
        topRow.getChildren().add(homeComboBox);
        topRow.getChildren().add(awayTeamLabel);
        topRow.getChildren().add(awayComboBox);
       
        
        HBox middleRow = new HBox();
        middleRow.getChildren().add(homeScoreLabel);
        middleRow.getChildren().add(homeScoreTextField);
        middleRow.getChildren().add(awayScoreLabel);
        middleRow.getChildren().add(awayScoreTextField);
        
        
        HBox bottomRow = new HBox();
        bottomRow.getChildren().add(gameDateLabel);
        bottomRow.getChildren().add(gameDateBox);
        createGameButton.setOnAction(event -> createGameButtonClicked());
        bottomRow.getChildren().add(createGameButton);
       
        
        grid.add(topRow,0,0);
        grid.add(middleRow,0,1);
        grid.add(bottomRow,0,2);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }//start
    
    private void createGameButtonClicked() {
        
        BatterDB batterdb = new BatterDB();
        
        // get score from text fields
        int homeScore = Integer.parseInt(homeScoreTextField.getText());
        int awayScore = Integer.parseInt(awayScoreTextField.getText());
        
        // Makes a prepared statement
        String sql = "INSERT INTO Games (Game_team_one_id, Game_team_two_id, Game_win_id, Game_team_one_score, Game_team_two_score, Game_date) "
                + "VALUES (?,?,?,?,?)";
        //PreparedStatement ps = batterdb.getConnection().prepareStatement(sql);
        
        // Add data to Games
        //ps.setString(1, );
        //ps.setString(2, );
        //ps.setString(3, );
        //ps.setInt(4, homeScore);
        //ps.setInt(5, awayScore);
        //ps.setString(6, );
        //ps.executeUpdate();
        
        // Close connection when done
        batterdb.closeConnection();
    }//createGameButtonClicked
    
    
}//class
