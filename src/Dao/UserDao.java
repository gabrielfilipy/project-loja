package Dao;

import Conexao.ToConnectServer;
import Model.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserDao extends ToConnectServer{
   
    public static String table = "tbl_user";
    
    /*
        Save
    */
    public int save(User user){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO "+ table + " ("    
            + "user_name,"
            + "password, "    
            + "login "          
            + ") VALUES ("
            + "'" +user.getName() +"',"
            + "'" +user.getPassword() +"',"
            + "'" +user.getLogin() +"'"
                    
            + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
    /*
        Delete for ID
    */
    public boolean deleteForId(int IdUser){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM "  + table + " WHERE id = '"+IdUser+"'");
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        } finally { 
            this.fecharConexao();
        }   
    }
    
    /*
        Update
    */
    public boolean update (User user){
        try {
            this.conectar(); 
            return this.executarUpdateDeleteSQL("UPDATE " + table + " SET "
            + "user_name = '"+user.getName()+"',"
            + "login = '"+user.getLogin()+"',"
            + "password = '"+user.getPassword()+"' "      
            + " WHERE id = '"+user.getId()+"'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
    /*
        Search user for ID
    */
   public User searchUser (int IdUser){
        User user = new User();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "user_name,"
            + "password, "
            + "login "
                    
            + "FROM " + table + " WHERE id = '"+IdUser+"'");
            while(this.getResultSet().next()){
                user.setId(getResultSet().getInt(1));
                user.setName(getResultSet().getString(2));
                user.setPassword(getResultSet().getString(3));
                user.setLogin(getResultSet().getString(4));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return user; 
   }
   
   public User searchUserForLogin (String login){
        User user = new User();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "user_name,"
            + "password,"    
            + "login "  
                    
            + "FROM " + table + " WHERE name = '"+login+"'");
            while(this.getResultSet().next()){
                user.setId(getResultSet().getInt(1));
                user.setName(getResultSet().getString(2));
                user.setPassword(getResultSet().getString(3));
                user.setLogin(getResultSet().getString(4));
             }
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
        this.fecharConexao();
   } return user; 
   }
    
   /*
    Collection User
   */
   public ArrayList<User> collection(){
        ArrayList<User> collectionUser = new ArrayList<>();
        User user = new User();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id, "
            + "user_name, "
            + "password, "
            + "login "
            + "FROM " + table + " ORDER BY user_name;"
            + "");
            while(getResultSet().next()){
                user = new User();
                user.setId(this.getResultSet().getInt(1));
                user.setName(this.getResultSet().getString(2));
                user.setPassword(this.getResultSet().getString(3));
                user.setLogin(this.getResultSet().getString(4));
                collectionUser.add(user);
            }
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return collectionUser;
   }
   
   /*
    Search for name amd password
   */
   public boolean collectionUserForNameAndPassword(User user) {
        try {
             this.conectar();
             this.executarSQL(""
             + "SELECT "
             + "id, "
             + "user_name "
             + "FROM " + table + " WHERE name = '"+user.getName()+"' AND password = '"+user.getPassword()+"'");

        if(getResultSet().next()){
              return true;
        }else{
             return false;   
        }

         } catch (Exception e) {
             e.printStackTrace();
             return false;
        } finally {
             this.fecharConexao();
        }  
       
    }
   
   /*
    Search for login
   */
   public User searchForLogin (String login){
        User User = new User();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "id, "
            + "user_name, "
            + "login "
            + "FROM " + table + " WHERE login = '"+login+"'");
            while(this.getResultSet().next()){
            User.setId(getResultSet().getInt(1));
            User.setName(getResultSet().getString(2));
            User.setLogin(getResultSet().getString(3));
            }
        } catch (Exception e) {
        } finally {
            this.fecharConexao();
        } return User;
   }
   
    public ArrayList<User> collectionUserOline(){
        ArrayList<User> collectionUser = new ArrayList<>();
        User user = new User();
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "id, "
            + "user_id "
            + "FROM tbl_user_online;"
            + "");
            while(getResultSet().next()){
                user = new User();
                user.setId(this.getResultSet().getInt(1));
                collectionUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
            return collectionUser;
    }
    
   //USER ONLINE
   public int addUserOnline(User user){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_user_online ("    
            + "user_id "
            + ") VALUES ("
            + "'" + user.getId() +"' "
                    
            + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
   
    public boolean versionUserOnline (User user) {
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_user_online SET "
            + "user_id = '"+user.getId() + "', " 
            + " dt_end = '"+d.format(LocalDateTime.now()) + "' WHERE dt_end IS NULL;"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }  
   }
    
   public User searchUserOnline () { 
        User user = new User();
        try {
            this.conectar();
            this.executarSQL(""
            + "SELECT "
            + "user_id, "
            + "dt_end "
            + "FROM tbl_user_online WHERE dt_end IS NULL");
            while(this.getResultSet().next()){
                user.setId(getResultSet().getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             this.fecharConexao();
        } return user; 
   }
    
}
