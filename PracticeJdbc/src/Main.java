import java.math.BigDecimal;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/practicejdbc";
        // Database credentials
        String username = "root"; // Replace with your MySQL username
        String password = "Mysql@145"; // Replace with your MySQL password

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement()) {

            // Create product table
            String createTable = "CREATE TABLE IF NOT EXISTS products (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50)," +
                    "price DECIMAL(10, 2))";

            st.executeUpdate(createTable); // Do not return data
            System.out.println("The Product table is created");

            // Clear existing data before inserting new products
            String deleteSQL = "DELETE FROM products";
            st.executeUpdate(deleteSQL);
            System.out.println("All existing products have been deleted from the table.");

            // Reset the auto-increment value
            String resetAutoIncrementSQL = "ALTER TABLE products AUTO_INCREMENT = 1";
            st.executeUpdate(resetAutoIncrementSQL);
            System.out.println("Auto-increment value reset to 1.");

            // Insert data into the table
            String insertTable = "INSERT INTO products (name, price) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(insertTable)) {
                preparedStatement.setString(1, "Product A");
                preparedStatement.setBigDecimal(2, new BigDecimal("10.99"));
                preparedStatement.executeUpdate();
                System.out.println("Product A inserted successfully");

                preparedStatement.setString(1, "Product B");
                preparedStatement.setBigDecimal(2, new BigDecimal("20.49"));
                preparedStatement.executeUpdate();
                System.out.println("Product B inserted successfully");

                preparedStatement.setString(1, "Product C");
                preparedStatement.setBigDecimal(2, new BigDecimal("15.75"));
                preparedStatement.executeUpdate();
                System.out.println("Product C inserted successfully");

            } catch (SQLException e) {
                System.out.println("Error inserting products: " + e.getMessage());
            }

            // Update the price of Product A
            String updatePriceSQL = "UPDATE products SET price = ? WHERE name = ?";
            try (PreparedStatement updateStatement = con.prepareStatement(updatePriceSQL)) {
                updateStatement.setBigDecimal(1, new BigDecimal("12.99")); // New price
                updateStatement.setString(2, "Product A"); // Product to update
                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Product A price updated successfully.");
                } else {
                    System.out.println("Product A not found for update.");
                }
            } catch (SQLException e) {
                System.out.println("Error updating product price: " + e.getMessage());
            }

            // Display all products
            String selectSQL = "SELECT * FROM products";
            try (ResultSet rs = st.executeQuery(selectSQL)) {
                System.out.println("Products in the database:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    BigDecimal price = rs.getBigDecimal("price");
                    System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving products: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
