/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podliczto;

import java.sql.SQLException;

/**
 *
 * @author Konrad
 */
public class Persons extends DBData {
    
    String persons[] = new String[getRowCount()+1];
    
    public Persons(String queryURL) throws SQLException {
        super(queryURL);
    }
    
    public String[] getPersons() throws SQLException{
        int i=0;
        while(result.next()){
            
            persons[i+1]=result.getString("Nickname");
            i++;
        }
        return persons;
    }
    
}
