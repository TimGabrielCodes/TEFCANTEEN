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
    FoodDAO foodDao = new FoodDAOImpl();
    
    public List<Food> getFood(){
        if(foodDao.get() != null){
            return foodDao.get();
        }
        return null;
    }
    public boolean saveFood(Food food){
        return foodDao.saveFood(food);
    }
    
    public void uploadFoodCsv(String csv){
        
    }
    
    public Food getFood(int id){
        return foodDao.get(id);
    }
    
    public boolean deleteFood(int id){
        return foodDao.delete(id);
    }
    
    public boolean updateFood(Food newUpdate){
        return foodDao.update(newUpdate);
    }
}
