package com.example2.GettingStart;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example2.GettingStart.entity.Person;
import com.example2.GettingStart.repository.PersonRepository;

@SpringBootApplication
public class GettingStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(GettingStartApplication.class, args);
	}	

	
	@Bean
	CommandLineRunner runner(PersonRepository repository)
	{
		return args ->
		{
			Person person = new Person();
			person.setName("John");
			
			repository.save(person);
			Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
			System.out.println("name" + saved.getName());
		};
	}
}
