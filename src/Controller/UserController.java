package Controller;


import Dao.UserDao;
import Model.User;
import java.util.ArrayList;


public class UserController {

    private UserDao userDao = new UserDao();
    
     public User searchForLogin(String name){
         return this.userDao.searchForLogin(name);
     }
     
     public int saveUser(User user){
         return userDao.save(user);
     }
     
     public boolean deleteUser(int idUser){
         return this.userDao.deleteForId(idUser);
     }
     
     public boolean updateUser(User user){
         return this.userDao.update(user);
     }
     
     public User searchUser(int idUser){
         return this.userDao.searchUser(idUser);
     }
     
     public User searchLogin(String login){
         return this.userDao.searchForLogin(login);
     }
     
     public ArrayList<User> collectionUser(){
         return this.userDao.collection();
     }
     
     public ArrayList<User> collectionUserOnline(){
         return this.userDao.collectionUserOline();
     }
     
     public int addUserOnline(User user){
         return userDao.addUserOnline(user);
     }
     
     public boolean saveWithHistoric(User user){
         return this.userDao.versionUserOnline(user);
     }
     
     public User searchUserOnline(){
         return this.userDao.searchUserOnline(); 
     }
     
}
