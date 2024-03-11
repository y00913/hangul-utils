package com.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LibraryTestPrint {

    public String something() {
        LibraryTest libraryTest = new LibraryTest();
        return libraryTest.getName();
    }

}
