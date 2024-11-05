package com.example;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class HangulUtilsConfiguration {

    @Bean
    public HangulUtilsImpl hangulUtils () {
        return new HangulUtilsImpl();
    }

}
