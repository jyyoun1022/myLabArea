package org.jaeyeal.lab.app.lab.java;

public class BiFunctionLab {

    // BiFunction은 파라미터를 T,U 타입의 파라미터를 받아서 R 타입으로 반환하는 추상메서드를 제공

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
   }

   @FunctionalInterface
   public interface TriFunction<T, U, V, R> {
        R apply(T t, U u ,V v);
   }
   // 인자를 3개 받는 함수형 인터페이스 Custom

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x,y) -> x + y;
        Integer result = add.apply(8, 5);
        System.out.println("result = " + result);
    }
    /**
     * @FunctionalInterface
     * 는 단 하나의 abstract method(추상메서드)만을 갖는 인터페이스
     */
}
