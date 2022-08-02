package Dao;

import Conexao.ToConnectServer;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class StockDao extends ToConnectServer{
    
    public static String table = "tbl_product_for_stock";
    
    public int save(Stock o){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "name,"
            + "stock, "
            + "value_invest, "
            + "provider_id, "
            + "department_id, "
            + "user_id, "
            + "code_verification, "
            + "value_single "
            + ") VALUES ("
            + "'" +o.getName() +"',"
            + "'" +o.getStock() +"',"
            + "'" +o.getValue_invest() +"',"
            + "'" +o.getProvider_id() +"',"
            + "'" +o.getDepartment_id() +"',"
            + "'" +o.getUser_id() +"',"  
            + "'" +o.getCode_verification() +"', "
            + "'" +o.getValue_single() +"' " 
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
    
    public boolean update (Stock o){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "name = '"+o.getName()+"', "
            + "stock = '"+o.getStock()+"', "
            + "value_invest = '"+o.getValue_invest()+"', "
            + "provider_id = '"+o.getProvider_id()+"', " 
            + "department_id = '"+o.getDepartment_id()+"', "
            + "code_verification = '"+o.getCode_verification()+"', "
            + "user_id = '"+o.getUser_id()+"', "
            + "value_single = '"+o.getValue_single()+"' "        
            + " WHERE id = '"+o.getId()+"' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public Stock searchForId (int id){
        Stock o = new Stock();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "name, "
            + "stock, "
            + "value_invest, "
            + "provider_id, "
            + "department_id, "
            + "code_verification, "
            + "user_id, "
            + "value_single "
             
            + "FROM " + table + " WHERE id = '"+id+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_invest(getResultSet().getDouble(4));
                o.setProvider_id(getResultSet().getInt(5));
                o.setDepartment_id(getResultSet().getInt(6));
                o.setCode_verification(getResultSet().getString(7));
                o.setUser_id(getResultSet().getInt(8));
                o.setValue_single(getResultSet().getDouble(9));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public Stock searchForCodeVerication (String code){
        Stock o = new Stock();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id,"
            + "name,"
            + "stock, "
            + "value_invest, "
            + "provider_id, "
            + "department_id, "
            + "code_verification, "
            + "user_id, "
            + "value_single " 
                    
            + "FROM " + table + " WHERE code_verification = '"+code+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_invest(getResultSet().getDouble(4));
                o.setProvider_id(getResultSet().getInt(5));
                o.setDepartment_id(getResultSet().getInt(6));
                o.setCode_verification(getResultSet().getString(7));
                o.setUser_id(getResultSet().getInt(8));
                o.setValue_single(getResultSet().getDouble(9));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public Stock searchForname (String name){
        Stock o = new Stock();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id,"
            + "name,"
            + "stock, "
            + "value_invest, "
            + "provider_id, "
            + "department_id, "
            + "code_verification, " 
            + "user_id, "   
            + "value_single " 
                    
            + "FROM " + table + " WHERE name = '"+name+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_invest(getResultSet().getDouble(4));
                o.setProvider_id(getResultSet().getInt(5));
                o.setDepartment_id(getResultSet().getInt(6));
                o.setCode_verification(getResultSet().getString(7));
                o.setUser_id(getResultSet().getInt(8));
                o.setValue_single(getResultSet().getDouble(9));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public List<Stock> collection(){
        List<Stock> collection = new ArrayList<>();
        Stock o = new Stock();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id,"
            + "name,"
            + "stock, "
            + "value_invest, "
            + "provider_id, "
            + "department_id, "
            + "code_verification, " 
            + "user_id, "
            + "value_single " 
            + "FROM " + table + " ORDER BY name;"
            + "");
            while(getResultSet().next()){
                o = new Stock();
                o.setId(this.getResultSet().getInt(1));
                o.setName(this.getResultSet().getString(2));
                o.setStock(this.getResultSet().getInt(3));
                
                o.setValue_invest(this.getResultSet().getDouble(4));
                o.setProvider_id(this.getResultSet().getInt(5));
                o.setDepartment_id(this.getResultSet().getInt(6));
                o.setCode_verification(this.getResultSet().getString(7));
                o.setUser_id(this.getResultSet().getInt(8));
                o.setValue_single(getResultSet().getDouble(9));
                collection.add(o);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
   public List<Stock> collectionForCodeVerification(String code){
        List<Stock> collection = new ArrayList<>();
        Stock o = new Stock();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id, "
            + "name, "
            + "stock, "
            + "value_invest, "
            + "provider_id, "
            + "department_id, "
            + "code_verification, " 
            + "user_id, "
            + "value_single " 
            + "FROM " + table + " WHERE code_verification = " + code + ";"
            + "");
            while(getResultSet().next()){
                o = new Stock();
                o.setId(this.getResultSet().getInt(1));
                o.setName(this.getResultSet().getString(2));
                o.setStock(this.getResultSet().getInt(3));
                
                o.setValue_invest(this.getResultSet().getDouble(4));
                o.setProvider_id(this.getResultSet().getInt(5));
                o.setDepartment_id(this.getResultSet().getInt(6));
                o.setCode_verification(this.getResultSet().getString(7));
                o.setUser_id(this.getResultSet().getInt(8));
                o.setValue_single(getResultSet().getDouble(9));
                collection.add(o);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection; 
   }
   
   public List<Stocks> collectionStocksForNameOrCode(String search){
        List<Stocks> collection = new ArrayList<>();
        Department department = new Department();
        Stock stock = new Stock();
        Stocks stocks = new Stocks();
        Provider provider = new Provider();
        User user = new User();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "tbl_product_for_stock.id,"
            + "tbl_product_for_stock.name,"
            + "tbl_product_for_stock.stock," 
            + "tbl_product_for_stock.value_invest,"
            + "tbl_product_for_stock.provider_id,"        
            + "tbl_product_for_stock.department_id,"
            + "tbl_product_for_stock.code_verification,"
            + "tbl_product_for_stock.user_id,"        
             
            + "tbl_department.id,"        
            + "tbl_department.name,"  
                    
            + "tbl_provider.id,"  
            + "tbl_provider.name,"
            + "tbl_provider.address,"        
            + "tbl_provider.number_telephone,"        
            + "tbl_provider.email,"        
            
            + "tbl_user.id,"
            + "tbl_user.name "        
                    
            + " FROM " 
            + table + " INNER JOIN tbl_department ON tbl_department.id = tbl_product_for_stock.department_id "
            + " INNER JOIN tbl_provider ON tbl_provider.id = tbl_product_for_stock.provider_id "
            + " INNER JOIN tbl_user ON tbl_user.id = tbl_product_for_stock.user_id WHERE tbl_product_for_stock.code_verification = " + search + ";"
            + "");
            while(getResultSet().next()){
                stock = new Stock();
                department = new Department();
                stocks = new Stocks();
                provider = new Provider();
                user = new User();
                
                stock.setId(this.getResultSet().getInt(1));
                stock.setName(this.getResultSet().getString(2));
                stock.setStock(this.getResultSet().getInt(3));
                stock.setValue_invest(this.getResultSet().getDouble(4));
                stock.setProvider_id(this.getResultSet().getInt(5));
                stock.setDepartment_id(this.getResultSet().getInt(6));
                stock.setCode_verification(this.getResultSet().getString(7));
                stock.setUser_id(this.getResultSet().getInt(8));
                
                department.setId(this.getResultSet().getInt(9));
                department.setName(this.getResultSet().getString(10));
                
                provider.setId(this.getResultSet().getInt(11));
                provider.setName(this.getResultSet().getString(12));
                provider.setAddress(this.getResultSet().getString(13));
                provider.setNumber_telephone(this.getResultSet().getString(14));
                provider.setEmail(this.getResultSet().getString(15));
                
                user.setId(this.getResultSet().getInt(16));
                user.setName(this.getResultSet().getString(17));
                
                stocks.setStock(stock);
                stocks.setDepartment(department);
                stocks.setProvider(provider);
                stocks.setUser(user);
                
                collection.add(stocks);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
   public List<Stocks> collectionStocks(){
        List<Stocks> collection = new ArrayList<>();
        Department department = new Department();
        Stock stock = new Stock();
        Stocks stocks = new Stocks();
        Provider provider = new Provider();
        User user = new User();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "tbl_product_for_stock.id,"
            + "tbl_product_for_stock.name,"
            + "tbl_product_for_stock.stock," 
            + "tbl_product_for_stock.value_invest,"
            + "tbl_product_for_stock.provider_id,"        
            + "tbl_product_for_stock.department_id,"
            + "tbl_product_for_stock.code_verification,"
            + "tbl_product_for_stock.user_id,"        
             
            + "tbl_department.id,"        
            + "tbl_department.name,"  
                    
            + "tbl_provider.id,"  
            + "tbl_provider.name,"
            + "tbl_provider.address,"        
            + "tbl_provider.number_telephone,"        
            + "tbl_provider.email,"        
            
            + "tbl_user.id,"
            + "tbl_user.user_name "        
                    
            + " FROM " 
            + table + " INNER JOIN tbl_department ON tbl_department.id = tbl_product_for_stock.department_id "
            + " INNER JOIN tbl_provider ON tbl_provider.id = tbl_product_for_stock.provider_id "
            + " INNER JOIN tbl_user ON tbl_user.id = tbl_product_for_stock.user_id ;"
            + "");
            while(getResultSet().next()){
                stock = new Stock();
                department = new Department();
                stocks = new Stocks();
                provider = new Provider();
                user = new User();
                
                stock.setId(this.getResultSet().getInt(1));
                stock.setName(this.getResultSet().getString(2));
                stock.setStock(this.getResultSet().getInt(3));
                stock.setValue_invest(this.getResultSet().getDouble(4));
                stock.setProvider_id(this.getResultSet().getInt(5));
                stock.setDepartment_id(this.getResultSet().getInt(6));
                stock.setCode_verification(this.getResultSet().getString(7));
                stock.setUser_id(this.getResultSet().getInt(8));
                
                department.setId(this.getResultSet().getInt(9));
                department.setName(this.getResultSet().getString(10));
                
                provider.setId(this.getResultSet().getInt(11));
                provider.setName(this.getResultSet().getString(12));
                provider.setAddress(this.getResultSet().getString(13));
                provider.setNumber_telephone(this.getResultSet().getString(14));
                provider.setEmail(this.getResultSet().getString(15));
                
                user.setId(this.getResultSet().getInt(16));
                user.setName(this.getResultSet().getString(17));
                
                stocks.setStock(stock);
                stocks.setDepartment(department);
                stocks.setProvider(provider);
                stocks.setUser(user);
                
                collection.add(stocks);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
    
   public boolean alterStock(List<Stock> listStock) {
        try {
            this.conectar();
            for (int i = 0; i < listStock.size(); i++) {
                this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
                        + "stock = '" + listStock.get(i).getStock() + "'"
                        + " WHERE id = '" + listStock.get(i).getId() + "'"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
   
    public boolean alterStock(Stock stock) {
        try {
            this.conectar();
                this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
                        + "stock = '" + stock.getStock() + "'"
                        + " WHERE id = '" + stock.getId() + "'"
                );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
   
}
