package Controller;

import DAO.FoodDAO;
import DAO.FoodDAOImpl;
import Model.Transaction;
import Util.Cart;
import java.util.ArrayList;
import java.util.List;

public class TransactionController {
    FoodDAO foodDAO = new FoodDAOImpl();
    
    public List<Transaction> getAllTransactions(){
        ArrayList<Transaction> transList;
        transList =  (ArrayList<Transaction>) foodDAO.getTrans();
        return transList;
    }
    
    public Transaction getTransaction(Transaction transaction){
        
        return null;
    }
    
    public void saveTransaction(Transaction trans){
        foodDAO.logTransaction(trans);
    }
    
    public Boolean printInvoice(Transaction transaction){
        
        return null;
    }
    
    
}
