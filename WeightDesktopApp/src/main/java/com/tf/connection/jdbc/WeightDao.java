/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tf.connection.jdbc;

import com.tf.entity.Student;
import com.tf.entity.WeightEntry;
import com.tf.util.HibernateUtil;
import com.tf.util.WeightUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class WeightDao {
    
    public static List<WeightEntry> getAllWeightEntry(){
        List<WeightEntry> entries = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            entries = session.createQuery("from WeightEntry", WeightEntry.class).list();
        }catch(Exception e){
            WeightUtil.showError("Error while fetching data", e.getMessage());
        }
                
        return entries;
    }
    
}
