package Dao;

import Conexao.ToConnectServer;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao extends ToConnectServer{
    
    public static String table = "tbl_department";
    
    public int save(Department o){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "name "

            + ") VALUES ("
            + "'" +o.getName() +"' "
                    
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
    
    public boolean update (Department o){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "name = '"+o.getName()+"' "
            + " WHERE id = '"+o.getId()+"'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public List<Department> collection(){
        List<Department> collection = new ArrayList<>();
        Department o = new Department();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id, "
            + "name "
            + "FROM " + table + " ORDER BY name;"
            + "");
            while(getResultSet().next()){
                o = new Department();
                o.setId(this.getResultSet().getInt(1));
                o.setName(this.getResultSet().getString(2));
                collection.add(o);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
   public Department searchForId (int id){
        Department o = new Department();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "name " 
                    
            + "FROM " + table + " WHERE id = '"+id+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public Department searchForName (String name){
        Department o = new Department();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "name " 
                    
            + "FROM " + table + " WHERE name = '"+name+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
    
}
