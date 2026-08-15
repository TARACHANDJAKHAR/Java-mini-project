package com.university.management;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static Dotenv dotenv;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            // Load environment variables from .env file
            dotenv = Dotenv.load();
            url = dotenv.get("DB_URL", "jdbc:mysql://localhost:3306/assignment8");
            user = dotenv.get("DB_USERNAME", "root");
            password = dotenv.get("DB_PASSWORD", "");
            
            // Explicitly load the MySQL driver class to ensure it's available
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Failed to initialize database configuration: " + e.getMessage());
        }
    }

    /**
     * Gets a connection to the database.
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
