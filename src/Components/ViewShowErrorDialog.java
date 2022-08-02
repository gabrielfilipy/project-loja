package Components;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ViewShowErrorDialog extends javax.swing.JDialog {

    public ViewShowErrorDialog(java.awt.Frame parent, boolean modal, String text, String title) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle(title);
        jLText.setText(text);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBYes = new javax.swing.JButton();
        jLText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirm");
        setResizable(false);

        JBYes.setBackground(new java.awt.Color(30, 148, 210));
        JBYes.setForeground(new java.awt.Color(255, 255, 255));
        JBYes.setText("Entendi");
        JBYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBYes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JBYesMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JBYesMouseMoved(evt);
            }
        });
        JBYes.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                JBYesMouseWheelMoved(evt);
            }
        });
        JBYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBYesMouseClicked(evt);
            }
        });
        JBYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBYesActionPerformed(evt);
            }
        });
        JBYes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JBYesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBYesKeyReleased(evt);
            }
        });

        jLText.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLText.setText("Want to delete this?");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/windows-error-mini.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JBYes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLText, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBYes)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBYesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBYesKeyReleased
        
    }//GEN-LAST:event_JBYesKeyReleased

    private void JBYesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBYesKeyPressed
        dispose();
    }//GEN-LAST:event_JBYesKeyPressed

    private void JBYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBYesActionPerformed
        
    }//GEN-LAST:event_JBYesActionPerformed

    private void JBYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYesMouseClicked
        dispose();
    }//GEN-LAST:event_JBYesMouseClicked

    private void JBYesMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_JBYesMouseWheelMoved

    }//GEN-LAST:event_JBYesMouseWheelMoved

    private void JBYesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYesMouseMoved
       
    }//GEN-LAST:event_JBYesMouseMoved

    private void JBYesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYesMouseDragged

    }//GEN-LAST:event_JBYesMouseDragged

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
            java.util.logging.Logger.getLogger(ViewShowErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShowErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShowErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShowErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewShowErrorDialog dialog = new ViewShowErrorDialog(new javax.swing.JFrame(), true, "", "");
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
    private javax.swing.JButton JBYes;
    private javax.swing.JLabel jLText;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
