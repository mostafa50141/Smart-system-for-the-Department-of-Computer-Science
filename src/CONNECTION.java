import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CONNECTION {
    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=Project_CS";
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }
}
