package Controller;

import DAO.FoodDAO;
import DAO.FoodDAOImpl;
import Model.Transaction;
import Util.Cart;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TransactionController {
    FoodDAO foodDAO = new FoodDAOImpl();
     ArrayList<Transaction> transList;

    public TransactionController() {
        transList =  (ArrayList<Transaction>) foodDAO.getTrans();
    }
    
    public List<Transaction> getAllTransactions(){
        transList =  (ArrayList<Transaction>) foodDAO.getTrans();
        return transList;
    }
    
   
    public void saveTransaction(Transaction trans){
        foodDAO.logTransaction(trans);
    }
    
    public List<Transaction> getTodayTransactions(){
        List<Transaction> t = new ArrayList<>();
        
        Calendar cal = resetCalendar();
        long todaysTimestamp = cal.getTimeInMillis();
        
        for(Transaction trans : transList){
            
            if(trans.getTimestamp() >= todaysTimestamp){
                t.add(trans);
            }
        }
        return t;
    }
    
    public List<Transaction> getThisWeekTransactions(){
        List<Transaction> t = new ArrayList<>();
        
        Calendar cal = resetCalendar();
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        long firstDayOfWeekTimestamp = cal.getTimeInMillis();
        
        for(Transaction trans : transList){
            
            if(trans.getTimestamp() >= firstDayOfWeekTimestamp){
                t.add(trans);
            }
        }
        return t;
    }
    
    public List<Transaction> getThisMonthTransactions(){
        List<Transaction> t = new ArrayList<>();
        
        Calendar cal = resetCalendar();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        long firstDayOfMonthTimestamp = cal.getTimeInMillis();
        
        for(Transaction trans : transList){
            
            if(trans.getTimestamp() >= firstDayOfMonthTimestamp){
                t.add(trans);
            }
        }
        return t;
    }

    private Calendar resetCalendar() {
        //Reset Calendar
        //Provide clean calendar instance that has been reset to 00:00 of today
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        
        return cal;
    }
}
