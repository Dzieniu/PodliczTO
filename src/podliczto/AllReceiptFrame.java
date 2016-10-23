/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podliczto;

import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Konrad
 */
public class AllReceiptFrame extends javax.swing.JFrame {

    
    public String receipts = "SELECT r.forWhat , r.value, p.Nickname FROM Receipt r, Person p WHERE r.personID = p.idPerson";
    
    DBData allReceipt;
    Persons persons = new Persons("SELECT Nickname FROM Person");
    String[] columnNames;
    AddNewReceipt newReceiptFrame;
    Time time = new Time();
    
    public AllReceiptFrame() throws SQLException {
        
        initComponents();
        setLocationRelativeTo(null);
        todayDate.setText(time.getToday());
        dateFrom.setText(time.firstDayOfCurrentWeek);
        dateTo.setText(time.lastDayOfCurrentWeek);
        setDataInTable(receipts);
        selectPersonComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(persons.getPersons()));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AllReceiptFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AllReceiptFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
    }
    
    public void setDataInTable(String url) throws SQLException{
        allReceipt= new DBData(url);
        columnNames = allReceipt.getColumnNames();
        Object[][] data = allReceipt.getTableData();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        
        allReceipt = null;
        
    }
    
    

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        selectPersonComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        todayDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateFrom = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateTo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(0, 0));
        jTable1.setName(""); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        selectPersonComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectPersonComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPersonComboBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Dodaj paragon");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Wybierz użytkownika");

        jLabel2.setText("Wszystkie paragony");

        jLabel3.setText("Dziś:");

        todayDate.setText("jLabel4");

        jLabel4.setText("Tydzień:");

        dateFrom.setText("jLabel5");

        jLabel6.setText("-");

        dateTo.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectPersonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(todayDate))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateFrom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateTo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectPersonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(todayDate))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFrom)
                    .addComponent(jLabel6)
                    .addComponent(dateTo))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectPersonComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPersonComboBoxActionPerformed
        String urls;
        try {
        
        Object selected = selectPersonComboBox.getSelectedItem();
        allReceipt = new DBData();
        if(selected==null){
            urls= "SELECT r.forWhat, r.value, p.Nickname FROM Receipt r, Person p WHERE r.personID = p.idPerson";
        }
        else{
            urls = "SELECT r.forWhat, r.value, p.Nickname FROM Receipt r, Person p WHERE r.personID = p.idPerson AND p.nickname =\""+selected.toString()+"\"";
        }
        
        
            setDataInTable(urls);
        } catch (SQLException ex) {
            Logger.getLogger(AllReceiptFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_selectPersonComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            newReceiptFrame = new AddNewReceipt();
        } catch (SQLException ex) {
            Logger.getLogger(AllReceiptFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        newReceiptFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
    
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            try {
            setDataInTable(receipts);
        } catch (SQLException ex) {
            Logger.getLogger(AllReceiptFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateFrom;
    private javax.swing.JLabel dateTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selectPersonComboBox;
    private javax.swing.JLabel todayDate;
    // End of variables declaration//GEN-END:variables
}
