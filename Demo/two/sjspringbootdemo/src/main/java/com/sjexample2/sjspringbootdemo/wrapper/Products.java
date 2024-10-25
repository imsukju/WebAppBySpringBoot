package com.sjexample2.sjspringbootdemo.wrapper;

import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.data.util.Streamable;

import com.sjexample2.sjspringbootdemo.entity.Product;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Products implements Streamable<Product>
{
	private final Streamable<Product> streamable;
	
	public BigDecimal getTotalPrie()
	{
		return streamable.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
//	public BigDecimal getTotalPrie2()
//	{
//		return streamable.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
//	}
	
	@Override
	public Iterator<Product> iterator()
	{
		return streamable.iterator();
	}
}
