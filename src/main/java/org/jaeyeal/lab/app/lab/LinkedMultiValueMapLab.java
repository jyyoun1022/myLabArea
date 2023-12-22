package org.jaeyeal.lab.app.lab;


import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LinkedMultiValueMapLab {
    public static void main(String[] args) {

        Map<String, Integer> basicMap = new HashMap<>();
        basicMap.put("test", 1);
        basicMap.put("test", 2);

        MultiValueMap<String, Integer> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("Test", 1);
        multiValueMap.add("Test", 2);
//        multiValueMap.put("Test", Arrays.asList(2,3,4,5));


        System.out.println("basicMap = " + basicMap);
        System.out.println("multiValueMap = " + multiValueMap);
        // result
        /**
         * basicMap = {test=2}
         * multiValueMap = {Test=[1, 2]}
         */

        /**
         * MultiValueMap이 Map 인터페이스를 상속할 때 Value 값을 List로 감싼채 상속받는다.
         * , 하나의 Key 와 하나 이상의 value 로 이루어진 리스트를 쌍으로 받겠다는 뜻
         * 일반적인 Map은 Key가 중복될 수 없지만, MultiValueMap 은 중복되면 List로 들어간다.
         * +
         * MultiValueMap 의 put 은 value 값에 List 를 요구하므로 만들어진 List를 인자로 한번에 줄 수 있다.
         */


    }
}
