package org.boottrading.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.boottrading.util.PostgresJdbcConnection;

public class BootRepositoryImpl implements BootRepository {

    public void saveBootDataBase(String nameBoot) {
        try (Connection connection = DriverManager.getConnection(PostgresJdbcConnection.DB_URL,
            PostgresJdbcConnection.USER, PostgresJdbcConnection.PASS);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO boots (name_boot) VALUES (?)")) {

            ps.setString(1, nameBoot);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Ошибка SQL!");
            e.printStackTrace();
        }
    }
}
feat(product): create method saveBootDataBase in class BootRepositoryImpl