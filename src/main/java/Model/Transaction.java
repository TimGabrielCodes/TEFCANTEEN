
package Model;

/**
 *
 * @author mac
 */

//A transaction is generated whenever food is sold and a receipt is printed
public class Transaction {
    private int id;
    private String timestamp;
    private String food_name;
    private double price;
    
    public Transaction(){
        
    }

    public Transaction(int id, String timestamp, String food_name, double price) {
        this.id = id;
        this.timestamp = timestamp;
        this.food_name = food_name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
    
    
    
}
