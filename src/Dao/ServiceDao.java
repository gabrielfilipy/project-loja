package Dao;

import Conexao.ToConnectServer;
import Model.Service;
import java.util.ArrayList;

public class ServiceDao extends ToConnectServer{
    public static String table = "tbl_service";
    
    public int save(Service service){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("  
            + "description,"          
            + "sigla " 

            + ") VALUES ("
            + "'" +service.getDescription() +"',"
            + "'" +service.getSigla() +"' "  
                    
            + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
    public ArrayList<Service> collection(){
        ArrayList<Service> collectionUser = new ArrayList<>();
        Service user = new Service();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id,"         
            + "description,"          
            + "sigla " 
            + "FROM " + table + " ORDER BY description;"
            + "");
            while(getResultSet().next()){
                user = new Service();
                user.setId(this.getResultSet().getInt(1));
                user.setDescription(this.getResultSet().getString(2));
                user.setSigla(this.getResultSet().getString(3));
                collectionUser.add(user);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collectionUser;
   }
    
   public Service searchServiceForSigla (String sigla){
        Service s = new Service();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id,"         
            + "description,"          
            + "sigla "   
                    
            + "FROM tbl_service WHERE sigla = '"+sigla+"';");
            while(this.getResultSet().next()){
                s.setId(getResultSet().getInt(1));
                s.setDescription(getResultSet().getString(2));
                s.setSigla(getResultSet().getString(3));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return s; 
   }
}
