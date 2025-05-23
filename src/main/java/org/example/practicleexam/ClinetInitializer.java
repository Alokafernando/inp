package org.example.practicleexam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class ClinetInitializer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Client.fxml"));
        stage.setScene(new javafx.scene.Scene(parent));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
