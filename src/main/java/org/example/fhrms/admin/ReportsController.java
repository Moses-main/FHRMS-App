package org.example.fhrms.admin;

import org.example.fhrms.uicontroller.route.Navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ReportsController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> reportsTable;

    @FXML
    private TableColumn<?, ?> reportIdColumn;

    @FXML
    private TableColumn<?, ?> reportTypeColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    public void handleGenerateReport(ActionEvent event) {
        // Logic to generate a new report
    }

    public void handleDownloadReport(ActionEvent event) {
        // Logic to download the selected report
    }

    /**
     * Handles the back button action to return to the admin dashboard.
     */
    @FXML
    private void handleBackToDashboard() {
        // Navigate back to the admin dashboard
        System.out.println("Back to Dashboard clicked");

        Stage stage = (Stage) backButton.getScene().getWindow();
        // Navigation.navigateTo("admin/admin-dashboard.fxml", stage);
        Navigation.navigateTo("admin", stage);
        // Add your logic for managing users
    }

}
