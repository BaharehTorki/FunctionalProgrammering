package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private int id;
    private String pass;
    private String username;
    private String name;
    private String efternamn;
    private Address address;
    private LocalDate update;

    public User(int id, String pass, String username, String name, String efternamn, Address address, LocalDate update) {
        this.id = id;
        this.pass = pass;
        this.username = username;
        this.name = name;
        this.efternamn = efternamn;
        this.address = address;
        this.update = update;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }
/*
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }*/

    public LocalDate getUpdate() {
        return update;
    }

    public void setUpdate(LocalDate update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return String.format("   %-10s   |   %-9s   |   %-9s  |  %-10s  |   %-19s ",   username, name, efternamn, address.getPostort(), update ) ;
    }
}
