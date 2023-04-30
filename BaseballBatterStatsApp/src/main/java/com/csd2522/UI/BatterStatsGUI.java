/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csd2522.UI;

/**
 *
 * @author nickr
 */
import com.csd2522.DB.BatterDB;
import static com.csd2522.UI.PlayerAddGUI.fillTeamCombo;
import com.csd2522.ValidationFormat.Validation;

import static com.csd2522.baseballbatterstatsapp.BatterGUIApp.fillGameCombo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BatterStatsGUI extends Application{
   
    
    // get DB instance
    private BatterDB db = new BatterDB();
    
    private final HashMap<String, Integer> games = db.getTeams();
    private static TreeMap<String,Integer> players = new TreeMap<>();
    private ArrayList<String> teams = db.getTeamIDs();
    
    //Team select combo
    private static ComboBox<String> teamSelect = new ComboBox<>();
    private Label selectTeamLabel = new Label("Select Team to Show Players");

    
   //Player Select Combo Boxes
   private ComboBox<String> playerSelect1 = new ComboBox<>();
   private ComboBox<String> playerSelect2 = new ComboBox<>();
   private ComboBox<String> playerSelect3 = new ComboBox<>();
   private ComboBox<String> playerSelect4 = new ComboBox<>();
   private ComboBox<String> playerSelect5 = new ComboBox<>();
   private ComboBox<String> playerSelect6 = new ComboBox<>();
   private ComboBox<String> playerSelect7 = new ComboBox<>();
   private ComboBox<String> playerSelect8 = new ComboBox<>();
   private ComboBox<String> playerSelect9 = new ComboBox<>();
   
   //Player 1
       TextField firstBField1 = new TextField();
       TextField secondBField1 = new TextField();
       TextField thirdBField1 = new TextField();
       TextField fourthBField1 = new TextField();
       TextField abField1 = new TextField();
       TextField runsField1 = new TextField();
       TextField hitsField1 = new TextField();
       TextField bbField1 = new TextField();
       TextField soField1 = new TextField();
       TextField hpField1 = new TextField();
       TextField rbiField1 = new TextField();
       TextField tbField1 = new TextField();
       //Player 2
       TextField firstBField2 = new TextField();
       TextField secondBField2 = new TextField();
       TextField thirdBField2 = new TextField();
       TextField fourthBField2 = new TextField();
       TextField abField2 = new TextField();
       TextField runsField2 = new TextField();
       TextField hitsField2 = new TextField();
       TextField bbField2 = new TextField();
       TextField soField2 = new TextField();
       TextField hpField2 = new TextField();
       TextField rbiField2 = new TextField();
       TextField tbField2 = new TextField();
       //Player 3
       TextField firstBField3 = new TextField();
       TextField secondBField3 = new TextField();
       TextField thirdBField3 = new TextField();
       TextField fourthBField3 = new TextField();
       TextField abField3 = new TextField();
       TextField runsField3 = new TextField();
       TextField hitsField3 = new TextField();
       TextField bbField3 = new TextField();
       TextField soField3 = new TextField();
       TextField hpField3 = new TextField();
       TextField rbiField3 = new TextField();
       TextField tbField3 = new TextField();
       //Player 4
       TextField firstBField4 = new TextField();
       TextField secondBField4 = new TextField();
       TextField thirdBField4 = new TextField();
       TextField fourthBField4 = new TextField();
       TextField abField4 = new TextField();
       TextField runsField4 = new TextField();
       TextField hitsField4 = new TextField();
       TextField bbField4 = new TextField();
       TextField soField4 = new TextField();
       TextField hpField4 = new TextField();
       TextField rbiField4 = new TextField();
       TextField tbField4 = new TextField();
       //Player 5
       TextField firstBField5 = new TextField();
       TextField secondBField5 = new TextField();
       TextField thirdBField5 = new TextField();
       TextField fourthBField5 = new TextField();
       TextField abField5 = new TextField();
       TextField runsField5 = new TextField();
       TextField hitsField5 = new TextField();
       TextField bbField5 = new TextField();
       TextField soField5 = new TextField();
       TextField hpField5 = new TextField();
       TextField rbiField5 = new TextField();
       TextField tbField5 = new TextField();
       //Player 6
       TextField firstBField6 = new TextField();
       TextField secondBField6 = new TextField();
       TextField thirdBField6 = new TextField();
       TextField fourthBField6 = new TextField();
       TextField abField6 = new TextField();
       TextField runsField6 = new TextField();
       TextField hitsField6 = new TextField();
       TextField bbField6 = new TextField();
       TextField soField6 = new TextField();
       TextField hpField6 = new TextField();
       TextField rbiField6 = new TextField();
       TextField tbField6 = new TextField();
       //Player 7
       TextField firstBField7 = new TextField();
       TextField secondBField7 = new TextField();
       TextField thirdBField7 = new TextField();
       TextField fourthBField7 = new TextField();
       TextField abField7 = new TextField();
       TextField runsField7 = new TextField();
       TextField hitsField7 = new TextField();
       TextField bbField7 = new TextField();
       TextField soField7 = new TextField();
       TextField hpField7 = new TextField();
       TextField rbiField7 = new TextField();
       TextField tbField7 = new TextField();
       //Player 8
       TextField firstBField8 = new TextField();
       TextField secondBField8 = new TextField();
       TextField thirdBField8 = new TextField();
       TextField fourthBField8 = new TextField();
       TextField abField8 = new TextField();
       TextField runsField8 = new TextField();
       TextField hitsField8 = new TextField();
       TextField bbField8 = new TextField();
       TextField soField8 = new TextField();
       TextField hpField8 = new TextField();
       TextField rbiField8 = new TextField();
       TextField tbField8 = new TextField();  
       //Player 9
       TextField firstBField9 = new TextField();
       TextField secondBField9 = new TextField();
       TextField thirdBField9 = new TextField();
       TextField fourthBField9 = new TextField();
       TextField abField9 = new TextField();
       TextField runsField9 = new TextField();
       TextField hitsField9 = new TextField();
       TextField bbField9 = new TextField();
       TextField soField9 = new TextField();
       TextField hpField9 = new TextField();
       TextField rbiField9 = new TextField();
       TextField tbField9 = new TextField();



    @Override
    public void start(Stage primaryStage) {
       //Stage title
       primaryStage.setTitle("Batter Stats");

       
       //Create grid, scene and add grid to scene
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        Scene scene = new Scene(grid, 750, 775);
       
       // Set scene and display stage
       primaryStage.setScene(scene);
       primaryStage.show();
       
       //game select combo box
        ComboBox<String> gameSelect = new ComboBox<>();
        gameSelect.setPromptText("Select Game");
        //fill gameSelect combo box 
        fillGameCombo(gameSelect,games);
        HBox buttonBox1 = new HBox(10);
        buttonBox1.getChildren().add(gameSelect);
        buttonBox1.getChildren().add(teamSelect);
        grid.add(buttonBox1,0, 0,  4, 1);
        
        //Accept and clear buttons
        Button registerStatsButton = new Button("Register Stats");
        Button clearStatsButton = new Button("Clear Stats");
        HBox buttonBox2 = new HBox(10);
        buttonBox2.getChildren().add(registerStatsButton);
        buttonBox2.getChildren().add(clearStatsButton);
        grid.add(buttonBox2, 9, 20, 6, 2);
        //registerStatsButton.setOnAction(registerStats());

        
        //Team select combo box        
        teamSelect.setPromptText("Select Team");
        fillTeamCombo(teamSelect, teams);
        

        // Player Select ComboBoxs labels 
        playerSelect1.setPromptText("Select Player");        
        playerSelect2.setPromptText("Select Player");
        playerSelect3.setPromptText("Select Player");
        playerSelect4.setPromptText("Select Player");
        playerSelect5.setPromptText("Select Player");
        playerSelect6.setPromptText("Select Player");
        playerSelect7.setPromptText("Select Player");
        playerSelect8.setPromptText("Select Player");
        playerSelect9.setPromptText("Select Player");
        
        //Select Team button 
        // Player Select combo boxes are filled withing getPlayers 
        Button selectTeamButton = new Button ("Select Team");        
        selectTeamButton.setOnAction(event -> {players = fillPHash(teamSelect); getPlayers(playerSelect1, players); });
     

        
        //Position select combo boxes
        ComboBox<String> positionSelect1 = new ComboBox<>();
        positionSelect1.setPromptText("Position");
        ComboBox<String> positionSelect2 = new ComboBox<>();
        positionSelect2.setPromptText("Position");
        ComboBox<String> positionSelect3 = new ComboBox<>();
        positionSelect3.setPromptText("Position");
        ComboBox<String> positionSelect4 = new ComboBox<>();
        positionSelect4.setPromptText("Position");
        ComboBox<String> positionSelect5 = new ComboBox<>();
        positionSelect5.setPromptText("Position");
        ComboBox<String> positionSelect6 = new ComboBox<>();
        positionSelect6.setPromptText("Position");
        ComboBox<String> positionSelect7 = new ComboBox<>();
        positionSelect7.setPromptText("Position");
        ComboBox<String> positionSelect8 = new ComboBox<>();
        positionSelect8.setPromptText("Position");
        ComboBox<String> positionSelect9 = new ComboBox<>();
        positionSelect9.setPromptText("Position");
        
        
        //Positions 
        String[] positions = {"Pitch Hitter", "Catcher", "First base", "Second base",
           "Third base", "Short stop", "Left field", "Center field", "Right field"
       };
        //Add positions to team select boxex
         positionSelect1.getItems().addAll(Arrays.asList(positions));
         positionSelect2.getItems().addAll(Arrays.asList(positions));
         positionSelect3.getItems().addAll(Arrays.asList(positions));
         positionSelect4.getItems().addAll(Arrays.asList(positions));
         positionSelect5.getItems().addAll(Arrays.asList(positions));
         positionSelect6.getItems().addAll(Arrays.asList(positions));
         positionSelect7.getItems().addAll(Arrays.asList(positions));
         positionSelect8.getItems().addAll(Arrays.asList(positions));
         positionSelect9.getItems().addAll(Arrays.asList(positions));


         

      
       //create labels 
       //Label selectGameLabel = new Label ("Select Game");
       
       //Player Labels
       Label player1 = new Label ("Player 1");
       Label player2 = new Label ("Player 2");
       Label player3 = new Label ("Player 3");
       Label player4 = new Label ("Player 4");
       Label player5 = new Label ("Player 5");
       Label player6 = new Label ("Player 6");
       Label player7 = new Label ("Player 7");
       Label player8 = new Label ("Player 8");
       Label player9 = new Label ("Player 9");




       //Player 1
      // Label playerSelectLabel1 = new Label ("Select Player:");
      // Label positionSelectLabel1 = new Label ("Player Position:");
       Label firstBLabel1 = new Label ("1B:");
       Label secondBLabel1 = new Label ("2B:");
       Label thirdBLabel1 = new Label ("3B:");
       Label fourthBLabel1 = new Label ("4b:");
       Label abLabel1 = new Label ("AB:");
       Label runsLabel1 = new Label ("Runs");
       Label hitsLabel1 = new Label ("Hits");
       Label bbLabel1 = new Label ("BB");
       Label soLabel1 = new Label ("SO");
       Label hpLabel1 = new Label ("HP");
       Label rbiLabel1 = new Label ("RBI:");
       Label tbLabel1 = new Label ("TB");
       //Player2
     //  Label playerSelectLabel2 = new Label ("Select Player:");
      // Label positionSelectLabel2 = new Label ("Player Position:");
       Label firstBLabel2 = new Label ("1B:");
       Label secondBLabel2 = new Label ("2B:");
       Label thirdBLabel2 = new Label ("3B:");
       Label fourthBLabel2 = new Label ("4b:");
       Label abLabel2 = new Label ("AB:");
       Label runsLabel2 = new Label ("Runs");
       Label hitsLabel2 = new Label ("Hits");
       Label bbLabel2 = new Label ("BB");
       Label soLabel2 = new Label ("SO");
       Label hpLabel2 = new Label ("HP");
       Label rbiLabel2 = new Label ("RBI:");
       Label tbLabel2 = new Label ("TB");
       //Player 3
       //Label playerSelectLabel3 = new Label ("Select Player:");
       //Label positionSelectLabel3 = new Label ("Player Position:");
       Label firstBLabel3 = new Label ("1B:");
       Label secondBLabel3 = new Label ("2B:");
       Label thirdBLabel3 = new Label ("3B:");
       Label fourthBLabel3 = new Label ("4b:");
       Label abLabel3 = new Label ("AB:");
       Label runsLabel3 = new Label ("Runs");
       Label hitsLabel3 = new Label ("Hits");
       Label bbLabel3 = new Label ("BB");
       Label soLabel3 = new Label ("SO");
       Label hpLabel3 = new Label ("HP");
       Label rbiLabel3 = new Label ("RBI:");
       Label tbLabel3 = new Label ("TB");
       //Player 4
       //Label playerSelectLabel4 = new Label ("Select Player:");
       //Label positionSelectLabel4 = new Label ("Player Position:");
       Label firstBLabel4 = new Label ("1B:");
       Label secondBLabel4 = new Label ("2B:");
       Label thirdBLabel4 = new Label ("3B:");
       Label fourthBLabel4 = new Label ("4b:");
       Label abLabel4 = new Label ("AB:");
       Label runsLabel4 = new Label ("Runs");
       Label hitsLabel4 = new Label ("Hits");
       Label bbLabel4 = new Label ("BB");
       Label soLabel4 = new Label ("SO");
       Label hpLabel4 = new Label ("HP");
       Label rbiLabel4 = new Label ("RBI:");
       Label tbLabel4 = new Label ("TB");
       //Player 5
       //Label playerSelectLabel5 = new Label ("Select Player:");
       //Label positionSelectLabel5 = new Label ("Player Position:");
       Label firstBLabel5 = new Label ("1B:");
       Label secondBLabel5 = new Label ("2B:");
       Label thirdBLabel5 = new Label ("3B:");
       Label fourthBLabel5 = new Label ("4b:");
       Label abLabel5 = new Label ("AB:");
       Label runsLabel5 = new Label ("Runs");
       Label hitsLabel5 = new Label ("Hits");
       Label bbLabel5 = new Label ("BB");
       Label soLabel5 = new Label ("SO");
       Label hpLabel5 = new Label ("HP");
       Label rbiLabel5 = new Label ("RBI:");
       Label tbLabel5 = new Label ("TB");
       //Player 6
       //Label playerSelectLabel6 = new Label ("Select Player:");
       //Label positionSelectLabel6 = new Label ("Player Position:");
       Label firstBLabel6 = new Label ("1B:");
       Label secondBLabel6 = new Label ("2B:");
       Label thirdBLabel6 = new Label ("3B:");
       Label fourthBLabel6 = new Label ("4b:");
       Label abLabel6 = new Label ("AB:");
       Label runsLabel6 = new Label ("Runs");
       Label hitsLabel6 = new Label ("Hits");
       Label bbLabel6 = new Label ("BB");
       Label soLabel6 = new Label ("SO");
       Label hpLabel6 = new Label ("HP");
       Label rbiLabel6 = new Label ("RBI:");
       Label tbLabel6 = new Label ("TB");
       //Player 7
       //Label playerSelectLabel7 = new Label ("Select Player:");
       //Label positionSelectLabel7 = new Label ("Player Position:");
       Label firstBLabel7 = new Label ("1B:");
       Label secondBLabel7 = new Label ("2B:");
       Label thirdBLabel7 = new Label ("3B:");
       Label fourthBLabel7 = new Label ("4b:");
       Label abLabel7 = new Label ("AB:");
       Label runsLabel7 = new Label ("Runs");
       Label hitsLabel7 = new Label ("Hits");
       Label bbLabel7 = new Label ("BB");
       Label soLabel7 = new Label ("SO");
       Label hpLabel7 = new Label ("HP");
       Label rbiLabel7 = new Label ("RBI:");
       Label tbLabel7 = new Label ("TB");
       //Player 8
       //Label playerSelectLabel8 = new Label ("Select Player:");
       //Label positionSelectLabel8 = new Label ("Player Position:");
       Label firstBLabel8 = new Label ("1B:");
       Label secondBLabel8 = new Label ("2B:");
       Label thirdBLabel8 = new Label ("3B:");
       Label fourthBLabel8 = new Label ("4b:");
       Label abLabel8 = new Label ("AB:");
       Label runsLabel8 = new Label ("Runs");
       Label hitsLabel8 = new Label ("Hits");
       Label bbLabel8 = new Label ("BB");
       Label soLabel8 = new Label ("SO");
       Label hpLabel8 = new Label ("HP");
       Label rbiLabel8 = new Label ("RBI:");
       Label tbLabel8 = new Label ("TB");
       //Player 9
       //Label playerSelectLabel9 = new Label ("Select Player:");
       //Label positionSelectLabel9 = new Label ("Player Position:");
       Label firstBLabel9 = new Label ("1B:");
       Label secondBLabel9 = new Label ("2B:");
       Label thirdBLabel9 = new Label ("3B:");
       Label fourthBLabel9 = new Label ("4b:");
       Label abLabel9 = new Label ("AB:");
       Label runsLabel9 = new Label ("Runs");
       Label hitsLabel9 = new Label ("Hits");
       Label bbLabel9 = new Label ("BB");
       Label soLabel9 = new Label ("SO");
       Label hpLabel9 = new Label ("HP");
       Label rbiLabel9 = new Label ("RBI:");
       Label tbLabel9 = new Label ("TB");
      
       //Create text fields
       
       
       //Set widths
       gameSelect.setPrefWidth(110);
       teamSelect.setPrefWidth(110);
       
       //P1
       playerSelect1.setMaxWidth(110);
       positionSelect1.setMaxWidth(110);
       firstBField1.setMaxWidth(30);
       secondBField1.setMaxWidth(30);
       thirdBField1.setMaxWidth(30);
       fourthBField1.setMaxWidth(30);
       abField1.setMaxWidth(30);
       runsField1.setMaxWidth(30);
       hitsField1.setMaxWidth(30);
       bbField1.setMaxWidth(30);
       soField1.setMaxWidth(30);
       hpField1.setMaxWidth(30);
       rbiField1.setMaxWidth(30);
       tbField1.setMaxWidth(30);
       //P2
       playerSelect2.setMaxWidth(110);
       positionSelect2.setMaxWidth(110);
       firstBField2.setMaxWidth(30);
       secondBField2.setMaxWidth(30);
       thirdBField2.setMaxWidth(30);
       fourthBField2.setMaxWidth(30);
       abField2.setMaxWidth(30);
       runsField2.setMaxWidth(30);
       hitsField2.setMaxWidth(30);
       bbField2.setMaxWidth(30);
       soField2.setMaxWidth(30);
       hpField2.setMaxWidth(30);
       rbiField2.setMaxWidth(30);
       tbField2.setMaxWidth(30);
       //P3
       playerSelect3.setMaxWidth(110);
       positionSelect3.setMaxWidth(110);
       firstBField3.setMaxWidth(30);
       secondBField3.setMaxWidth(30);
       thirdBField3.setMaxWidth(30);
       fourthBField3.setMaxWidth(30);
       abField3.setMaxWidth(30);
       runsField3.setMaxWidth(30);
       hitsField3.setMaxWidth(30);
       bbField3.setMaxWidth(30);
       soField3.setMaxWidth(30);
       hpField3.setMaxWidth(30);
       rbiField3.setMaxWidth(30);
       tbField3.setMaxWidth(30);
       //P4
       playerSelect4.setMaxWidth(110);
       positionSelect4.setMaxWidth(110);
       firstBField4.setMaxWidth(30);
       secondBField4.setMaxWidth(30);
       thirdBField4.setMaxWidth(30);
       fourthBField4.setMaxWidth(30);
       abField4.setMaxWidth(30);
       runsField4.setMaxWidth(30);
       hitsField4.setMaxWidth(30);
       bbField4.setMaxWidth(30);
       soField4.setMaxWidth(30);
       hpField4.setMaxWidth(30);
       rbiField4.setMaxWidth(30);
       tbField4.setMaxWidth(30);
       //P5
       playerSelect5.setMaxWidth(110);
       positionSelect5.setMaxWidth(110);
       firstBField5.setMaxWidth(30);
       secondBField5.setMaxWidth(30);
       thirdBField5.setMaxWidth(30);
       fourthBField5.setMaxWidth(30);
       abField5.setMaxWidth(30);
       runsField5.setMaxWidth(30);
       hitsField5.setMaxWidth(30);
       bbField5.setMaxWidth(30);
       soField5.setMaxWidth(30);
       hpField5.setMaxWidth(30);
       rbiField5.setMaxWidth(30);
       tbField5.setMaxWidth(30);
       //P6
       playerSelect6.setMaxWidth(110);
       positionSelect6.setMaxWidth(110);
       firstBField6.setMaxWidth(30);
       secondBField6.setMaxWidth(30);
       thirdBField6.setMaxWidth(30);
       fourthBField6.setMaxWidth(30);
       abField6.setMaxWidth(30);
       runsField6.setMaxWidth(30);
       hitsField6.setMaxWidth(30);
       bbField6.setMaxWidth(30);
       soField6.setMaxWidth(30);
       hpField6.setMaxWidth(30);
       rbiField6.setMaxWidth(30);
       tbField6.setMaxWidth(30);
       //P7
       playerSelect7.setMaxWidth(110);
       positionSelect7.setMaxWidth(110);
       firstBField7.setMaxWidth(30);
       secondBField7.setMaxWidth(30);
       thirdBField7.setMaxWidth(30);
       fourthBField7.setMaxWidth(30);
       abField7.setMaxWidth(30);
       runsField7.setMaxWidth(30);
       hitsField7.setMaxWidth(30);
       bbField7.setMaxWidth(30);
       soField7.setMaxWidth(30);
       hpField7.setMaxWidth(30);
       rbiField7.setMaxWidth(30);
       tbField7.setMaxWidth(30);
        //P8
       playerSelect8.setMaxWidth(110);
       positionSelect8.setMaxWidth(110);
       firstBField8.setMaxWidth(30);
       secondBField8.setMaxWidth(30);
       thirdBField8.setMaxWidth(30);
       fourthBField8.setMaxWidth(30);
       abField8.setMaxWidth(30);
       runsField8.setMaxWidth(30);
       hitsField8.setMaxWidth(30);
       bbField8.setMaxWidth(30);
       soField8.setMaxWidth(30);
       hpField8.setMaxWidth(30);
       rbiField8.setMaxWidth(30);
       tbField8.setMaxWidth(30);
       //P9      
       playerSelect9.setMaxWidth(110);
       positionSelect9.setMaxWidth(110);
       firstBField9.setMaxWidth(30);
       secondBField9.setMaxWidth(30);
       thirdBField9.setMaxWidth(30);
       fourthBField9.setMaxWidth(30);
       abField9.setMaxWidth(30);
       runsField9.setMaxWidth(30);
       hitsField9.setMaxWidth(30);
       bbField9.setMaxWidth(30);
       soField9.setMaxWidth(30);
       hpField9.setMaxWidth(30);
       rbiField9.setMaxWidth(30);
       tbField9.setMaxWidth(30);
       
       //Add to grid
       //P1
       //First row
       //grid.add(playerSelectLabel1, 0, 3);
       grid.add(player1, 0, 2);
       grid.add(playerSelect1,1, 2);
       //grid.add(positionSelectLabel1, 2, 3);
       grid.add(positionSelect1, 1, 3);
       grid.add(firstBLabel1, 2, 2);
       grid.add(firstBField1,3, 2);
       grid.add(secondBLabel1, 4, 2);
       grid.add(secondBField1, 5, 2);
       grid.add(thirdBLabel1, 6, 2);
       grid.add(thirdBField1, 7, 2);
       grid.add(fourthBLabel1,8, 2);
       grid.add(fourthBField1, 9,2);
       grid.add(abLabel1, 10, 2);
       grid.add(abField1, 11, 2);
       grid.add(runsLabel1, 12, 2);
       grid.add(runsField1, 13, 2);
       //P1
       //second row
       grid.add(hitsLabel1, 2, 3);
       grid.add(hitsField1, 3, 3);
       grid.add(bbLabel1, 4, 3);
       grid.add(bbField1, 5, 3);
       grid.add(soLabel1, 6, 3);
       grid.add(soField1, 7, 3);
       grid.add(hpLabel1, 8, 3);
       grid.add(hpField1, 9, 3);
       grid.add(rbiLabel1, 10, 3);
       grid.add(rbiField1,11, 3);
       grid.add(tbLabel1, 12, 3);
       grid.add(tbField1, 13, 3);
       
       //P2
       //First row
       //grid.add(playerSelectLabel2, 0, 5);
       grid.add(player2, 0, 4);
       grid.add(playerSelect2, 1, 4);
       //grid.add(positionSelectLabel2, 2, 5);
       grid.add(positionSelect2,1, 5);
       grid.add(firstBLabel2, 2, 4);
       grid.add(firstBField2, 3, 4);
       grid.add(secondBLabel2, 4, 4);
       grid.add(secondBField2, 5, 4);
       grid.add(thirdBLabel2, 6, 4);
       grid.add(thirdBField2, 7, 4);
       grid.add(fourthBLabel2,8, 4);
       grid.add(fourthBField2, 9, 4);
       grid.add(abLabel2, 10, 4);
       grid.add(abField2, 11, 4);
       grid.add(runsLabel2, 12, 4);
       grid.add(runsField2, 13, 4);
       //P2
       //second row
       grid.add(hitsLabel2, 2, 5);
       grid.add(hitsField2, 3, 5);
       grid.add(bbLabel2, 4, 5);
       grid.add(bbField2, 5, 5);
       grid.add(soLabel2, 6, 5);
       grid.add(soField2, 7, 5);
       grid.add(hpLabel2, 8, 5);
       grid.add(hpField2, 9, 5);
       grid.add(rbiLabel2, 10, 5);
       grid.add(rbiField2,11, 5);
       grid.add(tbLabel2, 12, 5);
       grid.add(tbField2, 13, 5);
       //P3
       //First row
       //grid.add(playerSelectLabel3, 0, 7);
       grid.add(player3, 0,6);
       grid.add(playerSelect3, 1, 6);
       //grid.add(positionSelectLabel3, 2, 7);
       grid.add(positionSelect3, 1, 7);
       grid.add(firstBLabel3, 2, 6);
       grid.add(firstBField3, 3, 6);
       grid.add(secondBLabel3, 4, 6);
       grid.add(secondBField3, 5, 6);
       grid.add(thirdBLabel3, 6, 6);
       grid.add(thirdBField3, 7, 6);
       grid.add(fourthBLabel3,8, 6);
       grid.add(fourthBField3, 9, 6);
       grid.add(abLabel3, 10, 6);
       grid.add(abField3, 11, 6);
       grid.add(runsLabel3, 12, 6);
       grid.add(runsField3, 13, 6);
       //P3
       //second row
       grid.add(hitsLabel3, 2, 7);
       grid.add(hitsField3, 3, 7);
       grid.add(bbLabel3, 4, 7);
       grid.add(bbField3, 5, 7);
       grid.add(soLabel3, 6, 7);
       grid.add(soField3, 7, 7);
       grid.add(hpLabel3, 8, 7);
       grid.add(hpField3, 9, 7);
       grid.add(rbiLabel3, 10, 7);
       grid.add(rbiField3,11, 7);
       grid.add(tbLabel3, 12, 7);
       grid.add(tbField3, 13, 7);
       //P4
       //First row
       //grid.add(playerSelectLabel4, 0, 9);
       grid.add(player4, 0, 8);
       grid.add(playerSelect4, 1, 8);
       //grid.add(positionSelectLabel4, 2, 9);
       grid.add(positionSelect4, 1, 9);
       grid.add(firstBLabel4, 2, 8);
       grid.add(firstBField4, 3, 8);
       grid.add(secondBLabel4, 4, 8);
       grid.add(secondBField4, 5, 8);
       grid.add(thirdBLabel4, 6, 8);
       grid.add(thirdBField4, 7, 8);
       grid.add(fourthBLabel4,8, 8);
       grid.add(fourthBField4, 9, 8);
       grid.add(abLabel4, 10, 8);
       grid.add(abField4, 11, 8);
       grid.add(runsLabel4, 12, 8);
       grid.add(runsField4, 13, 8);
       //P4
       //second row
       grid.add(hitsLabel4, 2, 9);
       grid.add(hitsField4, 3, 9);
       grid.add(bbLabel4, 4, 9);
       grid.add(bbField4, 5, 9);
       grid.add(soLabel4, 6, 9);
       grid.add(soField4, 7, 9);
       grid.add(hpLabel4, 8, 9);
       grid.add(hpField4, 9, 9);
       grid.add(rbiLabel4, 10, 9);
       grid.add(rbiField4,11, 9);
       grid.add(tbLabel4, 12, 9);
       grid.add(tbField4, 13, 9);
       //P5
       //First row
       //grid.add(playerSelectLabel5, 0, 11);
       grid.add(player5, 0, 10);
       grid.add(playerSelect5, 1, 10);
       //grid.add(positionSelectLabel5, 2, 11);
       grid.add(positionSelect5, 1, 11);
       grid.add(firstBLabel5, 2, 10);
       grid.add(firstBField5, 3, 10);
       grid.add(secondBLabel5, 4, 10);
       grid.add(secondBField5, 5, 10);
       grid.add(thirdBLabel5, 6, 10);
       grid.add(thirdBField5, 7, 10);
       grid.add(fourthBLabel5,8, 10);
       grid.add(fourthBField5, 9, 10);
       grid.add(abLabel5, 10, 10);
       grid.add(abField5, 11, 10);
       grid.add(runsLabel5, 12, 10);
       grid.add(runsField5, 13, 10);
       //P5
       //second row
       grid.add(hitsLabel5, 2, 11);
       grid.add(hitsField5, 3, 11);
       grid.add(bbLabel5, 4, 11);
       grid.add(bbField5, 5, 11);
       grid.add(soLabel5, 6, 11);
       grid.add(soField5, 7, 11);
       grid.add(hpLabel5, 8, 11);
       grid.add(hpField5, 9, 11);
       grid.add(rbiLabel5, 10, 11);
       grid.add(rbiField5,11, 11);
       grid.add(tbLabel5, 12, 11);
       grid.add(tbField5, 13, 11);
      //P6
       //First row
       //grid.add(playerSelectLabel6, 0, 13);
       grid.add(player6, 0, 12);
       grid.add(playerSelect6, 1, 12);
       //grid.add(positionSelectLabel6, 2, 13);
       grid.add(positionSelect6, 1, 13);
       grid.add(firstBLabel6, 2, 12);
       grid.add(firstBField6, 3, 12);
       grid.add(secondBLabel6, 4, 12);
       grid.add(secondBField6, 5, 12);
       grid.add(thirdBLabel6, 6, 12);
       grid.add(thirdBField6, 7, 12);
       grid.add(fourthBLabel6,8, 12);
       grid.add(fourthBField6, 9, 12);
       grid.add(abLabel6, 10, 12);
       grid.add(abField6, 11, 12);
       grid.add(runsLabel6, 12, 12);
       grid.add(runsField6, 13, 12);
       //P6
       //second row
       grid.add(hitsLabel6, 2, 13);
       grid.add(hitsField6, 3, 13);
       grid.add(bbLabel6, 4, 13);
       grid.add(bbField6, 5, 13);
       grid.add(soLabel6, 6, 13);
       grid.add(soField6, 7, 13);
       grid.add(hpLabel6, 8, 13);
       grid.add(hpField6, 9, 13);
       grid.add(rbiLabel6, 10, 13);
       grid.add(rbiField6,11, 13);
       grid.add(tbLabel6, 12, 13);
       grid.add(tbField6, 13, 13);
       //P7
       //First row
       //grid.add(playerSelectLabel7, 0, 15);
       grid.add(player7, 0, 14);
       grid.add(playerSelect7, 1, 14);
       //grid.add(positionSelectLabel7, 2, 15);
       grid.add(positionSelect7, 1, 15);
       grid.add(firstBLabel7, 2, 14);
       grid.add(firstBField7, 3, 14);
       grid.add(secondBLabel7, 4, 14);
       grid.add(secondBField7, 5, 14);
       grid.add(thirdBLabel7, 6, 14);
       grid.add(thirdBField7, 7, 14);
       grid.add(fourthBLabel7,8, 14);
       grid.add(fourthBField7, 9, 14);
       grid.add(abLabel7, 10, 14);
       grid.add(abField7, 11, 14);
       grid.add(runsLabel7, 12, 14);
       grid.add(runsField7, 13, 14);
       //P7
       //second row
       grid.add(hitsLabel7, 2, 15);
       grid.add(hitsField7, 3, 15);
       grid.add(bbLabel7, 4, 15);
       grid.add(bbField7, 5, 15);
       grid.add(soLabel7, 6, 15);
       grid.add(soField7, 7, 15);
       grid.add(hpLabel7, 8, 15);
       grid.add(hpField7, 9, 15);
       grid.add(rbiLabel7, 10, 15);
       grid.add(rbiField7,11, 15);
       grid.add(tbLabel7, 12, 15);
       grid.add(tbField7, 13, 15);
       //P8
       //First row
       //grid.add(playerSelectLabel8, 0, 17);
       grid.add(player8, 0, 16);
       grid.add(playerSelect8, 1, 16);
       //grid.add(positionSelectLabel8, 2, 17);
       grid.add(positionSelect8, 1, 17);
       grid.add(firstBLabel8, 2, 16);
       grid.add(firstBField8, 3, 16);
       grid.add(secondBLabel8, 4, 16);
       grid.add(secondBField8, 5, 16);
       grid.add(thirdBLabel8, 6, 16);
       grid.add(thirdBField8, 7, 16);
       grid.add(fourthBLabel8,8, 16);
       grid.add(fourthBField8, 9, 16);
       grid.add(abLabel8, 10, 16);
       grid.add(abField8, 11, 16);
       grid.add(runsLabel8, 12, 16);
       grid.add(runsField8, 13, 16);
       //P7
       //second row
       grid.add(hitsLabel8, 2, 17);
       grid.add(hitsField8, 3, 17);
       grid.add(bbLabel8, 4, 17);
       grid.add(bbField8, 5, 17);
       grid.add(soLabel8, 6, 17);
       grid.add(soField8, 7, 17);
       grid.add(hpLabel8, 8, 17);
       grid.add(hpField8, 9, 17);
       grid.add(rbiLabel8, 10, 17);
       grid.add(rbiField8,11, 17);
       grid.add(tbLabel8, 12, 17);
       grid.add(tbField8, 13, 17);
        //P9
       //First row
       //grid.add(playerSelectLabel9, 0, 19);
       grid.add(player9, 0, 18);
       grid.add(playerSelect9, 1, 18);
       //grid.add(positionSelectLabel9, 2, 19);
       grid.add(positionSelect9, 1, 19);
       grid.add(firstBLabel9, 2, 18);
       grid.add(firstBField9, 3, 18);
       grid.add(secondBLabel9, 4, 18);
       grid.add(secondBField9, 5, 18);
       grid.add(thirdBLabel9, 6, 18);
       grid.add(thirdBField9, 7, 18);
       grid.add(fourthBLabel9,8, 18);
       grid.add(fourthBField9, 9, 18);
       grid.add(abLabel9, 10, 18);
       grid.add(abField9, 11, 18);
       grid.add(runsLabel9, 12, 18);
       grid.add(runsField9, 13, 18);
       //P9
       //second row
       grid.add(hitsLabel9, 2, 19);
       grid.add(hitsField9, 3, 19);
       grid.add(bbLabel9, 4, 19);
       grid.add(bbField9, 5, 19);
       grid.add(soLabel9, 6, 19);
       grid.add(soField9, 7, 19);
       grid.add(hpLabel9, 8, 19);
       grid.add(hpField9, 9, 19);
       grid.add(rbiLabel9, 10, 19);
       grid.add(rbiField9,11, 19);
       grid.add(tbLabel9, 12, 19);
       grid.add(tbField9, 13, 19);
              
       

    }

    public ComboBox<String> getPlayers(ComboBox<String> playerSelect, TreeMap<String, Integer> players) {
        Validation v = new Validation();
        
        String teamName = teamSelect.getSelectionModel().getSelectedItem();
        
        if(players.size() != 0)    
        {    
 
            playerSelect.getItems().clear();
            
  
                for (Map.Entry<String, Integer> element: players.entrySet()) {
                    playerSelect1.getItems().add(element.getKey());
                    playerSelect2.getItems().add(element.getKey());
                    playerSelect3.getItems().add(element.getKey());
                    playerSelect4.getItems().add(element.getKey());
                    playerSelect5.getItems().add(element.getKey());
                    playerSelect6.getItems().add(element.getKey());
                    playerSelect7.getItems().add(element.getKey());
                    playerSelect8.getItems().add(element.getKey());
                    playerSelect9.getItems().add(element.getKey());

                   
                }
                // if size is zero, but we have valid team then still want to let us know
                selectTeamLabel.setText(teamName );
            }
            else
            {
                selectTeamLabel.setText("Team has no players entered");
            }
        return playerSelect;
        }
    public static ComboBox<String> fillTeamSelect(ComboBox<String> teamSelectm, ArrayList<String> teams) {
        for (String team : teams) {
            teamSelect.getItems().add(team);
        }
        return teamSelect;
    }
    
    private TreeMap<String, Integer> fillPHash(ComboBox<String> teamSelect) {
        BatterDB db = new BatterDB();
        String team = teamSelect.getSelectionModel().getSelectedItem();
        
        TreeMap<String, Integer> treeMap = db.getPlayers(team);
        return treeMap;
    }
    
    public void registerStats() {
        
    }
        public void handle(ActionEvent event) {
            
            if (    //player1
                    firstBField1.getText().isEmpty() || secondBField1.getText().isEmpty() || thirdBField1.getText().isEmpty() || fourthBField1.getText().isEmpty() || abField1.getText().isEmpty() || runsField1.getText().isEmpty() || hitsField1.getText().isEmpty() ||
                    bbField1.getText().isEmpty() || soField1.getText().isEmpty() || hpField1.getText().isEmpty() ||
                    //player2
                    firstBField2.getText().isEmpty() || secondBField2.getText().isEmpty() || thirdBField2.getText().isEmpty() || fourthBField2.getText().isEmpty() || abField2.getText().isEmpty() || runsField2.getText().isEmpty() || hitsField2.getText().isEmpty() || 
                    bbField2.getText().isEmpty() || soField2.getText().isEmpty() || hpField2.getText().isEmpty() ||
                    //player3
                    firstBField3.getText().isEmpty() || secondBField3.getText().isEmpty() || thirdBField3.getText().isEmpty() || fourthBField3.getText().isEmpty() || abField3.getText().isEmpty() || runsField3.getText().isEmpty() || hitsField3.getText().isEmpty() ||
                    bbField3.getText().isEmpty() || soField3.getText().isEmpty() || hpField3.getText().isEmpty() ||
                    //Player4
                    firstBField4.getText().isEmpty() || secondBField4.getText().isEmpty() || thirdBField4.getText().isEmpty() || fourthBField4.getText().isEmpty() || abField4.getText().isEmpty() || runsField4.getText().isEmpty() || hitsField4.getText().isEmpty() ||
                    bbField4.getText().isEmpty() || soField4.getText().isEmpty() || hpField4.getText().isEmpty() ||
                    //Player5
                    firstBField5.getText().isEmpty() || secondBField5.getText().isEmpty() || thirdBField5.getText().isEmpty() || fourthBField5.getText().isEmpty() || abField5.getText().isEmpty() || runsField5.getText().isEmpty() || hitsField5.getText().isEmpty() ||
                    bbField5.getText().isEmpty() || soField5.getText().isEmpty() || hpField5.getText().isEmpty() ||
                    //Player6
                    firstBField6.getText().isEmpty() || secondBField6.getText().isEmpty() || thirdBField6.getText().isEmpty() || fourthBField6.getText().isEmpty() || abField6.getText().isEmpty() || runsField7.getText().isEmpty() || hitsField7.getText().isEmpty() ||
                    bbField6.getText().isEmpty() || soField6.getText().isEmpty() || hpField7.getText().isEmpty() ||
                    //Player7
                    firstBField7.getText().isEmpty() || secondBField7.getText().isEmpty() || thirdBField7.getText().isEmpty() || fourthBField7.getText().isEmpty() || abField7.getText().isEmpty() || runsField7.getText().isEmpty() || hitsField7.getText().isEmpty() ||
                    bbField7.getText().isEmpty() || soField7.getText().isEmpty() || hpField7.getText().isEmpty() ||
                    //Player8
                    firstBField9.getText().isEmpty() || secondBField9.getText().isEmpty() || thirdBField9.getText().isEmpty() || fourthBField9.getText().isEmpty() || abField9.getText().isEmpty() || runsField9.getText().isEmpty() || hitsField9.getText().isEmpty() ||
                    bbField9.getText().isEmpty() || soField9.getText().isEmpty() || hpField9.getText().isEmpty())
            
            { 
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Missing entries");
                alert.setContentText("Make sure to enter all players names.");
                alert.showAndWait();
               //eturn();
            }
      //      else {
        
    }
}
        