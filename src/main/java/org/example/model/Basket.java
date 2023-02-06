package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private User user;
    private String orderID;
    private List<Product> products = new ArrayList<>();

    public Basket(User user, String orderID, List<Product> products) {
        this.user = user;
        this.orderID = orderID;
        this.products = products;
    }

    public Basket(User user, String orderID, Product product) {
        this.user = user;
        this.orderID = orderID;
        this.products.add(product);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return orderID +" ";
    }
}
