package Controller;

import Dao.PaymentDao;
import Model.Payment;

public class PaymentController {
    
    PaymentDao dao = new PaymentDao();
    
    public Payment searchForId(int id) {
        return this.dao.searchForId(id);
    }
    
    public Payment searchForInitials(String initials) {
        return this.dao.searchForInitials(initials);
    }
    
}
