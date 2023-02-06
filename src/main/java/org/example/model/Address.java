package org.example.model;

import java.time.LocalDate;

public class Address {
    private int id;
    private int zipcode;
    private String postort;
    private LocalDate createdDate;
    private LocalDate updateDate;

    public Address(int id, int zipcode, String postort, LocalDate createdDate, LocalDate updateDate) {
        this.id = id;
        this.zipcode = zipcode;
        this.postort = postort;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getPostort() {
        return postort;
    }

    public void setPostort(String postort) {
        this.postort = postort;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return String.format("   %-10d   |   %-9s   |   %-9s   |    %-9s  ", zipcode , postort, createdDate , updateDate);
    }
}
