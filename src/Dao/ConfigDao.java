package Dao;

import Conexao.ToConnectServer;
import Model.Conf;
import Model.Service;
import Util.AddServices;
import java.util.ArrayList;

public class ConfigDao extends ToConnectServer{
    public static String table = "tbl_config";
    
    public int save(Conf conf){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("   
            + "id_service,"         
            + "date,"          
            + "id_user,"   
            + "active "

            + ") VALUES ("
            + "'" +conf.getIdService() +"',"
            + "'" +conf.getDate() +"'," 
            + "'" +conf.getIdUser() +"',"
            + "'" +conf.getActive() +"'"  
                    
            + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
    public boolean update (Conf conf){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "id_service = '"+conf.getIdService()+"',"
            + "date = '"+ conf.getDate()+"',"
            + "id_user = '"+ conf.getIdUser()+"',"
            + "active = '"+ conf.getActive()+"' "
            + " WHERE id = '"+conf.getId_config()+"'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public boolean deleteForId(int id){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM "  + table + " WHERE id_user = '"+id+"'");
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        } finally { 
            this.fecharConexao();
        }   
    }
    
    public Conf searchUserAndService (int idService, int idUser){
        Conf config = new Conf();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id,"        
            + "id_service,"         
            + "date,"          
            + "id_user,"   
            + "active "   
                    
            + "FROM " + table + " WHERE id_service = '"+idService+"' AND id_user = '"+idUser+"'");
            while(this.getResultSet().next()){
                config.setId_config(getResultSet().getInt(1));
                config.setidService(getResultSet().getInt(2));
                config.setDate(getResultSet().getString(3));
                config.setIdUser(getResultSet().getInt(4));
                config.setActive(getResultSet().getInt(5));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return config; 
   }
    
   public ArrayList<Conf> collectionOfServiceAndUser(int idUser){
        ArrayList<Conf> collection = new ArrayList<>();
        Conf config = new Conf();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id,"        
            + "id_service,"         
            + "date,"          
            + "id_user,"   
            + "active "   
            + "FROM " + table + " WHERE id_user = '"+idUser+"' ;"
            + "");
            while(getResultSet().next()){
                config = new Conf();
                config.setId_config(getResultSet().getInt(1));
                config.setidService(getResultSet().getInt(2));
                config.setDate(getResultSet().getString(3));
                config.setIdUser(getResultSet().getInt(4));
                config.setActive(getResultSet().getInt(5));
                collection.add(config);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
    
}
