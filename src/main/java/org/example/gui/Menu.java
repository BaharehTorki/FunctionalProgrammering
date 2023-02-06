package org.example.gui;

import org.example.service.Dao;
import org.example.service.DaoImpl;

import java.util.Scanner;

public class Menu {

    private static Scanner in = new Scanner(System.in);

    private static Dao dao = new DaoImpl();

    public static void main(String[] args) {
        System.out.println(StringsConstant.BANNER);
        String username = in.next();
        String password = in.next();

        if (dao.availableUser(username, password)) {
            new MyPage(username);
        } else {
            System.out.println("användarnamn eller lösenord är inte korrekt!");
        }
    }
}
