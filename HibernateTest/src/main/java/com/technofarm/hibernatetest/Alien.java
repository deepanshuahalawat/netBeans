/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.technofarm.hibernatetest;

/**
 *
 * @author HP
 */
public class Alien {
    private int id;
    private String name;
    private String color;

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){this.name=name;}
    public void setColor(String name){this.color=color;}
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getColor(){return this.color;}
}
