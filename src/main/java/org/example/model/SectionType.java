package org.example.model;

public enum SectionType {
    MAN(1), DAM(2), BARN(3);

    private int value;
    private SectionType(int value){
        this.value = value;
    }

    public static SectionType getSectionTypeByValue(int index){
        SectionType[] values = SectionType.values();

        return  values[index-1];
    }

}
