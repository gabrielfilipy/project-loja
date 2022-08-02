package Model;

public class Product {
    
    private int id;
    private String name;
    private int stock;
    private Double value_sale;
    private int stock_id;
    private int user_id;
    private String dateAndHours;
    private String code_verification;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getValue_sale() {
        return value_sale;
    }

    public void setValue_sale(Double value_sale) {
        this.value_sale = value_sale;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDateAndHours() {
        return dateAndHours;
    }

    public void setDateAndHours(String dateAndHours) {
        this.dateAndHours = dateAndHours;
    }

    public String getCode_verification() {
        return code_verification;
    }

    public void setCode_verification(String code_verification) {
        this.code_verification = code_verification;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public Boolean existsProduct (String code) {
        return this.getCode_verification().equals(code) ? true : false;
    } 
    
}
