package org.jaeyeal.lab.app.lab.java;

public class IntegerLab {
    public static void main(String[] args) {
        Integer num1 = 128;
        System.out.println(num1 == Integer.valueOf(128));

        Integer num2 = 127;
        System.out.println(num2 == Integer.valueOf(127));

        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));

        System.out.println("==");

        System.out.println(Integer.valueOf(128) == Integer.valueOf(128));

        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));
    }
}
