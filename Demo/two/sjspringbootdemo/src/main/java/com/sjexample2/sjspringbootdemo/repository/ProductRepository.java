package com.sjexample2.sjspringbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.sjexample2.sjspringbootdemo.entity.Product;
import com.sjexample2.sjspringbootdemo.wrapper.Products;

import lombok.RequiredArgsConstructor;

@Repository
//@RequiredArgsConstructor
public interface ProductRepository extends JpaRepository<Product, Long>
{
	Streamable<Product> findByDescriptionContaining(String description);
	
	Products findAllByDescriptionContaining(String description);
	
}
