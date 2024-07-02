/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.technofarm.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class App {
    public static void main(String str[]){
        System.out.println("Hello Hibernate...");
        Alien a= new Alien();
        a.setId(10);
        a.setColor("RED");
        a.setName("Jadoo");
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.save(session);
    }

}
