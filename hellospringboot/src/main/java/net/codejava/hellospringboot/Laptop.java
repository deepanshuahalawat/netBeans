/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.hellospringboot;

import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */

@Component
public class Laptop {
    private int id;
    private String name;
    private String model;
    Laptop(){
        System.out.println("Laptop instantiated !");
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Laptop{" + "id=" + id + ", name=" + name + ", model=" + model + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}
