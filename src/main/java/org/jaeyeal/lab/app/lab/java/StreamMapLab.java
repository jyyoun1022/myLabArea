package org.jaeyeal.lab.app.lab.java;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapLab {
    //  Stream 의 map API는 stream 흐름에 있는 데이터를 변형해서 변형된 결과물을 stream 으로 반환해주는 기능을 제공합니다.

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -4);
        List<Integer> numberListX2 = numberList.stream()
                .map(x -> x * 2) // stream 데이터들을 2배하여 stream으로 반환
                .collect(Collectors.toList()); // stream 데이터를 리스트로 반환
        System.out.println(numberListX2);


        User user1 = new User();
        user1.setId(101);
        user1.setName("user1");
        user1.setVerified(true);
        user1.setEmailAddress("user1@gmail.com");

        User user2 = new User();
        user2.setId(102);
        user2.setName("user2");
        user2.setVerified(false);
        user2.setEmailAddress("user1@gmail.com");;

        User user3 = new User();
        user3.setId(103);
        user3.setName("user3");
        user3.setVerified(true);
        user3.setEmailAddress("user3@gmail.com");;


        List<User> users = Arrays.asList(user1, user2, user3);
        List<String> emailAddresses = users.stream()
                .map(User::getEmailAddress)
                .collect(Collectors.toList());

        System.out.println("emailAddresses = " + emailAddresses);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class User {
        private int id;
        private String name;
        private boolean verified;
        private String emailAddress;

    }
}
