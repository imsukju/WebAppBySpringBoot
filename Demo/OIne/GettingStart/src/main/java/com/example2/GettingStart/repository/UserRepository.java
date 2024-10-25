package com.example2.GettingStart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example2.GettingStart.entity.User;

@Repository
@Qualifier("userrepository")
public interface UserRepository extends CrudRepository<User, Long> {

    long countByLastname(String lastname);

    @Transactional
    long deleteByEmail(String email); // 이메일로 삭제 메서드 추가
    @Transactional
    List<User> removeByEmail(String email); // 이메일로 삭제 후 목록 리턴 메서드 추가

	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Long id);
	

}