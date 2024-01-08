package org.jaeyeal.lab.app.lab.java;

public class RuntimeLab {
    public static void main(String[] args) {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("core = " + core);

    }
}
