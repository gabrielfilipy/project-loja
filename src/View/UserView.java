package View;

import Components.ViewShowAlertDialog;
import Components.ViewShowErrorDialog;
import Components.ViewShowSuccessDialog;
import Controller.Enums.Services;
import Controller.ServiceController;
import Controller.UserController;
import Model.User;
import Model.Service;
import Util.AddServices;
import java.awt.Toolkit;

public class UserView extends javax.swing.JFrame {
    
    AddServices addServices = new AddServices();
    ServiceController services = new ServiceController();
    Service service = new Service();
    
    private ViewShowErrorDialog errorDialog;
    private ViewShowSuccessDialog mensageDialog;
    private ViewShowAlertDialog alertDialog;
    
    User user = new User();
    UserController users = new UserController();
    int REGISTRATION_USER ;
    int REGISTRATION_CLIENT ;
    int REGISTRATION_INVENTORY;
    int CANCEL_SALE;
    int CANCEL_SALE_UPDATE;
    int REPORT ;
    int ABANDON_SALE ;
    int REMOV_PRO_SALE ;
    
    boolean update = false;
     
    public UserView() {
        initComponents();
        setIcon();
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    public void clearFields () {
        tfLogin.setText("");
        tfPassword.setText("");
        tfCode.setText("");
        rBRegistration_user.setSelected(false);
        rBregistration_client.setSelected(false);
        rBregistration_inventory.setSelected(false);
        rBreports.setSelected(false);
        rBcancel_sale.setSelected(false);
        rBabandoned_sale.setSelected(false);
        rBRemoveProductListSale.setSelected(false);
    }
    
    public void addUser () {
        if(tfLogin.getText().equals("") || tfPassword.getText().equals("")) { 
            alertDialog = new ViewShowAlertDialog(this, true, "Required fields!", "Alert");
        }else{
            user.setLogin(tfLogin.getText());
            user.setName(tfName.getText());
            user.setPassword(tfPassword.getText());
            if(users.saveUser(user) > 0){
               user = users.searchForLogin(user.getLogin());
               addServices(user);
               mensageDialog = new ViewShowSuccessDialog(this, true, "Success");
            } 
        }
    }
    
    public void updateService (User user) { 
        AddServices addServices = new AddServices();
        if (rBcancel_sale.isSelected()) {
            CANCEL_SALE = 1;
        } else {
            CANCEL_SALE = 0;
        }
        addServices = new AddServices();
        addServices.updateServicesForConfiguration(user, this.services, 
            Services.CANCEL_SALE.getSigla(), Services.CANCEL_SALE.getDesc(), CANCEL_SALE);
        
        if (rBregistration_client.isSelected()) {
            REGISTRATION_CLIENT = 1;
        } else {
            REGISTRATION_CLIENT = 0;
        }
        addServices = new AddServices();
        addServices.updateServicesForConfiguration(user, this.services, 
            Services.REGISTRATION_CLIENT.getSigla(), Services.REGISTRATION_CLIENT.getDesc(), REGISTRATION_CLIENT);
        
        this.services = new ServiceController();
        if (rBRegistration_user.isSelected()) {
            REGISTRATION_USER = 1;
        } else {
            REGISTRATION_USER = 0;
        } 
        
        addServices = new AddServices();
        addServices.updateServicesForConfiguration(user, this.services, 
            Services.REGISTRATION_USER.getSigla(), Services.REGISTRATION_USER.getDesc(), REGISTRATION_USER);
         
        if (rBregistration_inventory.isSelected()) {
            REGISTRATION_INVENTORY = 1;
        } else {
            REGISTRATION_INVENTORY = 0;
        }
        addServices = new AddServices();
        addServices.updateServicesForConfiguration(user, this.services, 
            Services.REGISTRATION_INVENTORY.getSigla(), Services.REGISTRATION_INVENTORY.getDesc(), REGISTRATION_INVENTORY);
        
        if (rBreports.isSelected()) {
           REPORT = 1;
        } else {
           REPORT = 0;
        }
        addServices = new AddServices();
        addServices.updateServicesForConfiguration(user, this.services, 
            Services.REPORTS.getSigla(), Services.REPORTS.getDesc(), REPORT);
        
        if (rBabandoned_sale.isSelected()) {
            ABANDON_SALE = 1;
        } else {
            ABANDON_SALE = 0; 
        }
        addServices = new AddServices();
        addServices.updateServicesForConfiguration(user, this.services, 
            Services.ABANDONED_SALE.getSigla(), Services.ABANDONED_SALE.getDesc(), ABANDON_SALE);
        
        if (rBRemoveProductListSale.isSelected()) {
            REMOV_PRO_SALE = 1;
        } else {
            REMOV_PRO_SALE = 0;
        }
        addServices = new AddServices();
        addServices.updateServicesForConfiguration(user, this.services, 
                Services.REMOV_PROD.getSigla(), Services.REMOV_PROD.getDesc(), REMOV_PRO_SALE);
    }
    
    public void addServices (User user) {
    if (rBcancel_sale.isSelected()) {
        CANCEL_SALE = 1;
    } else {
        CANCEL_SALE = 0;
    }
    addServices.addServicesForConfiguration(user, this.services, 
            Services.CANCEL_SALE.getSigla(), Services.CANCEL_SALE.getDesc(), CANCEL_SALE);
            
    if (rBregistration_client.isSelected()) {
        REGISTRATION_CLIENT = 1;
    } else {
        REGISTRATION_CLIENT = 0;
    }
    addServices.addServicesForConfiguration(user, this.services, 
            Services.REGISTRATION_CLIENT.getSigla(), Services.REGISTRATION_CLIENT.getDesc(), REGISTRATION_CLIENT);
           
    if (rBRegistration_user.isSelected()) {
        REGISTRATION_USER = 1;
    } else {
        REGISTRATION_USER = 0;
    }
    addServices.addServicesForConfiguration(user, this.services, 
            Services.REGISTRATION_USER.getSigla(), Services.REGISTRATION_USER.getDesc(), REGISTRATION_USER);
           
    if (rBregistration_inventory.isSelected()) {
        REGISTRATION_INVENTORY = 1;
    } else {
        REGISTRATION_INVENTORY = 0;
    }
    addServices.addServicesForConfiguration(user, this.services, 
            Services.REGISTRATION_INVENTORY.getSigla(), Services.REGISTRATION_INVENTORY.getDesc(), REGISTRATION_INVENTORY);
           
    if (rBreports.isSelected()) {
        REPORT = 1;
    } else {
        REPORT = 0;
    }
    addServices.addServicesForConfiguration(user, this.services, 
            Services.REPORTS.getSigla(), Services.REPORTS.getDesc(), REPORT);
    
    if (rBabandoned_sale.isSelected()) {
        ABANDON_SALE = 1;
    } else {
        ABANDON_SALE = 0;
    }
    addServices.addServicesForConfiguration(user, this.services, 
            Services.ABANDONED_SALE.getSigla(), Services.ABANDONED_SALE.getDesc(), ABANDON_SALE);
    
    if (rBRemoveProductListSale.isSelected()) {
        REMOV_PRO_SALE = 1;
    } else {
        REMOV_PRO_SALE = 0;
    }
    addServices.addServicesForConfiguration(user, this.services, 
            Services.REMOV_PROD.getSigla(), Services.REMOV_PROD.getDesc(), REMOV_PRO_SALE);
    
    }
    
    public void update () {
        if(tfLogin.getText().equals("") || tfPassword.getText().equals("")) { 
            alertDialog = new ViewShowAlertDialog(this, true, "Required fields!", "Alert");
        }else{
            user.setId(Integer.parseInt(tfCode.getText()));
            user.setName(tfName.getText());
            user.setLogin(tfLogin.getText());
            user.setPassword(tfPassword.getText());
            
            if (users.updateUser(user)) {
                updateService(user);
                mensageDialog = new ViewShowSuccessDialog(this, true, "Updated successfully");
                JbAddOrUpdate.setText("Add");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JpUser = new javax.swing.JPanel();
        jPRoles = new javax.swing.JPanel();
        rBRegistration_user = new javax.swing.JRadioButton();
        rBregistration_client = new javax.swing.JRadioButton();
        rBregistration_inventory = new javax.swing.JRadioButton();
        rBcancel_sale = new javax.swing.JRadioButton();
        rBreports = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rBabandoned_sale = new javax.swing.JRadioButton();
        rBRemoveProductListSale = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JbAddOrUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfPassword = new javax.swing.JPasswordField();
        jLPassword = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jLName = new javax.swing.JLabel();
        tfCode = new javax.swing.JTextField();
        jLName1 = new javax.swing.JLabel();
        jLName2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User registration ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JpUser.setBackground(new java.awt.Color(255, 255, 255));
        JpUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JpUser.setForeground(new java.awt.Color(255, 255, 255));

        jPRoles.setBackground(new java.awt.Color(255, 255, 255));
        jPRoles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPRoles.setForeground(new java.awt.Color(255, 255, 255));

        rBRegistration_user.setBackground(new java.awt.Color(255, 255, 255));
        rBRegistration_user.setText("Cadastrar usuários");
        rBRegistration_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rBRegistration_userMouseClicked(evt);
            }
        });
        rBRegistration_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRegistration_userActionPerformed(evt);
            }
        });

        rBregistration_client.setBackground(new java.awt.Color(255, 255, 255));
        rBregistration_client.setText("Cadastrar cliente");
        rBregistration_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBregistration_clientActionPerformed(evt);
            }
        });

        rBregistration_inventory.setBackground(new java.awt.Color(255, 255, 255));
        rBregistration_inventory.setText("Cadastrar estoque");
        rBregistration_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBregistration_inventoryActionPerformed(evt);
            }
        });

        rBcancel_sale.setBackground(new java.awt.Color(255, 255, 255));
        rBcancel_sale.setText("Cancelar venda");
        rBcancel_sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rBcancel_saleMouseClicked(evt);
            }
        });
        rBcancel_sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBcancel_saleActionPerformed(evt);
            }
        });

        rBreports.setBackground(new java.awt.Color(255, 255, 255));
        rBreports.setText("Relatório de vendas");
        rBreports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBreportsActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(194, 80, 84));
        jLabel1.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("O que esse usuário pode ter acesso");

        rBabandoned_sale.setBackground(new java.awt.Color(255, 255, 255));
        rBabandoned_sale.setText("Abandonar venda");
        rBabandoned_sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rBabandoned_saleMouseClicked(evt);
            }
        });
        rBabandoned_sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBabandoned_saleActionPerformed(evt);
            }
        });

        rBRemoveProductListSale.setBackground(new java.awt.Color(255, 255, 255));
        rBRemoveProductListSale.setText("Remover produto da lista da venda");
        rBRemoveProductListSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rBRemoveProductListSaleMouseClicked(evt);
            }
        });
        rBRemoveProductListSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRemoveProductListSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPRolesLayout = new javax.swing.GroupLayout(jPRoles);
        jPRoles.setLayout(jPRolesLayout);
        jPRolesLayout.setHorizontalGroup(
            jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRolesLayout.createSequentialGroup()
                .addGroup(jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPRolesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPRolesLayout.createSequentialGroup()
                        .addGroup(jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rBRegistration_user)
                            .addComponent(rBregistration_client)
                            .addComponent(rBreports))
                        .addGap(99, 99, 99)
                        .addGroup(jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rBcancel_sale)
                            .addComponent(rBregistration_inventory)
                            .addComponent(rBabandoned_sale)
                            .addComponent(rBRemoveProductListSale))))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPRolesLayout.setVerticalGroup(
            jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBRegistration_user)
                    .addComponent(rBregistration_inventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBcancel_sale)
                    .addComponent(rBreports))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBregistration_client)
                    .addComponent(rBabandoned_sale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBRemoveProductListSale)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JbAddOrUpdate.setBackground(new java.awt.Color(255, 255, 255));
        JbAddOrUpdate.setText("Add");
        JbAddOrUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbAddOrUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAddOrUpdateActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLPassword.setBackground(new java.awt.Color(153, 153, 153));
        jLPassword.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLPassword.setText("*Senha:");

        jLName.setBackground(new java.awt.Color(153, 153, 153));
        jLName.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName.setText("*Login:");

        tfCode.setEnabled(false);

        jLName1.setBackground(new java.awt.Color(153, 153, 153));
        jLName1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName1.setText("Código:");

        jLName2.setBackground(new java.awt.Color(153, 153, 153));
        jLName2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName2.setText("*Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLName1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLName)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLPassword)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLName2)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLName2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLName)
                            .addComponent(jLName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfLogin)
                            .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpUserLayout = new javax.swing.GroupLayout(JpUser);
        JpUser.setLayout(JpUserLayout);
        JpUserLayout.setHorizontalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPRoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpUserLayout.createSequentialGroup()
                        .addGap(0, 465, Short.MAX_VALUE)
                        .addComponent(JbAddOrUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpUserLayout.setVerticalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(JbAddOrUpdate))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
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

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UserListView v = new UserListView();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JbAddOrUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAddOrUpdateActionPerformed
        if (!tfCode.getText().equals("")) {
            update();
        } else {
            addUser();
        }
        clearFields ();
    }//GEN-LAST:event_JbAddOrUpdateActionPerformed

    private void rBRegistration_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRegistration_userActionPerformed
      
    }//GEN-LAST:event_rBRegistration_userActionPerformed

    private void rBreportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBreportsActionPerformed
      
    }//GEN-LAST:event_rBreportsActionPerformed

    private void rBregistration_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBregistration_clientActionPerformed
      
    }//GEN-LAST:event_rBregistration_clientActionPerformed

    private void rBregistration_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBregistration_inventoryActionPerformed
        
    }//GEN-LAST:event_rBregistration_inventoryActionPerformed

    private void rBcancel_saleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBcancel_saleActionPerformed
       
    }//GEN-LAST:event_rBcancel_saleActionPerformed

    private void rBRegistration_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rBRegistration_userMouseClicked
       
        
    }//GEN-LAST:event_rBRegistration_userMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rBcancel_saleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rBcancel_saleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rBcancel_saleMouseClicked

    private void rBabandoned_saleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rBabandoned_saleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rBabandoned_saleMouseClicked

    private void rBabandoned_saleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBabandoned_saleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBabandoned_saleActionPerformed

    private void rBRemoveProductListSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rBRemoveProductListSaleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rBRemoveProductListSaleMouseClicked

    private void rBRemoveProductListSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRemoveProductListSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBRemoveProductListSaleActionPerformed

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
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton JbAddOrUpdate;
    private javax.swing.JPanel JpUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLName1;
    private javax.swing.JLabel jLName2;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPRoles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JRadioButton rBRegistration_user;
    public static javax.swing.JRadioButton rBRemoveProductListSale;
    public static javax.swing.JRadioButton rBabandoned_sale;
    public static javax.swing.JRadioButton rBcancel_sale;
    public static javax.swing.JRadioButton rBregistration_client;
    public static javax.swing.JRadioButton rBregistration_inventory;
    public static javax.swing.JRadioButton rBreports;
    public static javax.swing.JTextField tfCode;
    public static javax.swing.JTextField tfLogin;
    public static javax.swing.JTextField tfName;
    public static javax.swing.JPasswordField tfPassword;
    // End of variables declaration//GEN-END:variables
}
