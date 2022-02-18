/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Food;
import Model.Transaction;
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
public class FoodDAOImpl implements FoodDAO {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Food> list = null;
    List<Transaction> Translist = null;
    List<Transaction> Translist2 = null;
    List<Transaction> trackList = null;
    Food food = null;
    PreparedStatement preparedStmt = null;
    UserDAO userDAO = new UserDAOImpl();

    private Transaction transaction;
    

    @Override
    public List<Food> get() {
        try {
            list = new ArrayList<>();
            String sql = "select * from food ";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                food = new Food();
                food.setId(resultSet.getInt("id"));
                food.setFood_name(resultSet.getString("food_name"));
                food.setUnit(resultSet.getString("unit"));
                food.setPrice(resultSet.getDouble("price"));
                food.setAvailable(resultSet.getByte("available"));
           
                list.add(food);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

  
    @Override
    public boolean saveFood(Food food) {
        boolean flag = false;
        try {

            String sql = "insert into food( food_name, unit, price, available) "
                    + "values(?,?,?,?)";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, food.getFood_name());
            preparedStmt.setString(2, food.getUnit());
            preparedStmt.setDouble(3, food.getPrice());
            preparedStmt.setByte(4, food.isAvailable());
  
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Food get(int id) {

        try {
            food = new Food();
            String sql = "SELECT * FROM food WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                 food = new Food();
                food.setId(resultSet.getInt("id"));
                food.setFood_name(resultSet.getString("food_name"));
                food.setUnit(resultSet.getString("unit"));
                food.setPrice(resultSet.getDouble("price"));
                food.setAvailable(resultSet.getByte("available"));
           

 
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //////System.out.println(user.toString());
        return food;
    }
   

    @Override
    public Food get(String name) {

        try {
            food = new Food();
            String sql = "SELECT * FROM food WHERE food_name ='" + name + "'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
            
                food.setId(resultSet.getInt("id"));
                food.setPrice(resultSet.getDouble("price"));
                food.setFood_name(resultSet.getString("food_name"));
                food.setUnit(resultSet.getString("unit"));
                food.setAvailable(resultSet.getByte("available"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //////System.out.println(user.toString());
        return food;
    }

    @Override
    public boolean update(Food food) {
        boolean flag = false;

        try {
            String sql = "update food set food_name=?, price=?, unit= ?, available = ? where id= ?";
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1,food.getFood_name());
            preparedStmt.setDouble(2, food.getPrice());
            preparedStmt.setString(3, food.getUnit());
            preparedStmt.setByte(4, food.isAvailable());
            preparedStmt.setInt(5, food.getId());
            
            int id = preparedStmt.executeUpdate();
            System.out.print(id);
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM food WHERE id=" + id;
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
    }

    @Override
    public boolean logTransaction(Transaction transaction) {
        boolean flag = false;
        try {

            String sql = "insert into transaction(user_id, total_price,cart, status, timestamp)"
                    + "values(?,?,?,?,?)";
            try {
                connection = DBConnectionUtil.openConnection();
                preparedStmt = connection.prepareStatement(sql);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

           
            preparedStmt.setInt(1, transaction.getUser_id());
            preparedStmt.setDouble(2, transaction.getTotal_price());
            preparedStmt.setString(4, transaction.getStatus());
            preparedStmt.setLong(5, transaction.getTimestamp());


            preparedStmt.execute();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }



    @Override
    public List<Transaction> getTrans() {
        FoodDAO foodDAO = new FoodDAOImpl();
        try {
            Translist = new ArrayList<>();
            String sql = "select * from transaction ";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setUser_id(resultSet.getInt("user_id"));
                transaction.setTotal_price(resultSet.getDouble("total_price"));
                transaction.setTimestamp(resultSet.getLong("timestamp"));
                transaction.setStatus(resultSet.getString("status"));
               
                Translist.add(transaction);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return Translist;

  
    }

}


















