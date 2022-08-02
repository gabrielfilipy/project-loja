package Model;

public class Conf {
    
    private int id_config;
    private int id_service;
    private String date;
    private int user;
    private int active;

    public int getId_config() {
        return id_config;
    }

    public void setId_config(int id_config) {
        this.id_config = id_config;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdService() {
        return id_service;
    }

    public void setidService(int service) {
        this.id_service = service;
    }

    public int getIdUser() {
        return user;
    }

    public void setIdUser(int user) {
        this.user = user;
    }

    public int getActive() {
        return active;
    }
    
    public void setActive(int active) {
        this.active = active;
    }

}
