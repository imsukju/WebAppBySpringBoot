package com.example4.SpringBootDemo4.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example4.SpringBootDemo4.DTO.NamesOnlyDTO;
import com.example4.SpringBootDemo4.entity.Address;
import com.example4.SpringBootDemo4.entity.Person;
import com.example4.SpringBootDemo4.repositoy.PersonRepository.PersonSummary;
import com.example4.SpringBootDemo4.service.PersonService;

@RestController
public class Controller {

	@Qualifier("personService")
	@Autowired
	PersonService personservice;
	
	@GetMapping
	public Collection<Person> findAll()
	{
		return personservice.findAll();
	}
	
	@PostMapping("/new")
	public String getMethodName(@RequestParam("firstname") String firstname,
			@RequestParam("lsatname") String lsatname
			,@RequestParam("zipCode") String zipCode
			,@RequestParam("city") String city
			,@RequestParam("street") String street
			
			) {
		Address adress = new Address(zipCode,city,street);
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(firstname);
		person.setAddress(adress);

		personservice.savePerson(person);
		return "redirect:/";
	}
	
	@GetMapping("/findById")
	public Person findById(UUID id) 
	{
		return personservice.findById(id);
	}
	
	@PostMapping("/update/{id}")
	public Person update(@RequestParam("firstname") String firstname,
			@RequestParam("lsatname") String lsatname
			,@RequestParam("zipCode") String zipCode
			,@RequestParam("city") String city
			,@RequestParam("street") String street
			,@PathVariable("id") UUID id
			)
	{
		if (personservice.findById(id) != null)
		{
			Person person = personservice.findById(id);
			person.setFirstname(firstname);
			person.setLastname(lsatname);
			person.getAddress().setCity(city);
			person.getAddress().setZipCode(zipCode);
			person.getAddress().setStreet(street);
			return personservice.update(person);
			
		}
	
		return null;
	}
	
	@PostMapping("/deleteById")
	public void deleteById(@RequestParam("id") UUID id)
	{
		personservice.deleteById(id);
	}
	
	@GetMapping("findByLastname")
	public Collection<NamesOnlyDTO> findByLastname(@RequestParam("lastname") String lastname)
	{
		return personservice.findByLastname(lastname);
	}

	@GetMapping("/findByFirstname")
	public Collection<PersonSummary> findByFirstname(@RequestParam("firstname") String firstname) 
	{
		return personservice.findByFirstname(firstname);
	}
	
	@GetMapping("/findByLastnameStartingWith")
    // Find persons by last name starting with a prefix (using DTO)
    public Collection<NamesOnlyDTO> findByLastnameStartingWith(@RequestParam("prefix") String prefix) {
        return personservice.findByLastnameStartingWith(prefix);
    }

    // Dynamic projection for finding persons by last name
	@GetMapping("/findByLastnameWithClass")
    public Collection<?> findByLastname(@RequestParam("lastname") String lastname, @RequestParam("type") Class<?> type) {
        return personservice.findByLastname(lastname, type);
    }
	
	

}
