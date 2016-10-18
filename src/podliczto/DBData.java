
package podliczto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Konrad
 */
public class DBData {
    
    //TODO : Make it more clear.
            
    
    DBConnection connection = new DBConnection();
    String queryURL = "SELECT * FROM osoba";
    ResultSet result;

    public DBData() throws SQLException {
        this.result = connection.getData(connection.startConnection(), queryURL);
    }
    
    public void selectAll() throws SQLException{
    while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("imie");
                System.out.println(id+ " " + name);
            }
    }
    
}
