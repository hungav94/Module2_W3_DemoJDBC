import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException{
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/demo";
        String dbUserName = "root";
        String dbPassword = "123456";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL, dbUserName,dbPassword);
        return con;
    }
}
