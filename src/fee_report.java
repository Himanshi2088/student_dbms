
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANISH JAIN
 */
public class fee_report extends javax.swing.JFrame {

    /**
     * Creates new form fee_report
     */
    int courseid,studentid;
    ResultSet res,res1,res2,res3;
    public fee_report() {
        initComponents();
       
    }
    public void loaddata()
    {
        DefaultTableModel model=(DefaultTableModel)report_record.getModel();
        report_record.setModel(model);
        model.setRowCount(0);
        Object row[]=new Object[6];
                try
                {
                    Connection con,con1,con2,con3;
                    Statement stmt,stmt1,stmt2,stmt3;
                    String uid="root";

                    String pwd="";
                    
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
                    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
                    con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
                    con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
             
                    stmt=con.createStatement();
                    stmt1=con1.createStatement();
                    stmt2=con2.createStatement();
                    stmt3=con3.createStatement();
                                  
                    String qry="SELECT sname,sid FROM student_details";
                    res=stmt.executeQuery(qry);
                    
                    while(res.next())
                    {
                        studentid=res.getInt("sid");
                    String qry1="SELECT cid FROM course_applied WHERE sid="+res.getInt("sid"); 
                    res1=stmt1.executeQuery(qry1);
                     while(res1.next())
                     {
                         courseid=res1.getInt("cid");
                         String qry2="SELECT crs_fee,crs_name FROM course_mstr WHERE cid="+res1.getInt("cid");
                    res2=stmt2.executeQuery(qry2);
                           while(res2.next())
                           {
                              int actual=res2.getInt("crs_fee");
                               String qry3="SELECT date_of_receive AS DR,SUM(fee_received) AS FR FROM fee_details WHERE sid="+studentid+" AND cid="+courseid;
                               
                    res3=stmt3.executeQuery(qry3);
                               
                             if(res3.next())
                                  {
                                      
                                      int balance=actual-res3.getInt("FR");
                                       row[0]=res.getString("sname");
                                       row[1]=res.getString("sid");
                                       row[2]=res2.getString("crs_name");
                                       row[3]=res2.getString("crs_fee");
                                       row[4]=res3.getString("FR");
                                      // row[5]=res3.getString("DR");
                                    row[5]=(Object)balance;
                                       model.addRow(row);
                         
                                  }
                           
                     
                                 
                             
             
if(txtname_search.getText().length()>0 && txtcourse_search.getText().length()>0 && (txtdate_search.getText().length()>0 && txtdate1_search.getText().length()>0))
{

qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid AND sname LIKE '%"+txtname_search.getText()+"%' AND crs_name = "+txtcourse_search.getText()+" AND date >="+txtdate_search.getText()+" AND date <="+txtdate1_search.getText();
}
else if(txtname_search.getText().length()==0 &&txtcourse_search.getText().length()>0 &&(txtdate_search.getText().length()>0 && txtdate1_search.getText().length()>0))
{
qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid AND crs_name = "+txtcourse_search.getText()+" AND date >="+txtdate_search.getText()+" AND date <="+txtdate1_search.getText();            
}
else if(txtname_search.getText().length()>0 &&txtcourse_search.getText().length()==0 &&(txtdate_search.getText().length()>0 && txtdate1_search.getText().length()>0))
{
qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid AND sname LIKE '%"+txtname_search.getText()+"%' AND date >="+txtdate_search.getText()+" AND date <="+txtdate1_search.getText();            
}
else  if(txtname_search.getText().length()>0 &&txtcourse_search.getText().length()>0 &&(txtdate_search.getText().length()==0 && txtdate_search.getText().length()==0))
{
qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid AND sname LIKE '%"+txtname_search.getText()+"%' AND crs_name = "+txtcourse_search.getText()+"";            
}
else if(txtname_search.getText().length()>0 &&txtcourse_search.getText().length()==0&&(txtdate_search.getText().length()==0 && txtdate1_search.getText().length()==0))
{
qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid AND sname LIKE '%"+txtname_search.getText()+"%' ";                        
}
else if(txtname_search.getText().length()==0 &&txtcourse_search.getText().length()==0 &&(txtdate_search.getText().length()>0 && txtdate1_search.getText().length()>0))
{
qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid AND AND date >="+txtdate_search.getText()+" AND date <="+txtdate1_search.getText();            
                                 
}
else if(txtname_search.getText().length()==0 &&txtcourse_search.getText().length()>0 &&(txtdate_search.getText().length()==0 && txtdate1_search.getText().length()==0))
{
qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid AND course_mstr.crs_name = "+txtcourse_search.getText()+"";            
                                 
}
else
{
qry="SELECT fee_details.sid,fee_details.sname,fee_details.fee_received,course_mstr.crs_name,course_mstr.crs_fee FROM fee_details,course_mstr WHERE fee_details.cid=course_mstr.cid ";            
}
}
                     }
                    }

// System.out.println("SELECT student_details.sid,student_details.sname,course_applied.cid,student_details.mobile FROM student_details,course_applied WHERE student_details.sid=course_applied.sid , txtname_search LIKE '%"+txtname_search.getText()+"%' && txtsid_search LIKE %"+txtsid_search.getText()+"% && txtmobile_search LIKE '%"+txtmobile_search.getText()+"%'");

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        report_record = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcourse_search = new javax.swing.JTextField();
        txtdate_search = new javax.swing.JTextField();
        txtname_search = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdate1_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("FEE REPORT");

        report_record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "sname", "sid", "crs_name", "crs_fee", "fee_received", "balance_amt"
            }
        ));
        report_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_recordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(report_record);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel2.setText("Search Type:");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel3.setText("Course Name:");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel4.setText("Date:");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel5.setText("Name:");

        btnsearch.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnsearch.setText("SEARCH");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        jLabel6.setText("From");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        jLabel7.setText("to");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtname_search, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcourse_search, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsearch)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtdate_search, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdate1_search, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(436, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(421, 421, 421))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcourse_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtname_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdate_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtdate1_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnsearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model=(DefaultTableModel)report_record.getModel();
        report_record.setModel(model);
        //
       model.setRowCount(0);
        Object row[]=new Object[6];
                try
                {
                    Connection con;
                    Statement stmt;
                    
                    String uid="root";
                    String pwd="";
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",uid,pwd);
                    stmt=con.createStatement();
                    String qry;
                    
                
                 //ResultSet res=stmt.executeQuery(qry);
                    loaddata();
                }
               catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
    
    }//GEN-LAST:event_btnsearchActionPerformed

    private void report_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_recordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_report_recordMouseClicked

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
            java.util.logging.Logger.getLogger(fee_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fee_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fee_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fee_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fee_report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable report_record;
    private javax.swing.JTextField txtcourse_search;
    private javax.swing.JTextField txtdate1_search;
    private javax.swing.JTextField txtdate_search;
    private javax.swing.JTextField txtname_search;
    // End of variables declaration//GEN-END:variables
}
