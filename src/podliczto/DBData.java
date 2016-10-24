
package podliczto;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Konrad
 */
public class DBData {
    DBConnection connection = new DBConnection();
    String queryURL;
    ResultSet result;
    ResultSetMetaData rsmd;
    int rowCount=0;
    int count;
    
    public DBData(){
    }

    public DBData(String queryURL) throws SQLException {  
        this.queryURL = queryURL;
        this.result = connection.getData(connection.startConnection(), queryURL);
       
    }
    public String[] getColumnNames() throws SQLException{
        rsmd = result.getMetaData();
        String table[] = new String[rsmd.getColumnCount()];
        
        for (int i=1;i<=rsmd.getColumnCount();i++){
            table[i-1]=rsmd.getColumnName(i);
        }
        return table;
    }
    
    public Object[][] getTableData() throws SQLException{
            Object x[][] = new Object[getRowCount()][rsmd.getColumnCount()];
            int i=0;
          
           
         while (result.next()) {
             
            for(int j = 0;j<=rsmd.getColumnCount()-1;j++){ 
                x[i][j]=result.getString(j+1);
            }
            i++;
         }
         return x;
    }
    
    public int getRowCount() throws SQLException{
        result.last();
        rowCount = result.getRow();
        result.beforeFirst();
        return rowCount;
    }
    
    public int getPersonCount() throws SQLException{
        while (result.next()){
           count = result.getInt("summary");
        }
        return count;
    }
    
}
    
    
    

