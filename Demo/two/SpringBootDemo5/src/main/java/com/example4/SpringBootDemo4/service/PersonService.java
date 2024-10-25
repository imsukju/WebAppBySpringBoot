package com.example4.SpringBootDemo4.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example4.SpringBootDemo4.DTO.NamesOnlyDTO;
import com.example4.SpringBootDemo4.entity.Person;
import com.example4.SpringBootDemo4.repositoy.PersonRepository;
import com.example4.SpringBootDemo4.repositoy.PersonRepository.PersonSummary;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example4.SpringBootDemo4.repositoy.*;

@Service
@Qualifier("personService")
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // Create or update a person
    public Person save(Person person) {
        return personRepository.save(person);
    }

    // Find all persons
    public Collection<Person> findAll() {
        return personRepository.findAll();
    }

    // Find a person by ID
    public Person findById(UUID id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.orElse(null); // null if not found
    }

    // Update a person
    public Person update(Person person) {
        return personRepository.save(person);
    }

    // Delete a person by ID
    public void deleteById(UUID id) {
        personRepository.deleteById(id);
    }

    // Find persons by last name
    public Collection<NamesOnlyDTO> findByLastname(String lastname) {
    
    	Collection<NamesOnlyDTO> hello = personRepository.findByLastname(lastname).stream()
    	.map(
    		p -> new NamesOnlyDTO(p.getFirstname(),p.getLastname())
    		).collect(Collectors.toList());
    	
        return hello;
    }

    // Find persons by first name
    public Collection<PersonSummary> findByFirstname(String firstname) {
        return personRepository.findByFirstname(firstname);
    }

    // Find persons by last name starting with a prefix (using DTO)
    public Collection<NamesOnlyDTO> findByLastnameStartingWith(String prefix) {
        return personRepository.findByLastnameStartingWith(prefix);
    }

    // Dynamic projection for finding persons by last name
    public Collection<?> findByLastname(String lastname, Class<?> type) {
        return personRepository.findByLastname(lastname, type);
    }
    
    public void savePerson(Person person)
    {
    	personRepository.save(person);
    }
}