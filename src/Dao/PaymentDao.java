package Dao;

import Conexao.ToConnectServer;
import Model.Payment;

public class PaymentDao extends ToConnectServer{
    
    public static String table = "tbl_payments";
    
    public int save(Payment o) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "description "
            + ") VALUES ("
            + "'" +o.getDescription() +"' "
            + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
    public Payment searchForId (int code) {
        Payment o = new Payment();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "description, "
            + "code "
                    
            + "FROM " + table + " WHERE code = '" + code + "'");
            while(this.getResultSet().next()){
               o.setId(getResultSet().getInt(1));
               o.setDescription(getResultSet().getString(2));
            }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
    
   public Payment searchForInitials (String initials) {
        Payment o = new Payment();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "description, "
            + "code "        
            + "FROM " + table + " WHERE initials = '"+initials+"'");
            while(this.getResultSet().next()){
               o.setId(getResultSet().getInt(1));
               o.setDescription(getResultSet().getString(2));
               o.setCode(getResultSet().getInt(3));
            }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
    
}
