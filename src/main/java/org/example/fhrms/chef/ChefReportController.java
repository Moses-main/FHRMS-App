package org.example.fhrms.chef;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ChefReportController {

    @FXML
    private VBox root; // Root container of this FXML

    @FXML
    private TableView<?> reportTable;

    @FXML
    private TableColumn<?, ?> reportDateColumn;

    @FXML
    private TableColumn<?, ?> reportDetailsColumn;

    @FXML
    private TableColumn<?, ?> reportStatusColumn;

    @FXML
    private Button generateReportButton;

    @FXML
    private Button exportReportButton;

    @FXML
    private Button viewDetailedReportButton;

    @FXML
    private Button backButton;

    @FXML
    private void handleGenerateReport() {
        // Logic to generate a report
        System.out.println("Generate report clicked.");
    }

    @FXML
    private void handleExportReport() {
        // Logic to export a report
        System.out.println("Export report clicked.");
    }

    @FXML
    private void handleViewDetailedReport() {
        // Logic to view detailed report
        System.out.println("View detailed report clicked.");
    }

    @FXML
    private void handleBackToDashboard() {
        try {
            // Load the parent dashboard view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/DashboardView.fxml"));
            Parent parentView = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(parentView);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
