package main.java.com.kostr.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final String PROPERTIES_FILE = "app.properties";
    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnection.class) {
                if (connection == null) {
                    try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
                        if (input == null) {
                            throw new RuntimeException("Unable to find " + PROPERTIES_FILE + " file.");
                        }
                        Properties properties = new Properties();
                        properties.load(input);

                        String driver = properties.getProperty("driver");
                        String url = properties.getProperty("url");
                        String username = properties.getProperty("username");
                        String password = properties.getProperty("password");

                        Class.forName(driver);

                        connection = DriverManager.getConnection(url, username, password);
                    } catch (IOException | ClassNotFoundException | SQLException e) {
                        throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
                    }
                }
            }
        }
        return connection;
    }
}
