package Components;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ViewShowConfirmDialog extends javax.swing.JDialog {

    public static int YES_OPTION = 1;
    public static int NO_OPTION = 0;
    private int value = YES_OPTION;
    
    public ViewShowConfirmDialog(java.awt.Frame parent, boolean modal, String text) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jLText.setText(text);
        setVisible(true);
    }

    public void option (java.awt.event.KeyEvent e) {
        try {
           
           if (e.getKeyCode()== e.VK_LEFT){ 
              System.out.println("Left");
              JBYes.setBackground(new java.awt.Color(10, 175, 78));
              JBYes.setForeground(Color.white);
              jBNo.setBackground(new java.awt.Color(183, 28, 28));
              jBNo.setForeground(Color.white);
              JBYes.setSelected(true);
                setValue(YES_OPTION);
            }
            if (e.getKeyCode()== e.VK_RIGHT){ 
                System.out.println("Right");
                JBYes.setBackground(new java.awt.Color(0, 200, 83));
                JBYes.setForeground(Color.white);
                jBNo.setBackground(new java.awt.Color(153, 1, 18));
                jBNo.setForeground(Color.white);
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
            
        } catch (Exception x) {
            DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            JOptionPane.showMessageDialog(this, "Error selecting this user: ", "User", 0,
              new ImageIcon(getClass().getResource("/image/err.png"))); 
            System.out.println(d + " INFO ERRO: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBNo = new javax.swing.JButton();
        JBYes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirm");
        setResizable(false);

        jBNo.setBackground(new java.awt.Color(211, 47, 47));
        jBNo.setForeground(new java.awt.Color(255, 255, 255));
        jBNo.setText("No");
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

        JBYes.setBackground(new java.awt.Color(10, 175, 78));
        JBYes.setForeground(new java.awt.Color(255, 255, 255));
        JBYes.setText("Yes");
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/windows-whats-mini.png"))); // NOI18N

        jLText.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLText.setText("Want to delete this?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBYes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBNo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLText, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBYes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
        JBYes.setBackground(new java.awt.Color(30, 148, 210));
        JBYes.setForeground(Color.white);
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
        jBNo.setBackground(new java.awt.Color(30, 148, 210));
        jBNo.setForeground(Color.white);
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
            java.util.logging.Logger.getLogger(ViewShowConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShowConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShowConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShowConfirmDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewShowConfirmDialog dialog = new ViewShowConfirmDialog(new javax.swing.JFrame(), true, "");
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
