/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.LoginBean;
import Model.User;
import java.util.List;

/**
 *
 * @author mac
 */
public interface UserDAO {
       List<User> get();

    boolean  saveUser(User user);
    
    User get(int id);
    
    User get(String user_name);
   
    boolean login(LoginBean loginBean);
     
}
