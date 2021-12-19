/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.LoginBean;
import Model.User;
import Util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class UserDAOImpl implements UserDAO {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<User> list = null;
    User user = null;
    PreparedStatement preparedStmt = null;

    @Override
    public List<User> get() {

        try {
            list = new ArrayList<User>();
            String sql = "select * from user ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user = new User();
              //  user.setRole(resultSet.getString("role"));
                user.setId(resultSet.getInt("id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setSurn_name(resultSet.getString("surn_name"));
                user.setPhone_number(resultSet.getString("phone_number"));
                user.setPassword(resultSet.getString("password"));
                user.setUser_name(resultSet.getString("user_name"));
             
                list.add(user);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;

    }

  

    @Override
    public boolean saveUser(User user) {
        boolean flag = false;
        try {

      
            String sql = "insert into user(first_name, surn_name, phone_number, user_name, password, isAdmin) "
                    + "values('" + user.getFirst_name() + "','" + user.getSurn_name() + "','" + user.getPhone_number() + "','" + user.getUser_name() + "','" + user.getPassword() 
                    + "'," + user.isAdmin() +")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User get(int id) {
        User user = null;
        try {
            user = new User();
            String sql = "SELECT * FROM user  WHERE user_id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
               user.setId(resultSet.getInt("id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setSurn_name(resultSet.getString("surn_name"));
                user.setPhone_number(resultSet.getString("phone_number"));
                user.setPassword(resultSet.getString("password"));
                user.setUser_name(resultSet.getString("user_name"));
                 user.setAdmin(resultSet.getBoolean("isAdmin"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(user.toString());
        return user;
    }
        @Override
    public User get(String user_name) {
        User user = null;
        try {
            user = new User();
            String sql = "SELECT * FROM user  WHERE user_name='" + user_name+"'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
               user.setId(resultSet.getInt("id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setSurn_name(resultSet.getString("surn_name"));
                user.setPhone_number(resultSet.getString("phone_number"));
                user.setPassword(resultSet.getString("password"));
                user.setUser_name(resultSet.getString("user_name"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(user.toString());
        return user;
    }

    @Override
    public boolean login(LoginBean loginBean) {
        boolean isMatch = false;
        try {
           
            
            LoginBean loginMatch = new LoginBean();
            
            String sql = "select * from user where user_name=? and password =?";
            
            
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, loginBean.getUsername());
            stmt.setString(2, loginBean.getPassword());
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                return true;
            } else{
                return false;
                
                
                
            }   } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isMatch;




  
}
@Override
    public boolean deleteUser(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM user WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }}
