
import java.util.Calendar;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FUJITSU
 */
public class TestClass {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        System.out.println("Initial time"+new Date(cal.getTimeInMillis())+"\n Curr Ts"+cal.getTime());
        
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        
        System.out.println("First TS"+cal.getTime());
    }
}
