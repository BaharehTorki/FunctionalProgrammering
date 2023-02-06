package org.example.model;

import org.example.gui.MyPage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTypeTest {

    @Test
    void name() {

        MyPage a = new MyPage("username1");

    }

    @Test
    void name1() {
        List<Integer> integers = new ArrayList<>();
        Map<String, List<Integer>> str = new HashMap<>();
        /************************************/
        if (str.get("001002") == null) {
            integers.add(5);
            str.put("001001", integers);
        }
        if (str.get("001002") == null) {
            integers.add(14);
            str.put("001001", integers);
        }else {
            str.get("001001").add(2);
        }

        /************************************/
        System.out.println(str.get("string2"));
    }
}