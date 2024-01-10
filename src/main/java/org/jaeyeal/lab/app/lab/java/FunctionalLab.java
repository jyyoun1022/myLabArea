package org.jaeyeal.lab.app.lab.java;

import java.util.function.Function;

public class FunctionalLab {

    // Function
    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }
    /**
     * Function 인터페이스는 apply 메서드 하나를 추상 메서드로 제공한다.
     */
    // 1. 구현 클래스 사용
    static class Adder implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer x) {
            return x * 2;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> myAdder = new Adder();

        int result = myAdder.apply(5);
        System.out.println("result = " + result);

        Function<Integer, Integer> myAdder2 = x -> x + 15;
        Integer result2 = myAdder2.apply(5);
        System.out.println("result2 = " + result2);
    }
}
