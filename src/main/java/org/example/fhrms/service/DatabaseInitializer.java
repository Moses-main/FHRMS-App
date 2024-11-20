package org.example.fhrms.service;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {

            // Create tables
            String createUsersTable = """
                    CREATE TABLE IF NOT EXISTS users (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(100) NOT NULL,
                        role VARCHAR(20) NOT NULL
                    );
                    """;

            String createInventoryTable = """
                    CREATE TABLE IF NOT EXISTS inventory (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        quantity INT NOT NULL,
                        price DECIMAL(10, 2) NOT NULL
                    );
                    """;

            statement.execute(createUsersTable);
            statement.execute(createInventoryTable);

            System.out.println("Database initialized successfully!");

        } catch (Exception e) {
            System.err.println("Database initialization failed: " + e.getMessage());
        }
    }
}

