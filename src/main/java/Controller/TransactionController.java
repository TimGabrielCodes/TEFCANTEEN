/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.FoodDAO;
import DAO.FoodDAOImpl;
import Model.Transaction;
import Model.Transaction2;
import Util.Cart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FUJITSU
 */
public class TransactionController {
    public List<Transaction> getAllTransactions(){
        
          FoodDAO foodDAO = new FoodDAOImpl();
           ArrayList<Transaction> transList;
      transList =  (ArrayList<Transaction>) foodDAO.getTrans();
      return transList;
    }
    
    public Transaction2 getTransaction(Transaction2 transaction){
        
        return null;
    }
    public void saveTransaction(Transaction trans){
        FoodDAO foodDAO = new FoodDAOImpl();
        foodDAO.logTransaction(trans);
    }
    
    public Boolean printInvoice(Transaction2 transaction){
        
        return null;
    }
    
    
}
