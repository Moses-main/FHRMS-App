package org.example.fhrms.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.fhrms.db;
import org.example.fhrms.model.Report;
import org.example.fhrms.uicontroller.route.Navigation;

public class ReportsController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<Report> reportsTable;

    @FXML
    private TableColumn<Report, String> reportIdColumn;

    @FXML
    private TableColumn<Report, String> reportTypeColumn;

    @FXML
    private TableColumn<Report, String> dateColumn;

    // ObservableList to hold data for the table
    private ObservableList<Report> reportList = FXCollections.observableArrayList();

    // Initialize method called after the FXM file is loaded
    @FXML
    public void initialize() {
        // initialize table columns
        initializeTableColumns();

        // load reports from the database
        // loadReports();
    }

    private void initializeTableColumns() {
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));

        reportTypeColumn.setCellValueFactory(new PropertyValueFactory<>("reportType"));

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateGenerated"));
    }

    // Load report data from the database and populate the table

    // private void loadReports(){
    // // retrieve reports from the database
    // reportList.clear(); // clear any existing data
    // reportList.addAll(db.getInstance().getAllReports());
    // }

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
