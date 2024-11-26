package org.example.fhrms.admin;

import javafx.beans.value.ObservableStringValue;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.fhrms.db;
import org.example.fhrms.model2.User;
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
    private TableView<User> usersTable;

    @FXML
    private TableColumn<User, String> idColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TableColumn<User, String> statusColumn;


        @FXML
        private void initialize() {
            // Ensure the table columns are bound to the correct properties
            idColumn.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
           statusColumn.setCellValueFactory(new PropertyValueFactory<User, String>("fullname"));
            roleColumn.setCellValueFactory(new PropertyValueFactory<User, String>("userRole"));

            // Populate the TableView with data
            System.out.println(db.getInstance().getAllUsers()); // Debugging line
            usersTable.getItems().addAll(db.getInstance().getAllUsers());

    }

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
