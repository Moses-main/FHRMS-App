# Restaurant Management System

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [System Architecture](#system-architecture)
- [Use Cases](#use-cases)
- [Setup & Installation](#setup--installation)
- [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

The **Restaurant Management System** is a complete solution designed to streamline the management of a restaurant's operations. It covers core functionalities such as **order management**, **inventory management**, and **role-based access** for **Admin**, **Waiters**, and **Chefs**.

This application is built to improve workflow and efficiency, enabling restaurant staff to quickly create, manage, and track food orders while ensuring the kitchen stays updated with stock levels. It also provides detailed **reporting** capabilities for restaurant management.

---

## Features

- **Admin Features**:

  - Manage Users (Create, Edit, Delete)
  - Manage Inventory (Add, Update, Delete Items)
  - Generate Reports (Sales, Inventory Usage)

- **Waiter Features**:

  - Create and Track Food Orders
  - Update Order Status
  - View Pending Orders

- **Chef Features**:

  - View Food Orders
  - Update Order Status (Ready/Completed)
  - View Inventory Levels

- **Inventory Management**:

  - Monitor Inventory Stock
  - Update Stock Levels

- **Reporting**:
  - Sales Reports
  - Inventory Usage Reports

---

## Technologies Used

- **JavaFX**: Used for building the user interface with FXML.
- **MySQL**: For the database management system.
- **JDBC**: Java Database Connectivity for interaction with MySQL database.
- **Maven**: For project build and dependency management.
- **FXML**: To design the layout and structure of the application.
- **CSS**: For styling the UI components.

---

## System Architecture

The system follows a **multi-tier architecture**, where each component is responsible for a specific function:

- **Presentation Layer**:
  - JavaFX FXML views and controllers (Admin, Waiter, Chef interfaces).
- **Business Logic Layer**:
  - Java classes handle the core functionality, such as food order creation, inventory management, and report generation.
- **Data Layer**:
  - MySQL database for storing user data, orders, inventory, and reports.

---

## Use Cases

1. **Admin Use Case**:

   - Admin can **manage users**, **generate reports**, and **manage inventory**. They can also **view and track food orders**.

2. **Waiter Use Case**:

   - Waiters can **create food orders**, **track orders**, and **update order status** based on the kitchen's progress.

3. **Chef Use Case**:
   - Chefs can **view orders**, **update the status of food items**, and **update inventory** when ingredients are used.

---

## Setup & Installation

Follow these steps to set up and run the project locally:

### Prerequisites

- Java Development Kit (JDK) version 8 or higher
- MySQL Database (or another database you prefer)
- Maven

### Step-by-Step Guide

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/restaurant-management-system.git
   cd restaurant-management-system
   ```

2. **Set up the MySQL database:**

   Create a new database restaurant_db and configure the necessary tables. You can find the database schema in src/main/resources/db/schema.sql.

3. **CREATE DATABASE restaurant_db**;

USE restaurant_db;
-- Execute the schema script to create the required tables
SOURCE src/main/resources/db/schema.sql;

Configure the Database Connection:

Open the src/main/resources/db.properties file and set the MySQL connection properties.

db.url=jdbc:mysql://localhost:3306/restaurant_db
db.username=root
db.password=yourpassword

4. **Build the project using Maven:**

- Run the following command to compile the project:

`mvn clean install`

- Run the Application:

Use the following command to launch the JavaFX application:

`mvn javafx:run`

5. **Running the Application**

   - Login Screen:
     Upon startup, the system will display a login screen where users (Admins, Waiters, or Chefs) can authenticate based on their roles.

   - Role-Based Dashboard:
     After logging in, users will be redirected to their respective dashboards:

     - Admin Dashboard: For managing users, inventory, and generating reports.
       Use the input below for both the username and password
       `test@admin`

     - Waiter Dashboard: For creating and tracking food orders.
       `test@chef`

     - Chef Dashboard: For viewing and updating food orders.
       `test@waiter`

   - Navigating through the app:
     Admins can manage users, inventory, and generate reports.
     Waiters can create orders and track their status.
     Chefs can manage inventory usage and update the status of orders.

6. **Contributing**

We welcome contributions to improve the functionality of the Restaurant Management System. Here’s how you can contribute:

- Fork the repository: Click the "Fork" button at the top of the page.
  Create a new branch:

- git checkout -b feature-name

#### Make your changes and commit them:

- git commit -m "Added new feature"

### Push to the branch:

- git push origin feature-name

### Create a pull request from your forked repository.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
