/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.tf.connection.jdbc.WeightDao;
import com.tf.entity.WeightEntry;
import com.tf.frame.MainFrame;
import com.tf.util.HibernateUtil;
import com.tf.util.WeightUtil;
import com.tf.vo.EntryVO;
import java.sql.Connection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class WeightService {

    MainFrame mainFrame = null;
    public WeightService(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void saveEntry(EntryVO entryVO) {
        try {
            WeightEntry weightEntry = WeightUtil.mapEntryVoToEntity(entryVO);
            if (weightEntry != null) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction trans = session.beginTransaction();
                session.persist(weightEntry);
                trans.commit();
                WeightUtil.showMessage("Congratulations !","Entry saved !");
                listAllEntries();
                mainFrame.addRowToTable(weightEntry);
            } else {
                System.out.println("Weight entry is null !");
            }
        } catch (Exception e) {
            WeightUtil.showError(e.getMessage(), "Error in save Entry");
            e.printStackTrace();
        }

    }
    public void listAllEntries(){
         List<WeightEntry> entries = WeightDao.getAllWeightEntry();
         if(entries != null){
             entries.forEach(System.out::println);
         }
    }
    
    

}
