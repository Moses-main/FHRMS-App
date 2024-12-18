package org.example.fhrms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.example.fhrms.service.DatabaseInitializer;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(HelloApplication.class.getResource("root.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("auth/signup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 320);
        scene.getStylesheets().setAll(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("FHRMS");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        DatabaseInitializer.initialize();
        launch();
    }
}