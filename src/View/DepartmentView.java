package View;

import Controller.DepartmentController;
import Controller.ProviderController;
import Controller.UserController;
import Model.*;
import static View.StockProductView.LIST_DEPARTMENT;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DepartmentView extends javax.swing.JFrame {

    Department p = new Department();
    DepartmentController departments = new DepartmentController();
    
    boolean update = false; 
    
    public DepartmentView() {
        initComponents();
        setIcon();
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    public void clearFields () {
        tfName.setText("");
        tfCode.setText("");
        LIST_DEPARTMENT();
    }
     
    public void add () { 
        if(tfName.getText().equals("")) { 
            JOptionPane.showMessageDialog(this, "Required fields!", "Provider", 0,
            new ImageIcon(getClass().getResource("/image/err.png"))); 
        }else{
            p.setName(tfName.getText().toUpperCase());
            if(departments.save(p) > 0){
               JOptionPane.showMessageDialog(this, "Success", "Provider", 0,
                    new ImageIcon(getClass().getResource("/image/suc.png"))); 
               clearFields ();
               StockProductView s = new StockProductView();
            } 
        }
    }
    
    public void update () {
        if(tfName.getText().equals("")) { 
            JOptionPane.showMessageDialog(this, "Required fields!", "User", 0,
            new ImageIcon(getClass().getResource("/image/err.png"))); 
        }else{
            
            p.setId(Integer.parseInt(tfCode.getText()));
            p.setName(tfName.getText());
            
            if (departments.update(p)) {
                JOptionPane.showMessageDialog(this, "Provider '" + p.getName().toUpperCase() + "' it has been updated successfully", "User", 0,
                    new ImageIcon(getClass().getResource("/image/suc.png"))); 
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JpUser = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jBEdit = new javax.swing.JButton();
        JbAddOrUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        tfCode = new javax.swing.JTextField();
        jLName1 = new javax.swing.JLabel();
        jLName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Department registration ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JpUser.setBackground(new java.awt.Color(255, 255, 255));
        JpUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JpUser.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBEdit.setBackground(new java.awt.Color(255, 255, 255));
        jBEdit.setText("Edit");
        jBEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditActionPerformed(evt);
            }
        });

        JbAddOrUpdate.setBackground(new java.awt.Color(255, 255, 255));
        JbAddOrUpdate.setText("Add");
        JbAddOrUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbAddOrUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAddOrUpdateActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tfCode.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tfCode.setEnabled(false);

        jLName1.setBackground(new java.awt.Color(153, 153, 153));
        jLName1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName1.setText("ID:");

        jLName.setBackground(new java.awt.Color(153, 153, 153));
        jLName.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName.setText("*Name:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLName1)
                    .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout JpUserLayout = new javax.swing.GroupLayout(JpUser);
        JpUser.setLayout(JpUserLayout);
        JpUserLayout.setHorizontalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpUserLayout.createSequentialGroup()
                        .addGap(0, 297, Short.MAX_VALUE)
                        .addComponent(JbAddOrUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JpUserLayout.setVerticalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jBEdit)
                    .addComponent(JbAddOrUpdate))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        DepartmentListView v = new DepartmentListView();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBEditActionPerformed

    private void JbAddOrUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAddOrUpdateActionPerformed
        if (!tfCode.getText().equals("")) {
            update();
        } else {
            add ();
        }
        clearFields ();
    }//GEN-LAST:event_JbAddOrUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DepartmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton JbAddOrUpdate;
    private javax.swing.JPanel JpUser;
    public static javax.swing.JButton jBEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLName1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField tfCode;
    public static javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
