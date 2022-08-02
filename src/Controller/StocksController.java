package Controller;

import Model.Stocks;
import java.util.List;
import Dao.*;
public class StocksController {

    StockDao dao = new StockDao();
    
    public List<Stocks> collection() {
        return dao.collectionStocks();
    }
    
    public List<Stocks> collectionForNameOrCode(String search) {
        return dao.collectionStocksForNameOrCode(search);
    }
    
}
