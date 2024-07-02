/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.hellospringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
public class WebController {
    
    @RequestMapping("/hello")
    public String sayHello(Model model){
        System.out.println("Saying hello....");
        model.addAttribute("message","Welcome to spring boot with netbeans");
        return "hello";
    }
}
