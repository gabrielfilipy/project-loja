package Controller;

import Dao.ClientDao;
import Model.Client;
import java.util.List;
public class ClientController {
    
    ClientDao dao = new ClientDao();
    
    public int save(Client object){
        return dao.save(object);
    }
    
    public boolean delete(int id){
        return this.dao.deleteForId(id);
    }
    
    public List<Client> collection(){
        return this.dao.collection();
    }
    
    public Client searchForId(int id){
        return this.dao.searchForId(id);
    }
    
    public Client searchForName(String name){
        return this.dao.searchForName(name);
    }
    
    public boolean update(Client object){
        return this.dao.update(object);
    }
    
}
