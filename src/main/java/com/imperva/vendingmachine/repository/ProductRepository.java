package com.imperva.vendingmachine.repository;

import com.imperva.vendingmachine.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

    List<Product> findAll();
}
