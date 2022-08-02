package Model;

public class Stock {
    
    private int id;
    private int stock;
    private String name;
    private Double value_invest;
    private int provider_id;
    private int department_id;
    private int user_id;
    private String code_verification;
    private Double value_single;
    
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

    public Double getValue_invest() {
        return value_invest;
    }

    public void setValue_invest(Double value_invest) {
        this.value_invest = value_invest;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCode_verification() {
        return code_verification;
    }

    public void setCode_verification(String code_verification) {
        this.code_verification = code_verification;
    }

    public Double getValue_single() {
        return value_single;
    }

    public void setValue_single(Double value_single) {
        this.value_single = value_single;
    }
    
}
