package com.imperva.vendingmachine.service.impl;

import com.imperva.vendingmachine.exception.*;
import com.imperva.vendingmachine.model.Person;
import com.imperva.vendingmachine.model.Product;
import com.imperva.vendingmachine.repository.ProductRepository;
import com.imperva.vendingmachine.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private static final int MAX_SIZE_INVENTORY = 50;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product addProduct(Product product) {
        productRepository.findByTitle(product.getTitle()).ifPresent(p ->
            {throw new ProductAlreadyExistsException("Product already exists: " + p.getTitle());});
        isAllowByMaxSizeInventory(product.getAmount());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String productTitle, Product product) {
        Product updatedProduct = findByTitle(productTitle);
        if (product.getAmount() != null && (product.getAmount() - updatedProduct.getAmount() > 0)){
            isAllowByMaxSizeInventory(product.getAmount() - updatedProduct.getAmount());
            updatedProduct.setAmount(product.getAmount());
        }

        updatedProduct.setPrice(product.getPrice());

        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(String title) {
        productRepository.delete(findByTitle(title));
    }

    @Override
    public Product findByTitle(String title) {
        return productRepository.findByTitle(title)
                .orElseThrow(() -> new ProductNotFoundException("title: " + title));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    private void isAllowByMaxSizeInventory(Integer amount){
        Integer currentSize = findAll().stream().mapToInt((s) -> s.getAmount()).sum();

        if ((currentSize + amount) > MAX_SIZE_INVENTORY) {
            throw new InventoryOversizeException("Inventory oversize, free "
                    + (MAX_SIZE_INVENTORY - currentSize) + " items only!");
        }
    }


}
