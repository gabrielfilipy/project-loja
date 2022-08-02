
package Conexao;

import Controller.Enums.DataBase;
import Controller.Enums.Scripts;
import View.Connection.ConnectionView;
import java.awt.Color;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionSingleServer {
    
    private static String USER_ROOT = DataBase.USER_ROOT.getDesc();
    private static String USER_SERVE = DataBase.USER_SERVER.getDesc();
    private static String PASSWORD_SERVER = DataBase.PASSWORD_SERVER.getDesc();
    private static String PASSWORD_ROOT = DataBase.PASSWORD_ROOT.getDesc();
    private static String DATABASE = DataBase.DATA_BASE.getDesc();
    private static String LOCAL_HOST = DataBase.LOCAL.getDesc();
    private static String PORT = DataBase.PORT.getDesc();
    
    Connection conect = null;     
    
    /*
        Para configurar o usuário SERVER no SGBD e dar suas permissões para o mesmo é necessário ter uma conexão inicial com o usuário ROOT para esse usuário cadastrar o usuário SERVER.
    */
    
    public Connection connectInitial() { 
        try {   
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://" + LOCAL_HOST + ":" + PORT + "/" + DATABASE, USER_ROOT, PASSWORD_ROOT); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao BANCO: " + DATABASE);
        }
            return conect;
    } 
    
    public Connection connectWithServer() { 
        try {   
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://" + LOCAL_HOST + ":" + PORT + "/" + DATABASE, USER_SERVE, PASSWORD_SERVER); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao BANCO: " + DATABASE);
        }
            return conect;
    } 
    
    public Boolean connectWithServer(String local, String port, String user, String password) { 
        try {   
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://" + local + ":" + port + "", user, password); 
        } catch (Exception e) {
            return false;
        }
            return true;
    } 
      
    public static Connection make_connection() throws SQLException { 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+LOCAL_HOST+"/"+DATABASE, USER_SERVE, PASSWORD_SERVER);  
        } catch (ClassNotFoundException e) {
            throw new SQLDataException(e.getException());
        }
    }
    
    public static Connection make_connection_client(String ip) throws SQLException { 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+LOCAL_HOST+"/"+DATABASE, USER_SERVE, PASSWORD_SERVER); 
        } catch (ClassNotFoundException e) {
            throw new SQLDataException(e.getException());
        }
    }
    
    public void runScript () throws SQLException {
        Connection con = connectInitial();
        for (Scripts scripts: Scripts.values()) {
            System.out.println(">> Query: " + scripts.getDescricao());
            PreparedStatement pstm = con.prepareStatement(scripts.getDescricao());
            pstm.executeUpdate();
            pstm.close();
        }
    }
    
}
