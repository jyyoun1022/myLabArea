package org.jaeyeal.lab.app.lab.java;

import java.util.Arrays;
import java.util.List;

public class StreamReduceLab {
    /**
     *  Optional<T> reduce(BinaryOperator<T> accumulator);
     *  - 주어진 accumulator 를 이용해 STream의 데이터를 합친다.
     *
     *  T reduce(T identity, BinaryOperator<T> accumulator);
     *  - 초기값에 accumulator 연산 방식으로 stream 데이터를 합친다.
     *  - 또한 쵝값이 존재하기에, 항상 반환값이 존재한다.
     *
     *  <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
     *  - 합치는 과정에서 타입이 바뀔 경우 사용
     *  - U 타입의 초기값과 T타입의 스트림 안에 데이터를 합쳐서 U타입의 결과물을 반환
     *  - identity에는 초기값, accumulator에는 identity는 T타입이고 stream는 T타입이므로
     *    둘을 어떻게 합칠지에 대한 함수, combiner에는 stream 값들 끼리에 대한 연산 함수를 명시
     *  - 보통 Map 을 이용해 U 타입의 데이터로 바꾸고 그 후 reduce 하는 것으로 대체할 수 있기에 자주 사용하지 않는다.
     *
     *  - 주어진 함수를 반복 적용해 Stream 안의 데이터를 하나의 값으로 합치는 기능을 제공
     *  - min, max, count 또한 reduce의 일종이다.
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        Integer sum = numbers.stream()
                .reduce((x, y) -> x + y)   // stream의 모든 데이터를 더해서 반환
                .get();

        System.out.println("sum = " + sum);

        Integer min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y)
                .get();
        // stream 데이터 중 가장 작은 데이터를 반환

        System.out.println("min = " + min);

        Integer product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        // 초기값 1을 시작으로 stream 데이터들을 곱하기 연산
        System.out.println("product = " + product);

        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");

        Integer sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);

        System.out.println("sumOfNumberStrList = " + sumOfNumberStrList);

        Integer sumOfNumberStrList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);

        System.out.println("sumOfNumberStrList2 = " + sumOfNumberStrList2);


        UserLab user1 = UserLab.builder()
                .friendUserIds(Arrays.asList(201, 202, 203, 204)).build();

        UserLab user2 = UserLab.builder()
                .friendUserIds(Arrays.asList(204, 205, 206)).build();

        UserLab user3 = UserLab.builder()
                .friendUserIds(Arrays.asList(204, 205, 207)).build();

        List<UserLab> users = Arrays.asList(user1, user2, user3);

        Integer sumOfNumberOfFriends = users.stream()
                .map(i -> i.getFriendUserIds())
                .map(List::size)
                .reduce(0, (x, y) -> x + y);

        System.out.println("sumOfNumberOfFriends = " + sumOfNumberOfFriends);


    }
}
