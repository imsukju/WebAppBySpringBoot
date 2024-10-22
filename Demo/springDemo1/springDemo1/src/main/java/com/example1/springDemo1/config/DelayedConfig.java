package com.example1.springDemo1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelayedConfig {

	@Bean(name = "helloDelayed")
	String helloDelayed()
	{
		return "Hello Delayed Bean";
	}
}
