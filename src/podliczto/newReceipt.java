
package podliczto;

import java.sql.SQLException;

/**
 *
 * @author Konrad
 */
public class newReceipt extends Persons{
    
    DBConnection send = new DBConnection();
    String persons[] = new String[getRowCount()];
    DBData datas;
    
    public newReceipt(String queryURL) throws SQLException {
        super(queryURL);
    }
    
    public String[] getPersons() throws SQLException{
        int i=0;
        while(result.next()){
            
            persons[i]=result.getString("Nickname");
            i++;
        }
        return persons;
    }
    
    public void putNewReceipt(String forWhat, int howMany, int personID) throws SQLException{
        datas = new DBData("SELECT * FROM receipt");
        int rows = datas.getRowCount();
        String sends="INSERT INTO receipt VALUES ("+ (rows+1)+","+"\""+forWhat+"\""+","+howMany+","+personID+")";
        send.startConnection().executeUpdate(sends);
        datas= null;
    }
    
    
    
}
