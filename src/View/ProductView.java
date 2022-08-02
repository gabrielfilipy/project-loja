package View;

import Components.AddImage;
import Components.ViewShowAlertDialog;
import Components.ViewShowErrorDialog;
import Components.ViewShowInputValueDialog;
import Components.ViewShowSuccessDialog;
import Controller.Enums.Path;
import Controller.ProductController;
import Controller.StockController;
import Exception.ImpossibleThisAction;
import Model.Product;
import Model.Stock;
import Util.*;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ProductView extends javax.swing.JFrame {
    
    private ViewShowAlertDialog alertDialog;
    private ViewShowErrorDialog errorDialog;
    private ViewShowInputValueDialog insertValueDialog;
    private AddImage addImage;
    private ViewShowSuccessDialog successDialog;
    
    public  boolean updateFoto = false;
    long fotoSerial = new Date().getTime();
    
    Product o = new Product();
    ProductController products = new ProductController();
    Stock stock = new Stock();
    StockController stocks = new StockController();
    BufferedImage image;
    private String imageName = "";
    String fotoname; 
    
    public ProductView() {
        initComponents();
//        setIcon();
        clearFields ();
    }
    
    private void setIcon() {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon-system.png"))); 
    }
    
    public void clearFields () {
        tfName.setText("");
        tfStock.setText("0");
        tfValueSale.setText("");
        tfCode.setText("");
        tfCodeVerification.setText("");
        tfImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/not-file.png")));
        tfCodeVerification.requestFocus();
        updateFoto = false;
        //tfValueSale.setEnabled(false);
    }
    
    public void add () {
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        fotoname = "FOTO" + fotoSerial;
        if(tfName.getText().equals("") || tfCodeVerification.getText().equals("") 
                || tfStock.getText().equals("0") || tfStock.getText().equals("0") 
                || tfValueSale.getText().equals("")) { 
            alertDialog = new ViewShowAlertDialog(this, true, "Alguns campos são obrigatórios.", "Alerta");
        }else{
            o.setName(tfName.getText());
            o.setCode_verification(tfCodeVerification.getText());
            o.setDateAndHours(d.format(LocalDateTime.now()) + "");
            if (updateFoto)
                o.setImage(fotoname);
            else 
                o.setImage("not-file");
            o.setStock(Integer.parseInt(tfStock.getText()));
            o.setStock_id(1);
            o.setUser_id(1);
            o.setValue_sale(Double.parseDouble(tfValueSale.getText()));
            if(products.save(o) > 0){
             try {
                stock.setStock(stocks.searchForCodeVerication(tfCodeVerification.getText()).getStock() - Integer.parseInt(String.valueOf(tfStock.getText()))); 
                stocks.alterStockSingle(stock);
                //String caminho = getClass().getResource("../image/").toString().substring(5);
                String caminho = Path.PATH_IMAGE.getPath();
                //System.out.println(">> getImage(): " + getImage());
                File outputfile = new File(caminho + fotoname);
                if (getImage() != null)
                    ImageIO.write(getImage(), "jpeg", outputfile);
             } catch (IOException ex) {
                Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
             }
               successDialog = new ViewShowSuccessDialog(this, true, "Produto adicionado com sucesso.");
               tfImg.setIcon(new javax.swing.ImageIcon(Path.PATH_IMAGE.getPath() + "not-file.jpg"));
               clearFields ();
            } 
        }
    }
    
    public void update () {
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if(tfName.getText().equals("") || tfCodeVerification.getText().equals("") 
                || tfStock.getText().equals("0") || tfStock.getText().equals("0") 
                || tfValueSale.getText().equals("")) {
            alertDialog = new ViewShowAlertDialog(this, true, "Alguns campos são obrigatórios.", "Alerta");
        } else {
            String nameFotoUpdate = jLDescritionFoto.getText();
            if (nameFotoUpdate.equals("not-file.jpeg"))
                nameFotoUpdate = "FOTO" + fotoSerial;
            nameFotoUpdate = StringUtils.removeEnd(nameFotoUpdate, ".jpeg");
            o.setName(tfName.getText());
            o.setCode_verification(tfCodeVerification.getText());
            o.setDateAndHours(d.format(LocalDateTime.now()) + "");
            o.setImage(nameFotoUpdate);
            o.setStock(Integer.parseInt(tfStock.getText()));
            o.setStock_id(1);
            o.setUser_id(1);
            o.setValue_sale(Double.parseDouble(tfValueSale.getText()));
            o.setId(Integer.parseInt(tfCode.getText()));
            if (products.update(o)) {
                if (updateFoto) {
                    try {
                    String caminho = Path.PATH_IMAGE.getPath();
                    File outputfile = new File(caminho + nameFotoUpdate);
                    outputfile.delete(); 
                    if (getImage() != null)
                        ImageIO.write(getImage(), "jpeg", outputfile);
                    } catch (IOException ex) {
                       Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                successDialog = new ViewShowSuccessDialog(this, true, "Produto adicionado com sucesso."); 
                clearFields ();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        jLName = new javax.swing.JLabel();
        tfCodeVerification = new javax.swing.JTextField();
        jLName2 = new javax.swing.JLabel();
        jLName1 = new javax.swing.JLabel();
        jLName3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        tfCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        tfCode1 = new javax.swing.JTextField();
        tfCode2 = new javax.swing.JTextField();
        tfCode3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        tfCode4 = new javax.swing.JTextField();
        tfCode5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCode6 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        tfCode7 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        tfCode8 = new javax.swing.JTextField();
        jLName4 = new javax.swing.JLabel();
        tfCode9 = new javax.swing.JTextField();
        jLName5 = new javax.swing.JLabel();
        tfCode10 = new javax.swing.JTextField();
        jLName6 = new javax.swing.JLabel();
        tfCode11 = new javax.swing.JTextField();
        tfCode12 = new javax.swing.JTextField();
        tfCode13 = new javax.swing.JTextField();
        jLName7 = new javax.swing.JLabel();
        jLName8 = new javax.swing.JLabel();
        jLName9 = new javax.swing.JLabel();
        tfCode14 = new javax.swing.JTextField();
        jLName10 = new javax.swing.JLabel();
        jLName11 = new javax.swing.JLabel();
        tfCode15 = new javax.swing.JTextField();
        jLName12 = new javax.swing.JLabel();
        tfCode17 = new javax.swing.JTextField();
        tfCode18 = new javax.swing.JTextField();
        tfCode19 = new javax.swing.JTextField();
        jLName13 = new javax.swing.JLabel();
        jLName14 = new javax.swing.JLabel();
        jLName15 = new javax.swing.JLabel();
        tfValueSale = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        tfStock = new javax.swing.JTextField();
        jLName16 = new javax.swing.JLabel();
        tfCode21 = new javax.swing.JTextField();
        jLName17 = new javax.swing.JLabel();
        tfCode22 = new javax.swing.JTextField();
        jLName18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbAddOrUpdate = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLDescritionFoto = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tfImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product registration ");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLName.setBackground(new java.awt.Color(153, 153, 153));
        jLName.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("*Name:");

        tfCodeVerification.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tfCodeVerification.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodeVerificationKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodeVerificationKeyReleased(evt);
            }
        });

        jLName2.setBackground(new java.awt.Color(153, 153, 153));
        jLName2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName2.setText("Code verification:");

        jLName1.setBackground(new java.awt.Color(153, 153, 153));
        jLName1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName1.setText("Code:");

        jLName3.setBackground(new java.awt.Color(153, 153, 153));
        jLName3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName3.setText("Active:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        tfCode.setEditable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Unidade medida:");

        jButton4.setText("jButton4");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Grupo do produto:");

        jButton5.setText("jButton4");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Almoxarifado:");

        jButton6.setText("jButton4");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações complementares"));

        tfCode8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode8.setText("0");

        jLName4.setBackground(new java.awt.Color(153, 153, 153));
        jLName4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName4.setText("Redução ICMS (%):");

        tfCode9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode9.setText("0");

        jLName5.setBackground(new java.awt.Color(153, 153, 153));
        jLName5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName5.setText("COFNS:");

        tfCode10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode10.setText("0");

        jLName6.setBackground(new java.awt.Color(153, 153, 153));
        jLName6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName6.setText("PIS:");

        tfCode11.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode11.setText("0");

        tfCode12.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode12.setText("0");

        tfCode13.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode13.setText("0");

        jLName7.setBackground(new java.awt.Color(153, 153, 153));
        jLName7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName7.setText("Alq. diferente ICMS (%):");

        jLName8.setBackground(new java.awt.Color(153, 153, 153));
        jLName8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName8.setText("Alq. IPI (%):");

        jLName9.setBackground(new java.awt.Color(153, 153, 153));
        jLName9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName9.setText("Aql. ICMS (%):");

        tfCode14.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode14.setText("0");

        jLName10.setBackground(new java.awt.Color(153, 153, 153));
        jLName10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName10.setText("NCM:");

        jLName11.setBackground(new java.awt.Color(153, 153, 153));
        jLName11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName11.setText("Preço minimo:");

        tfCode15.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode15.setText("0");

        jLName12.setBackground(new java.awt.Color(153, 153, 153));
        jLName12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName12.setText("Preço de venda:");

        tfCode17.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode17.setText("0");

        tfCode18.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode18.setText("0");

        tfCode19.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode19.setText("0");

        jLName13.setBackground(new java.awt.Color(153, 153, 153));
        jLName13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName13.setText("Peso bruto:");

        jLName14.setBackground(new java.awt.Color(153, 153, 153));
        jLName14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName14.setText("Peso líquido:");

        jLName15.setBackground(new java.awt.Color(153, 153, 153));
        jLName15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName15.setText("CST:");

        tfValueSale.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValueSale.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLName4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCode8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLName5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCode9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLName6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCode10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLName7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLName8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLName9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCode13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCode12)
                    .addComponent(tfCode11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLName10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLName11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLName12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCode14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCode15, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValueSale, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLName15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLName14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLName13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCode19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCode17, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCode18, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfCode19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfCode18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfCode17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName15)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLName12)
                            .addComponent(tfValueSale, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfCode15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfCode14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName10)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(tfCode13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLName7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(tfCode12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLName8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(tfCode11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLName9)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(tfCode8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLName4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(tfCode9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLName5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(tfCode10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLName6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações estoque"));

        tfStock.setEditable(false);
        tfStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfStock.setText("0");

        jLName16.setBackground(new java.awt.Color(153, 153, 153));
        jLName16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName16.setText("Estoque atual:");

        tfCode21.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode21.setText("0");

        jLName17.setBackground(new java.awt.Color(153, 153, 153));
        jLName17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName17.setText("Estoque minimo:");

        tfCode22.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCode22.setText("0");

        jLName18.setBackground(new java.awt.Color(153, 153, 153));
        jLName18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLName18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName18.setText("Estoque máximo:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton7.setText("jButton4");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLName16, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLName17, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCode21))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLName18, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCode22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName16)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfCode21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(tfCode22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName18))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jLName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tfCode6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCode7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(tfCode4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(tfCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCode5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tfCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLName2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCodeVerification)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLName3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLName1)
                        .addComponent(jLName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLName2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfCodeVerification, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfCode4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCode5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLName)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfCode6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCode7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jButton2.setText("Buscar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbAddOrUpdate.setBackground(new java.awt.Color(255, 255, 255));
        jbAddOrUpdate.setText("Add");
        jbAddOrUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddOrUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddOrUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAddOrUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jbAddOrUpdate))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados do produto", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLDescritionFoto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        tfImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/not-file.png"))); // NOI18N
        tfImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tfImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tfImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfImgMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tfImgMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfImg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfImg, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDescritionFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(843, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLDescritionFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Imagem do produto", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProductListView v = new ProductListView();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbAddOrUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddOrUpdateActionPerformed
      if (!tfCode.getText().equals("")) {
        update();
      } else {
        add();
      }
        //clearFields ();
    }//GEN-LAST:event_jbAddOrUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfCodeVerificationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodeVerificationKeyPressed
       
    }//GEN-LAST:event_tfCodeVerificationKeyPressed

    private void tfCodeVerificationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodeVerificationKeyReleased
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER && !tfCodeVerification.getText().equals("")){  
            stock = new Stock();
            stock = stocks.searchForCodeVerication(tfCodeVerification.getText());
            if (stock.getValue_single() != null) {
                tfName.setText(stock.getName());
                tfValueSale.setText(stock.getValue_single() + "");
                tfValueSale.setEnabled(false);
            } else {
                tfValueSale.setEnabled(true);
                tfName.setText("");
                tfValueSale.setText("");
            }
        }                                   
    }//GEN-LAST:event_tfCodeVerificationKeyReleased

    private void tfImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfImgMouseClicked
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            try {
                updateFoto = true;
                image = ManipulateImage.setImageSize(arquivo.getAbsolutePath(), 210, 240);
                tfImg.setIcon(new ImageIcon(image));
            } catch (Exception ex) {
                // System.out.println(ex.printStackTrace().toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_tfImgMouseClicked

    private void tfImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfImgMousePressed

    }//GEN-LAST:event_tfImgMousePressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {  
            insertValueDialog = new ViewShowInputValueDialog(this, true, "Enter amount");
            int value = Integer.parseInt(insertValueDialog.getValue() + "");
            String stock = tfStock.getText();
            int sum; 
            sum = Integer.parseInt(stock) + value ;
            this.stock = new Stock();
            this.stock = stocks.searchForCodeVerication(tfCodeVerification.getText());
            if (this.stock.getStock() > 0 && sum > this.stock.getStock()) {
                 throw new ImpossibleThisAction("No stock");
            }
            tfStock.setText(sum+"");
        } catch (Exception e) {
            errorDialog = new ViewShowErrorDialog(this, true, e.getMessage(), "Error");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    public static javax.swing.JLabel jLDescritionFoto;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLName1;
    private javax.swing.JLabel jLName10;
    private javax.swing.JLabel jLName11;
    private javax.swing.JLabel jLName12;
    private javax.swing.JLabel jLName13;
    private javax.swing.JLabel jLName14;
    private javax.swing.JLabel jLName15;
    private javax.swing.JLabel jLName16;
    private javax.swing.JLabel jLName17;
    private javax.swing.JLabel jLName18;
    private javax.swing.JLabel jLName2;
    private javax.swing.JLabel jLName3;
    private javax.swing.JLabel jLName4;
    private javax.swing.JLabel jLName5;
    private javax.swing.JLabel jLName6;
    private javax.swing.JLabel jLName7;
    private javax.swing.JLabel jLName8;
    private javax.swing.JLabel jLName9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JButton jbAddOrUpdate;
    public static javax.swing.JTextField tfCode;
    public static javax.swing.JTextField tfCode1;
    public static javax.swing.JTextField tfCode10;
    public static javax.swing.JTextField tfCode11;
    public static javax.swing.JTextField tfCode12;
    public static javax.swing.JTextField tfCode13;
    public static javax.swing.JTextField tfCode14;
    public static javax.swing.JTextField tfCode15;
    public static javax.swing.JTextField tfCode17;
    public static javax.swing.JTextField tfCode18;
    public static javax.swing.JTextField tfCode19;
    public static javax.swing.JTextField tfCode2;
    public static javax.swing.JTextField tfCode21;
    public static javax.swing.JTextField tfCode22;
    public static javax.swing.JTextField tfCode3;
    public static javax.swing.JTextField tfCode4;
    public static javax.swing.JTextField tfCode5;
    public static javax.swing.JTextField tfCode6;
    public static javax.swing.JTextField tfCode7;
    public static javax.swing.JTextField tfCode8;
    public static javax.swing.JTextField tfCode9;
    public static javax.swing.JTextField tfCodeVerification;
    public static javax.swing.JLabel tfImg;
    public static javax.swing.JTextField tfName;
    public static javax.swing.JTextField tfStock;
    public static javax.swing.JTextField tfValueSale;
    // End of variables declaration//GEN-END:variables

    public String getImageName() {
        return imageName;
    }  

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
