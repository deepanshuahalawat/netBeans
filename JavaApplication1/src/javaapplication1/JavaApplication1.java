/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author HP
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {20, 40, 60, 40, 60, 20, 30, 30, 60, 20, 40, 40, 20};
        int num=0;
        int occurance=0;
        int len = arr.length;
        Map[] map = new Map[len];
        boolean flag = false;
        // converting array into key value pair
        map[0].key = arr[0];
        
        for(int i=0;i<len; i++){
            num = arr[i];
            flag = false;
            for(int j=0; j< map.length;j++){
                if(num == map[i].key){
                    map[i].val++;
                    flag = true;
                }
            }
            if(flag == false){
                map[i].key=arr[i];
                map[i].val++;
            }
        }
        
        
        for(int i=0;i<len;i++){
            System.out.println("VAL: "+map[i].val+"\t"+map[i].key);
        }
    }
    
}
 class Map{
    int key =0;// for integer only
    int val =0;// for integer values
}
