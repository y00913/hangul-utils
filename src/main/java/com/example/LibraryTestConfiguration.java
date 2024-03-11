package com.example;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class LibraryTestConfiguration {

    @Bean
    public LibraryTestPrint testName() {
        return new LibraryTestPrint();
    }

}
