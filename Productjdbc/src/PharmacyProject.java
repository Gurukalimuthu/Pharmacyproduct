import java.sql.*;
import java.util.Scanner;

public class PharmacyProject {

    static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/kali";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            // Create tables if they don't exist
            String createMedicationTable = "CREATE TABLE IF NOT EXISTS medications (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "quantity INT)";
            statement.executeUpdate(createMedicationTable);

            String createCustomerTable = "CREATE TABLE IF NOT EXISTS customers (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "phone VARCHAR(20))";
            statement.executeUpdate(createCustomerTable);

            // Insert sample data
            String insertMedicationData = "INSERT INTO medications (name, quantity) VALUES " +
                    "('curosin', 100), " +
                    "('cloudact', 50)";
            statement.executeUpdate(insertMedicationData);

            String insertCustomerData = "INSERT INTO customers (name, phone) VALUES " +
                    "('mani', '5945-875-857'), " +
                    "('kannan', '6847-486-846')";
            statement.executeUpdate(insertCustomerData);

            // Retrieve and display medications
            ResultSet medicationResultSet = statement.executeQuery("SELECT * FROM medications");
            while (medicationResultSet.next()) {
                int id = medicationResultSet.getInt("id");
                String name = medicationResultSet.getString("name");
                int quantity = medicationResultSet.getInt("quantity");
                System.out.println("Medication ID: " + id + ", Name: " + name + ", Quantity: " + quantity);
            }

            // Retrieve and display customers
            ResultSet customerResultSet = statement.executeQuery("SELECT * FROM customers");
            while (customerResultSet.next()) {
                int id = customerResultSet.getInt("id");
                String name = customerResultSet.getString("name");
                String phone = customerResultSet.getString("phone");
                System.out.println("Customer ID: " + id + ", Name: " + name + ", Phone: " + phone);
            }

            // Clean up resources
            medicationResultSet.close();
            customerResultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}