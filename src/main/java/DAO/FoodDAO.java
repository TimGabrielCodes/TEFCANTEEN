/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Food;
import Model.Transaction2;
import java.util.List;

/**
 *
 * @author mac
 */
public interface FoodDAO {
            List<Food> get();
//        List<Food> getRestock();
        List<Transaction2> getTrans();
//        List<Transaction> getUserTransactions(String name);
//        List<Transaction> countTrans();
//        List<Transaction> trackSales();
    boolean  saveFood(Food product);
   
    
    Food get(int id);

    
    Food get(String name);
    
    boolean update(Food product);
 
    
    boolean delete(int id);
    


    public boolean logTransaction(Transaction2 transaction);

//    public void updateTransaction(Transaction transaction);
    


   

    
}
