/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Asad
 */
public class Test extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            BorderPane root = new BorderPane();
            
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("Main.fxml").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
