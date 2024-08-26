// src/DatabaseHelper.java
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final String URL = "jdbc:postgresql://localhost:5432/javafxtodolist";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    // Load PostgreSQL JDBC driver
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createUser(String username, String password) {
        // Hash the password before storing it in a real application
        try (Connection conn = connect()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (var stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password); // Hash the password in a real application
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


