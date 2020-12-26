package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.entities.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RequestMapping("/people")
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(personRepository.findPersonById(id), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable Long id){
        if (p.getId() != null)
            return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
        else
            return createPerson(p);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

