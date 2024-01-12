package org.jaeyeal.lab.app.lab.java;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOperationLab {
    // 스트림의 종결 처리는 Stream 안의 데이터를 모아 반환하는 역할을 한다.
    // 중간처리 작업은 바로바로 실행이 되는 것이 아니라 종결 처리의 실행이
    // 필요할 때서야 비로소 중간 처리가 실행(Lazy Evaluation)

    /**
     *  Optional<T> max(Comparator<? super T> comparator);
     *  - max
     *      : Stream 안의 데이터 중 최대값을 반환한다.
     *      : Stream이 비어 있다면 빈 Optional 을 반환한다.
     *  Optional<T> min(Comparator<? super T> comparator);
     *  - min
     *      : Stream 안의 데이터 중 최소값을 반환
     *      : Stream이 비어 있다면 빈 Optional 을 반환
     *  long count();
     *  - count : Stream 안의 데이터 개수를 반환
     */
    public static void main(String[] args) {

        Optional<Integer> max = Stream.of(4, 67, 1, 6, 8, 9)
                .max(Integer::compareTo);

        System.out.println("max = " + max.get());

        StreamTerminalOperationLab.User user1 = new StreamTerminalOperationLab.User();
        user1.setId(101);
        user1.setName("user1");
        user1.setVerified(true);
        user1.setEmailAddress("user1@gmail.com");

        StreamTerminalOperationLab.User user2 = new StreamTerminalOperationLab.User();
        user2.setId(102);
        user2.setName("user2");
        user2.setVerified(false);
        user2.setEmailAddress("user1@gmail.com");;

        StreamTerminalOperationLab.User user3 = new StreamTerminalOperationLab.User();
        user3.setId(103);
        user3.setName("user3");
        user3.setVerified(true);
        user3.setEmailAddress("user3@gmail.com");;


        List<User> users = Arrays.asList(user1, user2, user3);

        User findUser = users.stream()
                .min((u2, u1) -> u1.getName().compareTo(u2.getName()))
                .get();
        // 가장 큰 값
        System.out.println("findUser = " + findUser);

        long positiveIntegerCount = Stream.of(1, -4, -11, 48, 7)
                .filter(i -> i > 0)
                .count();

        System.out.println("positiveIntegerCount = " + positiveIntegerCount);




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
