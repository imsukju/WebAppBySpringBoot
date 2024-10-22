package com.example2.GettingStart.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example2.GettingStart.dto.UserDTO;
import com.example2.GettingStart.entity.User;
import com.example2.GettingStart.repository.UserRepository;
import com.example2.GettingStart.service.UserSerivce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	@Autowired
	@Qualifier("userservice")
	UserSerivce userservice;



	
	@GetMapping("/")
	public String getAllUser() {
		return userservice.findAll().toString();
	}
	
	@GetMapping("/findbyEmail/{email}")
	public String findByemail(@PathVariable("email") String email)
	{
		if (email == null)
		{
			return "param is null ";
			
		}
		else
		{
			System.out.println(email);
		}

		if(userservice.findByEmail(email).isPresent())
		{
			Optional<User> ou = userservice.findByEmail(email);
			User user = ou.get();
			if(user != null)
			{
				UserDTO userDT = UserDTO.toUserDTO(user);
				return userDT.getFirstname() + userDT.getLastname();
			}
		}
		return "Null";
	}
	
	@GetMapping("/findbyEmail2")
	public String findByemail2(@RequestParam("email") String email)
	{
		if (email == null)
		{
			return "param is null ";
			
		}
		else
		{
			System.out.println(email);
		}

		if(userservice.findByEmail(email).isPresent())
		{
			Optional<User> ou = userservice.findByEmail(email);
			User user = ou.get();
			if(user != null)
			{
				UserDTO userDT = UserDTO.toUserDTO(user);
				return userDT.getFirstname() + userDT.getLastname();
			}
		}
		return "Null";
	}
	
//	@GetMapping("/new")
//	public void createNewUser(Model model)
//	{
//		model.addAttribute("User",new UserDTO());
//	}
//	
//	@PostMapping("/new")
//	public void creatnewUser(@ModelAttribute("User")UserDTO userdto)
//	{
//		userservice.createUser(userdto);
//	}

	
	@PostMapping("/new")
	public void creatnewUser(@RequestParam("fn")String firstname, @RequestParam("ln")String lastname,
			@RequestParam("em")String email)
	{
		UserDTO ud= new UserDTO();
		ud.setFirstname(firstname);
		ud.setLastname(lastname);
		ud.setEmail(email);

		userservice.createUser(ud);
		
	}
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("email") String email)
	{
		userservice.deleteByEmail(email);
		return "삭제완료";
	}
	
	@GetMapping("/remove")
	public String removeUser(@RequestParam("email") String email)
	{
		userservice.removeByEmail(email);
		return "삭제완료";
	}

	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id,@RequestParam("fn")String firstname, @RequestParam("ln")String ln)
	{
		UserDTO  dto = UserDTO.toUserDTO(userservice.findByid(id).get());
		
		return dto.toString();
	}

}
