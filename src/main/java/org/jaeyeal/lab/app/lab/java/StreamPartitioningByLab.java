package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPartitioningByLab {

    /**
     *  public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate)
     *
     *  public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate,
     *                                                     Collector<? super T, A, D> downstream)
     *  - GroupingBy 와 유사하지만 Function 대신 Predicate를 받아 true 와 false 두 Key  가 존재하는 map을 반환하는 collector
     *  - downstream collecotr를 넘겨 List 이외의 다른 형태로 map 의 value를 만들 수 있다.
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
        // 짝수는 true 키로 저장, 홀수는 false 를 키로 저장
        Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        System.out.println("numberPartitions = " + numberPartitions);
        System.out.println("numberPartitions.get(true) = " + numberPartitions.get(true));
        System.out.println("numberPartitions.get(false) = " + numberPartitions.get(false));

        UserLab user1 = UserLab.builder()
                .id(101)
                .name("user1")
                .emailAddress("user1@gmail.com")
                .friendUserIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214))
                .build();
        UserLab user2 = UserLab.builder()
                .id(102)
                .name("user2")
                .emailAddress("user2@gmail.com")
                .friendUserIds(Arrays.asList(204, 205, 206))
                .build();

        List<UserLab> users = Arrays.asList(user1, user2);

        Map<Boolean, List<UserLab>> userPartitions = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getFriendUserIds().size() > 5));

        System.out.println("userPartitions.get(true) = " + userPartitions.get(true));
        System.out.println("userPartitions.get(false) = " + userPartitions.get(false));


    }
}
