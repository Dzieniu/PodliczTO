package podliczto;

import javax.swing.JTable;

/**
 *
 * @author Konrad
 *        System.out.print(jTable1.getModel().getValueAt(0, 0));
 */
public class Menu {
    
    Time time = new Time();
    
    
    public void Menu(){
        
    }
    
    public String[] getDays(){

        return time.dayInWeek;
    }
    
    public void saveMenu(JTable jtable){
        int column = jtable.getModel().getColumnCount();
        int rows = jtable.getModel().getRowCount();
        
        for(int i=0;i<=rows-1;i++){
            for(int j =0;j<=column-1;j++){
            System.out.print(jtable.getModel().getValueAt(i,j)+" ");
            }
            System.out.println("");
        }
    }
}
