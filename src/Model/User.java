package Model;

public class User {
    
    private int id ;
    private String user_name ;
    private String password ; 
    private String login;
    private int id_user_online;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String nome) {
        this.user_name = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public int getId_user_online() {
        return id_user_online;
    }

    public void setId_user_online(int id_user_online) {
        this.id_user_online = id_user_online;
    }
    
    public Boolean existUser () {
        return getId() == 0 ? false : true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
