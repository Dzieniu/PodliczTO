
package podliczto;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Konrad
 */
public class DBConnection {
    
        private final String url = "jdbc:mysql://localhost:3306/test";
        private final String username = "root";
        private final String password = "apteka13";
        Statement statement;
        ResultSet result;
        
    
    public Statement startConnection() throws SQLException{
        Connection connection = (Connection) DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
        statement = connection.createStatement();
        return statement;
    }
    
    public ResultSet getData(Statement statement, String query) throws SQLException{
        result = statement.executeQuery(query);
        return result;
    
    }
    
    public void closeConnection() throws SQLException{
        statement.close();
        result.close();
        System.out.println("connection Closed");
    
    }
    
}
