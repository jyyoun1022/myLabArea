package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLab {
    public static void main(String[] args) {
        // 특정 객체를 요소로 갖는 Stream을 생성하고 싶을 때 Stream.of()를 사용
        Stream<String> stream = Stream.of("code", "chacha", "blog", "example");
        stream.forEach(i -> System.out.println(i));

        // 어떤 요소도 갖고 있지 않는 Stream 객체 생성( 비어있는 스트림)
        Stream<Object> emptyStream = Stream.empty();
        emptyStream.forEach(i -> System.out.println(i));

        // List.stream() 은 List의 요소들을 갖고 있는 Stream을 생성
        List<String> list = Arrays.asList("a1", "b1", "c3", "d4");
        Stream<String> listStream = list.stream();

        listStream.forEach(System.out::println);

        // Arrays.stream() 배열도 Stream으로 변환이 가능하다.
        String[] array = new String[]{"a1", "b2","c3","d5"};
        Stream<String> arrayStream = Arrays.stream(array);
        arrayStream.forEach(System.out::println);

        // Stream.generate()는 인자로 함수를 받고 , 이 함수가 리턴하는 객체들을 요소로 갖는 Stream을 생성
        Stream<String> generateStream = Stream.generate(() -> "Echo").limit(5);
        generateStream.forEach(System.out::println);

        // Math::random을 인자로 전달하면 랜덤 숫자로 이어진 스트림이 생성됩니다.

        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
        randomStream.forEach(System.out::println);


        // 메서드로 만들어서 사용하기
        Stream<String> oh = Stream.generate(() -> add("oh")).limit(5);
        oh.forEach(System.out::println);

        //  Stream.iterate() 두개의 인자를 받고, 첫번째 인자는 초기값, 두번째 인자는 함수
        Stream<Integer> iterStream = Stream.iterate(0, n -> n + 2).limit(5);
        iterStream.forEach(System.out::println);

        Stream.iterate("Oh", i -> add(i)).limit(5).forEach(System.out::println);

    }
    public static String add(String req) {
        return req + "Echo";
    }
}
