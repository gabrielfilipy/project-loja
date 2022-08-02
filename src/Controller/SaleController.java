package Controller;

import Dao.SaleDao;
import Model.*;
import java.util.List;
import java.util.Set;

public class SaleController {
    
    SaleDao dao = new SaleDao();
    
    public int save(Sale o){
        return dao.save(o);
    }
    
    public boolean delete(int id){
        return this.dao.deleteForId(id);
    }
    
    public List<SaleProducts> collection(String dateIni, String dateEnd){
        return this.dao.collection(dateIni, dateEnd);
    }
    
    public List<Sale> collection(){
        return this.dao.collection();
    }
    
    public Sale searchForId(int id){
        return this.dao.searchForId(id);
    }
    
    public boolean update(Sale o){
        return this.dao.update(o);
    }
    
    public Boolean collection(Set<Sale> collection) {
        return this.dao.saveCollectionSale(collection);
    }
    
}
