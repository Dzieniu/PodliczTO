
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
public class Main {
    public static void main(String[] args) throws SQLException {
        
        String queryURL = "SELECT * FROM osoba";
        
        DBConnection connection = new DBConnection();
        ResultSet result = connection.getData(connection.startConnection(), queryURL);
 
        while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("imie");
                System.out.println(id+ " " + name);
            }
        
        
    
    }
}
