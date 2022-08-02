
package View;

import Components.ViewShowAlertDialog;
import Components.ViewShowConfirmDialog;
import Components.ViewShowErrorDialog;
import Components.ViewShowInputValueDialog;
import Components.ViewShowSuccessDialog;
import Controller.SettingController;
import Model.SettingSystem;
import View.Connection.ConnectionView;
import java.awt.Component;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class HomeView extends javax.swing.JFrame {

    private ViewShowConfirmDialog viewShowConfirmDialog;
    private ViewShowErrorDialog errorDialog;
    private ViewShowSuccessDialog alert;
    private ViewShowInputValueDialog input;
    
    public HomeView() {
        initComponents();
        setIcon();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }  
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHome = new javax.swing.JPanel();
        tfName = new javax.swing.JLabel();
        jLFoto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmUser = new javax.swing.JMenuItem();
        JmStock = new javax.swing.JMenuItem();
        jmProduct = new javax.swing.JMenuItem();
        jmClient = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmReport = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setExtendedState(2);

        jPanelHome.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHome.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tfName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tfName.setText("User");

        jLFoto.setBackground(new java.awt.Color(255, 51, 51));
        jLFoto.setForeground(new java.awt.Color(255, 51, 51));
        jLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLFoto.setIcon(new javax.swing.ImageIcon("C:\\projects\\files\\image\\logo-home")); // NOI18N
        jLFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHomeLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(166, 166, 166)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Register");

        jmUser.setText("User");
        jmUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmUser.setEnabled(false);
        jmUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUserActionPerformed(evt);
            }
        });
        jMenu1.add(jmUser);

        JmStock.setText("Stock");
        JmStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JmStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmStockActionPerformed(evt);
            }
        });
        jMenu1.add(JmStock);

        jmProduct.setText("Product");
        jmProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmProduct.setEnabled(false);
        jmProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductActionPerformed(evt);
            }
        });
        jMenu1.add(jmProduct);

        jmClient.setText("Client");
        jmClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmClient.setEnabled(false);
        jmClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClientActionPerformed(evt);
            }
        });
        jMenu1.add(jmClient);

        jMenuItem3.setText("Provider");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Department");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Report");

        jmReport.setText("Sales");
        jmReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmReport.setEnabled(false);
        jmReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReportActionPerformed(evt);
            }
        });
        jMenu2.add(jmReport);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Settings");

        jMenuItem6.setText("Configuration");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem5.setText("Exit");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem1.setText("Connection");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUserActionPerformed
        UserView uv = new UserView();
        uv.setLocationRelativeTo(null);  
        uv.setVisible(true);
    }//GEN-LAST:event_jmUserActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        dispose();
        LoginView l = new LoginView();
        l.setVisible(true);
        l.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jmProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductActionPerformed
        ProductView p = new ProductView();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }//GEN-LAST:event_jmProductActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ConnectionView c = new ConnectionView();
        try{
            InetAddress end = InetAddress.getLocalHost();
            String ip = String.valueOf(end);
            ip = ip.replace("DESKTOP-VIGN5VM/", "");
            System.out.println(ip);
            c.setVisible(true);
            c.tfIp.setText(ip + "");
            c.setLocationRelativeTo(null);
        }
        catch(UnknownHostException uhex){
            System.out.println("Não foi possível obter o IP da máquina local.");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JmStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmStockActionPerformed
        StockProductView s = new StockProductView();
        s.setVisible(true);
        s.setLocationRelativeTo(null);
    }//GEN-LAST:event_JmStockActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ProviderView p = new ProviderView();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        DepartmentView v = new DepartmentView();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReportActionPerformed
        ReportSaleView reportSaleView = new ReportSaleView();
        reportSaleView.setVisible(true);
        reportSaleView.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmReportActionPerformed

    private void jmClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClientActionPerformed
        ClientView c = new ClientView();
        c.setVisible(true);
        c.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmClientActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        SettingView conf = new SettingView();
        SettingSystem settingSystem = new SettingSystem();
        SettingController settings = new SettingController();
        
        settingSystem = settings.search("EMP");
        conf.tfAddress.setText(settingSystem.getAddress());
        conf.tfCnpj.setText(settingSystem.getCnpj());
        conf.tfName.setText(settingSystem.getName());
        conf.tfFoto.setText(settingSystem.getFoto());
        conf.tfId.setText(settingSystem.getId() + "");
        conf.setVisible(true);
        conf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem JmStock;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanelHome;
    public static javax.swing.JMenuItem jmClient;
    public static javax.swing.JMenuItem jmProduct;
    public static javax.swing.JMenuItem jmReport;
    public static javax.swing.JMenuItem jmUser;
    public static javax.swing.JLabel tfName;
    // End of variables declaration//GEN-END:variables
}
