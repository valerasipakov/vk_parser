package com.javastart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("access_token.properties")
public class ApplicationConfiguration {


    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
