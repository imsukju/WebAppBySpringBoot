package com.example2.GettingStart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example2.GettingStart.dto.UserDTO;
import com.example2.GettingStart.entity.User;
import com.example2.GettingStart.service.UserService2;

@RestController
@RequestMapping("/user2")
public class CustomUsersController {

	@Autowired
	@Qualifier("userservice2")
	UserService2 userservice2;
	
	@GetMapping("/countByLastname")
	public Long getcountByLastname(String lastname)
	{
		return userservice2.countByLastname(lastname);
	}
	
	
	
	@PostMapping("/saveuser")
	public void saveUser(@RequestParam("fn")String firstname, @RequestParam("ln")String lastname,
			@RequestParam("em")String email,@RequestParam("status")String status)
	{
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setStatus(status);
		userservice2.saveUser(user);
		
		
	}
	
	@GetMapping("/findDistinctPeopleByLastnameOrFirstname")
	public String findDistinctPeopleByLastnameOrFirstname(@RequestParam("lastname") String lastname,
			@RequestParam("firstname") String firstname)
	{
		userservice2.findDistinctUserByLastnameOrFirstname(lastname, firstname);
		return new String();
	}

	
}
