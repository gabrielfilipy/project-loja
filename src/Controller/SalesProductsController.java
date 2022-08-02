package Controller;

import Dao.SaleDao;
import Model.*;
import java.util.List;
import java.util.Set;

public class SalesProductsController {
    
    SaleDao dao = new SaleDao();
    
    public boolean save(List<SaleProduct> collection) {
        return this.dao.salvarListaVendaProdutoDAO(collection);
    }
    
    public boolean save(Set<SaleProduct> collection) {
        return this.dao.salvarListaVendaProdutoSet(collection);
    }
    
    public List<SaleProducts> collection() {
        return dao.saleProduct();
    }
    
    public List<SaleProducts> collection(int code) {
        return dao.saleProduct(code);
    }
    
    public List<SaleProducts> collectionForPDF(int code) {
        return dao.saleProductForPDF(code);
    }
    
}
