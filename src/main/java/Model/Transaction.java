
package Model;

/**
 *
 * @author mac
 */

//A transaction is generated whenever food is sold and a receipt is printed
public class Transaction {
    private int id;
    private int user_id;
    private Double total_price;
    private String status = "Paid";
    private String timestamp;
    
    public Transaction(){
        
    }

    public Transaction(int id, int user_id, Double total_price, String timestamp) {
        this.id = id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    
    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", user_id=" + user_id + ", total_price=" + total_price+ ", status=" + status + ", timestamp=" + timestamp+ '}';
    }
    
}
