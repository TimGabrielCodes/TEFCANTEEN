/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Food;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author FUJITSU
 */
public class Cart {
    private HashMap<Food,Double> cartMap = new HashMap<>(); //Food name and price
    private HashMap<Food, Integer> quantityCounter = new HashMap<>(); //FOod name and quantity
    private HashMap<Food, String> unitCounter = new HashMap<>(); //Food name and UNit
    private int items;
    private int totalPrice = 0;
    
    public void addToCart(Food food){
//        String foodName = food.getFood_name();
        if(cartMap.get(food) == null){
            cartMap.put(food, food.getPrice());
            quantityCounter.put(food, 1);
            unitCounter.put(food, food.getUnit());
            items += 1;
        }else{
            Double newPrice = cartMap.get(food) + food.getPrice();
            cartMap.put(food, newPrice);
            quantityCounter.put(food, 
                    quantityCounter.get(food) + 1);
        }
    }
    
    public void removeFromCart(Food food){
//        String foodName = food.getFood_name();
        Double foodPrice = cartMap.get(food);
        if(foodPrice != null){
            if(foodPrice > food.getPrice()){
                cartMap.put(food, foodPrice - food.getPrice());
                quantityCounter.put(food, quantityCounter.get(food) - 1);
            }else{
                cartMap.remove(food);
                quantityCounter.remove(food);
                unitCounter.remove(food);
                items -= 1;
            }
        }
    }
    
    public String printCart(){
        Double total = 0.0;
        int counter = 1;
        
        StringBuffer str = new StringBuffer("TEF CANTEEN RECEIPT\n\n");
        str.append("Date: "+new Date());
        str.append("\n__________________________________________\n");
        
        for(Map.Entry<Food, Double> entry : cartMap.entrySet()){
            final Double price = entry.getValue();
            
            //entry.getKey()+" \t "+quantityCounter.get(entry.getKey())+" "+
//                    unitCounter.get(entry.getKey())+"\t"+entry.getValue()+"\n",
            str.append(counter+". \n"
                    + " FOOD NAME: \t\t"+entry.getKey().getFood_name()+"  \n"
                            + " QUANTITY: \t\t"+quantityCounter.get(entry.getKey())+" "+unitCounter.get(entry.getKey())+"\n"
                                    + " PRICE: \t\t"+entry.getValue()+" NGN \n");
            total += entry.getValue();
            counter++;
        }
        
        str.append("__________________________________________");
        str.append("\n\nTOTAL \t\t "+total+" NGN");
        str.append("\n\nItems \t\t "+items);
        str.append("\n\nPlease Proceed to get your food");
        str.append("\n\nThank you for your patronage\n\n\n\n");
        return str.toString();
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public HashMap<Food, Double> getCartMap() {
        return cartMap;
    }

    public HashMap<Food, Integer> getQuantityCounter() {
        return quantityCounter;
    }

    public HashMap<Food, String> getUnitCounter() {
        return unitCounter;
    }
    
    public double getTotalPrice(){
        for(Map.Entry<Food, Double> entry : cartMap.entrySet()){
            totalPrice += entry.getValue();
        }
        return totalPrice;
    }
}
