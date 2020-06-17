package com.imperva.vendingmachine.service.impl;

import com.imperva.vendingmachine.exception.NotEnoughBalanceException;
import com.imperva.vendingmachine.model.Person;
import com.imperva.vendingmachine.model.Product;
import com.imperva.vendingmachine.service.OrderService;
import com.imperva.vendingmachine.service.PersonService;
import com.imperva.vendingmachine.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    private final PersonService personService;
    private final ProductService productService;

    public OrderServiceImpl(PersonService personService, ProductService productService) {
        this.personService = personService;
        this.productService = productService;
    }

    @Override
    public void provideOrder(String personNickname, String productTitle) {
        Person person = personService.findByNickname(personNickname);
        Product product = productService.findByTitle(productTitle);

        if (person.getBalance().subtract(product.getPrice()).compareTo(BigDecimal.ZERO) < 0){
            throw new NotEnoughBalanceException("Not enough balance");
        }

        product.setAmount(product.getAmount() - 1);

        personService.updatePerson(personNickname, person.getBalance().subtract(product.getPrice()));
        productService.updateProduct(product.getTitle(), product);

    }

}
