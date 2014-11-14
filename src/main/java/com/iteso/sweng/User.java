/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteso.sweng;

/**
 *
 * @author CoCoNO
 */
public class User {
    private int id;
    private String name;
    private int level;
    
    public User(int _id,String _name,int _lvl)
    {
        id=_id;
        name=_name;
        level=_lvl;
    }
    
    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getLevel()
    {
        return level;
    }
    
}
