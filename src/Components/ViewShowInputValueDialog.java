package Components;

import java.awt.Color;

public class ViewShowInputValueDialog extends javax.swing.JDialog {

    private int value = 0;
    public static int YES_OPTION = 1;
    public static int NO_OPTION = 0;
    private int valueOption = YES_OPTION;
    
    public ViewShowInputValueDialog(java.awt.Frame parent, boolean modal, String text) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle(text);
        setVisible(true);
        tfValue.setText("0");
    }
    
    public void option (java.awt.event.KeyEvent e) {
        try {
           
           if (e.getKeyCode()== e.VK_LEFT){ 
              System.out.println("Left");
              jBOk.setBackground(new java.awt.Color(10, 175, 78));
              jBOk.setForeground(Color.white);
              jBCancel.setBackground(new java.awt.Color(183, 28, 28) );
              jBCancel.setForeground(Color.white);
              jBOk.setSelected(true);
                setValue(YES_OPTION);
            }
            if (e.getKeyCode()== e.VK_RIGHT){ 
                System.out.println("Right");
                jBOk.setBackground(new java.awt.Color(0, 200, 83));
                jBOk.setForeground(Color.white);
                jBCancel.setBackground(new java.awt.Color(153, 1, 18));
                jBCancel.setForeground(Color.white);
                jBCancel.setSelected(true);
                jBOk.setSelected(false);
                setValue(NO_OPTION);
            }
            
            if (e.getKeyCode()== e.VK_ENTER && getValue() == YES_OPTION) {
                add ();
                dispose();
            } 
            
            if (e.getKeyCode()== e.VK_ENTER && getValue() == NO_OPTION) {
                dispose();
            }
            
        } catch (Exception x) {
        }
    }
    
    void add () {
        setValue(Integer.parseInt(tfValue.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBCancel = new javax.swing.JButton();
        jBOk = new javax.swing.JButton();
        tfValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add value");
        setResizable(false);

        jBCancel.setBackground(new java.awt.Color(211, 47, 47));
        jBCancel.setForeground(new java.awt.Color(255, 255, 255));
        jBCancel.setText("Cancelar");
        jBCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jBCancelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBCancelMouseMoved(evt);
            }
        });
        jBCancel.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jBCancelMouseWheelMoved(evt);
            }
        });
        jBCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCancelMouseClicked(evt);
            }
        });
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });
        jBCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBCancelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBCancelKeyReleased(evt);
            }
        });

        jBOk.setBackground(new java.awt.Color(10, 175, 78));
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

        tfValue.setEditable(false);
        tfValue.setText("1");
        tfValue.setEnabled(false);
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
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfValue, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tfValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBOk)
                            .addComponent(jBCancel))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBOkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBOkKeyReleased
        option(evt);
    }//GEN-LAST:event_jBOkKeyReleased

    private void jBOkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBOkKeyPressed
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
        setValueOption(YES_OPTION);
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

    }//GEN-LAST:event_tfValueKeyReleased

    private void tfValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValueActionPerformed
        add();
        dispose();
    }//GEN-LAST:event_tfValueActionPerformed

    private void jBCancelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCancelMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelMouseDragged

    private void jBCancelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCancelMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelMouseMoved

    private void jBCancelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jBCancelMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelMouseWheelMoved

    private void jBCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelMouseClicked

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        setValueOption(NO_OPTION);
        dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBCancelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelKeyPressed

    private void jBCancelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBCancelKeyReleased
        option(evt);
    }//GEN-LAST:event_jBCancelKeyReleased

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
            java.util.logging.Logger.getLogger(ViewShowInputValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShowInputValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShowInputValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShowInputValueDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                ViewShowInputValueDialog dialog = new ViewShowInputValueDialog(new javax.swing.JFrame(), true, "");
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
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tfValue;
    // End of variables declaration//GEN-END:variables

    public int getValue() {
        return valueOption;
    }

    public void setValue(int value) {
        this.valueOption = value;
    }

    /**
     * @return the valueOption
     */
    public int getValueOption() {
        return valueOption;
    }

    /**
     * @param valueOption the valueOption to set
     */
    public void setValueOption(int valueOption) {
        this.valueOption = valueOption;
    }

}
