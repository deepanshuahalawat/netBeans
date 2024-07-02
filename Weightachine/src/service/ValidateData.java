/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author HP
 */
public class ValidateData {
    public static String validateRate(String rate){
        String message = null;
        if(rate == null || rate.length() == 0){
            return "Rate can not be empty !";
        }
        try{
            Float.parseFloat(rate);
        }catch(Exception e){
            return "Please enter valid number !";
        }
        return message;
    }
    
     public static String validateWeight(String weight){
        String message = null;
        if(weight == null || weight.length() == 0){
            return "Weight can not be empty !";
        }
        try{
            Float.parseFloat(weight);
        }catch(Exception e){
            return "Please enter valid weight !";
        }
        return message;
    }
    public static String validateItemCode(String itemCode){
        String message = null;
        if(itemCode == null || itemCode.length() == 0){
            return "Item Code is empty !";
        }
        return message;
    }
    public static String validateItemName(String itemName){
        String message = null;
        if(itemName == null || itemName.length() == 0){
            return "Item Name is empty !";
        }
        return message;
    }
    
}
