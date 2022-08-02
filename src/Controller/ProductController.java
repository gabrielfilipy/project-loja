package Controller;

import Dao.ProductDao;
import Model.*;
import java.util.List;

public class ProductController {
    
    ProductDao dao = new ProductDao();
    
    public int save(Product o){
        return dao.save(o);
    }
    
    public boolean delete(int id){
        return this.dao.deleteForId(id);
    }
    
    public List<Product> collection(){
        return this.dao.collection();
    }
    
    public Product searchForId(int id){
        return this.dao.searchForId(id);
    }
    
    public Product searchForCodeVerication(String code){
        return this.dao.searchForCodeVerication(code);
    }
    
    public List<Product> searchForName(String name){
        return this.dao.searchForName(name);
    }
    
    public boolean update(Product o){
        return this.dao.update(o);
    }
    
    public boolean alterStock(List<Product> collection) {
        return this.dao.alterStock(collection);
    }
    
}
