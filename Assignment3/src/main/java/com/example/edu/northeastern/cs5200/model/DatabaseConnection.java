package com.example.edu.northeastern.cs5200.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String USER = System.getenv("master");
    private static final String PASSWORD = System.getenv("Mjj111111");
    private static final String SCHEMA = System.getenv("test ");
    private static final String DB_HOSTNAME = System.getenv("cs5200-jinjingmiao-fall2019.c6zuuyi0sch9.us-east-2.rds.amazonaws.com:3306");

    private static final String URL = String.format("jdbc:mysql://%s/%s", DB_HOSTNAME, SCHEMA);


    private DatabaseConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}


