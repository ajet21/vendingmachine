package com.imperva.vendingmachine.service.impl;

import com.imperva.vendingmachine.exception.NicknameAlreadyExistsException;
import com.imperva.vendingmachine.exception.PersonNotFoundException;
import com.imperva.vendingmachine.model.Person;
import com.imperva.vendingmachine.repository.PersonRepository;
import com.imperva.vendingmachine.service.PersonService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        personRepository.findByNickname(person.getNickname()).ifPresent(p ->
            {throw new NicknameAlreadyExistsException("Nickname already exists: " + p.getNickname());});

        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(String nickname, BigDecimal balance) {
        Person person = findByNickname(nickname);
        person.setBalance(balance);

        return personRepository.save(person);
    }

    @Override
    public void deletePerson(String nickname) {
        personRepository.delete(findByNickname(nickname));
    }

    @Override
    public Person findByNickname(String nickname) {
        return personRepository.findByNickname(nickname)
                .orElseThrow(() -> new PersonNotFoundException("nickname: " + nickname));
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }


}
