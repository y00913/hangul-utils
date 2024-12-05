# hangul-utils

## 한글 관련 유틸 라이브러리

### - dependency 추가 방법
```java
  // build.gradle 에 추가
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }

  dependencies {
    ...
    implementation 'com.github.y00913:hangul-utils:v0.3.7'
  }
```

### - 기능들
1. 한글 단어 리스트 중 주어진 초성으로 시작하는 단어 리스트를 리턴합니다.
```java
  List<String> tmp = HangulUtils.getListByCho('ㄱ',Arrays.asList("가가가","까나나","다다다","나나","구도","11"));
  System.out.println(tmp.toString());
  // 출력 결과 => [가가가, 까나나, 구도]

  List<String> tmp = HangulUtils.getListByCho('ㄲ',Arrays.asList("가가가","까나나","다다다","나나","구도","11"));
  System.out.println(tmp.toString());
  // 출력 결과 => [까나나]

  List<String> tmp = HangulUtils.getListByCho('1',Arrays.asList("가가가","까나나","다다다","나나","구도","11"));
  System.out.println(tmp.toString());
  // 출력 결과 => [] (한글로 된 단어만 찾습니다 .)
```
