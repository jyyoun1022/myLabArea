package org.jaeyeal.lab.app.lab.java;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamFindLab {
    /**
     *  Optional<T> findFirst();
     *  -  stream 안의 첫번쨰 데이터를 반환한다.
     *  - Stream이 비어있다면 빈 Optional을 반환한다.
     *
     *  Optional<T> findAny();
     *  - Stream 안의 아무 데이터나 리턴한다.(매번 달리지기 떄문에 순서가 필요 없을 때 사용)
     *  - Parallel Stream을 사용할 때, 최적화를 할 수 있다.
     *  - Stream이 비어있다면 빈 Optional 을 반환한다.
     */

    public static void main(String[] args) {
        Optional<Integer> anyNegativeInteger = Stream.of(3, 2, -5, 6)
                .filter(x -> x < 0)
                .findAny();

        System.out.println("anyNegativeInteger = " + anyNegativeInteger);

        Optional<Integer> firstPositiveInteger = Stream.of(-3, -2, -5, 6)
                .filter(x -> x > 0)
                .findFirst();

        System.out.println("firstPositiveInteger = " + firstPositiveInteger);
    }
}
