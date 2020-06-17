package com.imperva.vendingmachine.service;

import com.imperva.vendingmachine.model.Person;
import java.math.BigDecimal;
import java.util.List;

public interface PersonService {

    Person addPerson(Person person);

    Person updatePerson(String nickname, BigDecimal balance);

    void deletePerson(String nickname);

    Person findByNickname(String nickname);

    List<Person> findAll();

}
