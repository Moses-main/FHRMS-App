package org.example.fhrms.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageRolesController {

    @FXML
    private TableView<?> rolesTable;

    @FXML
    private TableColumn<?, ?> roleNameColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    public void handleAddRole(ActionEvent event) {
        // Logic to add a role
    }

    public void handleEditRole(ActionEvent event) {
        // Logic to edit a role
    }

    public void handleDeleteRole(ActionEvent event) {
        // Logic to delete a role
    }
}
