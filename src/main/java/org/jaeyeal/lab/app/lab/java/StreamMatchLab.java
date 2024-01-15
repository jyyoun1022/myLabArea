package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;

public class StreamMatchLab {
    /**
     *  boolean allMatch(Predicate<? super T> predicate);
     *  - Stream 안의 모든 데이터가 predicate를 만족하면 true를 반환
     *
     *  boolean anyMatch(Predicate<? super T> predicate);
     *  - Stream 안의 데이터 중 하나라도 predicate를 만족하면 true를 반환
     */
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);

        // 모두 양수이면 true
        boolean allPositive = numbers.stream()
                .allMatch(number -> number > 0);

        System.out.println("allPositive = " + allPositive);

        // 하나라도 음수라면 true
        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number < 0);

        System.out.println("anyNegative = " + anyNegative);

        UserLab user1 = UserLab.builder()
                .id(101)
                .name("user1")
                .verified(true)
                .emailAddress("user1@gmail.com")
                .build();

        UserLab user2 = UserLab.builder()
                .id(102)
                .name("user2")
                .verified(false)
                .emailAddress("user2@gmail.com")
                .build();

        List<UserLab> users = Arrays.asList(user1, user2);

        // 모든 유저가 이메일 인증이 되어있다면 true
        boolean allUserVerified = users.stream()
                .allMatch(user -> user.isVerified());
        System.out.println("allUserVerified = " + allUserVerified);


    }
}
