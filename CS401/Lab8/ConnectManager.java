import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManager {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mpp";
    private static final String USERNAME = "wetransport";
    private static final String PASSWORD = "Co92D1hbrlf7";
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME,
                PASSWORD);
        return conn;
    }
}
