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
                os.print(jtable.getValueAt(row, col)+" ");
            }
        os.println("");
        }
        os.close();
    
    }
    public void loadMenu(JTable jtable) throws FileNotFoundException, IOException{
        DefaultTableModel mod = (DefaultTableModel) jtable.getModel();
        BufferedReader bfw = new BufferedReader(new FileReader("menu.txt"));
        for (int i = 0 ; i < jtable.getRowCount(); i++){
                mod.addRow( bfw.readLine().split(" ") );
        }
        bfw.close();
        
        
    }
    
}
