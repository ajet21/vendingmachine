package com.imperva.vendingmachine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @SequenceGenerator(sequenceName = "product_id_seq", allocationSize = 1, name = "PRODUCT_SEQ")
    @JsonIgnore
    private Long id;

    private String title;

    private BigDecimal price;

    private Integer amount;
}
