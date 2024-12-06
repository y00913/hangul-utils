package com.example.hangulutils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class HangulUtils{

    private static final List<Character> INITIAL_LIST = Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ');
    private static final Set<Character> DOUBLE_INITIAL_SET = Set.of('ㄲ', 'ㄸ', 'ㅃ', 'ㅆ', 'ㅉ');
    private static final int KOREAN_START_UNICODE = 0xAC00;
    private static final int JUNGSUNG_UNICODE = 0x1C;
    private static final int JONGSUNG_UNICODE = 0x15;

    private HangulUtils() {

    }

    // 해당 초성으로 시작하는 리스트 리턴
    public static List<String> getListByCho(Character chosung, List<String> list) {
        return list.stream()
                .filter(data -> isEqual(chosung, getFirstInitial(data)))
                .toList();
    }

    // 해당 문자열의 초성 리턴
    private static Character getFirstInitial(String data) {
        char result = ' ';

        if (data == null || data.isEmpty()) {
            return result;
        }

        char firstChar = data.charAt(0);

        if(!isKorean(firstChar)) {
            return result;
        }

        int firstCharUnicode = firstChar - KOREAN_START_UNICODE;
        int firstInitialIndex = firstCharUnicode / (JUNGSUNG_UNICODE * JONGSUNG_UNICODE);

        if (firstInitialIndex >= 0 && firstInitialIndex < INITIAL_LIST.size()) {
            result = INITIAL_LIST.get(firstInitialIndex);
        }

        return result;
    }

    // 한글인지 확인
    private static boolean isKorean(char ch) {
        return (ch >= 0xAC00 && ch <= 0xD7A3) ||
                (ch >= 0x1100 && ch <= 0x1112) ||
                (ch >= 0x1161 && ch <= 0x1175) ||
                (ch >= 0x11A8 && ch <= 0x11C2);
    }

    // 해당 초성과 매치되는지 확인
    private static boolean isEqual(Character selectedCho, Character firstInitial) {
        if (!DOUBLE_INITIAL_SET.contains(selectedCho) && DOUBLE_INITIAL_SET.contains(firstInitial)) {
            int index = INITIAL_LIST.indexOf(firstInitial);

            if(index != -1) {
                firstInitial = INITIAL_LIST.get(index - 1);
            }
        }

        return firstInitial.equals(selectedCho);
    }

}
