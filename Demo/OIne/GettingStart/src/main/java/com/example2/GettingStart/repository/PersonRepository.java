package com.example2.GettingStart.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.example2.GettingStart.entity.Person;

public interface PersonRepository extends Repository<Person,Long>
{
	  Person save(Person person);

	  Optional<Person> findById(long id);
}
