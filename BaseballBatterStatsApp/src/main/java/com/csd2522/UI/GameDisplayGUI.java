/*
    Author: Daniel Cronauer
    Date: 5/4/2023
    File: PlayerAddGUI.java
    Purpose: Page to take in text area, this will display game to text area
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
import static com.csd2522.UI.PlayerAddGUI.fillPlayersHash;
import static com.csd2522.UI.PlayerAddGUI.fillTeamCombo;
import java.util.ArrayList;
import com.csd2522.ValidationFormat.*;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.control.TextArea;

/**
 *
 * @author Locke
 */
public class GameDisplayGUI {
   
   
    
    // This is the start method for JavaFX it handles creation of scene, stage
    // and controls DC 4//26/2023
    public void start(Stage primaryStage, StringBuilder message) {
        Validation v = new Validation();
               
        // title set
        primaryStage.setTitle("Display game");
        
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
        Scene scene = new Scene(grid, 800,800);
        
        // create vbox 10 px padding between controls DC 4//26/2023
        VBox appContainer = new VBox(10);
        
        // create Hbox with 10px padding between controls DC 4//26/2023
        HBox textBox = new HBox(10);
        
        // create TextArea DC 5/4/2023
        TextArea game = new TextArea();
        // set style and size of text area  5/4/2023
        game.setStyle("-fx-font-family: monospace");
        game.setPrefColumnCount(100);
        game.setPrefRowCount(80);
        // add string to text area  5/4/2023
        game.appendText(message.toString());
        // dont let edits
        game.setEditable(false);
        
        // add to hbox DC 5/4/2023 
        textBox.getChildren().add(game);
        
        
        
        
        
      
        
     
        
  
        appContainer.getChildren().add(textBox);
       
        
        // now we add vbox appContainer to GridPane object grid at col 0 
        // and row 0. Also we are defining the column span as 2 and row span as 1 DC 4//26/2023
        grid.add(appContainer, 0, 0, 2, 1);
        
        // lower case s to set stage with scene object created above
        primaryStage.setScene(scene);
        // show the stage now that we have created scene, added root container layout
        // and added all the desired sub layout objects and controls. DC 4//26/2023
        primaryStage.show();        
    }}
