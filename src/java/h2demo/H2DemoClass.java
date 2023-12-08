package h2demo;

import org.h2.tools.Console;

import java.sql.*;
import java.util.Scanner;

public class H2DemoClass {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // JDBC URL for H2 in-memory database
        String jdbcUrl = "jdbc:h2:mem:testdb";
        Console.main("-web", "-webAllowOthers", "-tcp", "-tcpAllowOthers", "-browser");
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             Statement statement = connection.createStatement()) {

            // Create a table
            statement.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY (id))");

            // Insert some data
            statement.execute("INSERT INTO users (name) VALUES ('Alice')");
            statement.execute("INSERT INTO users (name) VALUES ('Bob')");

            // Retrieve data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Scanner sc = new Scanner(System.in);
                System.out.println("ID: " + id + ", Name: " + name);

                String names = sc.next();
                System.out.println("Name"+name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
