package com.example.hangulutils;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
class HangulUtilsConfiguration {

    @Bean
    public HangulUtilsImpl hangulUtils () {
        return new HangulUtilsImpl();
    }

}
