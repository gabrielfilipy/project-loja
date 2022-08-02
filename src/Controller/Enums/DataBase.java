
package Controller.Enums;

public enum DataBase {
    
    DATA_BASE("loja"),
    LOCAL("localhost"), 
    USER_ROOT("root"), 
    USER_SERVER("root"), 
    PASSWORD_SERVER(""),
    PASSWORD_ROOT(""),
    PORT("3306");
    
    private String desc;
    
    private DataBase(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
}
