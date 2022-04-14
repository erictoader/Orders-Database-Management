package com.erictoader.ordersdatabasemanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/*
 *  This is the main class containing a single main method which will initialize the JavaFX window
 *  @author Toader Eric-Stefan
 */
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-stage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Orders Management");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}