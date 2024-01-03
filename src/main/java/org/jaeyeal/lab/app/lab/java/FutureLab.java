package org.jaeyeal.lab.app.lab.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class FutureLab {
    public static void main(String[] args) {
        //  executor.submit() 은 Future 객체를 리턴한다.
        //  Future를 따로 저장을 해 두면 메인쓰레드에서 쓰레드풀에서 처리한 결과를 알 수있다.


        // List 에 futre를 job1 에서 job4까지의 작업을 순서대로 추가했기 때문에
        final int availableCore = Runtime.getRuntime().availableProcessors();// 현재 사용가능한 core 개수를 리턴
        System.out.println("Runtime.getRuntime().totalMemory() = " + Runtime.getRuntime().totalMemory());
        System.out.println("Runtime.getRuntime().freeMemory() = " + Runtime.getRuntime().freeMemory());
        System.out.println("availableCore = " + availableCore);

        final ExecutorService executor = Executors.newFixedThreadPool(availableCore);
        final List<Future<String>> futures = new ArrayList<>();

        IntStream.range(1, 5)
                .forEach(i -> {
                    futures.add(executor.submit(() -> {
                        System.out.println("finished job" + i);
                        return "job" + i + " " + Thread.currentThread().getName();
                    }));
                });

        for (Future<String> future : futures) {
            String result = null;
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }

        executor.shutdownNow();
        System.out.println("end");



    }
}
