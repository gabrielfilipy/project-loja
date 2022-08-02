package Controller;

import Dao.StockDao;
import Model.*;
import java.util.List;

public class StockController {
    
    StockDao dao = new StockDao();
    
    public int save(Stock o){
        return dao.save(o);
    }
    
    public boolean delete(int id){
        return this.dao.deleteForId(id);
    }
    
    public List<Stock> collection(){
        return this.dao.collection();
    }
    
    public List<Stock> collectionForCodeVerification(String code){
        return this.dao.collectionForCodeVerification(code);
    }
    
    public Stock searchForId(int id){
        return this.dao.searchForId(id);
    }
    
    public Stock searchForCodeVerication(String code){
        return this.dao.searchForCodeVerication(code);
    }
    
    public boolean update(Stock o){
        return this.dao.update(o);
    }
    
    public boolean alterStockCollection(List<Stock> listStock) {
        return this.dao.alterStock(listStock);
    }
    
    public boolean alterStockSingle(Stock stock) {
        return this.dao.alterStock(stock);
    }
    
}
