package org.boottrading.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.boottrading.util.PostgresJdbcConnection;

public class BootRepositoryImpl implements BootRepository {

    public void saveBootDataBase(String nameBoot) {
        try (Connection connection = DriverManager.getConnection(PostgresJdbcConnection.DB_URL,
                PostgresJdbcConnection.USER, PostgresJdbcConnection.PASS)) {
            Class.forName("org.postgresql.Driver");

            String sql = "INSERT INTO boots (name_boot) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, nameBoot);
                ps.executeUpdate();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось загрузить драйвер JDBC PostgreSQL");
            e.printStackTrace();
            return;
        } catch (SQLException e) {
            System.out.println("Ошибка SQL!");
            e.printStackTrace();
        }

    }

}
