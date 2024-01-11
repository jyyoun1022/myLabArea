package org.jaeyeal.lab.app.lab.java;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapLab {
    public static void main(String[] args) {
        Order order1 = Order.builder()
                .id(100)
                .orderLines(Arrays.asList(
                        OrderLine.builder()
                                .id(1001)
                                .type("dd")
                                .amount(4000)
                                .build(),
                        OrderLine.builder()
                                .id(1002)
                                .type("ss")
                                .amount(4000)
                                .build()
                )).build();

        Order order2 = Order.builder()
                .id(101)
                .orderLines(Arrays.asList(
                        OrderLine.builder()
                                .id(1003)
                                .type("ddd")
                                .amount(5000)
                                .build(),
                        OrderLine.builder()
                                .id(1004)
                                .type("sss")
                                .amount(5000)
                                .build()
                )).build();

        List<Order> orders = Arrays.asList(order1, order2);

        List<OrderLine> result = orders.stream()
                .map(i -> i.getOrderLines())// OrderLine만 뽑아서 스트림 반환 // Stream<List<OrderLine>>
                .flatMap(orderLines -> orderLines.stream()) //  List<OrderLine>을 Stream으로 변경하고 flat을 통해 하나의 Stream으로 반환 // Stream<OrderLine>
                .collect(Collectors.toList());

        System.out.println("result = " + result);

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class Order {
        private int id;
        @Builder.Default
        private List<OrderLine> orderLines = new ArrayList<>();
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class OrderLine {
        private int id;
        private String type;
        private int amount;
    }
}
