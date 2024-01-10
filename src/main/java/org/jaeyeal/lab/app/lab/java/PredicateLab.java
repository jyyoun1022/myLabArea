package org.jaeyeal.lab.app.lab.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateLab {

    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }

    // Predicate 인터페이스는 하나의 인자를 받아서 처리하고 boolean을 반환하는 추상 메서드를 하나 갖고 있습니다.

    public static void main(String[] args) {
        java.util.function.Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(-1));

        List<Integer> inputs = Arrays.asList(10, -5, 4, -2, 0, 3);
        System.out.println("Positive number: " + filter(inputs, isPositive));
        System.out.println("Non-positive number: " + filter(inputs, isPositive.negate()));
        System.out.println("Non-negative number: "
                + filter(inputs, isPositive.or(x -> x == 0)));
        System.out.println("Positive even numbers: "
                + filter(inputs, isPositive.and(x -> x % 2 == 0)));
    }
    // Predicate<T> or
//    or API는 인자로 다른 Predicate을 받아서 둘 중에 하나라도 만족하면 true를 반환하는 새로운 Predicate을 반환해줍니다.

    public static <T> List<T> filter(List<T> inputs, java.util.function.Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T input : inputs) {
            if (condition.test(input)) {
                output.add(input);
            }
        }
        return output;
    }
}
