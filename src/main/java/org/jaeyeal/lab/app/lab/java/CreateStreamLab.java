package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStreamLab {
    /**
     * 데이터의 흐름을 만들어 주는 것입니다.
     * 컬렉션 형태로 구성된 데이터를 람다를 이용해 간결하고 직관적으로 프로세스 할 수 있게 한다.
     * For, While 등을 기존 loop를 대체한다.
     * 손쉽게 병렬 처리를 할 수 있게 해준다.
     * 일회성으로 한 번 사용하면 재사용 불가
     */
    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> names = nameStream.collect(Collectors.toList());
        System.out.println(names);

        String[] cityArray = new String[] {"San Jose", "Seoul", "Tokyo" };
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cities = cityStream.collect(Collectors.toList());
        System.out.println(cities);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3, 5, 7));
        List<Integer> numbers = numberSet.stream().collect(Collectors.toList());
        System.out.println(numbers);

    }


}
