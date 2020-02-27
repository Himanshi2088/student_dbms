
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
public class course_appld extends javax.swing.JFrame {

    /**
     * Creates new form course_appld
     */
    public course_appld() {
        initComponents();
         loaddata();
         stream();
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
            String qry="SELECT * FROM student_details WHERE sname LIKE '%"+txtsearch.getText()+"%'";
            res=stmt.executeQuery(qry);
            while(res.next())
            {
                row[0]=res.getInt("sid");
                row[1]=res.getString("sname");
                row[2]=res.getString("mobile");
                row[3]=res.getString("enrollno");
                model.addRow(row);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void stream()
    {
        try
        {
        Connection con;
         Statement stmt;
         String uid="root";
         String pwd="";
         
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
         stmt=con.createStatement();
            String qry="SELECT cid FROM course_mstr";
            ResultSet res= stmt.executeQuery(qry);
              txtcid.addItem("SELECT"); 
              while(res.next())
              {
                  txtcid.addItem(res.getString("cid"));
                  txtcid.getSelectedItem();  
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablerecords = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtsid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        txtsearch = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        txtcid = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtupdate = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setText("COURSE APPLIED");

        tablerecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sid", "Name", "Mobile", "Enrollno"
            }
        ));
        tablerecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablerecordsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablerecords);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Sid:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Search By:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Cid:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Date:");

        btnsave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("If You Want To Update :");

        txtupdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtupdate.setText("Update");
        txtupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtupdateActionPerformed(evt);
            }
        });

        btnclear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnclear.setText("CLEAR");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(btnsave)
                                .addGap(97, 97, 97)
                                .addComponent(btnclear)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(102, 102, 102)
                                        .addComponent(txtupdate))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addGap(53, 53, 53)
                                        .addComponent(txtsid, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(132, 132, 132)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtsid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsave)
                            .addComponent(btnclear)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtupdate))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablerecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablerecordsMouseClicked
        // TODO add your handling code here:
        int i=tablerecords.getSelectedRow();
        //JOptionPane.showMessageDialog(this,""++i,"Status",JOptionPane.INFORMATION_MESSAGE);
        TableModel model=tablerecords.getModel();
        txtsid.setText(model.getValueAt(i,0).toString());
    }//GEN-LAST:event_tablerecordsMouseClicked

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        try
        {
            String sid,cid,date;
            
            sid=txtsid.getText();
            cid=txtcid.getSelectedItem().toString();
            date=txtdate.getText();
            
            Connection con;
            Statement stmt;
            String uid="root";
            String pwd="";
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
            
            stmt=con.createStatement();
            String qry="INSERT INTO course_applied (sid,cid,date) VALUES ("+sid+","+cid+",'"+date+"')";
            
            //System.out.println(qry);
            stmt.executeUpdate(qry);
            JOptionPane.showMessageDialog(this,"Data Saved Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
              JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);      
        }
        if(txtdate.getText().length()==0)
        {
            JOptionPane.showMessageDialog(this,"Empty Text","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtupdateActionPerformed
        // TODO add your handling code here:
        crs_app_update p=new crs_app_update();
        p.setVisible(true);
    }//GEN-LAST:event_txtupdateActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtsid.setText("");
        txtcid.addItem("SELECT");
        txtdate.setText(""); 
        
    }//GEN-LAST:event_btnclearActionPerformed

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
            java.util.logging.Logger.getLogger(course_appld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(course_appld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(course_appld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(course_appld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new course_appld().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablerecords;
    private javax.swing.JComboBox<String> txtcid;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsid;
    private javax.swing.JButton txtupdate;
    // End of variables declaration//GEN-END:variables
}
