package org.jaeyeal.lab.app.lab.job;

import org.apache.commons.lang3.StringUtils;

import java.net.*;

public class DefaultLab {

    public static void main(String[] args) {
        try {
            InetAddress naverIp = InetAddress.getByName("www.naver.com");
            System.out.println("naverIp.getHostName() = " + naverIp.getHostName());
            System.out.println("naverIp.getHostAddress() = " + naverIp.getHostAddress());
            System.out.println("naverIp.getAddress() = " + naverIp.getAddress());
            System.out.println("naverIp.getCanonicalHostName() = " + naverIp.getCanonicalHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        /**
         * URL 클래스 (Uniform Resource Locator)
         * 인터넷에서 접근 가능한 자원(Resource)의 주소를 표현할 수 있는 형식
         * URL 을 안다 => 특정 리소스에 접근해서 가져올 수 있다.
         * URL을 추상화하여 만든 클래스
         *
         * URI(Uniform Resource Identifier)
         * 특정 자원에 접근하기 위한 형식이나 고유한 이름
         * URL보다 넒은 의미의 개념
         */

        boolean equals = StringUtils.equals(null, null);
        System.out.println(equals);
    }
}
