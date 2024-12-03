package com.example.hangulutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class HangulUtils{

    private static final List<Character> InitialList = Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ');
    private static final List<Character> doubleInitialList = Arrays.asList('ㄲ', 'ㄸ', 'ㅃ', 'ㅆ', 'ㅉ');

    // 해당 초성으로 시작하는 리스트 리턴
    public static List<String> getListByCho(Character chosung, List<String> list) {
        List<String> dataList = new ArrayList<>();

        for (String data : list) {
            Character initial = getInitial(data);
            if (isInitialMatch(chosung, initial)) {
                dataList.add(data);
            }
        }

        return dataList;
    }

    // 해당 문자열의 초성 리턴
    private static Character getInitial(String data) {
        Character firstChar = data.charAt(0);
        int uniCode = (int) firstChar - 0xAC00;
        int initialIndex = (int) Math.floor(uniCode / 588);

        if (initialIndex >= 0 && initialIndex < InitialList.size()) {
            return InitialList.get(initialIndex);
        }

        return ' ';
    }

    // 해당 초성과 매치되는지 확인
    private static Boolean isInitialMatch(Character selectedCho, Character initial) {
        if (!doubleInitialList.contains(selectedCho) && doubleInitialList.contains(initial)) {
            int index = InitialList.indexOf(initial);
            initial = InitialList.get(index - 1);
        }

        return initial.equals(selectedCho);
    }

}
