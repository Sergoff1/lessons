package SD_First.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStorage implements Storage {

    private Connection connection;

    public DatabaseStorage() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            createTableIfNotExist();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(String data) {
        String query = "INSERT INTO storage(data) VALUES(?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String retrieve(int id) {
        String query = "SELECT data FROM storage WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createTableIfNotExist() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS storage (id SERIAL PRIMARY KEY, data TEXT)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
}
