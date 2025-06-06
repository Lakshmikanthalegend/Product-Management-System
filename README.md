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

# Easy JDBC Steps

Import Necessary Packages:

Import the required classes from the java.sql package to enable JDBC functionalities, such as Connection, DriverManager, Statement, PreparedStatement, and ResultSet.

Load Driver (using DriverManager):

Use Class.forName("com.mysql.cj.jdbc.Driver") to load the JDBC driver class, which allows the application to communicate with the MySQL database.

Register Driver:

The driver is registered automatically when it is loaded using DriverManager, enabling the application to establish connections to the database.

Create Connection:

Establish a connection to the database using DriverManager.getConnection(url, username, password), where url specifies the database location, and username and password are the credentials for accessing the database.

Create Statement:

Create a Statement or PreparedStatement object using the Connection object to execute SQL queries against the database.

Execute Statement:

Execute the SQL query using the executeQuery() method for SELECT statements or executeUpdate() for INSERT, UPDATE, or DELETE operations, which returns results or the number of affected rows.

Close:

Close the ResultSet, Statement, and Connection objects to free up database resources and prevent memory leaks, ensuring proper cleanup after database operations.
