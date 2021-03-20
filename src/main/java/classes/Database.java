package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class made to hold database properties and to create connections easy.
 * The database properties, password, url etc can be changed without effect any other
 * class that relies on this class to create connections.
 * @author jonas
 */
public class Database {

    private static String dbURL = "jdbc:derby://localhost:1527/AntonsSkafferi";
    private static String user = "anton";
    private static String pw = "anton";

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL, user, pw);
    }

}
