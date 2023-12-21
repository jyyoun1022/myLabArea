package org.jaeyeal.lab.app.lab;

import lombok.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConstructorLab {

    private String name = "22"; // 슈크림
    private int age = 3; // 팥
    private boolean home = false; // 콜라


    public static void main(String[] args) {
        // 클래스를 내가 수정하고 넣고 작업을 하고 싶으면 객체로 만들어야된다.
        // 클래스를 인스턴스화 시켜야해요.
        ConstructorLab instance1 = new ConstructorLab();
        System.out.println("instance1 = " + instance1);


        ConstructorLab instance2 = new ConstructorLab("나는 슈크림", 1,true);
        System.out.println("instance2 = " + instance2);


        ConstructorLab dd = ConstructorLab.builder()
                .name("dd")
                .age(1)
                .home(false)
                .build();
        System.out.println(dd);


    }
}

