package podliczto;

import java.sql.SQLException;

/**
 *
 * @author Konrad
 */
public class CalculateData  {
    
    DBData calculations;
    int tab[];
    int counted=0;
    
    public int[] sumaryPersonValues(String[] persons) throws SQLException{
        tab = new int[persons.length];
        for(int i=0;i<=persons.length-1;i++){
            calculations=new DBData("SELECT SUM(value) as 'summary' FROM Receipt r, Person p WHERE r.personID = p.idPerson AND p.nickname =\""+persons[i]+"\"");
            counted = calculations.getPersonCount();
            tab[i]=counted;
            counted =0;
        }
        return tab;
    }
    
}
