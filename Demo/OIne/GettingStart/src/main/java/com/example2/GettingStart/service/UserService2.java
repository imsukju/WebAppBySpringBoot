package com.example2.GettingStart.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example2.GettingStart.dto.UserDTO;
import com.example2.GettingStart.entity.User;
import com.example2.GettingStart.repository.UserRepositoryByJPA;

@Service
@Qualifier("userservice2")
public class UserService2 {

	@Autowired
	@Qualifier("userrepositorybyjpa")
    private final UserRepositoryByJPA userrepositorybyjpa;

    public UserService2(UserRepositoryByJPA userRepository) {
        this.userrepositorybyjpa = userRepository;
    }
    
    

    public long countByLastname(String lastname) {
        return userrepositorybyjpa.countByLastname(lastname);
    }

    @Transactional
    public long deleteByEmail(String email) { // 이메일로 삭제하는 메서드 추가
        return userrepositorybyjpa.deleteByEmail(email);
    }

    @Transactional
    public List<UserDTO> removeByEmail(String email) {
        List<User> users = userrepositorybyjpa.removeByEmail(email);
        return users.stream()
                    .map(UserDTO::toUserDTO) // User -> UserDTO 변환
                    .collect(Collectors.toList());
    }

    public UserDTO saveUser(User user) {
        User savedUser = userrepositorybyjpa.save(user);
        return UserDTO.toUserDTO(savedUser); // User -> UserDTO 변환
    }

    public List<UserDTO> findAll() {
        List<User> users = (List<User>) userrepositorybyjpa.findAll();
        return users.stream()
                    .map(UserDTO::toUserDTO) // User -> UserDTO 변환
                    .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        User user = userrepositorybyjpa.findById(id).orElse(null);
        return UserDTO.toUserDTO(user); // User -> UserDTO 변환 (null 가능성 처리)
    }


    @Transactional
    public void updateUser(String firstname, String lastname, String email, String status) {
        User user = userrepositorybyjpa.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setStatus(status);
        
    }
    
    // FirstName이 특정 prefix로 시작하는 유저 목록 조회
    public List<UserDTO> findByFirstNameStartingWith(String prefix) {
        List<User> users = userrepositorybyjpa.findByFirstnameStartingWith(prefix);
        return users.stream()
                    .map(UserDTO::toUserDTO)
                    .collect(Collectors.toList());
    }

    // LastName이 특정 문자열을 포함하는 유저 목록 조회
    public List<UserDTO> findByLastNameContaining(String substring) {
        List<User> users = userrepositorybyjpa.findByLastnameContaining(substring);
        return users.stream()
                    .map(UserDTO::toUserDTO)
                    .collect(Collectors.toList());
    }

    // Email에 특정 문자열이 없는 유저 목록 조회
    public List<UserDTO> findByEmailNotContaining(String substring) {
        List<User> users = userrepositorybyjpa.findByEmailNotContaining(substring);
        return users.stream()
                    .map(UserDTO::toUserDTO)
                    .collect(Collectors.toList());
    }
    
 // 이메일과 성으로 사용자 검색
    public List<UserDTO> findByEmailAndLastname(String emailAddress, String lastname) {
        return userrepositorybyjpa.findByEmailAndLastname(emailAddress, lastname)
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }

    // 성 또는 이름으로 중복 제거된 사용자 검색
    public List<UserDTO> findDistinctUserByLastnameOrFirstname(String lastname, String firstname) {
        return userrepositorybyjpa.findDistinctUserByLastnameOrFirstname(lastname, firstname)
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }

    // 성을 기준으로 대소문자를 무시하고 사용자 검색
    public List<UserDTO> findByLastnameIgnoreCase(String lastname) {
        return userrepositorybyjpa.findByLastnameIgnoreCase(lastname)
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }

    // 성과 이름을 기준으로 대소문자를 무시하고 사용자 검색
    public List<UserDTO> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname) {
        return userrepositorybyjpa.findByLastnameAndFirstnameAllIgnoreCase(lastname, firstname)
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }

    // 성을 기준으로 이름을 오름차순으로 정렬하여 사용자 검색
    public List<UserDTO> findByLastnameOrderByFirstnameAsc(String lastname) {
        return userrepositorybyjpa.findByLastnameOrderByFirstnameAsc(lastname)
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }

    // 성을 기준으로 이름을 내림차순으로 정렬하여 사용자 검색
    public List<UserDTO> findByLastnameOrderByFirstnameDesc(String lastname) {
        return userrepositorybyjpa.findByLastnameOrderByFirstnameDesc(lastname)
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }
    
 // 특정 범위 내의 사용자 검색
    public List<UserDTO> findUsersByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<User> users = userrepositorybyjpa.findByCreationDateBetween(startDate, endDate);
        return users.stream().map(UserDTO::toUserDTO).collect(Collectors.toList());
    }

    // 특정 날짜 이전의 사용자 검색
    public List<UserDTO> findUsersByCreationDateLessThan(LocalDateTime date) {
        List<User> users = userrepositorybyjpa.findByCreationDateLessThan(date);
        return users.stream().map(UserDTO::toUserDTO).collect(Collectors.toList());
    }

    // 이메일에 특정 문자열이 포함된 사용자 검색
    public List<UserDTO> findUsersByEmailContaining(String keyword) {
        List<User> users = userrepositorybyjpa.findByEmailContaining(keyword);
        return users.stream().map(UserDTO::toUserDTO).collect(Collectors.toList());
    }
    
    public List<UserDTO> findByLastNameThroughtSortedAndLimited(String lastname,Sort sort ,int limit)
    {
    	List<User> user = userrepositorybyjpa.findByLastname(lastname, sort, Limit.of(limit));
    	return user.stream().map(UserDTO::toUserDTO).collect(Collectors.toList());
    	
    }
}
