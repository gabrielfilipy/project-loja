package Repository;

import Controller.ConfigController;
import Controller.ServiceController;
import Model.Conf;
import Model.Service;
import Model.User;
import java.util.ArrayList;

public class ServiceForConfiguration {
    
    ConfigController configs = new ConfigController();
    ServiceController services = new ServiceController();
    Service service = new Service();
    
    public static final int HAVE = 1;
    public static final int NOT_HAVE = 0;
    
    public Boolean have (User user, String siglaServ) {
        ArrayList<Conf> list = configs.searchUserAndServiceCollection(user.getId());
        for (int i =0; i< list.size(); i++) { 
            service = new Service();
            service = services.searchServiceForSigla(siglaServ);
            if(list.get(i).getIdService() == service.getId() && 
                            list.get(i).getActive() == HAVE) 
                return true;
            
        }
        return false;
    }
    
}
