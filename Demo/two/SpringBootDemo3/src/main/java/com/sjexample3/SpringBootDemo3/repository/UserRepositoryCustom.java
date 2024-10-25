package com.sjexample3.SpringBootDemo3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sjexample3.SpringBootDemo3.entity.User;

public interface UserRepositoryCustom {
	@Query("SELECT u FROM User u WHERE u.active = true")
	List<User> customQueryMethod();
}
