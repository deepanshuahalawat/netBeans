/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technofarm.springBoot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Component
public class MyController {
    
    public MyController(){
        System.out.println("MyController object created !");
    }
    
    @RequestMapping("/home")
    public String home(){
        System.out.println("Calling home()");
        return "home.html";
    }
}
