package com.springcoredemo.config;

import com.springcoredemo.common.Coach;
import com.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aqua")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
