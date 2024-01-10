package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;

public class BiConsumerLab {

    @FunctionalInterface
    public interface BiConsumer<T, U> {
        void accept(T t, U u);
    }
    // BiConsumer 는 2개의 인자를 받아서 처리하고 아무것도 리턴하지 않는 추상 메서드를 갖고 있다.

    public static void main(String[] args) {
        BiConsumer<Integer, Double> myDoubleProcessor = (index, input) -> System.out.println("processing " + input + "at index " + index);
        List<Double> inputs = Arrays.asList(5.5, 3.3, 7.1, 8.8, 1.0);
        process(inputs, myDoubleProcessor);
    }

    public static <T> void process(List<T> inputs, BiConsumer<Integer, T> processor) {
        for (int i = 0; i < inputs.size(); i++) {
            processor.accept(i, inputs.get(i));
        }
    }
}
