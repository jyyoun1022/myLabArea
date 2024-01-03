package org.jaeyeal.lab.app.lab.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLimitLab {
    /**
     *  limit() 은 Stream 에서 일정 개수만큼만 데이터를 가져와서 새로운 스트림을 생성
     *  skip() 은 인자로 전달된 숫자만큼 요소를 건너띄고, 그 이후의 요소들만 스트림을 생성,
     *          => Stream의 초기 데이터를 무시할 때 사용할 수 있다.
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.limit(5);

        stream2.forEach(System.out::println);

        Stream<String> stream3 = list.stream();
        Stream<String> stream4 = stream3.skip(5);
        stream4.forEach(System.out::println);
    }
}
