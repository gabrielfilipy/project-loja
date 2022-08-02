package Controller;

import Dao.ServiceDao;
import Model.Conf;
import Model.Service;
import java.util.ArrayList;

public class ServiceController {
    
    ServiceDao dao = new ServiceDao();
    
    public int save(Service service){
         return dao.save(service);
    }
  
    public Service searchServiceForSigla(String service){
         return dao.searchServiceForSigla(service);
    }
    
}
