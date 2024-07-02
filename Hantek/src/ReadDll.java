/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class ReadDll {
    
    public static void main(String atr[]){
        new ReadDll().read();
    }
    public void read(){
        try{
        System.loadLibrary("HTMarch");
        
        }catch(Exception e){
            System.out.println("ex:"+e);
        }
    }
}
