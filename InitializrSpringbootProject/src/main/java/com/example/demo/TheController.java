/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Component
public class TheController {

    public TheController() {
        System.out.println("The controller instantiated !");
    }
    
    
    @RequestMapping("home")
    public String home(){
        System.out.println("home called ");
        return "home";
    }
}
