package Dao;

import Conexao.ToConnectServer;

import Model.Provider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProviderDao extends ToConnectServer {
    
    public static String table = "tbl_provider";
    
    public int save(Provider provider){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "name,"
            + "address,"
            + "number_telephone,"
            + "email"

            + ") VALUES ("
            + "'" +provider.getName() +"',"
            + "'" +provider.getAddress() +"',"
            + "'" +provider.getNumber_telephone() +"',"
            + "'" +provider.getEmail() +"'"
                    
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
    
    public boolean update (Provider provider){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "name = '"+provider.getName()+"',"
            + "address = '"+provider.getAddress()+"'," 
            + "number_telephone = '"+provider.getNumber_telephone()+"',"
            + "email = '"+provider.getEmail()+"'"
            + " WHERE id = '"+provider.getId()+"'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public List<Provider> collection(){
        List<Provider> collectionUser = new ArrayList<>();
        Provider o = new Provider();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id, "
            + "name, "
            + "address, "
            + "number_telephone, "
            + "email "
            + "FROM " + table + " ORDER BY name;"
            + "");
            while(getResultSet().next()){
                o = new Provider();
                o.setId(this.getResultSet().getInt(1));
                o.setName(this.getResultSet().getString(2));
                o.setAddress(this.getResultSet().getString(3));
                o.setNumber_telephone(this.getResultSet().getString(4));
                o.setEmail(this.getResultSet().getString(5));
                collectionUser.add(o);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collectionUser;
   }
   
   public Set<Provider> collectionSet(){
        Set<Provider> collection = new HashSet<>();
        Provider o = new Provider();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id, "
            + "name, "
            + "address, "
            + "number_telephone, "
            + "email "
            + "FROM " + table + " ORDER BY name;"
            + "");
            while(getResultSet().next()){
                o = new Provider();
                o.setId(this.getResultSet().getInt(1));
                o.setName(this.getResultSet().getString(2));
                o.setAddress(this.getResultSet().getString(3));
                o.setNumber_telephone(this.getResultSet().getString(4));
                o.setEmail(this.getResultSet().getString(5));
                collection.add(o);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
   public Provider searchForId (int id){
        Provider o = new Provider();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "name, "
            + "address, "
            + "number_telephone, "
            + "email "   
                    
            + "FROM " + table + " WHERE id = '"+id+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setAddress(getResultSet().getString(3));
                o.setNumber_telephone(getResultSet().getString(4));
                o.setEmail(getResultSet().getString(5));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public Provider searchForName (String name){
        Provider o = new Provider();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "name, "
            + "address, "
            + "number_telephone, "
            + "email "   
                    
            + "FROM " + table + " WHERE name = '"+name+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setAddress(getResultSet().getString(3));
                o.setNumber_telephone(getResultSet().getString(4));
                o.setEmail(getResultSet().getString(5));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
    
}
