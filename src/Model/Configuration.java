package Model;

public class Configuration {
    
    /*
    *   Aqui ficam as regras do sistema na questão do que o usuário pode ou não acessar.
    */
    
    private int registration_user;
    private Integer registration_client;
    private Integer registration_inventory;
    private Integer cancel_sale;
    private Integer reports;

    public int getRegistration_user() {
        return registration_user;
    }

    public void setRegistration_user(int registration_user) {
        this.registration_user = registration_user;
    }
    
    public Integer getRegistration_client() {
        return registration_client;
    }

    public void setRegistration_client(Integer registration_client) {
        this.registration_client = registration_client;
    }

    public Integer getRegistration_inventory() {
        return registration_inventory;
    }

    public void setRegistration_inventory(Integer registration_inventory) {
        this.registration_inventory = registration_inventory;
    }

    public Integer getCancel_sale() {
        return cancel_sale;
    }

    public void setCancel_sale(Integer cancel_sale) {
        this.cancel_sale = cancel_sale;
    }

    public Integer getReports() {
        return reports;
    }

    public void setReports(Integer reports) {
        this.reports = reports;
    }

}
