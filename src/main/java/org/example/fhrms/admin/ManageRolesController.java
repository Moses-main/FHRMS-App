package org.example.fhrms.admin;

import org.example.fhrms.model2.Role;
import org.example.fhrms.model2.RoleInfo;
import org.example.fhrms.uicontroller.route.Navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ManageRolesController {
    @FXML
    private Button backButton;

    @FXML
    private TableView<RoleInfo> rolesTable;

    @FXML
    private TableColumn<RoleInfo, String> roleNameColumn;

    @FXML
    private TableColumn<RoleInfo, String> descriptionColumn;

    public void handleAddRole(ActionEvent event) {
        // Logic to add a role
    }

    public void handleEditRole(ActionEvent event) {
        // Logic to edit a role
    }

    public void handleDeleteRole(ActionEvent event) {
        // Logic to delete a role
    }

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
