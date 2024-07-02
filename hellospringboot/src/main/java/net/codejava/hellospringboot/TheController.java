/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.hellospringboot;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class TheController {
    
    @RequestMapping("home")
    public ModelAndView home(String name){
        ModelAndView mv = new ModelAndView();
        System.out.println("name:"+name);
        System.out.println("Inside home()");
        
        mv.addObject("name", name);
        mv.setViewName("home");
        return mv;
    }

}
