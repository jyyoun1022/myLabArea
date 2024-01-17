package org.jaeyeal.lab.app.lab.java;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetLab {
    /**
     * Set은 집합 자료구조, TreeSet은 정렬된 집합 자료 구조
     */
    public static void main(String[] args) {

        Set<Integer> tSet = new TreeSet<>();
        tSet.add(1);
        tSet.add(2);
        tSet.add(4);
        tSet.add(3);
        tSet.forEach(i -> System.out.println(i));
    }
}
