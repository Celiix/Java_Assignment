package com.example.records;

// Celisha Daramy / 1340551 - Student Hall Application OOP

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

///**
// * This is the main application that the program will run from.
// * Below is just the general setup like the title name of the window and the size of the window by using the Scene class
// */

public class HelloApplication extends Application {
    @Override
//    /** Overriding method*/
    public void start(Stage stage) throws IOException {

//
//         * The fxml-loader is a usable class used to load and graph the GUI using fxml language at runtime.
//         *
//         * This file is only used from the fxml-loader to create the UI but links with the HelloController.java file which contains the handle user events and for the modification of the GUI.
//         *
//         * In advance of loading the FXML file and constructing the user interface, the FXMLLoader will instantiate the controller and inject any dependencies that are required.
//
//        /** Use of getResource method to load fxml file "hello-view.fxml" that details the UI of the app.*/
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

//        /**Height and Width of window*/
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);

//        /**Setting title of the window.*/
        stage.setTitle("Student Hall Application Assignment");
        stage.setScene(scene);

//        /** Visualisation of window*/
        stage.show();
    }


     /**@param args - Launches main application*/
    public static void main(String[] args) {
        launch();
    }
}