
package Controller.Enums;

public enum Services {
    
    REGISTRATION_USER("REG-USER", "Registration user"),
    REGISTRATION_INVENTORY("REG-INV", "Registration inventory"),
    REGISTRATION_PRODUCT("REG-INV", "Registration product"),
    REGISTRATION_CLIENT("REG-CLI", "Registration client"),
    CANCEL_SALE("REG-SALE", "Cancel sale"),
    REMOV_PROD("REMOV-PROD", "Remove product list of sale"),
    ABANDONED_SALE("ABAND-SALE", "Abandoned sale"),
    REPORTS("REP", "Reports");
    
    private String sigla;
    private String desc;
    
    private Services(String sigla, String desc) {
        this.sigla = sigla;
        this.desc = desc;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDesc() {
        return desc;
    }
    
}
