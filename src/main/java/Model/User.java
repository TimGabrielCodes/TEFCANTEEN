/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mac
 */
public class User {
    
    private int id;
    private String first_name;
    private String surn_name;
    private String phone_number;
    private String user_name;
    private String password;
    private boolean admin;
    public User() {
    }

    public User(int id, String first_name, String surn_name, String phone_number, String user_name, String password, boolean admin) {
        this.id = id;
        this.first_name = first_name;
        this.surn_name = surn_name;
        this.phone_number = phone_number;
        this.user_name = user_name;
        this.password = password;
        this.admin  = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurn_name() {
        return surn_name;
    }

    public void setSurn_name(String surn_name) {
        this.surn_name = surn_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", first_name=" + first_name + ", surn_name=" + surn_name + ", phone_number=" + phone_number + ", user_name=" + user_name + ", password=" + password + ", isAdmin=" + admin + '}';
    }

  
    
    
}
