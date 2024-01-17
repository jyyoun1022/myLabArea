package org.jaeyeal.lab.app.lab.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmLab {
    public static void main(String[] args) {
        /**
         * List To Array
         */
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        //  1 . stream().toArray()
        String[] array = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        //  2. toArray()
        String[] result = list.toArray(new String[0]);
        System.out.println(Arrays.toString(result));


    }
}
