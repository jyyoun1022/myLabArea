package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamParallelLab {
    /**
     *  List<Integer> numbers = Arrays.asList(1,2,3);
     *  Stream<Integer> parallelStream = numbers.parallelStream(); // 바로 병렬 스트림 만들기
     *  Stream<Integer> parallelStream2 = numbers.stream().parallel(); // 스트림 만들고 병렬로 바꾸기
     *  - 여러 개의 스레드를 이용해서 Stream 처리 과정을 병렬화 합니다.
     *  - 중간 과정은 병렬 처리 되지만 순서가 있는 stream의 경우 종결처리 했을 때의 결과물이 기존으 ㅣ순차적 처리와 일치하도록
     *    종결 처리과정에서 조저된다.
     *  - 예를들어, List로 Collect 한다면 중간 처리 과정은 여러 스레드 동작하여 순서가 바뀔 수 있지만 종결 처리과정에서 순서가 조정된다.
     *
     *  - 장점 :
     *      - 굉장히 간단하게 병럴처리를 사용할 수 있게 ㅎ재ㅜㄴ다.
     *      - 속도가 비약적으로 빨라진다.
     *  - 단점 :
     *      - 공통으로 사용하는 리소스가 있을 경우 잘못된 결과가나오거나 오류가 날 수 있다(deadlock)
     *      - 이를 막기위해 mutex, semaphore 등 병렬처리 기술을 이용하면 순차 처리보다 느려질 수있다.
     */

    public static void main(String[] args) {
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

        UserLab user3 = UserLab.builder()
                .id(103)
                .name("user3")
                .verified(false)
                .emailAddress("user3@gmail.com")
                .build();

        UserLab user4 = UserLab.builder()
                .id(104)
                .name("user4")
                .verified(true)
                .emailAddress("user4@gmail.com")
                .build();

        List<UserLab> users = Arrays.asList(user1, user2, user3, user4);
        // 이메일 인증 안된 유저에게 이메일 보내는 과정을 병렬처리
        users.parallelStream()
                .filter(user -> !user.isVerified())
                .forEach(i -> System.out.println(i));

        // user을 map 으로 가공하는 작업을 병렬 처리
        // 하지만 최종 결과물은 순서가 보장된다.
        List<UserLab> processedUsers = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user " + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());

        System.out.println("\"=\" = " + "=");
        processedUsers.forEach(i -> System.out.println(i));


    }
}
