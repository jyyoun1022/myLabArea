package org.jaeyeal.lab.app.lab.java;

public class BiFunctionLab {

    // BiFunction은 파라미터를 T,U 타입의 파라미터를 받아서 R 타입으로 반환하는 추상메서드를 제공

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x,y) -> x + y;
        Integer result = add.apply(8, 5);
        System.out.println("result = " + result);
    }
}
