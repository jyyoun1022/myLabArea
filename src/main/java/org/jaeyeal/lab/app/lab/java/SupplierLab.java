package org.jaeyeal.lab.app.lab.java;

public class SupplierLab {

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }
    // Supplier 는 공급하는 인터페이스로 input 없이 리턴값만 갖는 추상 메서드를 갖고 있다.
    public static void main(String[] args) {
        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        printRandomDoubles(myRandomDoubleSupplier, 5);
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
