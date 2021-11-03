/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mac
 */
public class Food {
    
    private int id;
    private String food_name;
    private String unit;
    private Double price;
    private Byte available = 1;
    
    public Food(){
        
    }

    public Food(int id, String food_name, String unit, Double price,Byte available) {
        this.id = id;
        this.food_name = food_name;
        this.unit = unit;
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte isAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    @Override
    public String toString() {
        
        return "Food{" + "id=" + id + ", food_name=" + food_name + ", unit=" + unit + ", price=" + price + ", available=" + available + '}';
    }
    
    
    
    
}
