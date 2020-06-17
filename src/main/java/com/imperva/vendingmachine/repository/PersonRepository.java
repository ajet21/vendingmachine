package com.imperva.vendingmachine.repository;

import com.imperva.vendingmachine.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByNickname(String nickname);

    List<Person> findAll();
}
