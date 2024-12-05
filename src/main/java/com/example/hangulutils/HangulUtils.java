package com.example.hangulutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class HangulUtils{

    private static final List<Character> InitialList = Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ');
    private static final List<Character> doubleInitialList = Arrays.asList('ㄲ', 'ㄸ', 'ㅃ', 'ㅆ', 'ㅉ');
    private static final Integer koreanStartUnicode = 0xAC00;
    private static final Integer jungsungUnicode = 0x1C;
    private static final Integer jongsungUnicode = 0x15;

    // 해당 초성으로 시작하는 리스트 리턴
    public static List<String> getListByCho(Character chosung, List<String> list) {
        List<String> dataList = new ArrayList<>();
        for (String data : list) {
            Character firstInitial = getFirstInitial(data);
            if (isEqual(chosung, firstInitial)) {
                dataList.add(data);
            }
        }

        return dataList;
    }

    // 해당 문자열의 초성 리턴
    private static Character getFirstInitial(String data) {
        Character firstChar = data.charAt(0);
        int firstCharUnicode = (int) firstChar - koreanStartUnicode;
        int firstInitialIndex = (int) Math.floor(firstCharUnicode / (jungsungUnicode * jongsungUnicode));

        if (firstInitialIndex < 0 || firstInitialIndex >= InitialList.size()) {
            return ' ';
        }

        return InitialList.get(firstInitialIndex);
    }

    // 해당 초성과 매치되는지 확인
    private static Boolean isEqual(Character selectedCho, Character firstInitial) {
        if (!doubleInitialList.contains(selectedCho) && doubleInitialList.contains(firstInitial)) {
            int index = InitialList.indexOf(firstInitial);
            firstInitial = InitialList.get(index - 1);
        }

        return firstInitial.equals(selectedCho);
    }

}
