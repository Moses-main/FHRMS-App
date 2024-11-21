package org.example.fhrms.uicontroller.dashboard;

import org.example.fhrms.uicontroller.route.Navigation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DashboardController {
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnInventory;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnHR;
    @FXML
    private Button btnReports;
    @FXML
    private StackPane mainContent;
    //
    // @FXML
    // private Button btnChef;

    // @FXML
    // protected void goToChefDashboard() {
    // Stage stage = (Stage) btnChef.getScene().getWindow();
    // Navigation.navigateTo("chef", stage);
    // }

    @FXML
    private void initialize() {
        // Add action listeners to navigation buttons
        btnDashboard.setOnAction(event -> loadSection("Dashboard"));
        btnInventory.setOnAction(event -> loadSection("Inventory Management"));
        btnOrders.setOnAction(event -> loadSection("Order Processing"));
        btnHR.setOnAction(event -> loadSection("HR Management"));
        btnReports.setOnAction(event -> loadSection("Reports"));

    }

    private void loadSection(String section) {
        mainContent.getChildren().clear();
        mainContent.getChildren().add(new javafx.scene.control.Label(section + " Section Coming Soon!"));
    }
}
