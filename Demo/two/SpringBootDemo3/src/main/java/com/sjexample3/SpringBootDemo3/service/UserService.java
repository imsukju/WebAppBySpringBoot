package com.sjexample3.SpringBootDemo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.sjexample3.SpringBootDemo3.repository.UserRepository2;

import lombok.RequiredArgsConstructor;

@Service

public class UserService {
	
	@Autowired
	@Qualifier("userRepository2")
	private UserRepository2 userRepository2;
	
	public void customQueryMethod()
	{
		userRepository2.customQueryMethod();
	}
	
}
