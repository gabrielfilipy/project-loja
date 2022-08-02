package Controller;

import Dao.ConfigDao;
import Model.Conf;
import Util.AddServices;
import java.util.ArrayList;

public class ConfigController {
    
    ConfigDao dao = new ConfigDao();
    
    public int save(Conf conf){
         return dao.save(conf);
    }
    
    public Conf searchUserAndService(int idService, int idUser){
        return this.dao.searchUserAndService(idService, idUser);
    }
    
    public ArrayList<Conf> searchUserAndServiceCollection(int idUser){
        return this.dao.collectionOfServiceAndUser(idUser);
    }
    
    public boolean update(Conf c){
         return this.dao.update(c);
    }
    
    public boolean delete(int id){
         return this.dao.deleteForId(id);
    }
    
}
