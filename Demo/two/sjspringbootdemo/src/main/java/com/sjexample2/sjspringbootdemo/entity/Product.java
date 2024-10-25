package com.sjexample2.sjspringbootdemo.entity;

import java.math.BigDecimal;
import java.util.Iterator;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	private BigDecimal price;
	
	public Product(String description, BigDecimal price) 
	{
		this.description = description;
	    this.price = price;
	}

}
