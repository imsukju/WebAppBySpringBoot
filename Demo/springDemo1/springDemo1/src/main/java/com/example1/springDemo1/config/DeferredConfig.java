package com.example1.springDemo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeferredConfig {

    @Bean
    public String deferredService() {
        return "Deferred Service Bean Loaded";
    }
}