package com.example2.GettingStart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example2.GettingStart.dto.UserDTO;
import com.example2.GettingStart.entity.User;
import com.example2.GettingStart.repository.UserRepository;

;

@Service
@Qualifier("userservice")
public class UserSerivce {
	@Autowired
	@Qualifier("userrepository")
	private UserRepository userrepository;
	
    public long countByLastname(String lastname)
    {	
    	
    	return userrepository.countByLastname(lastname);
    }

    public long deleteByEmail(String email)
    {
    	return userrepository.deleteByEmail(email);
    } // 이메일로 삭제 메서드 추가

    public List<User> removeByEmail(String email)
    {
    	//toUserDTO
    	List<User> users = userrepository.removeByEmail(email);
    	
    	List<UserDTO> dtos = users.stream().
    			map(UserDTO::toUserDTO)
    			.collect(Collectors.toList());
    	return userrepository.removeByEmail(email);
    } // 이메일로 삭제 후 목록 리턴 메서드 추가

	public Optional<User> findByEmail(String email)
	{
		return userrepository.findByEmail(email);
	}
	public void createUser(UserDTO userDTO)
	{
		User user = UserDTO.toEntity(userDTO);
		userrepository.save(user);
	}
	
	public Iterable<User> findAll()
	{
		return userrepository.findAll();
	}
	
	public Optional<User> findByid(Long id)
	{
		return userrepository.findById(id);
	}
	
	public void updateuser(String firstname, String lastnmae)
	{
		
	}

}
