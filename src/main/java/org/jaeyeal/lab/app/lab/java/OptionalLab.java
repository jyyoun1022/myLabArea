package org.jaeyeal.lab.app.lab.java;

import java.util.Optional;

public class OptionalLab {
    public static void main(String[] args) {
        /**
         * Optional<Type> 은 단순히 어떤 객체를 wrapping하는 객체입니다.
         * Optional.of(obj)는 인자로 전달된 객체를 가지고 있는 Optional을 생성해주는 함수
         *
         * 만약, 객체를 가지고 있지 않은 Optional은 of() 메서드로 생성할 수 없습니다.
         * Option.of(null)은 허용되지 않는다.
         * Option.of()는 null이 아닌 객체만 인자로 전달할 수 있다.
         *
         * 1. Optional.ofNullable(null)
         * 2. Optional.empty()
         */

        Optional.of("s"); // ok
//        Optional.of(null)     // ng
        Optional.ofNullable(null); // ok
        Optional.empty();   // ok

        /**
         * Optional 의 객체가 null이 될 수 있기 때문에, Optional에서 리턴되는 값이 null인지 항상 확인하고 사용해야 한다.
         *
         */
        String nullString = null;
        Optional<String> opString = Optional.of("a string in optional");
        Optional<String> nullOpString = Optional.ofNullable(nullString);

        opString.ifPresent(s -> System.out.println("opString: " + s));
        nullOpString.ifPresent(s -> System.out.println("nullOpString: " + s));
        // Optional.ifPresent(consumer)은 Optional이 null을 갖고 있는 경우 아무동작을 하지 않습니다.



    }
}
