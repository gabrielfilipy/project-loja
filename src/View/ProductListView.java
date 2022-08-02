package View;

import Components.ViewShowConfirmDialog;
import Components.ViewShowErrorDialog;
import Components.ViewShowSuccessDialog;
import Controller.ConfigController;
import Controller.Enums.Path;
import Controller.ProductController;
import Model.Conf;
import java.util.ArrayList;
import Model.*;
import java.awt.Toolkit;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductListView extends javax.swing.JFrame {

    private ViewShowConfirmDialog viewShowConfirmDialog;
    private ViewShowErrorDialog errorDialog;
    private ViewShowSuccessDialog dialog;
    
    List<Product> list = new ArrayList<>();
    Product o = new Product();
    ProductController products = new ProductController();
    
    Conf conf = new Conf();
    ConfigController configs = new ConfigController();
    boolean remove = false;
    
    public ProductListView() {
        initComponents();
        table.getTableHeader().setDefaultRenderer(new Util.TableHeaderStyle());
        table.setRowHeight(20);
       // setIcon();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        listData();
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    private void listData(){
        list = products.collection();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        int cont = list.size();
        for(int i = 0; i <cont; i++){
            model.addRow(new Object[]{
            list.get(i).getId(),
            list.get(i).getName(),
            list.get(i).getStock(),
            "R$" + list.get(i).getValue_sale()
        });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCDelete = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Products");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jCDelete.setBackground(new java.awt.Color(255, 255, 255));
        jCDelete.setForeground(new java.awt.Color(255, 102, 102));
        jCDelete.setText("Wish to delete?");
        jCDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCDeleteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Cancel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Stock", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.setOpaque(false);
        table.setRequestFocusEnabled(false);
        table.setSelectionForeground(new java.awt.Color(204, 204, 204));
        table.getTableHeader().setReorderingAllowed(false);
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
            table.getColumnModel().getColumn(0).setMaxWidth(90);
            table.getColumnModel().getColumn(1).setPreferredWidth(500);
            table.getColumnModel().getColumn(1).setMaxWidth(400);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Etiqueta");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Balança");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCDelete))
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
        int line = table.getSelectedRow();
        int code = (int) table.getValueAt(line, 0);
        ProductView u = new ProductView();
        try {
            o = new Product();
            o = products.searchForId(code); 
            u.tfCode.setText(o.getId() + ""); 
            u.tfName.setText(o.getName());  
            u.tfStock.setText(o.getStock() + "");
            u.tfValueSale.setText(o.getValue_sale() + "");
            u.tfCodeVerification.setText(o.getCode_verification() + "");
            u.jLDescritionFoto.setText(o.getImage() + ".jpeg");
            if (u.jLDescritionFoto.getText().equals("not-file.jpeg")) 
                u.tfImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/not-file.png")));
            else {
                u.tfImg.setIcon(new javax.swing.ImageIcon(Path.PATH_IMAGE.getPath() + o.getImage()));
            }
            if (!remove)
            dispose();
            
            u.setVisible(true);
            u.setLocationRelativeTo(null);
            u.jbAddOrUpdate.setText("Update");
            
        } catch (Exception e) {
            errorDialog = new ViewShowErrorDialog(this, true, "Error: " + e, "Product");
            DateTimeFormatter dh = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            System.out.println(dh.format(LocalDateTime.now()) + " ERRO: " + e);
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void jCDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDeleteActionPerformed
        if (remove) {
            remove = false;
        } else {
            remove = true;
        }
    }//GEN-LAST:event_jCDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProductView u = new ProductView();
        u.setLocationRelativeTo(null);
        u.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        
    }//GEN-LAST:event_tableKeyPressed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        if (remove) {
            try {
                int line = table.getSelectedRow();
                int code = (int) table.getValueAt(line, 0);
                viewShowConfirmDialog = new ViewShowConfirmDialog(this, true, "Want to delete this?");
                int value = viewShowConfirmDialog.getValue();
                if (value == viewShowConfirmDialog.YES_OPTION && products.delete(code)) {
                    o = new Product();
                    o = products.searchForId(code);
                    String caminho = getClass().getResource("../image/").toString().substring(5);
                    File outputfile = new File(caminho + o.getImage());
                    outputfile.delete();
                    if (products.delete(code)) {
                        dialog = new ViewShowSuccessDialog(this, true, "Delete success.");
                        listData();
                    } 
                }
            } catch (Exception e) {
                DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                errorDialog = new ViewShowErrorDialog(this, true, "Error: " + e, "Product");
                System.out.println(d + " INFO ERRO: " + e);
            }
        }
    }//GEN-LAST:event_tableMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductListView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JCheckBox jCDelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
