package Dao.CreateDataBase;

import Components.ViewShowAlertDialog;
import Conexao.ConnectionSingleServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controller.Enums.DataBase;

public class CreateIfNotExist {
    
    private ViewShowAlertDialog alertDialog;
    ConnectionSingleServer con = new ConnectionSingleServer();      
    Connection cn = con.connectInitial();
    
    private Boolean dataBase () {
        Boolean create = false;
        PreparedStatement pstm;
        String sql = "CREATE DATABASE IF NOT EXISTS " + DataBase.DATA_BASE.getDesc() + ";";
        try {
            pstm = cn.prepareStatement(sql);
            pstm.execute(); 
            create = true;
            //pstm.close();
        } catch (SQLException e) {
            alertDialog = new ViewShowAlertDialog(null, true, "Not create a database!", "Error");
        }
        return create;
    }
    
    public Boolean dataBaseExist () {
        Boolean create = false;
        if (!dataBase())
            create = false;
        else if (dataBase())
            create = true;
        
        return create;
    }
    
}
