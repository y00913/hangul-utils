package com.example;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        HangulUtils hangulUtils = new HangulUtils();
        List<String> testLiat = Arrays.asList("까가가", "가나나", "가다다", "나나나", "다다다", "11");
        List<String> resList = hangulUtils.getListByCho(  ' ', testLiat);

        System.out.println(resList);
    }

}
