/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tf.util;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class WeightUtil {
    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, "Information",message,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showError(String header, String message){
        JOptionPane.showMessageDialog(null, header,message,JOptionPane.ERROR_MESSAGE);
    }
}
