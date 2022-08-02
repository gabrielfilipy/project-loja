package Controller;

import Dao.*;
import Model.*;
import java.util.List;

public class DepartmentController {
    
    DepartmentDao dao = new DepartmentDao();
    
    public int save(Department o){
        return dao.save(o);
    }
    
    public boolean delete(int idUser){
        return this.dao.deleteForId(idUser);
    }
    
    public List<Department> collection(){
        return this.dao.collection();
    }
    
    public Department searchForId(int id){
        return this.dao.searchForId(id);
    }
    
    public Department searchForName(String name){
        return this.dao.searchForName(name);
    }
    
    public boolean update(Department o){
        return this.dao.update(o);
    }
    
}
