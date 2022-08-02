package View;

import Components.ViewShowErrorDialog;
import Controller.ConfigController;
import Controller.DepartmentController;
import Model.Conf;
import java.util.ArrayList;
import Model.*;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DepartmentListView extends javax.swing.JFrame {

    private ViewShowErrorDialog errorDialog;
    List<Department> list = new ArrayList<>();
    Department o = new Department();
    DepartmentController departments = new DepartmentController();
    
    Conf conf = new Conf();
    ConfigController configs = new ConfigController();
    
    boolean remove = false;
    
    public DepartmentListView() {
        initComponents();
        setIcon();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        listData();
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    private void listData(){ 
        list = departments.collection();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        int cont = list.size();
        for(int i = 0; i <cont; i++){
            model.addRow(new Object[]{
            list.get(i).getId(),
            list.get(i).getName()
        });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JpUser = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jCDelete = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Users");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JpUser.setBackground(new java.awt.Color(255, 255, 255));
        JpUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JpUser.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Code", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
            table.getColumnModel().getColumn(0).setMaxWidth(60);
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
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCDelete)
                    .addComponent(jButton1))
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
        int line = table.getSelectedRow();
        int code = (int) table.getValueAt(line, 0);
        DepartmentView u = new DepartmentView();
        try {
            o = departments.searchForId(code);
            u.tfName.setText(o.getName()); 
            u.tfCode.setText(o.getId() + "");
            
            if (!remove)
            dispose();
            
            u.JbAddOrUpdate.setText("Update"); 
            u.update = true;
            u.setVisible(true);
            u.setLocationRelativeTo(null);
            
        } catch (Exception e) {
            errorDialog = new ViewShowErrorDialog(this, true, "Error selecting this department", "Department");
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
        UserView u = new UserView();
        u.JbAddOrUpdate.setText("Add");
    }//GEN-LAST:event_jCDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DepartmentView u = new DepartmentView();
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
                int otpion = JOptionPane.showConfirmDialog(this, "Confirm it action?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(otpion == JOptionPane.YES_OPTION){
                    if (departments.delete(code)) {
                        JOptionPane.showMessageDialog(this, "Delete success", "User", 0,
                        new ImageIcon(getClass().getResource("/image/suc.png")));
                        listData();
                    } 
                }
            } catch (Exception e) {
                DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                JOptionPane.showMessageDialog(this, "Error selecting this user: ", "User", 0,
                new ImageIcon(getClass().getResource("/image/err.png"))); 
                System.out.println(d + " INFO ERRO: " + e);
            }
        }
    }//GEN-LAST:event_tableMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentListView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpUser;
    private javax.swing.JButton jButton1;
    public static javax.swing.JCheckBox jCDelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
