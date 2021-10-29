
package Model;

/**
 *
 * @author mac
 */

//A transaction is generated whenever food is sold and a receipt is printed
public class Transaction {
    private int id;
    private int food_id;
    private int user_id;
    private Double total_price;
    private String timestamp;
    private String status;
    private int group_id;
    
    public Transaction(){
        
    }

    public Transaction(int id, int food_id, int user_id, Double total_price, String timestamp, String status, int group_id) {
        this.id = id;
        this.food_id = food_id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.timestamp = timestamp;
        this.status = status;
        this.group_id = group_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", food_id=" + food_id + ", user_id=" + user_id + ", total_price=" + total_price + ", timestamp=" + timestamp + ", status=" + status + ", group_id=" + group_id + '}';
    }
    
    
    
    
    
}
