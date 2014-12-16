package com.grameenfoundation.models;

/**
 * Created by Ronald on 12/16/2014.
 */
public class Commodity {
    private String name;

    public Commodity(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
