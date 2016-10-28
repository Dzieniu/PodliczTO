package podliczto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public void saveMenuToFile(JTable jtable) throws IOException{
        
       
        PrintWriter os = new PrintWriter("menu.txt");
        int column = jtable.getModel().getColumnCount();
        int rows = jtable.getModel().getRowCount();
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < column; col++) {
                os.println(jtable.getValueAt(row, col));
            }
        }
        os.close();
    
    }
    public void loadMenu(JTable jtable) throws FileNotFoundException, IOException{
         BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
         int column = jtable.getModel().getColumnCount();
            int rows = jtable.getModel().getRowCount();
         String line = null;
         String list[] = new String[column*rows];
         int incr = 0;
         while ((line = br.readLine()) != null) {
             list[incr]=line;
             incr++;
         }
         incr = 0;
         for (int row = 0; row < rows; row++) {
            for (int col = 0; col < column; col++) {
                if(list[incr].equals("null")){
                jtable.setValueAt(null,row, col);
                }
                else{
                jtable.setValueAt(list[incr],row, col);
                }
                    
            incr++;
            }
            
        }
         
        
    }

    void cleanList(JTable jtable) {
       int column = jtable.getModel().getColumnCount();
       int rows = jtable.getModel().getRowCount();
       for (int row = 0; row < rows; row++) {
            for (int col = 0; col < column; col++) {
                jtable.setValueAt(null,row, col);
            }
            
        }
    }
    
}
