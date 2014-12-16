package com.grameenfoundation.models;

import java.util.List;

/**
 * Created by Ronald on 12/16/2014.
 */
public class Vendor {

    private String name;
    private Market market;
    private List<Item> stock;

    public Vendor(){}

    public Vendor(String name, Market market, List<Item> stock) {
        this.name = name;
        this.market = market;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public List<Item> getStock() {
        return stock;
    }

    public void setStock(List<Item> stock) {
        this.stock = stock;
    }
}
