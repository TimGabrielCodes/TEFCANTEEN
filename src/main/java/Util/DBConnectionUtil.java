
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionUtil {
    //Define Database properties
    
    private static final String URL = "jdbc:mysql://localhost:3306/tefCanteen?serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection con  = null;
    
    
    //Static method to get connection
    
    public static Connection openConnection() throws ClassNotFoundException, SQLException{
        //Check the connection
        if(con != null){
            return con;
        }
        else{
        
                //load the driver
                Class.forName(DRIVER);
                
                //Get the connection
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                //Return the connection
                return con;
           
        }
    }
    
}

