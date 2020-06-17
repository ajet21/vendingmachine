package com.imperva.vendingmachine.service;

import com.imperva.vendingmachine.model.Person;
import com.imperva.vendingmachine.model.Product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product updateProduct(String productTitle, Product product);

    void deleteProduct(String nickname);

    Product findByTitle(String title);

    List<Product> findAll();

}
