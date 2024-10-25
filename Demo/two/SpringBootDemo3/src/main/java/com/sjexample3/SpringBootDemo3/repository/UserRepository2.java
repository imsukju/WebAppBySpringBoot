package com.sjexample3.SpringBootDemo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjexample3.SpringBootDemo3.entity.User;


public interface UserRepository2 extends JpaRepository<User, Long>, UserRepositoryCustom {
	// Additional query methods can be defined here
}
