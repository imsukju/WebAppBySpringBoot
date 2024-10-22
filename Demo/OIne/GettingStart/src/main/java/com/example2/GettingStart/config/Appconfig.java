package com.example2.GettingStart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages  = {"com.example2.GettingStart.repository","com.example2.GettingStart.service"})
public class Appconfig {

}
