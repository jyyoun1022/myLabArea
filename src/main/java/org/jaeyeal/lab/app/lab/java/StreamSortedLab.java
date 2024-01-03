package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamSortedLab {
    public static void main(String[] args) {
        //  Stream.sorted()는 스트림의 요소들이 어떤 기준으로 정렬되어 전달되는 새로운 스트림 객체를 리턴합니다.
        //  요소들을 어떻게 정렬하는지에 대한 내용은 Comparable || Comparator 에 구현되어야 한다.

        // String은 기본적으로 Comparable이 구현되어 있다.

        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "smalltalk");
        langs.stream().sorted().forEach(System.out::println);
        // 알파벤 순서대로 정렬되었는데, 만약 역순으로 정렬을 하고 싶다면
        langs.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // 이 때, Stream의 요소가 Comparable 인터페이스를 구현하지 않았다면
        // Stream.sorted(Comparator) 처럼 Comparator를 구현하여 인자로 전달하면 된다.

        langs.stream().sorted(Comparator.comparing(s -> s.length())).forEach(System.out::println);
        // 역순으로 하고싶다면
        langs.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

    }
}
