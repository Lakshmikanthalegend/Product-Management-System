# Product-Management-System
This project is a simple Java-based application that manages a products database using JDBC (Java Database Connectivity). The application demonstrates fundamental database operations such as creating tables, inserting records, updating records, and retrieving data.
Features
Database Connectivity: Connects to a MySQL database to perform CRUD (Create, Read, Update, Delete) operations.

Table Creation: Creates a products table if it does not already exist, with fields for ID, name, and price.

Data Insertion: Inserts multiple products into the database.

Data Deletion: Deletes all existing records from the products table before inserting new data.

Auto-Increment Reset: Resets the auto-increment value of the ID field to start from 1 after deletion.

Data Update: Updates the price of a specific product in the database.

Data Retrieval: Retrieves and displays all products currently in the database.

# Technologies Used

Java: Programming language used to implement the application logic.

JDBC: Java Database Connectivity for interacting with the MySQL database.

MySQL: Database management system used to store product data.

# Code Overview

Database Connection: Establishes a connection to the MySQL database using JDBC.

Table Management: Creates the products table with fields for ID, name, and price.

# Data Manipulation:

Deletes all existing records from the products table.

Resets the auto-increment value for the product ID.

Inserts three products into the table.

Updates the price of "Product A".

Data Display: Retrieves and prints all products in the database to the console.
