package org.jaeyeal.lab.app.lab.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // SingleThreadExecutor 는 Thread 가 1개인 Executor 이다.
        // 1개 이기 때문에 작업을 예약한 순서대로 처리를 한다.
        // 동시성(Concurrency)를 고려할 필요가 없다.
        Future<?> submit1 = executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job1 " + threadName);
        });

        Future<?> submit2 = executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job2 " + threadName);
        });

        Future<?> submit3 = executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job3 " + threadName);
        });

        Future<?> submit4 = executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job4 " + threadName);
        });


        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("end");
    }
}
