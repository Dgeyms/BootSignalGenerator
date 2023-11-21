package org.boottrading.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5433/TradingBotDatabase";
        String user = "postgres";
        String password = "";

        try {
            // Загрузка драйвера JDBC
            Class.forName("org.postgresql.Driver");

            // Установление соединения
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Соединение с базой данных успешно установлено!");
                return connection;
            } else {
                System.out.println("Не удалось установить соединение с базой данных.");
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
