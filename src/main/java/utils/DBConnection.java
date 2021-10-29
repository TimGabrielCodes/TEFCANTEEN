/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FUJITSU
 */
public class DBConnection {

    private static synchronized Connection getConnection() {
        try {
            return DriverManager.getConnection(LoginConfig.URL, LoginConfig.USERNAME, LoginConfig.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static synchronized Boolean runQuery(String sqlStatement) {
        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            return stmt.execute(sqlStatement);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }

    public static synchronized ResultSet runQueryForResult(String sqlStatement) {
        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            return stmt.executeQuery(sqlStatement);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }
}
