package org.example.model;

public enum CategoryType {
    PLATTASKOR(1),
    SPORT(2),
    PARTY(3),
    SNEAKERS(4),
    VINTERSKOR(5);

    private int value;
    private CategoryType(int value){
        this.value = value;
    }

    public static CategoryType getCategoryByValue(int value){
        CategoryType[] values = CategoryType.values();

        return  values[value-1];
    }



}
