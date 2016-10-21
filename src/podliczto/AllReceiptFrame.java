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

    
    public String receipts = "SELECT r.forWhat, r.value, p.Nickname FROM Receipt r, Person p WHERE r.personID = p.idPerson";
    
    DBData allReceipt = new DBData(receipts);
    Persons persons = new Persons("SELECT Nickname FROM Person");
    String[] columnNames;
    
    public AllReceiptFrame() throws SQLException {
        initComponents();
        setDataInTable();
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
    
    public void setDataInTable() throws SQLException{
        columnNames = allReceipt.getColumnNames();
        Object[][] data = allReceipt.getTableData();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        selectPersonComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(persons.getPersons()));
        
    }
    
    

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        selectPersonComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(jTable1);

        selectPersonComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectPersonComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPersonComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectPersonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(selectPersonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectPersonComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPersonComboBoxActionPerformed
        JComboBox selectPersonComboBox = (JComboBox) evt.getSource();
        Object selected = selectPersonComboBox.getSelectedItem();
        allReceipt.queryURL = "SELECT r.forWhat, r.value, p.Nickname FROM Receipt r, Person p WHERE r.personID = p.idPerson AND p.nickname =\""+selected.toString()+"\"";
        //jLabel1.setText(allReceipt.queryURL);
        
    }//GEN-LAST:event_selectPersonComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selectPersonComboBox;
    // End of variables declaration//GEN-END:variables
}
