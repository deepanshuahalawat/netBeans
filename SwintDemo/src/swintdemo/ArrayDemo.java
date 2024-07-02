/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swintdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author HP
 */
public class ArrayDemo {
    public static void main(String arg[]){
        List<String> cars = new ArrayList<String>();
        cars.add("maruti");
        cars.add("wagwnor");
        cars.add("hyundai");
        List<String> names = Arrays.asList("Larry", "Steve", "James");
        names.forEach(Show::show);
        Showroom s = Show::showSame ;
        s.showCar();
        s = () -> System.out.println("YOYOY");
        s.showCar();
        String str = "Hello";
        
                
    }
    
    
    
}

abstract class Show{
    public static void show(String name){
        System.out.println(name.toUpperCase());
    }
    public static void showSame(){
        System.out.println("Its showSame method !");
    }
    public abstract void absMethod();
}
@FunctionalInterface
interface Showroom{
    public void showCar();
    
    
}

