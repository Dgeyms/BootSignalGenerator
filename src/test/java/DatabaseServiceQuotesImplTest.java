import org.boottrading.model.Token;
import org.boottrading.service.repository.DatabaseServiceQuotesImpl;
import org.boottrading.util.PostgreSQLConnection;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PostgreSQLConnection.class)
public class DatabaseServiceQuotesImplTest {
    @Test
    void saveClosePricesInDatabaseTest() {
        // Create mock-object Connection и PreparedStatement
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);

        // Create mock-object для вашего интерфейса Token
        Token token = mock(Token.class);
        when(token.getTime()).thenReturn("2023-11-01"); // Замените на реальные значения
        //when(token.getNameToken()).thenReturn("BTC"); // Замените на реальные значения
        when(token.getQuoteDataList()).thenReturn(new ArrayList<>(List.of(100.0, 101.0, 102.0))); // Замените на реальные значения

        // Создаем экземпляр вашего класса для тестирования
        DatabaseServiceQuotesImpl databaseService = new DatabaseServiceQuotesImpl();
        try {
            // Мокаем статический метод MySQLConnection.getConnection()
            mockStatic(PostgreSQLConnection.class);
            when(PostgreSQLConnection.getConnection()).thenReturn(connection);

            // Мокаем вызовы методов PreparedStatement
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

            // Вызываем метод, который мы тестируем
            databaseService.saveClosePricesInDatabase(token);

            // Проверяем, что методы были вызваны с ожидаемыми параметрами
            verify(preparedStatement, times(3)).setString(anyInt(), anyString());
            verify(preparedStatement, times(3)).setBigDecimal(anyInt(), any());

            // Здесь вы можете добавить дополнительные проверки по вашему усмотрению
        } catch (SQLException e) {
            // Обработка ошибок
            e.printStackTrace();
        }
    }

}
