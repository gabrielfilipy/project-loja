package Dao;

import Conexao.ToConnectServer;
import Model.SettingSystem;

public class SettingSystemDao extends ToConnectServer{
    
    public static String table = "tbl_setting_of_system";
    
    public int save(SettingSystem o){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "foto, "
            + "name_company, "
            + "cnpj, "
            + "address, "        
            + "sigla "         
                    
            + ") VALUES ("
            + "'" +o.getFoto() +"', "
            + "'" +o.getName() +"', "
            + "'" +o.getCnpj() +"', "
            + "'" +o.getAddress() +"', "
            + "'" +o.getSigla() +"' "        
                    
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
    
    public boolean update (SettingSystem o){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "foto = '"+o.getFoto()+"',"
            + "name_company = '"+o.getName()+"'," 
            + "address = '"+o.getAddress()+"',"
            + "sigla = '"+o.getSigla()+"',"
            + "cnpj = '"+o.getCnpj()+"' "
            + " WHERE id = '"+o.getId()+"'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
   
   public SettingSystem searchForSigla (String sigla) {
        SettingSystem o = new SettingSystem();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "foto, "
            + "name_company, "
            + "cnpj, "
            + "address, "        
            + "sigla "  
                    
            + "FROM " + table + " WHERE sigla = '"+sigla+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setFoto(getResultSet().getString(2));
                o.setName(getResultSet().getString(3));
                o.setCnpj(getResultSet().getString(4));
                o.setAddress(getResultSet().getString(5));
                o.setSigla(getResultSet().getString(6));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
    
}
