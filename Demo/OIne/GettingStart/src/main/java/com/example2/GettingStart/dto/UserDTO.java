package com.example2.GettingStart.dto;


import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example2.GettingStart.entity.User;
import com.example2.GettingStart.repository.UserRepository;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	private Long id;
	private String firstname;
	private String lastname;
	private String Email;
	private String status;

	public static UserDTO toUserDTO(User user)
	{
		if (user != null)
		{
			UserDTO  ud = new UserDTO();
			ud.setId(user.getId());
			ud.setFirstname(user.getFirstname());
			ud.setLastname(user.getLastname());
			ud.setEmail(user.getEmail());
			ud.setStatus(user.getStatus());

			return ud;
		}
		
		return null;

	}
	
	public  static User toEntity(UserDTO userdto)
	{
		User u = new User();

		u.setId(userdto.getId());
		u.setFirstname(userdto.firstname);
		u.setLastname(userdto.getLastname());
		u.setEmail(userdto.getEmail());
		u.setStatus(userdto.getStatus());
		return u;


	}

}
