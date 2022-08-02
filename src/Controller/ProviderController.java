package Controller;

import Dao.ProviderDao;
import java.util.List;
import Model.*;
import java.util.Set;

public class ProviderController {
    
    ProviderDao dao = new ProviderDao();
    
    public int save(Provider o){
        return dao.save(o);
    }
    
    public boolean delete(int id){
        return this.dao.deleteForId(id);
    }
    
    public List<Provider> collection(){
        return this.dao.collection();
    }
    
    public Set<Provider> collectionSet(){
        return this.dao.collectionSet();
    }
    
    public Provider searchForId(int id){
        return this.dao.searchForId(id);
    }
    
    public Provider searchForName(String name){
        return this.dao.searchForName(name);
    }
    
    public boolean update(Provider o){
        return this.dao.update(o);
    }
    
}
