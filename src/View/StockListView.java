package View;

import Components.ViewShowConfirmDialog;
import Components.ViewShowErrorDialog;
import Controller.ConfigController;
import Controller.DepartmentController;
import Controller.ProviderController;
import Controller.StockController;
import Controller.StocksController;
import Model.Conf;
import java.util.ArrayList;
import Model.*;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StockListView extends javax.swing.JFrame {

    private ViewShowErrorDialog errorDialog;
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
    
    int option = 1;
    boolean remove = false;
    
    public StockListView() {
        initComponents();
        setIcon();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        listData();
        clearField();
    }
    
    public void clearField() {
        option = 1;
        jRName.setSelected(true);
        jRCode.setSelected(false);
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    private void listData(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        Stocks stocks = new Stocks();
        List<Stocks> listStocks = new ArrayList<>();
        StocksController stocksController = new StocksController();
        
        listStocks = stocksController.collection();
        
        
        int cont = listStocks.size();
        for(int i = 0; i <cont; i++){
            model.addRow(new Object[]{
            listStocks.get(i).getStock().getId(),
            listStocks.get(i).getStock().getName(),
            listStocks.get(i).getDepartment().getName(),
            listStocks.get(i).getProvider().getName(),
            listStocks.get(i).getUser().getName()
        });
        }
    }
    
    private void search () {
        Stocks stocks = new Stocks();
        List<Stocks> listStocks = new ArrayList<>();
        StocksController stocksController = new StocksController();
        
        listStocks = stocksController.collectionForNameOrCode(tfSearch.getText());
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        int cont = listStocks.size();
        for(int i = 0; i <cont; i++){
            model.addRow(new Object[]{
            listStocks.get(i).getStock().getId(),
            listStocks.get(i).getStock().getName(),
            listStocks.get(i).getDepartment().getName(),
            listStocks.get(i).getProvider().getName(),
            listStocks.get(i).getUser().getName()
        });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JpUser = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jCDelete = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jRName = new javax.swing.JRadioButton();
        jRCode = new javax.swing.JRadioButton();
        jRAll = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        JpUser.setBackground(new java.awt.Color(255, 255, 255));
        JpUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JpUser.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Department", "Provider", "Registrant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            table.getColumnModel().getColumn(0).setMaxWidth(90);
            table.getColumnModel().getColumn(1).setMaxWidth(400);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(150);
            table.getColumnModel().getColumn(4).setMaxWidth(120);
        }

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

        javax.swing.GroupLayout JpUserLayout = new javax.swing.GroupLayout(JpUser);
        JpUser.setLayout(JpUserLayout);
        JpUserLayout.setHorizontalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpUserLayout.createSequentialGroup()
                        .addComponent(jCDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JpUserLayout.setVerticalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCDelete)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setText("Search:");

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        jRName.setBackground(new java.awt.Color(255, 255, 255));
        jRName.setForeground(new java.awt.Color(51, 51, 51));
        jRName.setText("Name");
        jRName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRNameActionPerformed(evt);
            }
        });

        jRCode.setBackground(new java.awt.Color(255, 255, 255));
        jRCode.setForeground(new java.awt.Color(51, 51, 51));
        jRCode.setText("Code verification");
        jRCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRCodeActionPerformed(evt);
            }
        });

        jRAll.setBackground(new java.awt.Color(255, 255, 255));
        jRAll.setForeground(new java.awt.Color(51, 51, 51));
        jRAll.setText("All");
        jRAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRAll)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRName)
                    .addComponent(jRCode)
                    .addComponent(jRAll))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        StockProductView u = new StockProductView();
        try {
            o = stocks.searchForId(code);
            u.tfCodeVerification.setText(o.getCode_verification()); 
            u.tfName.setText(o.getName());  
            u.tfStock.setText(o.getStock() + "");
            u.tfValueInvest.setText(o.getValue_invest() + "");
            u.tfCode.setText(o.getId() + "");
            p = c.searchForId(o.getProvider_id());
            u.jCProviders.setSelectedItem(p.getName());
            department = departmentController.searchForId(o.getDepartment_id());
            u.jComboDepartment.setSelectedItem(department.getName());
            u.tfValueSingle.setText(o.getValue_single() + "");
            if (!remove)
            dispose();
            
            u.setVisible(true);
            u.setLocationRelativeTo(null);
            
        } catch (Exception e) {
            DateTimeFormatter dh = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            System.out.println(dh.format(LocalDateTime.now()) + "ERRO: " + e);
            errorDialog = new ViewShowErrorDialog(this, true, dh.format(LocalDateTime.now()) + "ERRO: " + e, "Stock");
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void jCDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDeleteActionPerformed
        if (remove) {
            remove = false;
        } else {
            remove = true;
        }
        UserView u = new UserView();
        u.JbAddOrUpdate.setText("Add");
    }//GEN-LAST:event_jCDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StockProductView u = new StockProductView();
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
                if(value == viewShowConfirmDialog.YES_OPTION){
                    if (stocks.delete(code)) {
                        JOptionPane.showMessageDialog(this, "Delete success", "User", 0,
                        new ImageIcon(getClass().getResource("/image/suc.png")));
                        listData();
                    } 
                }
            } catch (Exception e) {
                DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                JOptionPane.showMessageDialog(this, "Error selecting this user: ", "User", 0,
                new ImageIcon(getClass().getResource("/image/err.png")));
                System.out.println(d.format(LocalDateTime.now()) + " - INFO ERRO: " + e);
            }
        }
    }//GEN-LAST:event_tableMousePressed

    private void jRNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRNameActionPerformed
        jRCode.setSelected(false);
        jRAll.setSelected(false);
        option = 1;
    }//GEN-LAST:event_jRNameActionPerformed

    private void jRCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRCodeActionPerformed
        jRName.setSelected(false);
        jRAll.setSelected(false);
        option = 2;
    }//GEN-LAST:event_jRCodeActionPerformed

    private void tfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyPressed
        if (evt.getKeyCode()== evt.VK_ENTER && !tfSearch.getText().equals("")) { 
            if (option == 1) {
                DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
                final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
                table.setRowSorter(classificador);
                String texto = tfSearch.getText();  
                classificador.setRowFilter(RowFilter.regexFilter(texto, 1));
            } 
            if (option == 2) {
                search();
            }
        }
    }//GEN-LAST:event_tfSearchKeyPressed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        tfSearch.setText(tfSearch.getText().toUpperCase());
    }//GEN-LAST:event_tfSearchKeyReleased

    private void jRAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRAllActionPerformed
        listData();
        jRAll.setSelected(true);
        jRCode.setSelected(false);
        jRName.setSelected(false);
    }//GEN-LAST:event_jRAllActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockListView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpUser;
    private javax.swing.JButton jButton1;
    public static javax.swing.JCheckBox jCDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRAll;
    private javax.swing.JRadioButton jRCode;
    private javax.swing.JRadioButton jRName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
