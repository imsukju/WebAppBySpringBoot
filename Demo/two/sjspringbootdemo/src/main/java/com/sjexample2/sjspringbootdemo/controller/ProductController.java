package com.sjexample2.sjspringbootdemo.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjexample2.sjspringbootdemo.entity.Product;
import com.sjexample2.sjspringbootdemo.service.ProductService;
import com.sjexample2.sjspringbootdemo.wrapper.Products;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController 
{
	private final ProductService productservice;
	
	@PostMapping("/new")
	public String getsave(@RequestParam("description") String description, @RequestParam("price") BigDecimal price)
	{
		Product product = new Product();
		
		product.setDescription(description);
		product.setPrice(price);
		productservice.save(product);
		return "저장완료" + product.toString();
	}
	

	@GetMapping("/{description}")
	public Products findProductionBydescription(@PathVariable("description") String description)
	{
		return productservice.getProductsByDescription(description);
	}
	
	@GetMapping("/totalprice")
	public void getMethodName(@RequestParam("description") String description) 
	{
		productservice.printTotalPrice(description);
	
	}
	
}
