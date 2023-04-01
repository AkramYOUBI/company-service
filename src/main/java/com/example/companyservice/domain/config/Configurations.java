package com.example.companyservice.domain.config;

import feign.Client;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    public Client feignClient() {
        return new OkHttpClient();
    }
}
