/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author FUJITSU
 */
public class LoggedInUserHandler {
    private static int loggedInUserId = 0;
    
    public static void setLoggedInUserId(int id){
        loggedInUserId = id;
    }
    
    public static int getLoggedInUserId(){
        return loggedInUserId;
    }
}
