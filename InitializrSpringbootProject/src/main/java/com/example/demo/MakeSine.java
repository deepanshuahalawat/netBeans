/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.demo;

/**
 *
 * @author HP
 */
public class MakeSine {
    float val=0;
    float angle=0;
    float div = Math.PI/5;
    public static void main(String str[]){
       for(int i=0;i<5;i++){
         Serial.println(i*div+"\t\t"+Math.sin(i*div)+"\t");
     }
    }
}
