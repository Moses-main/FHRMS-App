package org.example.fhrms.uicontroller.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.fhrms.model.FoodItem;
import org.example.fhrms.model2.User;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

public class UserDashboardController {

    @FXML
    private Label displayUsername;

    @FXML
    private TableView<FoodItem> foodTable;

    @FXML
    private TableColumn<FoodItem, String> foodNameColumn;

    @FXML
    private TableColumn<FoodItem, Double> priceColumn;

    @FXML
    private TableColumn<FoodItem, Integer> quantityColumn;

    @FXML
    private ComboBox<String> foodComboBox;

    @FXML
    private Spinner<Integer> quantitySpinner;

    private final ObservableList<FoodItem> foodItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        User user=AuthService.getAuthService().getAuthenticatedUser();
        displayUsername.setText(
                "Welcome , "+user==null ? "User" : user.username()
        );

        foodNameColumn.setCellValueFactory(data -> data.getValue().foodNameProperty());
        priceColumn.setCellValueFactory(data -> data.getValue().priceProperty().asObject());
        foodItems.addAll(
                new FoodItem("Burger", 5.99, 10),
                new FoodItem("Pizza", 8.99, 5),
                new FoodItem("Pasta", 6.49, 7)
        );
        foodTable.setItems(foodItems);
        for (FoodItem foodItem : foodItems) {
            foodComboBox.getItems().add(foodItem.getFoodName());
        }
        quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
    }

    @FXML
    public void handlePlaceOrder() {
        String selectedFood = foodComboBox.getValue();
        int selectedQuantity = quantitySpinner.getValue();

        if (selectedFood == null) {
            showAlert(Alert.AlertType.ERROR, "Please select a food item to order.");
            return;
        }

        FoodItem foodItem = foodItems.stream()
                .filter(item -> item.getFoodName().equals(selectedFood))
                .findFirst()
                .orElse(null);

        if (foodItem == null || foodItem.getQuantity() < selectedQuantity) {
            showAlert(Alert.AlertType.ERROR, "Insufficient quantity available for " + selectedFood + ".");
            return;
        }

        // Update food quantity
        foodItem.setQuantity(foodItem.getQuantity() - selectedQuantity);
        foodTable.refresh();

        showAlert(Alert.AlertType.INFORMATION, "Order placed successfully for " + selectedFood + " (" + selectedQuantity + ").");
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    protected void hangleLogout(){
        AuthService.logoutUser();
        if(!AuthService.getAuthService().isUserAuthenticated()) goToLogin();
    }
    private void goToLogin() {
        Stage stage = (Stage) foodTable.getScene().getWindow();
        Navigation.navigateTo("login",stage);
    }
}
