package com.grameenfoundation.models;

/**
 * Created by Ronald on 12/16/2014.
 */
public class Item {

    private Commodity commodity;
    private float price;
    private int quantity;

    public Item(){}

    public Item(Commodity commodity, float price, int quantity) {
        this.commodity = commodity;
        this.price = price;
        this.quantity = quantity;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
