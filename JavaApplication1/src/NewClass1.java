/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
    public class NewClass1 {
    float val=0;
    float angle=0;
    static double div = Math.PI/4;
        
    public static void main(String str[]){
       for(int i=0;i<5;i++){
         System.out.println((float)i*div+"\t\t"+(float)Math.sin(i*div)*255+"\t");
     }
    }

}
