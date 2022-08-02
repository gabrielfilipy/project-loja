package View;

import Components.ViewShowAlertDialog;
import Components.ViewShowErrorDialog;
import Components.ViewShowInputDoubleValueDialog;
import Components.ViewShowInputValueDialog;
import Components.ViewShowSuccessDialog;
import Controller.*;
import Model.*;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class StockProductView extends javax.swing.JFrame {

    private ViewShowErrorDialog errorDialog;
    private ViewShowSuccessDialog mensageDialog;
    private ViewShowAlertDialog alertDialog;
    private ViewShowInputValueDialog insertValueDialog;
    private ViewShowInputDoubleValueDialog insertValueDoubleDialog;
    
    Stock stock = new Stock();
    StockController stocks = new StockController();
   
    Provider provider = new Provider();
    ProviderController providers = new ProviderController();
    
    Department department = new Department();
    DepartmentController departments = new DepartmentController();
    
    User user = new User();
    UserController users = new UserController();
    
     int registration_user ;
     int registration_client ;
     int registration_inventory;
     int canel_sale ;
     int reports ;
     
    public StockProductView() {
        initComponents();
        setIcon();
        clearFields ();
    }
    
    public static void LIST_PROVIDER(){
    jCProviders.removeAllItems();
    List<Provider> listProviders = new ArrayList<>();
    ProviderController providers = new ProviderController();
    listProviders = providers.collection();
        for (Provider p : listProviders) {
            jCProviders.addItem(p.getName());
        }
    }
    
    public static void LIST_DEPARTMENT(){
    jComboDepartment.removeAllItems();
    List<Department> listDepartment = new ArrayList<>();
    DepartmentController departments = new DepartmentController();
    listDepartment = departments.collection();
        for (Department d: listDepartment) {
            jComboDepartment.addItem(d.getName());
        }
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    public void clearFields () {
        tfName.setText("");
        tfStock.setText("0");
        tfCode.setText("");
        tfCodeVerification.setText("");
        jComboDepartment.setSelectedItem("None");
        jCProviders.setSelectedItem("None");
        tfValueInvest.setText("");
        tfCodeVerification.requestFocus();
        LIST_PROVIDER();
        LIST_DEPARTMENT();
    }
    
    public void add () {
        if(tfName.getText().equals("") || tfStock.getText().equals("")) { 
            alertDialog = new ViewShowAlertDialog(this, true, "Todos os campos são obrigatórios.!", "Alert");
        }else{
            stock.setName(tfName.getText().toUpperCase());
            stock.setValue_invest(Double.parseDouble(tfValueInvest.getText()));
            stock.setCode_verification(tfCodeVerification.getText());
            department = departments.searchForName(jComboDepartment.getSelectedItem() + "");
            stock.setDepartment_id(department.getId());
            provider = providers.searchForName(jCProviders.getSelectedItem() + "");
            stock.setProvider_id(provider.getId());
            stock.setStock(Integer.parseInt(tfStock.getText()));
            user = users.searchUserOnline();
            stock.setUser_id(user.getId());
            stock.setValue_single(Double.parseDouble(tfValueSingle.getText()));
            if(stocks.save(stock) > 0){
                    mensageDialog = new ViewShowSuccessDialog(this, true, "Success");
            } 
        }
    }
    
    public void update () {
        if(tfName.getText().equals("") || tfStock.getText().equals("") 
                || tfCode.getText().equals("") || tfCodeVerification.getText().equals("")
                || tfValueInvest.getText().equals("")) {
            alertDialog = new ViewShowAlertDialog(this, true, "Required fields!", "Alert");
        } else {
            stock.setStock(Integer.parseInt(tfStock.getText()));
            stock.setId(Integer.parseInt(tfCode.getText()));
            stock.setName(tfName.getText().toUpperCase());
            stock.setValue_invest(Double.parseDouble(tfValueInvest.getText()));
            stock.setCode_verification(tfCodeVerification.getText());
            department = departments.searchForName(jComboDepartment.getSelectedItem() + "");
            stock.setDepartment_id(department.getId());
            provider = providers.searchForName(jCProviders.getSelectedItem() + "");
            stock.setProvider_id(provider.getId());
            user = users.searchUserOnline(); 
            stock.setUser_id(user.getId());
            stock.setValue_single(Double.parseDouble(tfValueSingle.getText()));
            if (stocks.update(stock)) {
                mensageDialog = new ViewShowSuccessDialog(this, true, "Updated successfully.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JpUser = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLName1 = new javax.swing.JLabel();
        tfCode = new javax.swing.JTextField();
        jLPassword3 = new javax.swing.JLabel();
        tfCodeVerification = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        jLName = new javax.swing.JLabel();
        tfStock = new javax.swing.JTextField();
        jLPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfValueInvest = new javax.swing.JTextField();
        jLPassword1 = new javax.swing.JLabel();
        jLPassword2 = new javax.swing.JLabel();
        tfValueSingle = new javax.swing.JTextField();
        jLName2 = new javax.swing.JLabel();
        jCProviders = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLName3 = new javax.swing.JLabel();
        jComboDepartment = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock registration ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JpUser.setBackground(new java.awt.Color(255, 255, 255));
        JpUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JpUser.setForeground(new java.awt.Color(255, 255, 255));

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

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Withdraw");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLName1.setBackground(new java.awt.Color(153, 153, 153));
        jLName1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName1.setText("ID:");

        tfCode.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tfCode.setEnabled(false);

        jLPassword3.setBackground(new java.awt.Color(153, 153, 153));
        jLPassword3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLPassword3.setText("*Code:");

        tfCodeVerification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodeVerificationActionPerformed(evt);
            }
        });

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        jLName.setBackground(new java.awt.Color(153, 153, 153));
        jLName.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName.setText("*Name:");

        tfStock.setText("0");
        tfStock.setEnabled(false);
        tfStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStockActionPerformed(evt);
            }
        });

        jLPassword.setBackground(new java.awt.Color(153, 153, 153));
        jLPassword.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLPassword.setText("*Stock:");

        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jLabel1.setToolTipText("Add inventory");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        tfValueInvest.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValueInvestFocusLost(evt);
            }
        });
        tfValueInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValueInvestActionPerformed(evt);
            }
        });
        tfValueInvest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfValueInvestKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValueInvestKeyReleased(evt);
            }
        });

        jLPassword1.setBackground(new java.awt.Color(153, 153, 153));
        jLPassword1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLPassword1.setText("*Value invest:");

        jLPassword2.setBackground(new java.awt.Color(153, 153, 153));
        jLPassword2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLPassword2.setText("*Value sale:");

        tfValueSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValueSingleActionPerformed(evt);
            }
        });

        jLName2.setBackground(new java.awt.Color(153, 153, 153));
        jLName2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName2.setText("provider:");

        jCProviders.setBackground(new java.awt.Color(255, 255, 255));
        jCProviders.setForeground(new java.awt.Color(51, 51, 51));
        jCProviders.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DB", "Carrefour", "Nova era", "Baratão da carne" }));
        jCProviders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCProviders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCProvidersMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCProvidersMousePressed(evt);
            }
        });
        jCProviders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCProvidersActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jLabel3.setToolTipText("Add provider");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLName3.setBackground(new java.awt.Color(153, 153, 153));
        jLName3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName3.setText("*Department:");
        jLName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLName3MousePressed(evt);
            }
        });

        jComboDepartment.setBackground(new java.awt.Color(255, 255, 255));
        jComboDepartment.setForeground(new java.awt.Color(51, 51, 51));
        jComboDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboDepartment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboDepartmentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboDepartmentMousePressed(evt);
            }
        });
        jComboDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDepartmentActionPerformed(evt);
            }
        });
        jComboDepartment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboDepartmentKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboDepartmentKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jLabel4.setToolTipText("Add department");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLName1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLName2)
                            .addComponent(jCProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLName3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLPassword3)
                            .addComponent(tfCodeVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLPassword1)
                                    .addComponent(tfValueInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLPassword2)
                                    .addComponent(tfValueSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLName)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfStock)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfCodeVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfName, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLPassword3)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLName1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLPassword1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValueInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLPassword2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValueSingle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLName2)
                    .addComponent(jLName3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCProviders)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboDepartment)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout JpUserLayout = new javax.swing.GroupLayout(JpUser);
        JpUser.setLayout(JpUserLayout);
        JpUserLayout.setHorizontalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpUserLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JpUserLayout.setVerticalGroup(
            JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addGroup(JpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StockListView v = new StockListView();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!tfCode.getText().equals("")) {
            update();
        } else {
            add();
        }
        clearFields ();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        ProviderView p = new ProviderView();
        p.jBEdit.setEnabled(false);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {  
            insertValueDialog = new ViewShowInputValueDialog(this, true, "Enter amount");
            int value = Integer.parseInt(insertValueDialog.getValue() + "");
            String stock = tfStock.getText();
            int sum;  
            sum = value + Integer.parseInt(stock);
            tfStock.setText(sum+"");
        } catch (Exception e) {
            alertDialog = new ViewShowAlertDialog(this, true, "Por favor insira um número inteiro", "Alert");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jCProvidersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCProvidersActionPerformed
        
    }//GEN-LAST:event_jCProvidersActionPerformed

    private void jCProvidersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCProvidersMouseClicked
      
    }//GEN-LAST:event_jCProvidersMouseClicked

    private void jComboDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboDepartmentMouseClicked
       
    }//GEN-LAST:event_jComboDepartmentMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        DepartmentView v = new DepartmentView();
        v.jBEdit.setEnabled(false);
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jComboDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDepartmentActionPerformed
    
    }//GEN-LAST:event_jComboDepartmentActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        WithDrawView v = new WithDrawView();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tfValueInvestFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValueInvestFocusLost
      
    }//GEN-LAST:event_tfValueInvestFocusLost

    private void tfCodeVerificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodeVerificationActionPerformed
        tfName.requestFocus();
    }//GEN-LAST:event_tfCodeVerificationActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        tfValueInvest.requestFocus();
    }//GEN-LAST:event_tfNameActionPerformed

    private void tfStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStockActionPerformed
        
    }//GEN-LAST:event_tfStockActionPerformed

    private void tfValueInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValueInvestActionPerformed
        tfValueSingle.requestFocus();
    }//GEN-LAST:event_tfValueInvestActionPerformed

    private void tfValueSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValueSingleActionPerformed
        jCProviders.requestFocus();
    }//GEN-LAST:event_tfValueSingleActionPerformed

    private void tfValueInvestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValueInvestKeyPressed
        if (evt.getKeyCode()== evt.VK_ENTER && !tfValueInvest.getText().equals("")) { 
            Double valueInvest = Double.parseDouble(tfValueInvest.getText() + "");
            
            insertValueDoubleDialog = new ViewShowInputDoubleValueDialog(this, true, "What percentage?");
            Double percentage = Double.parseDouble(insertValueDoubleDialog.getValue() + "") / 100.0; 
            Double total = valueInvest + (percentage * valueInvest);
            if (total > 0) {
                Double valueSingle = total;
                if (valueSingle > 0) {
                    insertValueDoubleDialog = new ViewShowInputDoubleValueDialog(this, true, "What how many units/weight?");
                    int share = Integer.parseInt(insertValueDoubleDialog.getValue() + "");
                    if (share > 0) {
                        tfValueSingle.setText(valueSingle / share + "");
                    }
                }
            }
        }
    }//GEN-LAST:event_tfValueInvestKeyPressed

    private void tfValueInvestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValueInvestKeyReleased
        
    }//GEN-LAST:event_tfValueInvestKeyReleased

    private void jComboDepartmentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboDepartmentMousePressed
        
    }//GEN-LAST:event_jComboDepartmentMousePressed

    private void jComboDepartmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboDepartmentKeyPressed
        
    }//GEN-LAST:event_jComboDepartmentKeyPressed

    private void jComboDepartmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboDepartmentKeyReleased
        
    }//GEN-LAST:event_jComboDepartmentKeyReleased

    private void jLName3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLName3MousePressed
        
    }//GEN-LAST:event_jLName3MousePressed

    private void jCProvidersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCProvidersMousePressed
        
    }//GEN-LAST:event_jCProvidersMousePressed

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
            java.util.logging.Logger.getLogger(StockProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JComboBox jCProviders;
    public static javax.swing.JComboBox jComboDepartment;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLName1;
    private javax.swing.JLabel jLName2;
    private javax.swing.JLabel jLName3;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLPassword1;
    private javax.swing.JLabel jLPassword2;
    private javax.swing.JLabel jLPassword3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField tfCode;
    public static javax.swing.JTextField tfCodeVerification;
    public static javax.swing.JTextField tfName;
    public static javax.swing.JTextField tfStock;
    public static javax.swing.JTextField tfValueInvest;
    public static javax.swing.JTextField tfValueSingle;
    // End of variables declaration//GEN-END:variables
}
