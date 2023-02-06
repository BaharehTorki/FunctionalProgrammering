package org.example.model;

import java.time.LocalDate;

public class Order {
    private String orderId;
    private LocalDate createdDate;
    private Product product;
    private User user;
    private LocalDate update;


    public Order(String orderId, LocalDate createdDate, Product product, User user, LocalDate update) {
        this.orderId = orderId;
        this.createdDate = createdDate;
        this.product = product;
        this.user = user;
        this.update = update;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getUpdate() {
        return update;
    }

    public void setUpdate(LocalDate update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return String.format(" %-7s   |   %-11s   |    %-8s  |   %-4s   |   %12s   |" , orderId, createdDate, product.getId(), user.getId(), update);
    }
}
