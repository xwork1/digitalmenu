package dbBaglantisi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MariaDBConnection extends ConnectDB {
    
    Connection c = null;
    
    @Override
    public Connection Connect() {
        try {
           Class.forName("org.mariadb.jdbc.Driver");
           c = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/dijitalmenu?user=root&password=123");
           return c;
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public void Disconnected() {
        c = null;
    }

}
