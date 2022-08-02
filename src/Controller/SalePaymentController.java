package Controller;

import Dao.SalePaymentDao;
import Model.SalePayment;
import java.util.List;
import java.util.Set;
public class SalePaymentController {
    
    SalePaymentDao dao = new SalePaymentDao();
    
    public boolean save(Set<SalePayment> collection){
        return dao.save(collection); 
    }
    
}
