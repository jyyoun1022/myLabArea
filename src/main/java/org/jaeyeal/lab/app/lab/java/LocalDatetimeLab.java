package org.jaeyeal.lab.app.lab.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDatetimeLab {
    public static void main(String[] args) {
        LocalDateTime syncDate = LocalDateTime.now();
        System.out.println("syncDate = " + syncDate);
        String registerDatetime = "2024-01-04 16:18:10";
        String registerDatetime2 = "2024-01-04T16:18:10";
        // 단순히 LocalDateTime.parse(String) 을 하려면 registerDatetime2 처럼 T 형식이 들어가야 한다.
        LocalDateTime parse1 = LocalDateTime.parse(registerDatetime2);
        System.out.println("parse1 = " + parse1);

        LocalDateTime parse2 = LocalDateTime.parse(registerDatetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("parse2 = " + parse2);
        String parse3 = parse2.format(DateTimeFormatter.ofPattern("yyyyMM"));
        System.out.println("parse3 = " + parse3);

    }
}
