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
    implementation 'com.github.y00913:hangul-utils:v0.4.3'
  }
```

### - 기능들
1. 한글 단어 리스트 중 주어진 초성으로 시작하는 단어 리스트를 리턴합니다.
```java
import java.util.Arrays;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        // 초성이 'ㄱ'인 단어 찾기
        List<String> tmp1 = HangulUtils.getListByCho(
            'ㄱ', Arrays.asList("가가가", "까나나", "다다다", "나나", "구도", "11")
        );
        System.out.println(tmp1); // 출력 결과: [가가가, 까나나, 구도]

        // 초성이 'ㄲ'인 단어 찾기
        List<String> tmp2 = HangulUtils.getListByCho(
            'ㄲ', Arrays.asList("가가가", "까나나", "다다다", "나나", "구도", "11")
        );
        System.out.println(tmp2); // 출력 결과: [까나나]

        // 초성이 '1'인 단어 찾기
        List<String> tmp3 = HangulUtils.getListByCho(
            '1', Arrays.asList("가가가", "까나나", "다다다", "나나", "구도", "11")
        );
        System.out.println(tmp3); // 출력 결과: [] (한글로 된 단어만 찾습니다.)
    }
}
```
2. 객체 리스트 내 특정 문자열 필드에서 주어진 초성으로 시작하는 객 리스트 리턴
```java
import java.util.List;

@Data
class User {
    String name;
    int number;

    public User(String name, int number) {
        this.name = name;
        this.number = number;
    }
}

public class Example2 {
    public static void main(String[] args) {
        // User 객체 리스트
        List<User> users = List.of(
            new User("가가가", 1),
            new User("까나나", 2),
            new User("다다다", 3),
            new User("나나", 4),
            new User("구도", 5),
            new User("11", 6)
        );

        // 초성이 'ㄱ'인 User 찾기
        List<User> tmp1 = HangulUtils.getListByCho('ㄱ', User::getName, users);
        System.out.println(tmp1);
        // 출력 결과 => [User(name=가가가, number=1), User(name=까나나, number=2), User(name=구도, number=5)]

        // 초성이 'ㄲ'인 User 찾기
        List<User> tmp2 = HangulUtils.getListByCho('ㄲ', User::getName, users);
        System.out.println(tmp2);
        // 출력 결과 => [User(name=까나나, number=2)]

        // 초성이 '1'인 User 찾기
        List<User> tmp3 = HangulUtils.getListByCho('1', User::getName, users);
        System.out.println(tmp3);
        // 출력 결과 => [] (한글로 된 단어만 찾습니다.)
    }
}

```
