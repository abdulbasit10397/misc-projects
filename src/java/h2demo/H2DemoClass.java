package h2demo;

import org.h2.tools.Console;

import java.sql.*;

/**
 * A simple java code to use h2 database and view the tables in h2 console
 */
public class H2DemoClass {

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
                System.out.println("ID: " + id + ", Name: " + name);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
