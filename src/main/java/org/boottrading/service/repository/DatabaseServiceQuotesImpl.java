package org.boottrading.service.repository;

import org.boottrading.model.Token;
import org.boottrading.util.PostgreSQLConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class implementing the interface DatabaseServiceQuotes
 * Quote service
 * Blings quotes from the exchange (using the API Exchange).
 * Saves quotes in the database
 */
public class DatabaseServiceQuotesImpl implements DatabaseServiceQuotes {
    // Единственный экземпляр класса
    private static DatabaseServiceQuotesImpl instance;

    // Приватный конструктор, чтобы предотвратить создание дополнительных экземпляров
    public DatabaseServiceQuotesImpl() {
        // Инициализация
    }

    // Метод для получения экземпляра класса
    public static synchronized DatabaseServiceQuotesImpl getInstance() {
        if (instance == null) {
            instance = new DatabaseServiceQuotesImpl();
        }
        return instance;
    }

    // method save closing prices in database Quotes
    public void saveClosePricesInDatabase(Token token) {
        String insertQuery = "INSERT INTO crypto_quotes (close_price, name_token) VALUES (?, ?)";

        try (Connection connection = PostgreSQLConnection.getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

             for (int i = 0; i < token.getQuoteDataList().size(); i++) {
                 preparedStatement.setBigDecimal(1, BigDecimal.valueOf(token.getQuoteDataList().get(i)));
                 preparedStatement.setString(2, token.getNameToken()); //symbol token
                 //preparedStatement.setString(1, token.getTime());

                    int affectedRows = preparedStatement.executeUpdate();
                    if(affectedRows > 0){
                        System.out.println("Запись в базу данных прошла успешно");
                    }else{
                        System.out.println("Данные НЕ записались в базу данных");

                    }
             }
        } catch (SQLException e) {
            System.out.println("Error SQL " + e.getMessage());
            e.printStackTrace();
        }
    }
}
