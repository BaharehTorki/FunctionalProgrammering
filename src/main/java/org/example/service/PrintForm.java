package org.example.service;

import org.example.gui.StringsConstant;

import java.util.List;

import static org.example.gui.StringsConstant.MENU;

public class PrintForm<T> {

    private String header;
    private List<T> items;

    public PrintForm(String header, List<T> items) {
        this.header = header;
        this.items = items;
    }

    public void print(){
        System.out.println(header);
        items.forEach(System.out::println);

    }

}
