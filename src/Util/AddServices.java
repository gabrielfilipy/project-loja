package Util;

import Controller.ConfigController;
import Controller.ServiceController;
import Model.*;
import java.time.LocalDate;

public class AddServices {
    
    LocalDate date = LocalDate.now();
    
    public Service addService (String sigla, String desc) {
        Service service = new Service();
        ServiceController services = new ServiceController();
        service.setDescription(desc);
        service.setSigla(sigla);
        
        services.save(service);
        return services.searchServiceForSigla(sigla);
    }
    
    public int addServicesForConfiguration (User user, ServiceController services, String sigla, String desc, Integer active) {
        ConfigController configs = new ConfigController();
        Service service = new Service();
        Conf conf = new Conf();
            service = services.searchServiceForSigla(sigla);
            if (!service.existsService ())
                service = addService(sigla, desc);
                
            conf.setActive(active);
            conf.setDate("12/12/2021");
            conf.setIdUser(user.getId());
            conf.setidService(service.getId());
            
            return configs.save(conf);
    }
    
    public Boolean updateServicesForConfiguration (User user, ServiceController services, String sigla, String desc, Integer active) {
        ConfigController configs = new ConfigController();
        Service service = new Service();
        Conf conf = new Conf();
        Conf newConf = new Conf();
        
        service = services.searchServiceForSigla(sigla);
            if (!service.existsService ())
                service = addService(sigla, desc);
            
        conf = configs.searchUserAndService(service.getId(), user.getId());
        //Caso não exista essa configuração para esse usuário então adicione agora, caso contrário atualize como o usuário quer.
        if (conf.getId_config() < 1) {
            addServicesForConfiguration(user, services, sigla, desc, active);
        } else {
            newConf.setId_config(conf.getId_config());
            newConf.setActive(active);
            newConf.setDate("12/12/2021");
            newConf.setIdUser(user.getId()); 
            newConf.setidService(service.getId());
        }
        return configs.update(newConf);
    }
    
}
