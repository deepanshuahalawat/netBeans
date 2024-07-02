/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.tf.frame.MainFrame;
import com.tf.util.WeightUtil;
import com.tf.vo.EntryVO;

/**
 *
 * @author HP
 */

        
public class WeightService {

    public WeightService() {
    }
    
    
    public void saveEntry(EntryVO entryVO){
        try{
            
        }catch(Exception e){
            WeightUtil.showError("Error in save Entry", e.getMessage());
        }
        
    }
    
    
    
}
