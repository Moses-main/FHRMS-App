package org.example.fhrms.route;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.fhrms.HelloApplication;

import java.util.Objects;

public class Navigation {

    public static void navigateTo(String fxmlFile, Stage stage) {
        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource(fxmlFile));

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
