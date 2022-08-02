package Model;

public class Service {
    
    private int id;
    private String description;
    private String sigla;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public Boolean existsService () {
        return getId() == 0 ? false : true;
    }
    
    
}
