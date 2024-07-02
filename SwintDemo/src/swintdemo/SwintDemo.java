/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swintdemo;

import com.sun.javafx.tk.RenderJob;

/**
 *
 * @author HP
 */
public class SwintDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number  = 15;
        try{
            Car c = (a , b) -> {
                int  speed = a;
                speed = speed+b;
                speed = speed *41+number;
                System.out.println("HP: "+a+"\tRadius: "+b+"\tSpeed: "+speed);
                return speed;
            };
            Car d = (a,b) -> {
                return a*b;
            };
            
            c.getSpeed(10,15);
            c.print();
            d.getSpeed(2,3);
            Car.color();
            Bus bus = ()->System.out.println("Bus capacity");
            bus.capicity();
        }catch(Exception e){
        }
    }
    
}
@FunctionalInterface
interface Car{
    int d =0;
    public int getSpeed(int engineHp, int tyreRadius);
    public static void color(){
        System.out.println("Car is red");
    }
    public static void c2(){}
    default public void c3(){}
    default public void print(){
        System.out.println("Car print");
    }
    
}
@FunctionalInterface
interface Bus{
    public void capicity();
    
    default public void print(){
        System.out.println("Bus print");
    }
}