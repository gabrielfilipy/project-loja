package Components;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ViewShowConfirmCustomDialog extends javax.swing.JDialog {

    public static int YES_OPTION = 1;
    public static int NO_OPTION = 0;
    private int value = YES_OPTION;
    
    public ViewShowConfirmCustomDialog(java.awt.Frame parent, boolean modal, String text) {
        super(parent, modal);
        initComponents();
        JBYes.setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        jLText.setText(text);
        setVisible(true);
        
    }

    public void option (java.awt.event.KeyEvent e) {
           if (e.getKeyCode()== e.VK_LEFT) { 
              System.out.println("Left");
              JBYes.setBackground(Color.LIGHT_GRAY);
              JBYes.setForeground(Color.BLACK);
              jBNo.setBackground(Color.WHITE);
              jBNo.setForeground(Color.BLACK);
              JBYes.setSelected(true);
                setValue(YES_OPTION);
            }
            if (e.getKeyCode()== e.VK_RIGHT) { 
                System.out.println("Right");
                JBYes.setBackground(Color.WHITE);
                JBYes.setForeground(Color.BLACK);
                jBNo.setBackground(Color.LIGHT_GRAY);
                jBNo.setForeground(Color.BLACK);
                jBNo.setSelected(true);
                JBYes.setSelected(false);
                setValue(NO_OPTION);
            }
            
            if (e.getKeyCode()== e.VK_ENTER && getValue() == YES_OPTION) {
                dispose();
            } 
            
            if (e.getKeyCode()== e.VK_ENTER && getValue() == NO_OPTION) {
                dispose();
            }
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLText = new javax.swing.JLabel();
        jBNo = new javax.swing.JButton();
        JBYes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirm");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLText.setText("Want to delete this?");

        jBNo.setBackground(new java.awt.Color(255, 255, 255));
        jBNo.setText("No");
        jBNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jBNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBNo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBNoMouseMoved(evt);
            }
        });
        jBNo.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jBNoMouseWheelMoved(evt);
            }
        });
        jBNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNoActionPerformed(evt);
            }
        });
        jBNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBNoKeyReleased(evt);
            }
        });

        JBYes.setBackground(new java.awt.Color(255, 255, 255));
        JBYes.setText("Yes");
        JBYes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JBYes, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBNo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLText, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBYes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBYesActionPerformed
        setValue(YES_OPTION);
        dispose();
    }//GEN-LAST:event_JBYesActionPerformed

    private void JBYesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBYesKeyReleased
        option(evt);
    }//GEN-LAST:event_JBYesKeyReleased

    private void jBNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBNoKeyReleased
        option(evt);
    }//GEN-LAST:event_jBNoKeyReleased

    private void jBNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNoActionPerformed
        setValue(NO_OPTION);
        dispose();
    }//GEN-LAST:event_jBNoActionPerformed

    private void JBYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYesMouseClicked
        
    }//GEN-LAST:event_JBYesMouseClicked

    private void JBYesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBYesKeyPressed
        
    }//GEN-LAST:event_JBYesKeyPressed

    private void JBYesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYesMouseMoved
        JBYes.setBackground(Color.LIGHT_GRAY);
        JBYes.setForeground(Color.black);
        jBNo.setBackground(Color.white);
        jBNo.setForeground(Color.BLACK);
        JBYes.setSelected(true);
    }//GEN-LAST:event_JBYesMouseMoved

    private void JBYesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBYesMouseDragged
        
    }//GEN-LAST:event_JBYesMouseDragged

    private void JBYesMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_JBYesMouseWheelMoved
        
    }//GEN-LAST:event_JBYesMouseWheelMoved

    private void jBNoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jBNoMouseWheelMoved
        
    }//GEN-LAST:event_jBNoMouseWheelMoved

    private void jBNoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNoMouseMoved
        JBYes.setBackground(Color.white);
        JBYes.setForeground(Color.black);
        jBNo.setBackground(Color.LIGHT_GRAY);
        jBNo.setForeground(Color.black);
        jBNo.setSelected(true);
        JBYes.setSelected(false);
        setValue(NO_OPTION);
    }//GEN-LAST:event_jBNoMouseMoved

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
            java.util.logging.Logger.getLogger(ViewShowConfirmCustomDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShowConfirmCustomDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShowConfirmCustomDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShowConfirmCustomDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewShowConfirmCustomDialog dialog = new ViewShowConfirmCustomDialog(new javax.swing.JFrame(), true, "");
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
    private javax.swing.JButton jBNo;
    private javax.swing.JLabel jLText;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
