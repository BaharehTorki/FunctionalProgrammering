package org.example.model;

import java.time.LocalDate;

public class Product {

    private int id;
    private int storlek;
    private String marke;
    private String color;
    private int pris;
    private CategoryType categoryType;
    private SectionType sectionType;
    private LocalDate createdDate;
    private LocalDate update;

    public Product(int id,
                   int storlek,
                   String marke,
                   String color,
                   int pris,
                   CategoryType categoryType,
                   SectionType sectionType,
                   LocalDate createdDate,
                   LocalDate update) {
        this.id = id;
        this.storlek = storlek;
        this.marke = marke;
        this.color = color;
        this.pris = pris;
        this.categoryType = categoryType;
        this.sectionType = sectionType;
        this.createdDate = createdDate;
        this.update = update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorlek() {
        return storlek;
    }

    public void setStorlek(int storlek) {
        this.storlek = storlek;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdate() {
        return update;
    }

    public void setUpdate(LocalDate update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return String.format("   %-6d|   %-5d | %-12s| %-8s| %-5d| %-13s|     %-7s | %-11s | %-12s",id, storlek, marke, color, pris, categoryType, sectionType, createdDate, update);

    }
}
