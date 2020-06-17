package com.imperva.vendingmachine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    @SequenceGenerator(sequenceName = "person_id_seq", allocationSize = 1, name = "PERSON_SEQ")
    @JsonIgnore
    private Long id;

    private String nickname;

    private String password;

    private BigDecimal balance;

    public Person(String nickname, String password, BigDecimal balance) {
        this.nickname = nickname;
        this.password = password;
        this.balance = balance;
    }
}
