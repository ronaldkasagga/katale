package com.grameenfoundation.models;

/**
 * Created by Ronald on 12/16/2014.
 */
public class Commodity {

    private String name;
    private Unit unit;

    public Commodity(String name) {
        this.name = name;
    }

    public Commodity(String name, Unit unit){
        this.name = name;
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
