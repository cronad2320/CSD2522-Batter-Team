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

import static com.csd2522.baseballbatterstatsapp.BatterGUIApp.fillGameCombo;
import java.util.Arrays;
import java.util.HashMap;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class BatterStatsGUI extends Application{
   
    
    // get DB instance
    private BatterDB db = new BatterDB();
    private final HashMap<String, Integer> games = db.getTeams();

    
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
        Scene scene = new Scene(grid, 1125, 775);
       
       // Set scene and display stage
       primaryStage.setScene(scene);
       primaryStage.show();
       
        ComboBox<String> gameSelect = new ComboBox<>();
        gameSelect.setPromptText("Select Game");
        //fill gameSelect combo box 
        fillGameCombo(gameSelect,games);
   
        

        // Player Select ComboBoxs
        ComboBox<String> playerSelect1 = new ComboBox<>();
        playerSelect1.setPromptText("Select Player");
        ComboBox<String> playerSelect2 = new ComboBox<>();
        playerSelect2.setPromptText("Select Player");
        ComboBox<String> playerSelect3 = new ComboBox<>();
        playerSelect3.setPromptText("Select Player");
        ComboBox<String> playerSelect4 = new ComboBox<>();
        playerSelect4.setPromptText("Select Player");
        ComboBox<String> playerSelect5 = new ComboBox<>();
        playerSelect5.setPromptText("Select Player");
        ComboBox<String> playerSelect6 = new ComboBox<>();
        playerSelect6.setPromptText("Select Player");
        ComboBox<String> playerSelect7 = new ComboBox<>();
        playerSelect7.setPromptText("Select Player");
        ComboBox<String> playerSelect8 = new ComboBox<>();
        playerSelect8.setPromptText("Select Player");
        ComboBox<String> playerSelect9 = new ComboBox<>();
        playerSelect9.setPromptText("Select Player");
        
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


         
        //Team select combo box
        ComboBox<String> teamSelect = new ComboBox<>();
        teamSelect.setPromptText("Select Team");
      
       //create labels 
       //Label selectGameLabel = new Label ("Select Game");
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
       
       //Set widths
       gameSelect.setPrefWidth(110);
       teamSelect.setPrefWidth(110);
       
       //P1
       playerSelect1.setPrefWidth(110);
       positionSelect1.setPrefWidth(110);
       firstBField1.setPrefWidth(30);
       secondBField1.setPrefWidth(30);
       thirdBField1.setPrefWidth(30);
       fourthBField1.setPrefWidth(30);
       abField1.setPrefWidth(30);
       runsField1.setPrefWidth(30);
       hitsField1.setPrefWidth(30);
       bbField1.setPrefWidth(30);
       soField1.setPrefWidth(30);
       hpField1.setPrefWidth(30);
       rbiField1.setPrefWidth(30);
       tbField1.setPrefWidth(30);
       //P2
       playerSelect2.setPrefWidth(110);
       positionSelect2.setPrefWidth(110);
       firstBField2.setPrefWidth(30);
       secondBField2.setPrefWidth(30);
       thirdBField2.setPrefWidth(30);
       fourthBField2.setPrefWidth(30);
       abField2.setPrefWidth(30);
       runsField2.setPrefWidth(30);
       hitsField2.setPrefWidth(30);
       bbField2.setPrefWidth(30);
       soField2.setPrefWidth(30);
       hpField2.setPrefWidth(30);
       rbiField2.setPrefWidth(30);
       tbField2.setPrefWidth(30);
       //P3
       playerSelect3.setPrefWidth(110);
       positionSelect3.setPrefWidth(110);
       firstBField3.setPrefWidth(30);
       secondBField3.setPrefWidth(30);
       thirdBField3.setPrefWidth(30);
       fourthBField3.setPrefWidth(30);
       abField3.setPrefWidth(30);
       runsField3.setPrefWidth(30);
       hitsField3.setPrefWidth(30);
       bbField3.setPrefWidth(30);
       soField3.setPrefWidth(30);
       hpField3.setPrefWidth(30);
       rbiField3.setPrefWidth(30);
       tbField3.setPrefWidth(30);
       //P4
       playerSelect4.setPrefWidth(110);
       positionSelect4.setPrefWidth(110);
       firstBField4.setPrefWidth(30);
       secondBField4.setPrefWidth(30);
       thirdBField4.setPrefWidth(30);
       fourthBField4.setPrefWidth(30);
       abField4.setPrefWidth(30);
       runsField4.setPrefWidth(30);
       hitsField4.setPrefWidth(30);
       bbField4.setPrefWidth(30);
       soField4.setPrefWidth(30);
       hpField4.setPrefWidth(30);
       rbiField4.setPrefWidth(30);
       tbField4.setPrefWidth(30);
       //P5
       playerSelect5.setPrefWidth(110);
       positionSelect5.setPrefWidth(110);
       firstBField5.setPrefWidth(30);
       secondBField5.setPrefWidth(30);
       thirdBField5.setPrefWidth(30);
       fourthBField5.setPrefWidth(30);
       abField5.setPrefWidth(30);
       runsField5.setPrefWidth(30);
       hitsField5.setPrefWidth(30);
       bbField5.setPrefWidth(30);
       soField5.setPrefWidth(30);
       hpField5.setPrefWidth(30);
       rbiField5.setPrefWidth(30);
       tbField5.setPrefWidth(30);
       //P6
       playerSelect6.setPrefWidth(110);
       positionSelect6.setPrefWidth(110);
       firstBField6.setPrefWidth(30);
       secondBField6.setPrefWidth(30);
       thirdBField6.setPrefWidth(30);
       fourthBField6.setPrefWidth(30);
       abField6.setPrefWidth(30);
       runsField6.setPrefWidth(30);
       hitsField6.setPrefWidth(30);
       bbField6.setPrefWidth(30);
       soField6.setPrefWidth(30);
       hpField6.setPrefWidth(30);
       rbiField6.setPrefWidth(30);
       tbField6.setPrefWidth(30);
       //P7
       playerSelect7.setPrefWidth(110);
       positionSelect7.setPrefWidth(110);
       firstBField7.setPrefWidth(30);
       secondBField7.setPrefWidth(30);
       thirdBField7.setPrefWidth(30);
       fourthBField7.setPrefWidth(30);
       abField7.setPrefWidth(30);
       runsField7.setPrefWidth(30);
       hitsField7.setPrefWidth(30);
       bbField7.setPrefWidth(30);
       soField7.setPrefWidth(30);
       hpField7.setPrefWidth(30);
       rbiField7.setPrefWidth(30);
       tbField7.setPrefWidth(30);
        //P8
       playerSelect8.setPrefWidth(110);
       positionSelect8.setPrefWidth(110);
       firstBField8.setPrefWidth(30);
       secondBField8.setPrefWidth(30);
       thirdBField8.setPrefWidth(30);
       fourthBField8.setPrefWidth(30);
       abField8.setPrefWidth(30);
       runsField8.setPrefWidth(30);
       hitsField8.setPrefWidth(30);
       bbField8.setPrefWidth(30);
       soField8.setPrefWidth(30);
       hpField8.setPrefWidth(30);
       rbiField8.setPrefWidth(30);
       tbField8.setPrefWidth(30);
       //P9      
       playerSelect9.setPrefWidth(110);
       positionSelect9.setPrefWidth(110);
       firstBField9.setPrefWidth(30);
       secondBField9.setPrefWidth(30);
       thirdBField9.setPrefWidth(30);
       fourthBField9.setPrefWidth(30);
       abField9.setPrefWidth(30);
       runsField9.setPrefWidth(30);
       hitsField9.setPrefWidth(30);
       bbField9.setPrefWidth(30);
       soField9.setPrefWidth(30);
       hpField9.setPrefWidth(30);
       rbiField9.setPrefWidth(30);
       tbField8.setPrefWidth(30);
       
       //Add to grid
       
       grid.add(gameSelect,0, 1 );
       grid.add(teamSelect, 1, 1);
       //P1
       //First row
       //grid.add(playerSelectLabel1, 0, 3);
       grid.add(playerSelect1,0, 2);
       //grid.add(positionSelectLabel1, 2, 3);
       grid.add(positionSelect1, 1, 2);
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
       grid.add(playerSelect2, 0, 4);
       //grid.add(positionSelectLabel2, 2, 5);
       grid.add(positionSelect2,1, 4);
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
       grid.add(playerSelect3, 0, 6);
       //grid.add(positionSelectLabel3, 2, 7);
       grid.add(positionSelect3, 1, 6);
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
       grid.add(playerSelect4, 1, 9);
       //grid.add(positionSelectLabel4, 2, 9);
       grid.add(positionSelect4, 3, 9);
       grid.add(firstBLabel4, 4, 9);
       grid.add(firstBField4, 5, 9);
       grid.add(secondBLabel4, 6, 9);
       grid.add(secondBField4, 7, 9);
       grid.add(thirdBLabel4, 8, 9);
       grid.add(thirdBField4, 9, 9);
       grid.add(fourthBLabel4,10, 9);
       grid.add(fourthBField4, 11, 9);
       grid.add(abLabel4, 12, 9);
       grid.add(abField4, 13, 9);
       grid.add(runsLabel4, 14, 9);
       grid.add(runsField4, 15, 9);
       //P4
       //second row
       grid.add(hitsLabel4, 4, 10);
       grid.add(hitsField4, 5, 10);
       grid.add(bbLabel4, 6, 10);
       grid.add(bbField4, 7, 10);
       grid.add(soLabel4, 8, 10);
       grid.add(soField4, 9, 10);
       grid.add(hpLabel4, 10, 10);
       grid.add(hpField4, 11, 10);
       grid.add(rbiLabel4, 12, 10);
       grid.add(rbiField4,13, 10);
       grid.add(tbLabel4, 14, 10);
       grid.add(tbField4, 15, 10);
       //P5
       //First row
       //grid.add(playerSelectLabel5, 0, 11);
       grid.add(playerSelect5, 1, 11);
       //grid.add(positionSelectLabel5, 2, 11);
       grid.add(positionSelect5, 3, 11);
       grid.add(firstBLabel5, 4, 11);
       grid.add(firstBField5, 5, 11);
       grid.add(secondBLabel5, 6, 11);
       grid.add(secondBField5, 7, 11);
       grid.add(thirdBLabel5, 8, 11);
       grid.add(thirdBField5, 9, 11);
       grid.add(fourthBLabel5,10, 11);
       grid.add(fourthBField5, 11, 11);
       grid.add(abLabel5, 12, 11);
       grid.add(abField5, 13, 11);
       grid.add(runsLabel5, 14, 11);
       grid.add(runsField5, 15, 11);
       //P5
       //second row
       grid.add(hitsLabel5, 4, 12);
       grid.add(hitsField5, 5, 12);
       grid.add(bbLabel5, 6, 12);
       grid.add(bbField5, 7, 12);
       grid.add(soLabel5, 8, 12);
       grid.add(soField5, 9, 12);
       grid.add(hpLabel5, 10, 12);
       grid.add(hpField5, 11, 12);
       grid.add(rbiLabel5, 12, 12);
       grid.add(rbiField5,13, 12);
       grid.add(tbLabel5, 14, 12);
       grid.add(tbField5, 15, 12);
      //P6
       //First row
       //grid.add(playerSelectLabel6, 0, 13);
       grid.add(playerSelect6, 1, 13);
       //grid.add(positionSelectLabel6, 2, 13);
       grid.add(positionSelect6, 3, 13);
       grid.add(firstBLabel6, 4, 13);
       grid.add(firstBField6, 5, 13);
       grid.add(secondBLabel6, 6, 13);
       grid.add(secondBField6, 7, 13);
       grid.add(thirdBLabel6, 8, 13);
       grid.add(thirdBField6, 9, 13);
       grid.add(fourthBLabel6,10, 13);
       grid.add(fourthBField6, 11, 13);
       grid.add(abLabel6, 12, 13);
       grid.add(abField6, 13, 13);
       grid.add(runsLabel6, 14, 13);
       grid.add(runsField6, 15, 13);
       //P6
       //second row
       grid.add(hitsLabel6, 4, 14);
       grid.add(hitsField6, 5, 14);
       grid.add(bbLabel6, 6, 14);
       grid.add(bbField6, 7, 14);
       grid.add(soLabel6, 8, 14);
       grid.add(soField6, 9, 14);
       grid.add(hpLabel6, 10, 14);
       grid.add(hpField6, 11, 14);
       grid.add(rbiLabel6, 12, 14);
       grid.add(rbiField6,13, 14);
       grid.add(tbLabel6, 14, 14);
       grid.add(tbField6, 15, 14);
       //P7
       //First row
       //grid.add(playerSelectLabel7, 0, 15);
       grid.add(playerSelect7, 1, 15);
       //grid.add(positionSelectLabel7, 2, 15);
       grid.add(positionSelect7, 3, 15);
       grid.add(firstBLabel7, 4, 15);
       grid.add(firstBField7, 5, 15);
       grid.add(secondBLabel7, 6, 15);
       grid.add(secondBField7, 7, 15);
       grid.add(thirdBLabel7, 8, 15);
       grid.add(thirdBField7, 9, 15);
       grid.add(fourthBLabel7,10, 15);
       grid.add(fourthBField7, 11, 15);
       grid.add(abLabel7, 12, 15);
       grid.add(abField7, 13, 15);
       grid.add(runsLabel7, 14, 15);
       grid.add(runsField7, 15, 15);
       //P7
       //second row
       grid.add(hitsLabel7, 4, 16);
       grid.add(hitsField7, 5, 16);
       grid.add(bbLabel7, 6, 16);
       grid.add(bbField7, 7, 16);
       grid.add(soLabel7, 8, 16);
       grid.add(soField7, 9, 16);
       grid.add(hpLabel7, 10, 16);
       grid.add(hpField7, 11, 16);
       grid.add(rbiLabel7, 12, 16);
       grid.add(rbiField7,13, 16);
       grid.add(tbLabel7, 14, 16);
       grid.add(tbField7, 15, 16);
       //P8
       //First row
       //grid.add(playerSelectLabel8, 0, 17);
       grid.add(playerSelect8, 1, 17);
       //grid.add(positionSelectLabel8, 2, 17);
       grid.add(positionSelect8, 3, 17);
       grid.add(firstBLabel8, 4, 17);
       grid.add(firstBField8, 5, 17);
       grid.add(secondBLabel8, 6, 17);
       grid.add(secondBField8, 7, 17);
       grid.add(thirdBLabel8, 8, 17);
       grid.add(thirdBField8, 9, 17);
       grid.add(fourthBLabel8,10, 17);
       grid.add(fourthBField8, 11, 17);
       grid.add(abLabel8, 12, 17);
       grid.add(abField8, 13, 17);
       grid.add(runsLabel8, 14, 17);
       grid.add(runsField8, 15, 17);
       //P7
       //second row
       grid.add(hitsLabel8, 4, 18);
       grid.add(hitsField8, 5, 18);
       grid.add(bbLabel8, 6, 18);
       grid.add(bbField8, 7, 18);
       grid.add(soLabel8, 8, 18);
       grid.add(soField8, 9, 18);
       grid.add(hpLabel8, 10, 18);
       grid.add(hpField8, 11, 18);
       grid.add(rbiLabel8, 12, 18);
       grid.add(rbiField8,13, 18);
       grid.add(tbLabel8, 14, 18);
       grid.add(tbField8, 15, 18);
        //P9
       //First row
       //grid.add(playerSelectLabel9, 0, 19);
       grid.add(playerSelect9, 1, 19);
       //grid.add(positionSelectLabel9, 2, 19);
       grid.add(positionSelect9, 3, 19);
       grid.add(firstBLabel9, 4, 19);
       grid.add(firstBField9, 5, 19);
       grid.add(secondBLabel9, 6, 19);
       grid.add(secondBField9, 7, 19);
       grid.add(thirdBLabel9, 8, 19);
       grid.add(thirdBField9, 9, 19);
       grid.add(fourthBLabel9,10, 19);
       grid.add(fourthBField9, 11, 19);
       grid.add(abLabel9, 12, 19);
       grid.add(abField9, 13, 19);
       grid.add(runsLabel9, 14, 19);
       grid.add(runsField9, 15, 19);
       //P7
       //second row
       grid.add(hitsLabel9, 4, 20);
       grid.add(hitsField9, 5, 20);
       grid.add(bbLabel9, 6, 20);
       grid.add(bbField9, 7, 20);
       grid.add(soLabel9, 8, 20);
       grid.add(soField9, 9, 20);
       grid.add(hpLabel9, 10, 20);
       grid.add(hpField9, 11, 20);
       grid.add(rbiLabel9, 12, 20);
       grid.add(rbiField9,13, 20);
       grid.add(tbLabel9, 14, 20);
       grid.add(tbField9, 15, 20);
    

       
    }}
        