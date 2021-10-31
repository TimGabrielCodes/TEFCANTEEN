/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Food;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author FUJITSU
 */
public class Cart {
    private HashMap<String,Double> cartMap = new HashMap<>();
    
    public void addToCart(Food food){
        if(cartMap.get(food.getFood_name()) == null){
            cartMap.put(food.getFood_name(), food.getPrice());
        }else{
            Double newPrice = cartMap.get(food.getFood_name()) + food.getPrice();
            cartMap.put(food.getFood_name(), newPrice);
        }
    }
    
    public void removeFromCart(Food food){
        Double foodPrice = cartMap.get(food.getFood_name());
        if(foodPrice != null){
            if(foodPrice > food.getPrice()){
                cartMap.put(food.getFood_name(), foodPrice - food.getPrice());
            }else{
                cartMap.remove(food.getFood_name());
            }
        }
    }
    
    public String printCart(){
        int total = 0;
        StringBuffer str = new StringBuffer("ITEM \t PRICE\n\n");
        
        for(Map.Entry<String, Double> entry : cartMap.entrySet()){
            str.append(entry.getKey()+" \t "+entry.getValue()+"\n");
            total += entry.getValue();
        }
        
        str.append("\n\nTOTAL \t "+total);
        return str.toString();
    }
}
