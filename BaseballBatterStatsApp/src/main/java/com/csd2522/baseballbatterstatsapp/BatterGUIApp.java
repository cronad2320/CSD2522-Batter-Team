/*
Author: Batter Team Daniel Cronauer, Michael Mowad, Andrew McKee
Date: 4/21/2023 added to project
File: Console.java
Purpose: Driver App, starts main window for App

 */

package com.csd2522.baseballbatterstatsapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.csd2522.ValidationFormat.StringUtil;
import com.csd2522.DB.BatterDB;


/**
 * JavaFX BatterGUIApp
 */
public class BatterGUIApp extends Application {

    @Override
    public void start(Stage stage) {
        //GridPane to attach items to
        GridPane mainPane = new GridPane();
        
        mainPane.setAlignment(Pos.TOP_LEFT);
        
      
        
        //hbox for items
        HBox testBox = new HBox(10);
        
        //create button for new window
        Label label1 = new Label("First page!");
        Label label2 = new Label("Test two!");
        testBox.getChildren().add(label1);
        testBox.getChildren().add(label2);
        
        Button buttonNewWindow = new Button();
        buttonNewWindow.setText("New window");
        testBox.getChildren().add(buttonNewWindow);
        // new handler event call newWindow when button clicked
        buttonNewWindow.setOnAction(event -> newWindow());//new EventHandler<ActionEvent>()
      
       
        
        // add Hbox to grid
        mainPane.add(testBox, 0, 0);
        
        Scene scene = new Scene(mainPane, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Landing Page");
        stage.show();
    }

    public static void main(String[] args) {
        
        launch();
    }
    /**
    *Simple test to see if we can run a new window
    */
    public static void newWindow()
    {
        Label newPageLabel = new Label("New label new window!");
        Button button2 = new Button();
        button2.setText("test");
        GridPane newLayout = new GridPane();

        newLayout.add(newPageLabel,0,0);
        newLayout.add(button2,0,1);
        
        button2.setOnAction(event -> printPlayers()); // test db connection
        
        Scene newScene = new Scene(newLayout,200,200);
        //set new stage
        Stage newWindow = new Stage();
        newWindow.setTitle("New page!");
        newWindow.setScene(newScene);

        newWindow.show();
    }
    
    public static void printPlayers()
    {
        BatterDB db = new BatterDB();
        db.printPlayers();
    }
}