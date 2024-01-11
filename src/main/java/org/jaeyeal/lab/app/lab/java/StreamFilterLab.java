package org.jaeyeal.lab.app.lab.java;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterLab {
    //  Stream 의 Filter API는 Predicate 에서 true를 반환하는 데이터만 존재하는 Stream을 리턴한다.
    public static void main(String[] args) {
        List<Integer> newFilteredNumbers = Stream.of(3, -5, 7, 10, -3)
                .filter(x -> x % 2 == 0) // 양수만 뽑아서 스트림 반환
                .collect(Collectors.toList()); // 스트림을 리스트로 변환
        System.out.println(newFilteredNumbers);
    }
}
