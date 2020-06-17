package com.imperva.vendingmachine.controller;

import com.imperva.vendingmachine.model.Person;
import com.imperva.vendingmachine.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/getByNickname")
    public Person findPersonByNickname(@RequestParam String nickname) {
        return personService.findByNickname(nickname);
    }

    @GetMapping("/getAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PutMapping("/update/{personNickname}")
    public void update(@PathVariable String personNickname, @RequestBody Person person) {
        personService.updatePerson(personNickname, person.getBalance());
    }

    @DeleteMapping("/delete/{personNickname}")
    public void delete(@PathVariable String personNickname) {
        personService.deletePerson(personNickname);
    }

}
