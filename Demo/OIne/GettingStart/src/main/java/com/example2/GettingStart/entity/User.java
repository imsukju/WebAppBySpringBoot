package com.example2.GettingStart.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User extends AbstractEntity<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private String status;
	
	@Column(unique = true)
	private String email;
	
	@Transient
	@Setter(AccessLevel.NONE)
	private boolean isNew = true;
	
	@PostLoad
	void markNotNew()
	{
		this.isNew =false; // 엔티티가 로드된 후 inNew 플래그를 false로 설정
	}
	
	
	
}
