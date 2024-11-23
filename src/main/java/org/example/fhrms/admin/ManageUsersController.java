package org.example.fhrms.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageUsersController {

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
}
