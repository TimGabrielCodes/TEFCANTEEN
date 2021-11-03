/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.LoginBean;
import Model.User;

/**
 *
 * @author Antoni
 */
public class UserController {
    private User user = null;
    UserDAO userDAO = new UserDAOImpl();
    
    public boolean logUserIn(LoginBean loginBean){
        return userDAO.login(loginBean) == true;
    }
    
    public void logUserOut(){
        
    }
    
    public Boolean isUserLoggedIn(){
        return false;
    }
    
    public Boolean isUserAdmin(){
        return false;
    }
    
    public Boolean isUserCashier(){
        return false;
    }
    
    public void updateUserDetails(int id, User user){
        
    }
    
 public boolean saveUser(User user){
     return userDAO.saveUser(user);
 }
    
    public User getUser(int id){
        
        return null;
    }
    
    public void deleteUser(int id){
        
        
    }
}
