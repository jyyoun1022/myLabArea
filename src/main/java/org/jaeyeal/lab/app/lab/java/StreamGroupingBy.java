package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamGroupingBy {
    /**
     *  public static <T, K> Collector<T, ?, Map<K, List<T>>>
     *     groupingBy(Function<? super T, ? extends K> classifier)
     *  - Stream 안의 데이터에 classifier를 적용했을 때, 결과 값이 같은 값끼리 List 로 모아서
     *      Map 의 형태로 반환해주는 Collector 입니다.
     *  - 이때 키는 classifier의 결과값, value 는 그 결과값을 갖는 데이터들
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);

        Map<Integer, List<Integer>> unitDigitMap = numbers.stream()
                // 10 으로 나눈 나머지가 같은 것끼리 List로 만들고, 키는 나머지값, value 는 나머지 값이 일치하는 데이터로 만든 리스트
                .collect(Collectors.groupingBy(number -> number % 10));

        System.out.println("unitDigitMap = " + unitDigitMap);

        Map<Integer, Set<Integer>> unitDigitSet = numbers.stream()
                // value 값을 리스트가 아닌 Set 컬렉션으로 만들기
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));

        System.out.println("unitDigitSet = " + unitDigitSet);

        Map<Integer, List<String>> unitDigitStrMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.mapping(number -> "unit digit is " + number, Collectors.toList())));

        System.out.println("unitDigitStrMap = " + unitDigitStrMap);


    }
}
