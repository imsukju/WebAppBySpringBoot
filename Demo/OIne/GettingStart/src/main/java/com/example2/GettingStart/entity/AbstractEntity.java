package com.example2.GettingStart.entity;

import org.springframework.data.domain.Persistable;

import jakarta.persistence.Transient;

import jakarta.persistence.*;
import lombok.*;

public abstract class AbstractEntity<id> implements Persistable<id>
{
	@Transient
	private boolean isNew = true;
	
	@Override
	public boolean isNew()
	{
		return isNew;
	}
	

	

	
}
