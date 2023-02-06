package org.example.model;

import java.time.LocalDate;

public class Lager {

    private int id;
    private Product product;
    private int antal;
    private LocalDate updated;

    public Lager(int id, Product product, int antal, LocalDate updated) {
        this.id = id;
        this.product = product;
        this.antal = antal;
        this.updated = updated;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return String.format("   %-7d|   %-5d|   %-7s   ", product.getId(), antal, updated);
    }
}
