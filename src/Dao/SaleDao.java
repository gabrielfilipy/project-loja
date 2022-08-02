package Dao;

import Conexao.ConnectionSingleServer;
import Conexao.ToConnectServer;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SaleDao extends ToConnectServer {
    static ConnectionSingleServer cc = new ConnectionSingleServer();
    static Connection cn = cc.connectWithServer();
    static PreparedStatement ps;
    public static String table = "tbl_sales";
    public static String table2 = "tbl_sale_product";
    
    public int save(Sale o) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "type_sales_id,"
            + "user_id, "
            + "client_id, "
            + "sale_date, "
            + "the_amount, "
            + "net_value, "
            + "gross_value, "
            + "discount, "
            + "total_value, "
            + "shift_id, "
            + "status, "
            + "user_id_alter_status, "
            + "date_status "
            + ") VALUES ("
            + "'" +o.getType_sale() +"',"
            + "'" +o.getUser_id() +"',"
            + "'" +o.getClienteId() +"',"
            + "'" +o.getDate() +"',"
            + "'" +o.getThe_amount() +"', "
            + "'" +o.getNetValue() +"', "
            + "'" +o.getGross_value() +"', "
            + "'" +o.getDiscount() +"', "
            + "'" +o.getTotal_value() +"', "
            + "'" +o.getShift_id() +"', "
            + "'" +o.getStatus() +"', "
            + "'" +o.getUserIdAlterStatus() +"', "
            + "'" +o.getDateStatus() +"' "
            + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
    public boolean saveCollectionSale(Set<Sale> collection) {
        try {
            this.conectar();
            collection.forEach(sale -> {
            this.insertSQL(
                "INSERT INTO " + table + " ("
            + "sale_id, "
            + "type_sales_id, "
            + "user_id, "
            + "client_id, "
            + "sale_date, "
            + "the_amount, "
            + "net_value, "
            + "gross_value, "
            + "discount, "
            + "total_value, "
            + "shift_id, "
            + "status, "
            + "user_id_alter_status, "
            + "date_status "
            + ") VALUES ("
            + "'" +sale.getIdSale() +"',"
            + "'" +sale.getType_sale() +"',"
            + "'" +sale.getUser_id() +"',"
            + "'" +sale.getClienteId() +"',"
            + "'" +sale.getDate() +"',"
            + "'" +sale.getThe_amount() +"', "
            + "'" +sale.getNetValue() +"', "
            + "'" +sale.getGross_value() +"', "
            + "'" +sale.getDiscount() +"', "
            + "'" +sale.getTotal_value() +"', "
            + "'" +sale.getShift_id() +"', "
            + "'" +sale.getStatus() +"', "
            + "'" +sale.getUserIdAlterStatus() +"', "
            + "'" +sale.getDateStatus() +"' "
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
    
    public boolean salvarListaVendaProdutoDAO(List<SaleProduct> collection) {
        try {
            this.conectar();
            int contando = collection.size();
            for (int i = 0; i < contando; i++) {
            this.insertSQL(
                "INSERT INTO " + table2 + " ("
                    + "product_id,"
                    + "sale_id,"
                    + "user_id,"
                    + "client_id,"
                    + "value_sale,"
                    + "amount "
                   
                + ") VALUES ("
                    + "'" + collection.get(i).getProduct_id()+ "',"
                    + "'" + collection.get(i).getSale_id() + "',"
                    + "'" + collection.get(i).getUser_id() + "',"
                    + "'" + collection.get(i).getClient_id() + "',"
                    + "'" + collection.get(i).getValue_sale() + "',"
                    + "'" + collection.get(i).getAmount() + "' "
                + ");"
            );
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao(); 
        }   
    }
    
    public boolean salvarListaVendaProdutoSet(Set<SaleProduct> collection) {
        try {
            this.conectar();
            int contando = collection.size();
            collection.forEach(s -> {
            this.insertSQL(
                "INSERT INTO " + table2 + " ("
                    + "product_id,"
                    + "sale_id,"
                    + "user_id,"
                    + "client_id,"
                    + "value_sale,"
                    + "amount, "
                    + "date "
                   
                + ") VALUES ("
                    + "'" + s.getProduct_id()+ "',"
                    + "'" + s.getSale_id() + "',"
                    + "'" + s.getUser_id() + "',"
                    + "'" + s.getClient_id() + "',"
                    + "'" + s.getValue_sale() + "',"
                    + "'" + s.getAmount() + "', "
                    + "'" + s.getDate() + "' "
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
    
    public boolean deleteForId(int id){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM "  + table + " WHERE sale_id = '"+id+"'");
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        } finally { 
            this.fecharConexao();
        }   
    }
    
    public boolean update (Sale o) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "type_sales_id = '"+o.getType_sale()+"', "
            + "user_id = '"+o.getUser_id()+"', "
            + "client_id = '"+o.getClienteId()+"', "
            + "sale_date = '"+o.getDate()+"', " 
            + "the_amount = '"+o.getThe_amount()+"', "
            + "net_value = '"+o.getNetValue()+"', "
            + "gross_value = '"+o.getGross_value()+"', " 
            + "discount = '"+o.getDiscount()+"', "
            + "total_value = '"+o.getTotal_value()+"', "
            + "shift_id = '"+o.getShift_id()+"', "
            + "sale_cancel = '"+o.getStatus()+"', "
            + "sale_abandoned = '"+o.getAbandoned()+"', "
            + "id = '"+o.getId()+"' "
            + " WHERE sale_id = '"+o.getId()+"' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public Sale searchForId (int id) {
        Sale o = new Sale();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "sale_id,"
            + "type_sales_id,"
            + "user_id, "
            + "client_id, "
            + "sale_date, "
            + "the_amount, "
            + "net_value, "
            + "gross_value, "
            + "discount, "
            + "total_value, "
            + "shift_id, "
            + "status, "
            + "user_id_alter_status, "
            + "date_status "
                    
            + "FROM " + table + " WHERE id = '"+id+"'");
            while(this.getResultSet().next()){
                o.setId(getResultSet().getInt(1));
                o.setType_sale(getResultSet().getInt(2));
                o.setUser_id(getResultSet().getInt(3));
                o.setClienteId(getResultSet().getInt(4));
                o.setDate(getResultSet().getString(5));
                o.setThe_amount(getResultSet().getInt(6));
                o.setNetValue(getResultSet().getDouble(7));
                o.setGross_value(getResultSet().getDouble(8));
                o.setDiscount(getResultSet().getDouble(9));
                o.setTotal_value(getResultSet().getDouble(10));
                o.setShift_id(getResultSet().getInt(11));
                o.setStatus(getResultSet().getString(12));
                o.setUserIdAlterStatus(getResultSet().getInt(13));
                o.setDateStatus(getResultSet().getString(14));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return o; 
   }
   
//   public List<Sale> collection(String dateIni, String dateEnd){
//        List<Sale> collection = new ArrayList<>();
//        Sale o = new Sale();
//        try {
//            this.conectar();
//            this.executarSQL("SELECT "
//            + "id, "
//            + "type_sales_id, "
//            + "user_id, "
//            + "client_id, "
//            + "date, "
//            + "hours, "
//            + "the_amount, "
//            + "net_value, "
//            + "gross_value, "
//            + "discount, "
//            + "total_value, "
//            + "payment_id " 
//                    
//            + " FROM " + table + " WHERE date BETWEEN '" + dateIni + "' AND '" + dateEnd + "';"
//            + "");
//            while(this.getResultSet().next()){
//                o = new Sale();
//                o.setId(getResultSet().getInt(1));
//                o.setType_sale(getResultSet().getInt(2));
//                o.setUser_id(getResultSet().getInt(3));
//                o.setClienteId(getResultSet().getInt(4));
//                o.setDate(getResultSet().getDate(5));
//                o.setHours(getResultSet().getString(6));
//                o.setThe_amount(getResultSet().getInt(7));
//                o.setNetValue(getResultSet().getDouble(8));
//                o.setGross_value(getResultSet().getDouble(9));
//                o.setDiscount(getResultSet().getDouble(10));
//                o.setTotal_value(getResultSet().getDouble(11));
//                o.setPayment_id(getResultSet().getInt(12));
//                collection.add(o);
//             }
//   } catch (Exception e) {
//   e.printStackTrace();
//   }finally{
//   this.fecharConexao();
//   }
//   return collection;
//   }
   
   public List<Sale> collection() {
        List<Sale> collection = new ArrayList<>();
        Sale o = new Sale();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "sale_id, "
            + "type_sales_id, "
            + "user_id, "
            + "client_id, "
            + "sale_date, "
            + "the_amount, "
            + "net_value, "
            + "gross_value, "
            + "discount, "
            + "total_value, "
            + "shift_id "
                    
            + " FROM " + table + ";"
            + "");
            while(this.getResultSet().next()){
                o = new Sale();
                o.setId(getResultSet().getInt(1));
                o.setType_sale(getResultSet().getInt(2));
                o.setUser_id(getResultSet().getInt(3));
                o.setClienteId(getResultSet().getInt(4));
                o.setDate(getResultSet().getString(5));
                o.setThe_amount(getResultSet().getInt(6));
                o.setNetValue(getResultSet().getDouble(7));
                o.setGross_value(getResultSet().getDouble(8));
                o.setDiscount(getResultSet().getDouble(9));
                o.setTotal_value(getResultSet().getDouble(10));
                o.setShift_id(getResultSet().getInt(11));
                collection.add(o);
             }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
   public List<SaleProducts> collection(String dateIni, String dateEnd) {
        List<SaleProducts> collection = new ArrayList<>();
        SaleProducts saleProducts = new SaleProducts();
        Sale sale = new Sale();
        User user = new User();
        Client client = new Client();
        SettingSystem settingSystem = new SettingSystem();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
      + "loja.tbl_sales.sale_date," +
"	loja.tbl_sales.total_value," +
"	loja.tbl_sales.the_amount," +
"	loja.tbl_sales.sale_id," +
"	loja.tbl_setting_of_system.name_company," +
"	loja.tbl_setting_of_system.cnpj," +
                    
"	loja.tbl_client.id," +
"	loja.tbl_client.telephone," +
"	loja.tbl_client.email," +
"	loja.tbl_client.address," +
"	loja.tbl_client.active," +
                    
"	loja.tbl_user.user_name," +
                    
"	loja.tbl_client.client_name," +
"	loja.tbl_sales.type_sales_id," +
"	loja.tbl_sales.user_id," +
"	loja.tbl_sales.client_id," +
"	loja.tbl_sales.net_value," +
"	loja.tbl_sales.gross_value," +
"	loja.tbl_sales.discount," +
"	loja.tbl_user.id" +
" FROM loja.tbl_sales" +
"	INNER JOIN loja.tbl_client ON " +
"	 loja.tbl_sales.client_id = loja.tbl_client.id " +
"	INNER JOIN loja.tbl_user ON " +
"	 loja.tbl_sales.user_id = loja.tbl_user.id ," +
"	loja.tbl_setting_of_system WHERE loja.tbl_sales.sale_date BETWEEN '" + dateIni + "' AND '" + dateEnd + "' ");
            while(getResultSet().next()){
                sale = new Sale();
                user = new User();
                client = new Client();
                settingSystem = new SettingSystem();
                saleProducts = new SaleProducts();
                
                sale.setDate(this.getResultSet().getString(1));
                sale.setTotal_value(this.getResultSet().getDouble(2));
                sale.setThe_amount(this.getResultSet().getInt(3));
                sale.setId(this.getResultSet().getInt(4));
                
                settingSystem.setName(this.getResultSet().getString(5));
                settingSystem.setCnpj(this.getResultSet().getString(6));
                
                client.setId(this.getResultSet().getInt(7));
                client.setTelephone(this.getResultSet().getString(8));
                client.setEmail(this.getResultSet().getString(9));
                client.setAddress(this.getResultSet().getString(10));
                client.setActive(this.getResultSet().getInt(11)); 
                
                user.setName(this.getResultSet().getString(12));
                
                client.setName(this.getResultSet().getString(13));
              
                sale.setType_sale(this.getResultSet().getInt(14));
                sale.setUser_id(this.getResultSet().getInt(15));
                sale.setClienteId(this.getResultSet().getInt(16));
                sale.setNetValue(this.getResultSet().getDouble(17));
                sale.setGross_value(this.getResultSet().getDouble(18));
                
                sale.setDiscount(this.getResultSet().getDouble(19));
                user.setId(this.getResultSet().getInt(20));
                
                saleProducts.setClient(client);
                saleProducts.setUser(user);
                saleProducts.setSale(sale);
                saleProducts.setSettingSystem(settingSystem);
                 
                collection.add(saleProducts);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
    public List<SaleProducts> saleProduct(){
        List<SaleProducts> collection = new ArrayList<>();
        SaleProducts saleProducts = new SaleProducts();
        Sale sale = new Sale();
        SaleProduct product = new SaleProduct();
        User user = new User();
        Client client = new Client();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + table + ".id,"   
            + table + ".type_sales_id,"  
            + table + ".user_id,"  
            + table + ".client_id,"          
            + table + ".date," 
            + table + ".the_amount,"   
            + table + ".net_value,"  
            + table + ".gross_value," 
            + table + ".discount,"         
            + table + ".total_value," 
            + table + ".payment_id,"     
                    
            + "tbl_sale_product.id,"  
            + "tbl_sale_product.name,"          
            + "tbl_sale_product.sale_id,"  
            + "tbl_sale_product.user_id,"          
            + "tbl_sale_product.value_sale,"          
            + "tbl_sale_product.amount, "   
                    
            + "tbl_client.id, "  
            + "tbl_client.client_name, "          
            + "tbl_client.telephone, "    
            + "tbl_client.email, "          
            + "tbl_client.address, "     
            + "tbl_client.active, "          
                    
            + "tbl_user.id, "          
            + "tbl_user.user_name, "      
                    
            + " FROM " 
            + table + " INNER JOIN " + table + " ON " + table + ".id = tbl_sale_product.sale_id;"
            + "");
            while(getResultSet().next()){
                sale = new Sale();
                product = new SaleProduct();
                
                sale.setId(this.getResultSet().getInt(1));
                sale.setType_sale(this.getResultSet().getInt(2));
                sale.setUser_id(this.getResultSet().getInt(3));
                sale.setClienteId(this.getResultSet().getInt(4));
                sale.setDate(this.getResultSet().getString(5));
                sale.setThe_amount(this.getResultSet().getInt(6));
                sale.setNetValue(this.getResultSet().getDouble(7));
                sale.setGross_value(this.getResultSet().getDouble(8));
                sale.setDiscount(this.getResultSet().getDouble(9));
                sale.setTotal_value(this.getResultSet().getDouble(10));
                sale.setPayment_id(this.getResultSet().getInt(11));
                
                product.setId(this.getResultSet().getInt(13));
                product.setProduct_id(this.getResultSet().getInt(14));
                product.setSale_id(this.getResultSet().getInt(15));
                product.setUser_id(this.getResultSet().getInt(16));
                product.setValue_sale(this.getResultSet().getDouble(17));
                product.setAmount(this.getResultSet().getInt(18));
                
                client.setId(this.getResultSet().getInt(19));
                client.setName(this.getResultSet().getString(20));
                client.setTelephone(this.getResultSet().getString(21));
                client.setEmail(this.getResultSet().getString(22));
                client.setAddress(this.getResultSet().getString(23));
                client.setActive(this.getResultSet().getInt(24));
                
                user.setId(this.getResultSet().getInt(25));
                user.setName(this.getResultSet().getString(26));
                
                saleProducts.setClient(client);
                saleProducts.setUser(user);
                saleProducts.setSale(sale);
                saleProducts.setSaleProduct(product);
                 
                collection.add(saleProducts);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
    
    public List<SaleProducts> saleProduct(int id){
        List<SaleProducts> collection = new ArrayList<>();
        SaleProducts saleProducts = new SaleProducts();
        Sale sale = new Sale();
        SaleProduct product = new SaleProduct();
        User user = new User();
        Client client = new Client();
        Product p = new Product();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + table + ".sale_id, "   
            + table + ".type_sales_id, "  
            + table + ".user_id, "  
            + table + ".client_id, "          
            + table + ".sale_date, " 
            + table + ".the_amount, "   
            + table + ".net_value, "  
            + table + ".gross_value, " 
            + table + ".discount, "         
            + table + ".total_value, " 
                    
            + "tbl_sale_product.id,"  
            + "tbl_sale_product.product_id,"          
            + "tbl_sale_product.sale_id,"  
            + "tbl_sale_product.user_id,"          
            + "tbl_sale_product.value_sale,"          
            + "tbl_sale_product.amount, "            
                   
            + "tbl_user.id, "          
            + "tbl_user.user_name, "  
                    
            + "tbl_product_for_sale.product_id, "
            + "tbl_product_for_sale.product_name "
            + " FROM " 
            + " tbl_sale_product INNER JOIN " + table + " ON  tbl_sale_product.sale_id = " + table + ".sale_id "
            + " INNER JOIN tbl_user ON tbl_sale_product.user_id = tbl_user.id "
            + " INNER JOIN tbl_product_for_sale ON tbl_sale_product.product_id = tbl_product_for_sale.product_id "
            + " WHERE tbl_sale_product.sale_id = " + id + "; "
            + "");
            while(getResultSet().next()){
                sale = new Sale();
                product = new SaleProduct();
                user = new User();
                client = new Client();
                saleProducts = new SaleProducts();
                p = new Product();
                
                sale.setId(this.getResultSet().getInt(1));
                sale.setType_sale(this.getResultSet().getInt(2));
                sale.setUser_id(this.getResultSet().getInt(3));
                sale.setClienteId(this.getResultSet().getInt(4));
                sale.setDate(this.getResultSet().getString(5));
                sale.setThe_amount(this.getResultSet().getInt(6));
                sale.setNetValue(this.getResultSet().getDouble(7));
                sale.setGross_value(this.getResultSet().getDouble(8));
                sale.setDiscount(this.getResultSet().getDouble(9));
                sale.setTotal_value(this.getResultSet().getDouble(10));
                
                product.setId(this.getResultSet().getInt(11));
                product.setProduct_id(this.getResultSet().getInt(12));
                product.setSale_id(this.getResultSet().getInt(13));
                product.setUser_id(this.getResultSet().getInt(14));
                product.setValue_sale(this.getResultSet().getDouble(15));
                product.setAmount(this.getResultSet().getInt(16));
              
//                client.setId(this.getResultSet().getInt(19));
//                client.setName(this.getResultSet().getString(20));
//                client.setTelephone(this.getResultSet().getString(21));
//                client.setEmail(this.getResultSet().getString(22));
//                client.setAddress(this.getResultSet().getString(23));
//                client.setActive(this.getResultSet().getInt(24));
//                
                user.setId(this.getResultSet().getInt(17));
                user.setName(this.getResultSet().getString(18));
                p.setId(this.getResultSet().getInt(19));
                p.setName(this.getResultSet().getString(20));
                
//                saleProducts.setClient(client);
                saleProducts.setUser(user);
                saleProducts.setSale(sale);
                saleProducts.setSaleProduct(product);
                saleProducts.setProduct(p);
                collection.add(saleProducts);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
    
   public List<SaleProducts> saleProductForPDF(int code){
        List<SaleProducts> collection = new ArrayList<>();
        SaleProducts saleProducts = new SaleProducts();
        Sale sale = new Sale();
        SaleProduct product = new SaleProduct();
        User user = new User();
        Client client = new Client();
        SettingSystem settingSystem = new SettingSystem();
        Product productForSale = new Product();
        Payment payment = new Payment();
        
        try {
            this.conectar();
            this.executarSQL("SELECT loja.tbl_setting_of_system.cnpj, " +
                " loja.tbl_setting_of_system.name_company, " +
                " loja.tbl_setting_of_system.address, " +
                    
                " loja.tbl_sales.sale_date, " +
                " loja.tbl_sales.gross_value, " +
                " loja.tbl_sales.discount, " +
                " loja.tbl_sales.the_amount, " +
                " loja.tbl_sales.total_value, " +  
                    
                " loja.tbl_sale_product.product_id, " +
                " loja.tbl_sale_product.amount, " +
                " loja.tbl_sale_product.value_sale, " +  
                    
                " loja.tbl_product_for_sale.product_name, " +
                " loja.tbl_product_for_sale.product_id, " +
                
                " loja.tbl_user.user_name, " + 
                    
                " loja.tbl_payments.description, " +
                    
                " loja.tbl_client.client_name " +    
                    
                "FROM loja.tbl_sale_product INNER JOIN loja.tbl_sales ON  loja.tbl_sale_product.sale_id = loja.tbl_sales.sale_id " +
                " INNER JOIN loja.tbl_setting_of_system ON loja.tbl_sale_product.id " +
                " INNER JOIN loja.tbl_product_for_sale ON loja.tbl_sale_product.product_id = loja.tbl_product_for_sale.product_id " +
                " INNER JOIN loja.tbl_user ON loja.tbl_sale_product.user_id = loja.tbl_user.id " + 
                " INNER JOIN loja.tbl_payments ON loja.tbl_sales.payment_id = loja.tbl_payments.id  " + 
                " INNER JOIN loja.tbl_client ON loja.tbl_sales.client_id = loja.tbl_client.id " +
                " AND loja.tbl_sale_product.client_id = loja.tbl_client.id WHERE loja.tbl_sale_product.sale_id = " + code); 
            while(getResultSet().next()){
                sale = new Sale();
                productForSale = new Product();
                user = new User();
                client = new Client();
                settingSystem = new SettingSystem();
                saleProducts = new SaleProducts();
                payment = new Payment();
                product = new SaleProduct();
                
                settingSystem.setCnpj(this.getResultSet().getString(1));
                settingSystem.setName(this.getResultSet().getString(2));
                settingSystem.setAddress(this.getResultSet().getString(3));
                
                sale.setDate(this.getResultSet().getString(4));
                sale.setGross_value(this.getResultSet().getDouble(5));
                sale.setDiscount(this.getResultSet().getDouble(6));
                sale.setThe_amount(this.getResultSet().getInt(7));
                sale.setTotal_value(this.getResultSet().getDouble(8));
                
                product.setProduct_id(this.getResultSet().getInt(9));
                product.setAmount(this.getResultSet().getInt(10));
                product.setValue_sale(this.getResultSet().getDouble(11));
                
                productForSale.setName(this.getResultSet().getString(12));
                productForSale.setId(this.getResultSet().getInt(13));
                
                user.setName(this.getResultSet().getString(14));
                
                payment.setDescription(this.getResultSet().getString(15));
                
                client.setName(this.getResultSet().getString(16));
                
                saleProducts.setClient(client);
                saleProducts.setUser(user);
                saleProducts.setSale(sale);
                saleProducts.setSettingSystem(settingSystem);
                saleProducts.setPayment(payment);
                saleProducts.setProduct(productForSale);
                saleProducts.setSaleProduct(product);
                
                collection.add(saleProducts);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collection;
   }
   
}
