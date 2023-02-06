package org.example.service;

import org.example.model.Lager;
import org.example.model.Order;
import org.example.model.User;
import org.example.model.Product;

import java.util.List;

public interface Dao {

    /* Method for Users */
    User findUserById(int id);
    User findUserByUsername(String username);

    Boolean availableUser(String name, String pass);

    List<User> getAllUsers();

    /* Method for Products*/
    Product findProductById(int id);

    List<Product> getAllProduct();

    /* Method for Stock*/
    List<Lager> getAllInLager();

    /* Method for Order*/
    List<Order> getAllOrder();
    List<Order> getAllOrderByUserId(int userId);

    /* Procedure*/
    boolean addToCart(int kid, String bId, int pId);

}
