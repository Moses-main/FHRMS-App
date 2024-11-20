package org.example.fhrms.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.example.fhrms.model.User;  // assuming you have a User model class

public class AdminController {

    @FXML
    private TableView<User> userTable;  // Table to display users

    @FXML
    private TableColumn<User, String> columnName;  // Column for Name
    @FXML
    private TableColumn<User, String> columnEmail;  // Column for Email
    @FXML
    private TableColumn<User, String> columnRole;  // Column for Role
    @FXML
    private TableColumn<User, String> columnStatus;  // Column for Status

    private ObservableList<User> userList;

    // This method is called after the FXML is loaded
    @FXML
    public void initialize() {
        // Initialize table columns
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        columnRole.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        columnStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Sample data to display in the table
        userList = FXCollections.observableArrayList(
            new User("John Doe", "john@example.com", "Admin", "Active"),
            new User("Jane Smith", "jane@example.com", "User", "Inactive")
        );

        // Set data to table
        userTable.setItems(userList);
    }

    // Handle "Add New User" button click
    @FXML
    public void handleAddUser(MouseEvent event) {
        System.out.println("Add New User Button Clicked");
        // Implement your logic for adding a new user here
    }
}
