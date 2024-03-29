
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Himanshi
 */
public class crs_app_update extends javax.swing.JFrame {

    /**
     * Creates new form crs_app_update
     */
    public crs_app_update() {
        initComponents();
        loaddata();
    }
     public void loaddata()
    {
        DefaultTableModel model=(DefaultTableModel)tablerecords.getModel();
        tablerecords.setModel(model);
        model.setRowCount(0);
        Object row[]=new Object[4];
        try
        {
            Connection con;
            Statement stmt;
            ResultSet res;
            String uid="root";
            String pwd="";
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
            
            stmt=con.createStatement();  
            String qry="SELECT * FROM course_applied WHERE sid LIKE '%"+txtsearch.getText()+"%'";
            res=stmt.executeQuery(qry);
            while(res.next())
            {
                row[0]=res.getInt("rid");
                row[1]=res.getInt("sid");
                row[2]=res.getInt("cid");
                row[3]=res.getString("date");
                model.addRow(row);
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablerecords = new javax.swing.JTable();
        txtsid = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        txtcid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtrid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("COURSE APPLIED UPDATE");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Search By:");

        tablerecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rid", "Sid", "Cid", "Date"
            }
        ));
        tablerecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablerecordsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablerecords);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setText("Cid:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Sid:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setText("Date:");

        btndelete.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btndelete.setForeground(new java.awt.Color(0, 0, 204));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(0, 51, 153));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setText("Rid:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtrid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndelete)
                            .addComponent(btnupdate)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        int result=JOptionPane.showConfirmDialog(this,"Are You Sure??","Confirmation",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
           try
        {
            String date;
            int rid,sid,cid;
            
            rid=Integer.parseInt(txtrid.getText());
            sid=Integer.parseInt(txtsid.getText());
            cid=Integer.parseInt(txtcid.getText());
            date=txtdate.getText();
            
            
            Connection con;
            Statement stmt;
            String uid="root";
            String pwd="";
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
            String qry="UPDATE course_applied SET sid="+sid+",cid="+cid+",date='"+date+"'WHERE rid="+Integer.parseInt(txtrid.getText());
            stmt=con.createStatement();
            stmt.executeUpdate(qry);
            loaddata();
            JOptionPane.showMessageDialog(this,"Data Saved Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
            
        }
           catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        txtrid.setText("");
        txtsid.setText("");
        txtcid.setText("");
        txtdate.setText("");
    }//GEN-LAST:event_btnupdateActionPerformed
    }
    
    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int result=JOptionPane.showConfirmDialog(this,"Are You Sure??","Confirmation",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
        try
        {
         Connection con;
         Statement stmt;
         String uid="root";
         String pwd="";
         
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
         stmt=con.createStatement();
         String qry="DELETE FROM course_applied WHERE rid="+Integer.parseInt(txtrid.getText());
         
        stmt.executeUpdate(qry);
        loaddata();
        JOptionPane.showMessageDialog(this,"Data Saved Successfully","Status",JOptionPane.INFORMATION_MESSAGE); 
        } 
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        txtrid.setText("");
        txtsid.setText("");
        txtcid.setText("");
        txtdate.setText("");
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tablerecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablerecordsMouseClicked
        // TODO add your handling code here:
        int i=tablerecords.getSelectedRow();
        //JOptionPane.showMessageDialog(this,""++i,"Status",JOptionPane.INFORMATION_MESSAGE);
        TableModel model=tablerecords.getModel();
        txtrid.setText(model.getValueAt(i,0).toString());
        txtsid.setText(model.getValueAt(i,1).toString());
        txtcid.setText(model.getValueAt(i,2).toString());
        txtdate.setText(model.getValueAt(i,3).toString());
    }//GEN-LAST:event_tablerecordsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crs_app_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crs_app_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crs_app_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crs_app_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crs_app_update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablerecords;
    private javax.swing.JTextField txtcid;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtrid;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsid;
    // End of variables declaration//GEN-END:variables
}
