package org.jaeyeal.lab.app.lab.java;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * java.util.concurrent.Executors 와 java.util.concurrent.ExecutorService를
 * 이용하면 간단히 쓰레드풀을 생성하여 병렬처리를 할 수 있다.
 */
public class ExecutorServiceLab {
    //Executors 는 ExecutorService 객체를 생성하며, 다음 메서드를 제공하여 쓰레드 풀을 개수 및 종류를 정할 수 있다.
    //  - newFixedThreadPool(int) : 인자 개수만큼 고정된 쓰레드풀을 만듭니다.
    //  - newCachedThreadPool() : 필요할 때, 필요한 만큼 쓰레드풀을 생성, 이미 생성된 쓰레드를 재활용하기에 성능상 이점
    //  - newScheduledThreadPool(int) : 일정 시간 뒤에 실행되는 작업이나, 주기적으로 수행되는 작업이 있다면 사용을 고려한다.
    //  - newSingleThreadExecutor() : 쓰레드 1개인 ExecutorService를 리턴한다.싱글 쓰레드에서 동작해야 하는 작업을 처리할 때 사용

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // Thread를 4개 생성하겠다는 의미
        // submit(() -> { } )은 멀티쓰레드로 처리할 작업을 예약
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("job1 " + threadName);
        });
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job2 " + threadName);
        });
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job3 " + threadName);

        });
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job4 " + threadName);
        });

        // 더이상 ExecutorService에 Task를 추가할 수 없도록 한다.
        // 그리고 처리중인 작업이 모두 완료되면 쓰레드풀을 종료시킨다.
        executor.shutdown();

        // shutdown() 호출 전에 등록된 Task 중에 아직 완료되지 않은 Task가 있을 수 있다.
        // timeout을 20초 설정하고 완료되기를 기다린다.
        // 20초 전에 완료되면 true를 리턴하며, 20초가 지나도 완료되지 않는다면 false를 리턴
        if (executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println(LocalDateTime.now() + " All jobs are terminated");
        } else {
            System.out.println(LocalDateTime.now() + " some jobs are not terminated");
            executor.shutdownNow();
        }
        System.out.println("end");
    }


}
