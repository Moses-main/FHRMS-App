package org.example.fhrms.admin;

import org.example.fhrms.uicontroller.route.Navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ManageUsersController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> usersTable;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> roleColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    public void handleAddUser(ActionEvent event) {
        // Logic to add a user
    }

    public void handleEditUser(ActionEvent event) {
        // Logic to edit a user
    }

    public void handleDeleteUser(ActionEvent event) {
        // Logic to delete a user
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
