package org.jaeyeal.lab.app.lab.java;

import java.util.Optional;

public class OrElseGetVsOrElseLab {

    private static String anyName() {
        System.out.println("reach anyName");
        return "anyName";
    }
    public static void main(String[] args) {

        String name = "snack";

        String elseName = Optional.ofNullable(name).orElse(anyName());
        System.out.println("elseName = " + elseName);

        String elseGetName = Optional.ofNullable(name).orElseGet(OrElseGetVsOrElseLab::anyName);
        System.out.println("elseGetName = " + elseGetName);

        /**
         * Optional의 orElse 는 if value != null ?: value : other
         * 이기 때문에 other이 메서드인 경우 만약 null 일경우 무조건 타게 되므로, 필요에 의해해서 잘써야함
         *
         *  ex) public T orElse([METHOD]) {
         *     return value != null ? value : other;
         * }
         *
         * 메서드가들어가기 때문에 동작이 되어버린다.
         *
         * orElseGet()은 supplier 의 () -> other.get() 을 타기 때문에
         * null일 경우에만 작동된다.
         */

    }
}
