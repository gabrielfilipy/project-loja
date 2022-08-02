package Controller;

import Dao.SettingSystemDao;
import Model.SettingSystem;

public class SettingController {
    
    SettingSystemDao dao = new SettingSystemDao();
    
    public int save(SettingSystem settingSystem){
         return dao.save(settingSystem);
    }  
    
    public SettingSystem search(String sigla){
         return dao.searchForSigla(sigla);
    }
    
    public Boolean update(SettingSystem settingSystem){
         return dao.update(settingSystem);
    }
    
}
