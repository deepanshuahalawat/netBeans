/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tf.util;

import com.tf.entity.WeightEntry;
import com.tf.vo.EntryVO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class WeightUtil {
    public static void showMessage(String header, String message){
        JOptionPane.showMessageDialog(null, message,header,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showError(String header, String message){
        JOptionPane.showMessageDialog(null, header,message,JOptionPane.ERROR_MESSAGE);
    }
    
    public static WeightEntry mapEntryVoToEntity(EntryVO entryVo){
        WeightEntry weightEntry = null;
        if(entryVo != null){
            weightEntry = new WeightEntry();
            weightEntry.setItemCode(entryVo.getItemCode());
            weightEntry.setItemName(entryVo.getItemName());
            weightEntry.setRate(entryVo.getRate());
            weightEntry.setWeight(entryVo.getWeight());
            weightEntry.setAmount(entryVo.getAmount());
            weightEntry.setDate(entryVo.getDate());
            weightEntry.setTime(entryVo.getTime());
            if(entryVo.getComment() != null && entryVo.getComment().length() > 255){
                weightEntry.setComment(entryVo.getComment().substring(0,255));
            }else{
                weightEntry.setComment(entryVo.getComment());
            }
        }
        return weightEntry;
    }
    
    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        Date date = new Date();
        return sdf.format(date);
    }
    
    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return sdf.format(date);
    }
}
