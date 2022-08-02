package View;

import Components.ViewShowAlertDialog;
import Components.ViewShowErrorDialog;
import Components.AddImage;
import Components.ViewShowSuccessDialog;
import Conexao.ConnectionSingleServer;
import Controller.ConfigController;
import Controller.Enums.Path;
import Controller.Enums.Services;
import Controller.ServiceController;
import Controller.SettingController;
import Controller.UserController;
import Dao.CreateDataBase.CreateIfNotExist;
import Model.Conf;
import Model.Service;
import Model.SettingSystem;
import Model.User;
import Repository.ServiceForConfiguration;
import Util.AddServices;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class LoginView extends javax.swing.JFrame {
    
    ViewSplash inicio; 
    
    private static String REGUSER = Services.REGISTRATION_USER.getSigla();
    private static String REGINV = Services.REGISTRATION_INVENTORY.getSigla();
    private static String REGCLI = Services.REGISTRATION_CLIENT.getSigla();
    private static String REPORTS = Services.REPORTS.getSigla();
    private static String PRODUCT = Services.REGISTRATION_PRODUCT.getSigla();
    
    ServiceController services = new ServiceController();
    Service service = new Service();
    
    ServiceForConfiguration serviceForConfiguration = new ServiceForConfiguration();
    
    private static String SIGLA = "ADMIN";
    private static String NAME_USER = "Administrador";
    
    private ViewShowErrorDialog errorDialog;
    private ViewShowAlertDialog alertDialog;
    private AddImage welcomeSystemDialog;
    
    ConfigController configs = new ConfigController();
    UserController users = new UserController();
    User user = new User();
    
    AddServices addServices = new AddServices();
    
    public LoginView() {
        initComponents();
        setLocationRelativeTo(null);
        setIcon();
    }
    
    public LoginView(ViewSplash inicio) throws SQLException, Exception{
        this.inicio = inicio;
        setProgress(0, "Inicializando...");
        initComponents();
        setProgress(20, "Conectando ao Servidor..."); 
            if (testConnectionDataBase()) {
                User user = new User();
                user = users.searchForLogin(SIGLA);
                if (!user.existUser()) {
                    user.setPassword(SIGLA);
                    user.setLogin(SIGLA);
                    user.setName(NAME_USER); 
                    users.saveUser(user);
                    user = users.searchForLogin(SIGLA);
                    for (Services service: Services.values()) {
                        this.service = this.services.searchServiceForSigla(service.getSigla());
                        if (!this.service.existsService())
                            addServices.addServicesForConfiguration(user, this.services, service.getSigla(), service.getDesc(), 1);
                    }
                }
                setProgress(23, "Carregando estoque...");  
                if (!testeTableProductSale()) {
                    errorDialog = new ViewShowErrorDialog(this, true, "Erro ao carregar estoque!", "Error");
                    throw new Exception();
                }
                setProgress(24, "Carregando tabela de usuários..."); 
                if (!testeTableUser ()) {
                    errorDialog = new ViewShowErrorDialog(this, true, "Erro ao analisar tabela de usuários!", "Error");
                    throw new Exception();
                }
                setProgress(25, "Carregango tabela dos clientes..."); 
                if (!testeTableClientes ()) {
                    errorDialog = new ViewShowErrorDialog(this, true, "Erro ao carregar tabela dos clientes!", "Error");
                    throw new Exception();
                }
                setProgress(26, "Aguarde mais um pouco...");
                setProgress(30, "Verificando usuário dessa máquina...");
                if (!testeTableClientes ()) {
                    errorDialog = new ViewShowErrorDialog(this, true, "Erro ao carregar possível usuário logado!", "Error");
                    throw new Exception();
                }
                setProgress(41, "Informações da empresa...");
                if (!loadSettingCompany ()) {
                    errorDialog = new ViewShowErrorDialog(this, true, "Erro ao adicionar informações da empresa!", "Error");
                    throw new Exception();
                }
                setProgress(98, "Servidor quase completo...");
                setProgress(99, "Só mais um pouco...");
                setProgress(100, "Pronto. Nenhum erro!");
                //this.setSize(410,500); 
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        btnLogar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tfName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tfName.setToolTipText("");
        tfName.setAutoscrolls(false);
        tfName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tfName.setMargin(new java.awt.Insets(0, 50, 0, 0));
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        tfPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });
        tfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPasswordKeyReleased(evt);
            }
        });

        btnLogar.setBackground(new java.awt.Color(75, 138, 189));
        btnLogar.setForeground(new java.awt.Color(255, 255, 255));
        btnLogar.setText("Logar");
        btnLogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfName)
                    .addComponent(tfPassword)
                    .addComponent(btnLogar, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        tfName.getAccessibleContext().setAccessibleName("");

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

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        tfPassword.requestFocus();
        verificationAndLogar();
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void verificationAndLogar() {
        String us = tfName.getText();
        String pass = tfPassword.getText();
        if(us.equals("") || pass.equals("")){
            alertDialog = new ViewShowAlertDialog(this, true, "Required fields", "Alert");
        }else{
            logar();
        }
    }
    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        verificationAndLogar();
    }//GEN-LAST:event_btnLogarActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        tfPassword.requestFocus();
    }//GEN-LAST:event_tfNameActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void tfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswordKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordKeyReleased

    private void tfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswordKeyPressed
     
    }//GEN-LAST:event_tfPasswordKeyPressed
    
    public void logar(){ 
    try { 
        ConnectionSingleServer con = new ConnectionSingleServer();      
        Connection cn = con.connectWithServer(); 
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "SELECT *from tbl_user where login = ? and password = ?";
        pst = cn.prepareStatement(sql); 
        pst.setString(1, tfName.getText());
        pst.setString(2, tfPassword.getText()); 
        rs = pst.executeQuery(); 
        if(rs.next()) {  
            String nome = rs.getString(2);
            HomeView home = new HomeView();
            user = users.searchUserOnline();
            if (user.existUser()) {
                user.setId(rs.getInt(1));
                users.saveWithHistoric(user);
                users.addUserOnline(user);
            } else {
                user.setId(rs.getInt(1));
                users.addUserOnline(user);
            }
               home.tfName.setText("Welcome, "  +nome); 
               home.setVisible(true);
               
               serviceForConfiguration = new ServiceForConfiguration();
               if (serviceForConfiguration.have(user, REGUSER)) 
                   home.jmUser.setEnabled(true); 
               
               if (serviceForConfiguration.have(user, REGCLI)) 
                   home.jmClient.setEnabled(true);
               
               if (serviceForConfiguration.have(user, REPORTS)) 
                   home.jmReport.setEnabled(true);
           
               if (serviceForConfiguration.have(user, PRODUCT))
                   home.jmProduct.setEnabled(true);
               
               if (serviceForConfiguration.have(user, REGINV))
                   home.JmStock.setEnabled(true);  
                   
               dispose();
             }
        } catch (Exception e) {
            System.out.println(">> " + e);
            errorDialog = new ViewShowErrorDialog(this, true, "Error: " + e, "Error" );
        }
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }  
    
    public void init () throws SQLException {
        ConnectionSingleServer c = new ConnectionSingleServer(); 
        c.runScript();
    }
    
    public Boolean testConnectionDataBase () throws SQLException {
        Boolean create = false;
        CreateIfNotExist c = new CreateIfNotExist();
        create = c.dataBaseExist();
        init ();
        return create;
    }
    
    public Boolean testeTableProductSale () {
        ConnectionSingleServer con = new ConnectionSingleServer();      
        Connection cn = con.connectWithServer(); 
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT *from tbl_product_for_sale";
        try { 
            pst = cn.prepareStatement(sql); 
            rs = pst.executeQuery(); 
            if(rs.getRow() >= 0)  
            {  
              return true;
            } 
        } catch (Exception e) {
            
        }
        return false;
    }
    
    public Boolean testeTableUser () {
        ConnectionSingleServer con = new ConnectionSingleServer();      
        Connection cn = con.connectWithServer(); 
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT *from tbl_user";
        try { 
            pst = cn.prepareStatement(sql); 
            rs = pst.executeQuery(); 
            if(rs.getRow() >= 0)  
            {  
              return true;
            } 
        } catch (Exception e) {
            
        }
        return false;
    }
    
    public Boolean testeTableClientes () {
        ConnectionSingleServer con = new ConnectionSingleServer();      
        Connection cn = con.connectWithServer(); 
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT *from tbl_client";
        try { 
            pst = cn.prepareStatement(sql); 
            rs = pst.executeQuery(); 
            if(rs.getRow() >= 0) 
            {  
              return true;
            } 
        } catch (Exception e) {
            
        }
        return false;
    }
    
    public Boolean testeTableUserOnline () {
        ConnectionSingleServer con = new ConnectionSingleServer();      
        Connection cn = con.connectWithServer();
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT *from tbl_user_online";
        try { 
            pst = cn.prepareStatement(sql); 
            rs = pst.executeQuery(); 
            if(rs.getRow() >= 0) 
            {  
              return true;
            } 
        } catch (Exception e) {
            
        }
        return false;
    }
    
    public Boolean loadSettingCompany () {
        SettingSystem settingSystem = new SettingSystem();
        SettingController settings = new SettingController();
        settingSystem = settings.search("EMP");
        System.out.println(">> settingSystem.getId(): " + settingSystem.getId());
        if (settingSystem.getId() == 0) {
            String fotoname = "logo-home";
            settingSystem.setAddress("Rua 16 de julhos, 537, São Francisco."); 
            settingSystem.setCnpj("45.543.915/0001-81");
            settingSystem.setFoto(fotoname);
            settingSystem.setName("Monet Design e Sistema");
            settingSystem.setSigla("EMP");
            if (settings.save(settingSystem) > 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                new LoginView().setVisible(true);
            }
        });
    }
    
    void setProgress(int percent, String informacao){
        inicio.getJLabel().setText(informacao);
        inicio.getJProgressBar().setValue(percent);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível carregar a inicialização");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField tfName;
    private javax.swing.JPasswordField tfPassword;
    // End of variables declaration//GEN-END:variables
}

