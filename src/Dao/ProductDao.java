package Dao;

import Conexao.ConnectionSingleServer;
import Conexao.ToConnectServer;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends ToConnectServer{
    static ConnectionSingleServer cc = new ConnectionSingleServer();
    static Connection cn = cc.connectWithServer();
    static PreparedStatement ps;
    public static String table = "tbl_product_for_sale";
    
    public int save(Product o){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "product_name,"
            + "stock, "
            + "product_value_sale, "
            + "stock_id, "
            + "user_id, "
            + "dateAndHours, "
            + "code_verification, "
            + "image "
            + ") VALUES ("
            + "'" +o.getName() +"',"
            + "'" +o.getStock() +"',"
            + "'" +o.getValue_sale() +"',"
            + "'" +o.getStock() +"',"
            + "'" +o.getUser_id() +"',"  
            + "'" +o.getDateAndHours() +"', "
            + "'" +o.getCode_verification() +"', "
            + "'" +o.getImage() +"' " 
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
            return this.executarUpdateDeleteSQL("DELETE FROM "  + table + " WHERE product_id = '"+id+"'");
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        } finally { 
            this.fecharConexao();
        }   
    }
    
    public boolean update (Product o){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "product_name = '"+o.getName()+"', "
            + "stock = '"+o.getStock()+"', "
            + "product_value_sale = '"+o.getValue_sale()+"', "
            + "stock_id = '"+o.getStock_id()+"', " 
            + "user_id = '"+o.getUser_id()+"', "
            + "dateAndHours = '"+o.getDateAndHours()+"', "
            + "image = '"+o.getImage()+"', "
            + "code_verification = '"+o.getCode_verification()+"' "
            + " WHERE product_id = '"+o.getId()+"' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public Product searchForId (int id){
        Product o = new Product();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "product_id,"
            + "product_name,"
            + "stock, "
            + "product_value_sale, "
            + "stock_id, "
            + "user_id, "
            + "dateAndHours, "
            + "code_verification, " 
            + "image "  
                    
            + "FROM " + table + " WHERE product_id = '"+id+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_sale(getResultSet().getDouble(4));
                o.setStock_id(getResultSet().getInt(5));
                o.setUser_id(getResultSet().getInt(6));
                o.setDateAndHours(getResultSet().getString(7));
                o.setCode_verification(getResultSet().getString(8));
                o.setImage(getResultSet().getString(9));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public List<Product> searchForName (String name){
        Product o = new Product();
        List<Product> collection = new ArrayList<>();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "product_id,"
            + "product_name,"
            + "stock, "
            + "product_value_sale, "
            + "stock_id, "
            + "user_id, "
            + "dateAndHours, "
            + "code_verification, "
            + "image "
            + "FROM " + table + " WHERE product_name LIKE '%"+name+"%'");
            while(this.getResultSet().next()){
                o = new Product();
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_sale(getResultSet().getDouble(4));
                o.setStock_id(getResultSet().getInt(5));
                o.setUser_id(getResultSet().getInt(6));
                o.setDateAndHours(getResultSet().getString(7));
                o.setCode_verification(getResultSet().getString(8));
                o.setImage(getResultSet().getString(9));
                collection.add(o);
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return collection; 
   }
   
   public Product searchForCodeVerication (String code){
        Product o = new Product();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "product_id,"
            + "product_name,"
            + "stock, "
            + "product_value_sale, "
            + "stock_id, "
            + "user_id, "
            + "dateAndHours, "
            + "code_verification, "
            + "image "
            + "FROM " + table + " WHERE code_verification = '"+code+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_sale(getResultSet().getDouble(4));
                o.setStock_id(getResultSet().getInt(5));
                o.setUser_id(getResultSet().getInt(6));
                o.setDateAndHours(getResultSet().getString(7));
                o.setCode_verification(getResultSet().getString(8));
                o.setImage(getResultSet().getString(9));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public Product searchForname (String name){
        Product o = new Product();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "product_id,"
            + "product_name,"
            + "stock, "
            + "product_value_sale, "
            + "stock_id, "
            + "user_id, "
            + "dateAndHours, " 
            + "image "  
                    
            + "FROM " + table + " WHERE product_name = '"+name+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_sale(getResultSet().getDouble(4));
                o.setStock_id(getResultSet().getInt(5));
                o.setUser_id(getResultSet().getInt(6));
                o.setDateAndHours(getResultSet().getString(7));
                o.setCode_verification(getResultSet().getString(8));
                o.setImage(getResultSet().getString(9));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
   public List<Product> collection() {
        List<Product> collection = new ArrayList<>();
        Product o = new Product();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "product_id,"
            + "product_name,"
            + "stock, "
            + "product_value_sale, "
            + "stock_id, "
            + "user_id, "
            + "dateAndHours, "
            + "code_verification, "
            + "image "
            + "FROM " + table + " ORDER BY product_name;"
            + "");
            while(getResultSet().next()){
                o = new Product();
                o.setId(getResultSet().getInt(1));
                o.setName(getResultSet().getString(2));
                o.setStock(getResultSet().getInt(3));
                o.setValue_sale(getResultSet().getDouble(4));
                o.setStock_id(getResultSet().getInt(5));
                o.setUser_id(getResultSet().getInt(6));
                o.setDateAndHours(getResultSet().getString(7));
                o.setCode_verification(getResultSet().getString(8));
                o.setImage(getResultSet().getString(9));
                collection.add(o);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
   public boolean alterStock(List<Product> collection) {
        try {
            this.conectar();
            for (int i = 0; i < collection.size(); i++) {
                System.out.println(">>> collection.get(i).getStock(): " + collection.get(i).getStock());
                this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
                        + " stock = '" + collection.get(i).getStock() + "'"
                        + " WHERE product_id = '" + collection.get(i).getId() + "'"
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
   
//   public List<Stocks> collectionStocks(){
//        List<Stocks> collection = new ArrayList<>();
//        Department department = new Department();
//        Stock stock = new Stock();
//        Stocks stocks = new Stocks();
//        Provider provider = new Provider();
//        User user = new User();
//        
//        try {
//            this.conectar();
//            this.executarSQL("SELECT "
//            + "tbl_product_for_stock.id,"
//            + "tbl_product_for_stock.name,"
//            + "tbl_product_for_stock.stock," 
//            + "tbl_product_for_stock.value_invest,"
//            + "tbl_product_for_stock.provider_id,"        
//            + "tbl_product_for_stock.department_id,"
//            + "tbl_product_for_stock.code_verification,"
//            + "tbl_product_for_stock.user_id,"        
//             
//            + "tbl_department.id,"        
//            + "tbl_department.name,"  
//                    
//            + "tbl_provider.id,"  
//            + "tbl_provider.name,"
//            + "tbl_provider.address,"        
//            + "tbl_provider.number_telephone,"        
//            + "tbl_provider.email,"        
//            
//            + "tbl_user.id,"
//            + "tbl_user.name "        
//                    
//            + " FROM " 
//            + table + " INNER JOIN tbl_department ON tbl_department.id = tbl_product_for_stock.department_id "
//            + " INNER JOIN tbl_provider ON tbl_provider.id = tbl_product_for_stock.provider_id "
//            + " INNER JOIN tbl_user ON tbl_user.id = tbl_product_for_stock.user_id ;"
//            + "");
//            while(getResultSet().next()){
//                stock = new Stock();
//                department = new Department();
//                stocks = new Stocks();
//                provider = new Provider();
//                user = new User();
//                
//                stock.setId(this.getResultSet().getInt(1));
//                stock.setName(this.getResultSet().getString(2));
//                stock.setStock(this.getResultSet().getInt(3));
//                stock.setValue_invest(this.getResultSet().getDouble(4));
//                stock.setProvider_id(this.getResultSet().getInt(5));
//                stock.setDepartment_id(this.getResultSet().getInt(6));
//                stock.setCode_verification(this.getResultSet().getString(7));
//                stock.setUser_id(this.getResultSet().getInt(8));
//                
//                department.setId(this.getResultSet().getInt(9));
//                department.setName(this.getResultSet().getString(10));
//                
//                provider.setId(this.getResultSet().getInt(11));
//                provider.setName(this.getResultSet().getString(12));
//                provider.setAddress(this.getResultSet().getString(13));
//                provider.setNumber_telephone(this.getResultSet().getString(14));
//                provider.setEmail(this.getResultSet().getString(15));
//                
//                user.setId(this.getResultSet().getInt(16));
//                user.setName(this.getResultSet().getString(17));
//                
//                stocks.setStock(stock);
//                stocks.setDepartment(department);
//                stocks.setProvider(provider);
//                stocks.setUser(user);
//                
//                collection.add(stocks);
//            }
//   } catch (Exception e) {
//   e.printStackTrace();
//   }finally{
//   this.fecharConexao();
//   }
//   return collection;
//   }
   
}
