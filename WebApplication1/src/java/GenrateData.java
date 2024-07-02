
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class GenrateData {
    public static void main(String args[]){
        Random rand = new Random();
        System.out.print("<html>");
        for(int i=0;i<20000;i++){
            float f1=rand.nextFloat();
            float f2=rand.nextFloat();
            float f3=rand.nextFloat();
            float f4=rand.nextFloat();
            System.out.println(i+","+f1+","+f2+","+f3+","+f4+"<br>");
        }
        System.out.print("</html>");
    }
}
