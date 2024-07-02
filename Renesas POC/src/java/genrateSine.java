/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class genrateSine {
    public static void main(String args[]){
        double pi = Math.PI;
        int points = 200;
        int data[] = new int[points];
        double angle = (2*pi)/points;
        
        System.out.println("Generating Sine data:");
        for(int i=0;i<points;i++)
            System.out.print(i+1 + ",\t\t\t");
        for(int i=0; i<points; i++){
            double val = Math.sin(i*angle);
            if(val < 0){
                //System.out.print("0,\t");
                data[i] = 0;
            }else{
                //System.out.print((int)(val*255)+",\t");
                data[i] = (int)(val*255);
            }
        }
        System.out.println("\n");
        for(int i=0; i<points; i++){
            System.out.print(data[i]+",\t\t\t");
        }
         System.out.println("\n");
        for(int i=points-1; i>=0; i--){
            System.out.print(data[i]+",\t\t\t");
        }
    }
}
