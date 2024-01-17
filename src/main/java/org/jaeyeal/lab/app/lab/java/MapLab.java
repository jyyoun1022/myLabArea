package org.jaeyeal.lab.app.lab.java;

import java.util.HashMap;
import java.util.Map;

public class MapLab {
    public static void main(String[] args) {
        /**
         *  getOrDefault
         *  -   map 에서 key ㄱ밧으로 value를 꺼내올 때,
         *  -   만약, map 안에 key값으로 저장된 것이 없다면 default 값으로 정해줄 수 있는 함수
         *
         *  containsKey
         *  -   map 안에 해당 key값이 존재하는지 확인하는 함수
         *
         *  remove
         *  -   map 에서 key 값을 갖는 key-value 쌍을 제거
         *
         *  equals
         *  -   map 에서 equals 를 하면 key 와 value 값이 모두 같은지 비교한다.
         */

        Map<Character, Integer> map = new HashMap<>();
        String str = "helloWorld";
        for(char c : str.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1); // 없으면 default값으로 0을 반환하라
        }

        System.out.println("map = " + map);

        map.put('A', 23);
        boolean containsKeyResult = map.containsKey('A');
        System.out.println("containsKeyResult = " + containsKeyResult);

        System.out.println("map_size= " + map.size());

        map.remove('A');
        System.out.println("map_size= " + map.size());


        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('A', 23);
        Map<Character, Integer> map2 = new HashMap<>();
        map2.put('A', 24);

        System.out.println("map1.equals(map2) = " + map1.equals(map2));
        
    }
}
