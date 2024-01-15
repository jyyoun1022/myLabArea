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



    }
}
