package com.gremwell.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gremwell.demo.persistence.model.Person;
import com.gremwell.demo.persistence.repo.PersonRepository;
import com.gremwell.demo.web.exception.PersonIdMismatchException;
import com.gremwell.demo.web.exception.PersonNotFoundException;

import com.gremwell.demo.persistence.model.VulnData;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/fname/{firstName}")
    public List<Person> findByFList(@PathVariable String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    @GetMapping("/{id}")
    public Person findOne(@PathVariable String id) {
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @PostMapping("/vuln")
    public List<Person> vuln(@RequestBody VulnData data) {
        return personRepository.vulnFind(data.getParam(), data.getValue());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        Person person1 = personRepository.save(person);
        return person1;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        personRepository.findById(id)
          .orElseThrow(PersonNotFoundException::new);
        personRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String id) {
        if (person.getId() != id) {
            throw new PersonIdMismatchException();
        }
        personRepository.findById(id)
          .orElseThrow(PersonNotFoundException::new);
        return personRepository.save(person);
    }
}
