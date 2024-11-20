package org.example.fhrms.uicontroller.route;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.example.fhrms.HelloApplication;

public class Navigation {

    public static void navigateTo(String route, Stage stage) {
        try {
            Parent root =
                    FXMLLoader.load(HelloApplication.class.getResource(
                            RoutesMap.getInstance().getRoute(route)
                    ));
            stage.getScene().setRoot(root);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
