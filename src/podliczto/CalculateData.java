package podliczto;

import java.sql.SQLException;

/**
 *
 * @author Konrad
 */
public class CalculateData  {
    
    DBData calculations;
    int tab[];
    
    public int[] sumaryPersonValues(String[] persons) throws SQLException{
        tab = new int[persons.length];
        for(int i=0;i<=persons.length-1;i++){
        calculations=new DBData("SELECT COUNT(r.value) FROM Receipt r, Person p WHERE r.personID = p.idPerson AND p.nickname =\""+persons[i]+"\"");
        int counted = calculations.getPersonCount();
        tab[i]=counted;
        calculations = null;
        }
        return tab;
    }
    
}
