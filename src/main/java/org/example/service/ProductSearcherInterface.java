package org.example.service;

import org.example.model.Product;

@FunctionalInterface
public interface ProductSearcherInterface {

    boolean search (Product p, String searchWord);
}
