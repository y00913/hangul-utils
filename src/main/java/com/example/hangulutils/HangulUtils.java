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
        if (data == null || data.isEmpty()) {
            return ' ';
        }

        char firstChar = data.charAt(0);
        int unicodeOffset = firstChar - KOREAN_START_UNICODE;

        if (unicodeOffset < 0 || unicodeOffset >= INITIAL_LIST.size() * JUNGSUNG_UNICODE * JONGSUNG_UNICODE) {
            return ' ';
        }

        int firstInitialIndex = unicodeOffset / (JUNGSUNG_UNICODE * JONGSUNG_UNICODE);
        return INITIAL_LIST.get(firstInitialIndex);
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
