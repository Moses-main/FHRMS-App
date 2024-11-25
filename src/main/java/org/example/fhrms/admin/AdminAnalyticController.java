package org.example.fhrms.admin;

import org.example.fhrms.uicontroller.route.Navigation;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminAnalyticController {

    @FXML
    private PieChart ordersPieChart;

    @FXML
    private BarChart<String, Number> revenueBarChart;

    @FXML
    private Button backButton;

    /**
     * Initializes the view components.
     */
    @FXML
    public void initialize() {
        loadOrdersPieChart();
        loadRevenueBarChart();
    }

    /**
     * Populates the pie chart with order statistics.
     */
    private void loadOrdersPieChart() {
        PieChart.Data pendingOrders = new PieChart.Data("Pending Orders", 40);
        PieChart.Data completedOrders = new PieChart.Data("Completed Orders", 120);
        PieChart.Data canceledOrders = new PieChart.Data("Canceled Orders", 20);

        ordersPieChart.getData().addAll(pendingOrders, completedOrders,
                canceledOrders);
    }

    /**
     * Populates the bar chart with revenue data.
     */
    private void loadRevenueBarChart() {
        XYChart.Series<String, Number> revenueSeries = new XYChart.Series<>();
        revenueSeries.setName("Monthly Revenue");

        revenueSeries.getData().add(new XYChart.Data<>("January", 15000));
        revenueSeries.getData().add(new XYChart.Data<>("February", 17000));
        revenueSeries.getData().add(new XYChart.Data<>("March", 19000));
        revenueSeries.getData().add(new XYChart.Data<>("April", 12000));

        revenueBarChart.getData().add(revenueSeries);
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

    /**
     * Handles the refresh button to reload analytics data.
     */
    @FXML
    private void handleRefreshAnalytics() {
        ordersPieChart.getData().clear();
        revenueBarChart.getData().clear();

        loadOrdersPieChart();
        loadRevenueBarChart();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Analytics Refreshed");
        alert.setHeaderText(null);
        alert.setContentText("The analytics data has been refreshed successfully.");
        alert.showAndWait();
    }

    /**
     * Handles the download report button action.
     */
    @FXML
    private void handleDownloadReport() {
        // Logic for downloading report
        System.out.println("Download Report clicked");
    }
}
