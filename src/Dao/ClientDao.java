package Dao;

import Conexao.ToConnectServer;
import Model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientDao extends ToConnectServer{
    
    public static String table = "tbl_client";
    
    public int save(Client object){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "client_name, "
            + "address, "
            + "active, "
            + "email, "
            + "telephone "  
                    
            + ") VALUES ("
            + "'" +object.getName() +"',"
            + "'" +object.getAddress() +"',"
            + "'" +object.getActive() +"',"
            + "'" +object.getEmail() +"',"
            + "'" +object.getTelephone() +"' "        
                    
            + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
    public boolean deleteForId(int id){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM "  + table + " WHERE id = '"+id+"'");
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        } finally { 
            this.fecharConexao();
        }   
    }
    
    public boolean update (Client object){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "client_name = '"+object.getName()+"',"
            + "address = '"+object.getAddress()+"'," 
            + "active = '"+object.getActive()+"',"
            + "email = '"+object.getEmail()+"',"
            + "telephone = '"+object.getTelephone()+"' "
            + " WHERE id = '"+object.getId()+"'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public List<Client> collection(){
        List<Client> collectionUser = new ArrayList<>();
        Client object = new Client();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id, "
            + "client_name, "
            + "address, "
            + "active, "
            + "email, "
            + "telephone "  
            + "FROM " + table + " ORDER BY client_name;"
            + "");
            while(getResultSet().next()){
                object = new Client();
                object.setId(this.getResultSet().getInt(1));
                object.setName(this.getResultSet().getString(2));
                object.setAddress(this.getResultSet().getString(3));
                object.setActive(this.getResultSet().getInt(4));
                object.setEmail(this.getResultSet().getString(5));
                object.setTelephone(this.getResultSet().getString(6));
                collectionUser.add(object);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collectionUser;
   }
   
   public Client searchForId (int id) {
        Client object = new Client();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "client_name, "
            + "address, "
            + "active, "
            + "email, "
            + "telephone " 
                    
            + "FROM " + table + " WHERE id = '"+id+"'");
            while(this.getResultSet().next()){
                object = new Client();
                object.setId(this.getResultSet().getInt(1));
                object.setName(this.getResultSet().getString(2));
                object.setAddress(this.getResultSet().getString(3));
                object.setActive(this.getResultSet().getInt(4));
                object.setEmail(this.getResultSet().getString(5));
                object.setTelephone(this.getResultSet().getString(6));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return object; 
   }
   
   public Client searchForName (String name){
        Client object = new Client();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "client_name, "
            + "address, "
            + "active, "
            + "email, "
            + "telephone " 
                    
            + "FROM " + table + " WHERE name = '"+name+"'");
            while(this.getResultSet().next()){
                object = new Client();
                object.setId(this.getResultSet().getInt(1));
                object.setName(this.getResultSet().getString(2));
                object.setAddress(this.getResultSet().getString(3));
                object.setActive(this.getResultSet().getInt(4));
                object.setEmail(this.getResultSet().getString(5));
                object.setTelephone(this.getResultSet().getString(6));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return object; 
   }
    
}
