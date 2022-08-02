package Dao;

import Conexao.ToConnectServer;
import Model.SalePayment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalePaymentDao extends ToConnectServer{
    
    public static String table = "tbl_sale_payment";
    
    public boolean save(Set<SalePayment> collection) {
        try {
            this.conectar();
            collection.forEach(s -> {
            this.insertSQL(
                "INSERT INTO " + table + " ("
                    + "payment_id, "
                    + "sale_id " 
                + ") VALUES ("
                    + "'" + s.getPayment_id()+ "',"
                    + "'" + s.getSale_id() + "' "
                + ");"
            );
            });
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao(); 
        }   
    }
    
}
