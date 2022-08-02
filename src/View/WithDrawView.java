package View;

import Components.ViewShowAlertDialog;
import Components.ViewShowConfirmDialog;
import Components.ViewShowErrorDialog;
import Components.ViewShowInputValueDialog;
import Components.ViewShowSuccessDialog;
import Controller.ConfigController;
import Controller.DepartmentController;
import Controller.ProviderController;
import Controller.StockController;
import Exception.ImpossibleThisAction;
import Model.Conf;
import java.util.ArrayList;
import Model.*;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class WithDrawView extends javax.swing.JFrame {

    private ViewShowErrorDialog errorDialog;
    private ViewShowAlertDialog alertDialog;
    private ViewShowSuccessDialog mensageDialog;
    private ViewShowInputValueDialog insertValueDialog;
    int value = 0;
    private ViewShowConfirmDialog viewShowConfirmDialog;
    List<Stock> list = new ArrayList<>();
    Stock o = new Stock();
    StockController stocks = new StockController();
    
    List<Department> departmentList = new ArrayList<>();
    Department deaprtment = new Department();
    DepartmentController departments = new DepartmentController();
    
    Conf conf = new Conf();
    ConfigController configs = new ConfigController();
    
    Provider p = new Provider();
    ProviderController c = new ProviderController();
    
    Department department = new Department();
    DepartmentController departmentController = new DepartmentController();
    
    boolean remove = false;
    
    public WithDrawView() {
        initComponents();
        setIcon();
        clearFields ();
    }
    
    public void clearFields () {
        jLName.setText("");
        tfCodeVerification.setText("");
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        model.setNumRows(0);
        tfCodeVerification.requestFocus();
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    public void save () {
        int c = table.getRowCount();
        int codeProduct;
        for (int i = 0; i < c; i++) {
            o = new Stock();
            codeProduct = (int) table.getValueAt(i, 1); 
            o.setId(codeProduct);
            o.setStock(stocks.searchForId(codeProduct).getStock() - Integer.parseInt(String.valueOf(table.getValueAt(i, 3))));  
            list.add(o);
        }
        
        if (stocks.alterStockCollection(list)) {
            mensageDialog = new ViewShowSuccessDialog(this, true, "Success");
            clearFields ();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JpUser = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodeVerification = new javax.swing.JTextField();
        jLName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JpUser.setBackground(new java.awt.Color(255, 255, 255));
        JpUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JpUser.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Code", "Name", "The amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(60);
            table.getColumnModel().getColumn(1).setMaxWidth(90);
            table.getColumnModel().getColumn(2).setPreferredWidth(900);
            table.getColumnModel().getColumn(2).setMaxWidth(400);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Cancel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Code verification:");

        tfCodeVerification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodeVerificationActionPerformed(evt);
            }
        });
        tfCodeVerification.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodeVerificationKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodeVerificationKeyReleased(evt);
            }
        });

        jLName.setBackground(new java.awt.Color(51, 51, 51));
        jLName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Code verification:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfCodeVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLName, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodeVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Run");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpUserLayout = new javax.swing.GroupLayout(JpUser);
        JpUser.setLayout(JpUserLayout);
        JpUserLayout.setHorizontalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addGroup(JpUserLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpUserLayout.setVerticalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
     viewShowConfirmDialog = new ViewShowConfirmDialog(this, true, "Want to delete this?");
     int value = viewShowConfirmDialog.getValue();
     if(value == viewShowConfirmDialog.YES_OPTION){
        int linha = table.getSelectedRow();
        String cod = String.valueOf(table.getValueAt(linha, 0));
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.removeRow(Integer.parseInt(cod)-1);
        tfCodeVerification.requestFocus();
     }
    }//GEN-LAST:event_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        
    }//GEN-LAST:event_tableKeyPressed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        
    }//GEN-LAST:event_tableMousePressed

    private void tfCodeVerificationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodeVerificationKeyPressed
        
    }//GEN-LAST:event_tfCodeVerificationKeyPressed

    private void tfCodeVerificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodeVerificationActionPerformed
     
    }//GEN-LAST:event_tfCodeVerificationActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        save ();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfCodeVerificationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodeVerificationKeyReleased
        if (evt.getKeyCode()== evt.VK_ENTER && !tfCodeVerification.getText().equals("")) { 
                o = stocks.searchForCodeVerication(tfCodeVerification.getText());
                if (o.getName() != null) {
                    try {
                        DefaultTableModel modelo = (DefaultTableModel) table.getModel();  
                        insertValueDialog = new ViewShowInputValueDialog(this, true, "Enter amount");
                        int value = Integer.parseInt(insertValueDialog.getValue() + "");
                        o = stocks.searchForCodeVerication(tfCodeVerification.getText());
                        if (value > o.getStock()) {
                            throw new ImpossibleThisAction("No stock!");
                        }
                        if (value == insertValueDialog.YES_OPTION) {
                            if (value == 0) {
                                throw new ImpossibleThisAction("Value incorret!");
                            }
                            //TODO: Verificar se já existe produto na tabela. Caso exista lançar uma exception impossibilitando ter produtos duplicados.
                            modelo.addRow(new Object[]{     
                                modelo.getRowCount()+1,
                                o.getId(),
                                o.getName(),
                                value
                            });
                            tfCodeVerification.setText("");
                            jLName.setText(value + " x " + o.getName());
                        }
                     } catch (Exception e) {
                         errorDialog = new ViewShowErrorDialog(this, true, e.getMessage(), "Error");
                     }
                } else {
                    errorDialog = new ViewShowErrorDialog(this, true, "Product no exist for this code!", "Error");
                    tfCodeVerification.setText("");
                }
            }
        
    }//GEN-LAST:event_tfCodeVerificationKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WithDrawView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfCodeVerification;
    // End of variables declaration//GEN-END:variables
}
