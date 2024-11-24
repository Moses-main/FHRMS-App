package org.example.fhrms.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReportsController {

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
}
