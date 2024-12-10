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
    implementation 'com.github.y00913:hangul-utils:v0.4.2'
  }
```

### - 기능들
1. 한글 단어 리스트 중 주어진 초성으로 시작하는 단어 리스트를 리턴합니다.
```java
  List<String> tmp1 = HangulUtils.getListByCho('ㄱ', Arrays.asList("가가가","까나나","다다다","나나","구도","11"));
  System.out.println(tmp1.toString());
  // 출력 결과 => [가가가, 까나나, 구도]

  List<String> tmp2 = HangulUtils.getListByCho('ㄲ', Arrays.asList("가가가","까나나","다다다","나나","구도","11"));
  System.out.println(tmp2.toString());
  // 출력 결과 => [까나나]

  List<String> tmp3 = HangulUtils.getListByCho('1', Arrays.asList("가가가","까나나","다다다","나나","구도","11"));
  System.out.println(tmp3.toString());
  // 출력 결과 => [] (한글로 된 단어만 찾습니다 .)
```
2. 객체 리스트 내 문자열로된 필드 중 주어진 초성으로 시작하는 단어 리스트를 리턴합니다.
```java
  class User {
    String name;
    int number;
    
    public User(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
  }

  class Example {
    List<User> users = List.of(
      new User("가가가", 1),
      new User("까나나", 2),
      new User("다다다", 3),
      new User("나나", 4),
      new User("구도", 5),
      new User("11", 6)
    );

    List<User> tmp1 = HangulUtils.getListByCho('ㄱ', User::getName, users);
    System.out.println(tmp1.toString());
    // 출력 결과 => [가가가, 까나나, 구도]

    List<User> tmp2 = HangulUtils.getListByCho('ㄲ', User::getName, users);
    System.out.println(tmp2.toString());
    // 출력 결과 => [까나나]

    List<User> tmp3 = HangulUtils.getListByCho('1', User::getName, users);
    System.out.println(tmp3.toString());
    // 출력 결과 => [] (한글로 된 단어만 찾습니다 .)
  }
```
