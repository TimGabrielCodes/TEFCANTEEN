/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mac
 */
public class DBConnectionUtil {
    
    //Define Database properties
    
    private static final String URL = "jdbc:mysql://localhost:3306/tefcanteen?serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "%310594%";
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



