package ru.lkodos.industrial_safety.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionMnager {

    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASS = "db.pass";
    private static final String DRIVER = "db.driver";

    static {
        loadDriver();
    }

    private ConnectionMnager() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.getProperty(URL),
                    PropertiesUtil.getProperty(USER),
                    PropertiesUtil.getProperty(PASS)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver() {
        try {
            Class.forName(PropertiesUtil.getProperty(DRIVER));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}