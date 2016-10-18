
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
        
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "apteka13";
        String name = "";
        
        Connection connection = (Connection) DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
        
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM osoba");
        
        if(rs.next()) {  
            name = rs.getString("imie");
        }
        System.out.println(name);
    
    }
}
