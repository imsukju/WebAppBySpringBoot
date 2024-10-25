package com.sjexample2.sjspringbootdemo.service;

import org.springframework.stereotype.Service;

import com.sjexample2.sjspringbootdemo.entity.Product;
import com.sjexample2.sjspringbootdemo.repository.ProductRepository;
import com.sjexample2.sjspringbootdemo.wrapper.Products;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService 
{
	private final ProductRepository productRepository;
	
	public Products getProductsByDescription(String description)
	{
		return productRepository.findAllByDescriptionContaining(description);
	}
	
	public void printTotalPrice(String description)
	{
		Products products = getProductsByDescription(description);
		
		System.out.println("Total Price : " + products.getTotalPrie());
	}
	
	public void save(Product product)
	{
		productRepository.save(product);
	}

}

