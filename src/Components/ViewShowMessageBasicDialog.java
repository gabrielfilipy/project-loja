package Components;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ViewShowMessageBasicDialog extends javax.swing.JDialog {

    public ViewShowMessageBasicDialog(java.awt.Frame parent, boolean modal, String text, String title) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jLText.setText(text);
        setTitle(title);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLText = new javax.swing.JLabel();
        JBYes1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLText.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLText.setText("Want to delete this?");

        JBYes1.setBackground(new java.awt.Color(255, 255, 255));
        JBYes1.setText("Ok");
        JBYes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        JBYes1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBYes1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JBYes1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JBYes1MouseMoved(evt);
            }
        });
        JBYes1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                JBYes1MouseWheelMoved(evt);
            }
        });
        JBYes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBYes1MouseClicked(evt);
            }
        });
        JBYes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBYes1ActionPerformed(evt);
            }
        });
        JBYes1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JBYes1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBYes1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLText, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBYes1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBYes1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBYes1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYes1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_JBYes1MouseDragged

    private void JBYes1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYes1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_JBYes1MouseMoved

    private void JBYes1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_JBYes1MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_JBYes1MouseWheelMoved

    private void JBYes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYes1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JBYes1MouseClicked

    private void JBYes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBYes1ActionPerformed
        dispose();
    }//GEN-LAST:event_JBYes1ActionPerformed

    private void JBYes1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBYes1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBYes1KeyPressed

    private void JBYes1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBYes1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JBYes1KeyReleased

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
            java.util.logging.Logger.getLogger(ViewShowMessageBasicDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShowMessageBasicDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShowMessageBasicDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShowMessageBasicDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewShowMessageBasicDialog dialog = new ViewShowMessageBasicDialog(new javax.swing.JFrame(), true, "", "");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBYes1;
    private javax.swing.JLabel jLText;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
