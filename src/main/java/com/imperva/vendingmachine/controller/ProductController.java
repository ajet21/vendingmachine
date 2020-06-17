package com.imperva.vendingmachine.controller;

import com.imperva.vendingmachine.model.Person;
import com.imperva.vendingmachine.model.Product;
import com.imperva.vendingmachine.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getByTitle")
    public Product findProductByTitle(@RequestParam String title) {
        return productService.findByTitle(title);
    }

    @GetMapping("/getAll")
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/update/{productTitle}")
    public void update(@PathVariable String productTitle, @RequestBody Product product) {
        productService.updateProduct(productTitle, product);
    }

    @DeleteMapping("/delete/{productTitle}")
    public void delete(@PathVariable String productTitle) {
        productService.deleteProduct(productTitle);
    }
}
