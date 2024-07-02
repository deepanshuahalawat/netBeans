/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tf.util;

import com.tf.connection.jdbc.GetH2Connection;
import com.tf.connection.jdbc.WeightDao;
import com.tf.entity.Student;
import com.tf.entity.WeightEntry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class TestDb {

    public static void main(String[] args) {
        testHibernate();
        /*
        Connection connection = GetH2Connection.getH2Connection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM student";
                
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                
                int count = 0;
                
                while (resultSet.next()) {
                    count++;
                    
                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("name");
                    System.out.println("Student #" + count + ": " + ID + ", " + name);
                }
            } catch (SQLException ex) {
                System.out.println("Error while executing sql !");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Enable to get connection");
        }
*/
    }
    public static void testHibernate(){
        Student student = new Student(0, "Fadatare");
        Student student1 = new Student(1, "Cena");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(student);
            session.save(student1);
            // commit transaction
            transaction.commit();
            
             
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Student > students = session.createQuery("from Student", Student.class).list();
            students.forEach(s -> System.out.println(s.getFirstName()));
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    
}
