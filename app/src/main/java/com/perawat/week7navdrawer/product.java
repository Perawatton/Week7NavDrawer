package com.perawat.week7navdrawer;

/**
 * Created by msi on 27/2/2561.
 */

public class product {
    private  String name;
    private  int qty;
    private  double price;

    public product() {
    }

    public product(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}