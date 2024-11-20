
package org.example.fhrms.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private StringProperty name;
    private StringProperty email;
    private StringProperty role;
    private StringProperty status;

    public User(String name, String email, String role, String status) {
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.role = new SimpleStringProperty(role);
        this.status = new SimpleStringProperty(status);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty roleProperty() {
        return role;
    }

    public StringProperty statusProperty() {
        return status;
    }
}
