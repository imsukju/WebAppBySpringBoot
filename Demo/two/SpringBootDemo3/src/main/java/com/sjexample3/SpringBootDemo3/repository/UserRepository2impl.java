package com.sjexample3.SpringBootDemo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sjexample3.SpringBootDemo3.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Primary
@Repository
@Qualifier("userRepository2")
public class UserRepository2impl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<User> customQueryMethod() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        
        return null;
    }
}
