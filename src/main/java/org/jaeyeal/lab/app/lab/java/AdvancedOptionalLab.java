package org.jaeyeal.lab.app.lab.java;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

public class AdvancedOptionalLab {
    /**
     * public void ifPresent(Consumer<? super T> action)
     *  - Optional 이 null이 아니라면 action을 실행
     *  - action은 Consumer 함수형 인터페이스라 반환 타입이 void
     *
     * public <U> Optional<U> map(Function<? super T, ? extends U> mapper)
     *  - Optional 안에 값이 존재한다면 ampper를 적용
     *  - mapper 의 반환 타입에 따라서 Optional의 타입도 변경된다.
     *
     * public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)
     *  - Stream의 flatMap 과 비슷한 기능을 제공
     *  - Optional 안의 Optional 이 존재한다면 이것들을 하나의 Optional 로 flat하게 만들어 주는 기능을 제공
     *
     */
    public static void main(String[] args) {
        Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
        // Optional 안에 값이 존재한다면 출력
        maybeUser.ifPresent(i -> System.out.println("i1 = " + i));

        // Optional 안에 값이 존재한다면 amp 으로 가공한 값이 Optional 안에 담긴다.
        Optional<Integer> mayBeId = Optional.ofNullable(maybeGetUser(true)).map(i -> i.getId());
        mayBeId.ifPresent(i -> System.out.println("i2 = " + i));

        // Optional 안의 값이 null 이기 때문에 map이 동작하지 않는다.
        Optional<Integer> mayBeId2 = Optional.ofNullable(maybeGetUser(false)).map(i -> i.getId());
        // Optional 안의 값이 null 이기 때문에 동작x
        mayBeId.ifPresent(i -> System.out.println("i3 = " + i));

        // Optional 안의 값이 null 이기 때문에 orElse가 동작
        String userName = Optional.ofNullable(maybeGetUser(false))
                .map(User::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is null");

        System.out.println("userName = " + userName);


    }
    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return User.builder()
                    .id(1001)
                    .name("user")
                    .emailAddress("test@gmail.com")
                    .verified(false)
                    .build();
        } else {
            return null;
        }

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private int id;
        private String name;
        private String emailAddress;
        private boolean verified;
    }
}
