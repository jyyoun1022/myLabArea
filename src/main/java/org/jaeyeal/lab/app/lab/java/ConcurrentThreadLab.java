package org.jaeyeal.lab.app.lab.java;

import java.util.concurrent.TimeUnit;

public class ConcurrentThreadLab {
    private static  boolean stopRequested;
    public static void main(String[] args) throws InterruptedException {
        Thread background = new Thread(() -> {
            for (int i = 0; !stopRequested; i++) {
            }
            System.out.println("background 쓰레드가 종료");
        });

        background.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        System.out.println("main 쓰레드가 종료");

        /**
         * 이 때 백그라운드 스레드는 종료되지 않고 계속 살아 있음
         *
         * 1. background Thread는 Main Thread 와는 다른 CPU의 캐시 메모리에 존재하는 stopRequested 공유자원을 복제한다.
         * 2. 이후 복제한 stopRequested를 사용해서 조건식을 반복해서 실행
         * 3. 1초 이후 Main Thread를 stopRequested를 true로 바꾼다.
         *
         * 하지만 background Thread에서는 Main Thread와는 다른 CPU Cache Memory에 잇는 stopRequested를 참조하기 때문에
         * Main쓰레드에 다른 CPU cacheMeomory에 있는 stopRequested를 참조하기 때문에 일어난 변경을 알아채지 못합니다.
         */


    }

}
