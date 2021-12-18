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
    private HashMap<String,Double> cartMap = new HashMap<>(); //Food name and price
    private HashMap<String, Integer> quantityCounter = new HashMap<>(); //FOod name and quantity
    private HashMap<String, String> unitCounter = new HashMap<>(); //Food name and UNit
    private int items;
    
    public void addToCart(Food food){
        String foodName = food.getFood_name();
        if(cartMap.get(foodName) == null){
            cartMap.put(foodName, food.getPrice());
            quantityCounter.put(foodName, 1);
            unitCounter.put(foodName, food.getUnit());
            items += 1;
        }else{
            Double newPrice = cartMap.get(foodName) + food.getPrice();
            cartMap.put(foodName, newPrice);
            quantityCounter.put(foodName, 
                    quantityCounter.get(foodName) + 1);
        }
    }
    
    public void removeFromCart(Food food){
        String foodName = food.getFood_name();
        Double foodPrice = cartMap.get(foodName);
        if(foodPrice != null){
            if(foodPrice > food.getPrice()){
                cartMap.put(foodName, foodPrice - food.getPrice());
                quantityCounter.put(foodName, quantityCounter.get(foodName) - 1);
            }else{
                cartMap.remove(foodName);
                quantityCounter.remove(foodName);
                unitCounter.remove(foodName);
                items -= 1;
            }
        }
    }
    
    public String printCart(){
        Double total = 0.0;
        StringBuffer str = new StringBuffer("TEF CANTEEN \n ITEM \t QUANTITY \t PRICE\n(NGN)\n\n");
        
        for(Map.Entry<String, Double> entry : cartMap.entrySet()){
            final Double price = entry.getValue();
            str.append(entry.getKey()+" \t "+quantityCounter.get(entry.getKey())+" "+
                    unitCounter.get(entry.getKey())+"\t"+entry.getValue()+"\n");
            total += entry.getValue();
        }
        
        str.append("\n\nTOTAL \t\t "+total);
        str.append("\n\nItems \t\t "+items);
        str.append("\n\nPlease Proceed to get your food");
        str.append("\n\nThank you for your patronage");
        return str.toString();
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public HashMap<String, Double> getCartMap() {
        return cartMap;
    }

    public HashMap<String, Integer> getQuantityCounter() {
        return quantityCounter;
    }

    public HashMap<String, String> getUnitCounter() {
        return unitCounter;
    }
    
    
}
