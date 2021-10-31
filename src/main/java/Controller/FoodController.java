/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.FoodDAO;
import DAO.FoodDAOImpl;
import Model.Food;
import java.util.List;

/**
 *
 * @author mac
 */
public class FoodController {
    FoodDAO foodDAO = new FoodDAOImpl();
    
    public List<Food> getFood(){
        if(foodDAO.get() != null){
            return foodDAO.get();
        }
        return null;
    }
    
    public void uploadFoodCsv(String csv){
        
    }
    
    public boolean saveFood(Food food){
        if(foodDAO.save(food)){
            return true;
        }
        else return false;
    }
    
    
    public Food getFood(int id){
        
        return null;
    }
    
    public void deleteFood(int id){
        
        
    }
    
    public void updateFood(int id, Food newUpdate){
        
        
    }
}
