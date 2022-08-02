package Model;

import java.util.Date;
import java.util.List;

public class SaleProducts {
    
    private User user;
    private Client client;
    private Sale sale;
    private SaleProduct saleProduct;
    private SettingSystem settingSystem;
    private List<SaleProducts> list;
    private Product product;
    private Payment payment;
    
    private String sale_date;
    private Double total_value;
    private Double gross_value;
    private Double discount;
    
    private int id;
    private int the_amount;
    private String client_name;
    private String user_name;
    private String name_company;
    private String cnpj;
    
    private String address;
    private String hours;
    private int amount;
    private String product_name;
    private int product_id;
    private Double value_sale;
    
    private String description;
    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<SaleProducts> getList() {
        return list;
    }

    public void setList(List<SaleProducts> list) {
        this.list = list;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public SaleProduct getSaleProduct() {
        return saleProduct;
    }

    public void setSaleProduct(SaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }

    public SettingSystem getSettingSystem() {
        return settingSystem;
    }

    public void setSettingSystem(SettingSystem settingSystem) {
        this.settingSystem = settingSystem;
    }

    public String getSale_date() {
        return getSale().getDate();
    }

    public void setSale_date(String sale_date) {
        sale_date = getSale().getDate();
        this.sale_date = sale_date;
    }

    public Double getTotal_value() {
        return getSale().getTotal_value();
    }

    public void setTotal_value(Double total_value) {
        total_value = getSale().getTotal_value();
        this.total_value = total_value;
    }

    public int getId() {
        return getSale().getId();
    }

    public void setId(int id) {
        id = getSale().getId();
        this.id = id;
    }

    public int getThe_amount() { 
        return getSale().getThe_amount();
    }

    public void setThe_amount(int the_amount) {
        the_amount = getSale().getThe_amount();
        this.the_amount = the_amount;
    }

    public String getClient_name() {
        return getClient().getName();
    }

    public void setClient_name(String client_name) {
        client_name = getClient().getName();
        this.client_name = client_name;
    }

    public String getUser_name() {
        return getUser().getName();
    }

    public void setUser_name(String user_name) {
        user_name = getUser().getName();
        this.user_name = user_name;
    }
    
    public String getName_company() {
        return getSettingSystem().getName();
    }

    public void setName_company(String name_company) {
        name_company = getSettingSystem().getName();
        this.name_company = name_company;
    }

    public String getCnpj() {
        return getSettingSystem().getCnpj();
    }

    public void setCnpj(String cnpj) {
        cnpj = getSettingSystem().getCnpj();
        this.cnpj = cnpj;
    }
    
    public String getAddress() {
        return getSettingSystem().getAddress();
    }

    public void setAddress(String address) {
        address = getSettingSystem().getAddress();
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getAmount() {
        return getSaleProduct().getAmount();
    }

    public void setAmount(int amount) {
        amount = getSaleProduct().getAmount();
        this.amount = amount;
    }

    public String getProduct_name() {
        return getProduct().getName();
    }

    public void setProduct_name(String product_name) {
        product_name = getProduct().getName();
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return getProduct().getId();
    }

    public void setProduct_id(int product_id) {
        product_id = getProduct().getId();
        this.product_id = product_id;
    }

    public Double getValue_sale() {
        return getSaleProduct().getValue_sale();
    }

    public void setValue_sale(Double value_sale) {
        value_sale = getSaleProduct().getValue_sale();
        this.value_sale = value_sale;
    }

    public Double getGross_value() {
        return getSale().getGross_value();
    }

    public void setGross_value(Double gross_value) {
        gross_value = getSale().getGross_value();
        this.gross_value = gross_value;
    }

    public Double getDiscount() {
        return getSale().getDiscount();
    }

    public void setDiscount(Double discount) {
        discount = getSale().getDiscount();
        this.discount = discount;
    }

    public String getDescription() {
        return getPayment().getDescription();
    }

    public void setDescription(String description) {
        description = getPayment().getDescription();
        this.description = description;
    }
    
}
