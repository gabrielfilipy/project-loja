package Model;

import java.util.Date;

public class Sale {
    
    private int id;
    private int idSale;
    private int type_sale;
    private int user_id; 
    private int client_id;
    private String sale_date;
    private int the_amount;
    private Double net_value;
    private Double gross_value;
    private Double discount;
    private Double total_value;
    private int payment_id;
    private int shift_id;
    private String status;
    private int abandoned;
    private int userIdCanceled;
    private String dateCanceled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_sale() {
        return type_sale;
    }

    public void setType_sale(int type_sale) {
        this.type_sale = type_sale;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getClienteId() {
        return client_id;
    }

    public void setClienteId(int user_cliente) {
        this.client_id = user_cliente;
    }

    public String getDate() {
        return sale_date;
    }

    public void setDate(String date) {
        this.sale_date = date;
    }

    public int getThe_amount() {
        return the_amount;
    }

    public void setThe_amount(int the_amount) {
        this.the_amount = the_amount;
    }

    public Double getNetValue() {
        return net_value;
    }

    public void setNetValue(Double net_value) {
        this.net_value = net_value;
    }

    public Double getGross_value() {
        return gross_value;
    }

    public void setGross_value(Double gross_value) {
        this.gross_value = gross_value;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Double total_value) {
        this.total_value = total_value;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getShift_id() {
        return shift_id;
    }

    public void setShift_id(int shift_id) {
        this.shift_id = shift_id;
    }
    
    public String getStatus() {
        return status ;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAbandoned() {
        return abandoned; 
    }

    public void setAbandoned(int abandoned) {
        this.abandoned = abandoned;
    }
    
    public Boolean isCanceled () { 
        if (status == null)
            return false;
        
        return this.status.equals("Cancelada") ? true  : false;
    }
    
    public Boolean isAbandoned () {
        if (status == null)
            return false;
            
        return this.status.equals("Abandonada") ? true  : false ;
    } 

    public int getUserIdAlterStatus() {
        return userIdCanceled;
    }

    public void setUserIdAlterStatus(int userIdCanceled) {
        this.userIdCanceled = userIdCanceled;
    }

    public String getDateStatus() {
        return dateCanceled;
    }

    public void setDateStatus(String dateCanceled) {
        this.dateCanceled = dateCanceled;
    }
    
}
