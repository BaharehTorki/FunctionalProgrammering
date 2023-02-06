package org.example.service;

public class QueryConstant {
    public static final String KUND_BY_ID = "SELECT * from kund k where k.id=?";
    public static final String KUND_BY_USERNAME = "SELECT * from kund k where k.username=?";
    public static final String ALL_KUND = "select * from kund";

    public static final String PRODUCT_BY_ID = "select * from produkt p where p.id=?";
    public static final String ALL_PRODUCTS = "select * from produkt";

    public static final String ADDRESS_BY_ID = "select * from adress a where a.id=?";
    public static final String ALL_ADDRESS = "select * from adress";

    public static String ALL_IN_LAGER = "select * from lager";
    public static final String WHERE_PRODUCT_IN_STOCK = "select * from lager where antalILager > 0";
    public static String ALL_ORDERS = "select * from beställning";
    public static String ALL_ORDERS_BY_USER = "select * from beställning b where b.kundId=?";
    public static String REPORT_USER_ORDER = "select * from kund, produkt, adress where k.id = ?, b.kundId = ?, p.id = ?";



}
