package Components;

import java.awt.Color;

public class ViewShowInputDoubleValueDialog extends javax.swing.JDialog {

    private int value = 0;
    private ViewShowAlertDialog alertDialog;
    
    public ViewShowInputDoubleValueDialog(java.awt.Frame parent, boolean modal, String text) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle(text);
        setVisible(true);
        tfValue.setText("0");
    }
    
    public static Character getFirstCharacter(String s)
    {
        if(s == null || s.length() == 0)
            return null;
        else
        {
            char[] charArr = s.toCharArray();
            return charArr[0];
        }
    }
    
    void add () {
        String valueOfUser = tfValue.getText();
        if (getFirstCharacter(valueOfUser).equals("0")) {
            valueOfUser.substring(1);
        } else {
        setValue(Integer.parseInt(valueOfUser));
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBOk = new javax.swing.JButton();
        tfValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add value");
        setResizable(false);

        jBOk.setBackground(new java.awt.Color(30, 148, 210));
        jBOk.setForeground(new java.awt.Color(255, 255, 255));
        jBOk.setText("Adicionar");
        jBOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBOk.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jBOkMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBOkMouseMoved(evt);
            }
        });
        jBOk.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jBOkMouseWheelMoved(evt);
            }
        });
        jBOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBOkMouseClicked(evt);
            }
        });
        jBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOkActionPerformed(evt);
            }
        });
        jBOk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBOkKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBOkKeyReleased(evt);
            }
        });

        tfValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValueActionPerformed(evt);
            }
        });
        tfValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValueKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfValueKeyTyped(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/windows-whats-mini.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBOk)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfValue, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfValue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBOk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBOkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBOkKeyReleased
        
    }//GEN-LAST:event_jBOkKeyReleased

    private void jBOkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBOkKeyPressed
       if (evt.getKeyCode()== evt.VK_ENTER){ 
            add ();
            dispose();
       }
       if (evt.getKeyCode()== evt.VK_UP){ 
            int v = Integer.parseInt(tfValue.getText());
            v++;
            tfValue.setText(v + "");
        }
        if (evt.getKeyCode()== evt.VK_DOWN){ 
            int v = Integer.parseInt(tfValue.getText());
            if (v > 0) {
                v--;
            }
            tfValue.setText(v + "");
        }
    }//GEN-LAST:event_jBOkKeyPressed

    private void jBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOkActionPerformed
       add ();
       dispose();
    }//GEN-LAST:event_jBOkActionPerformed

    private void jBOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBOkMouseClicked
       
    }//GEN-LAST:event_jBOkMouseClicked

    private void jBOkMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jBOkMouseWheelMoved

    }//GEN-LAST:event_jBOkMouseWheelMoved

    private void jBOkMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBOkMouseMoved
       
    }//GEN-LAST:event_jBOkMouseMoved

    private void jBOkMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBOkMouseDragged

    }//GEN-LAST:event_jBOkMouseDragged

    private void tfValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValueKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_tfValueKeyTyped

    private void tfValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValueKeyReleased
        if (evt.getKeyCode()== evt.VK_ENTER) { 
            add();
            dispose();
        }
    }//GEN-LAST:event_tfValueKeyReleased

    private void tfValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValueActionPerformed
        
    }//GEN-LAST:event_tfValueActionPerformed

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
            java.util.logging.Logger.getLogger(ViewShowInputDoubleValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShowInputDoubleValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShowInputDoubleValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShowInputDoubleValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewShowInputDoubleValueDialog dialog = new ViewShowInputDoubleValueDialog(new javax.swing.JFrame(), true, "");
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
    private javax.swing.JButton jBOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tfValue;
    // End of variables declaration//GEN-END:variables

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
