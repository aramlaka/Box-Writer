/**
 * Created by akhil on 1/15/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button boxMake;
    Button copy;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Box Maker");

        boxMake = new Button("Boxify");
        copy = new Button("Copy");

        StackPane layout = new StackPane();
        layout.getChildren().add(boxMake);

        Scene scene = new Scene(layout,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == boxMake){

        }

        if(event.getSource() == copy){

        }
    }
}
