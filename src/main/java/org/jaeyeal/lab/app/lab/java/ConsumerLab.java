package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLab {

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }
    // Consumer 인터페이스는 값을 받아서 처리하고 아무것도 리턴하지 않는 추상메서드를 갖고 있다.

    public static void main(String[] args) {
        List<Integer> integerInputs = Arrays.asList(4, 2, 3);
        Consumer<Integer> myIntegerProcessor = x -> System.out.println("processing Integer " + x);

        process(integerInputs, myIntegerProcessor);
    }
    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }
}
