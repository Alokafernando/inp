package org.example.practicleexam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerInitializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Server.fxml"));
        stage.setScene(new javafx.scene.Scene(parent));
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}