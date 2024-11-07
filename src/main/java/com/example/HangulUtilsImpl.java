package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HangulUtilsImpl implements HangulUtils{

    private static final List<Character> InitialList = Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ');
    private static final List<Character> doubleInitialList = Arrays.asList('ㄲ', 'ㄸ', 'ㅃ', 'ㅆ', 'ㅉ');

    private Character getInitial(String gameName) {
        Character firstChar = gameName.charAt(0);
        int uniCode = (int) firstChar - 0xAC00;
        int initialIndex = (int) Math.floor(uniCode / 588);

        if (initialIndex >= 0 && initialIndex < InitialList.size()) {
            return InitialList.get(initialIndex);
        }

        return ' ';
    }

    private Boolean isInitialMatch(Character initial, Character selectedCho) {
        if (doubleInitialList.contains(initial)) {
            int index = InitialList.indexOf(initial);
            initial = InitialList.get(index - 1);
        }

        return initial.equals(selectedCho);
    }

    @Override
    public List<String> getListByCho(Character chosung, List<String> list) {
        List<String> dataList = new ArrayList<>();

        for (String data : list) {
            Character initial = getInitial(data);
            if (isInitialMatch(initial, chosung)) {
                dataList.add(data);
            }
        }

        return dataList;
    }

}
