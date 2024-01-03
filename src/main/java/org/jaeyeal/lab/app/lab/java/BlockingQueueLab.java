package org.jaeyeal.lab.app.lab.java;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.*;

public class BlockingQueueLab {
    public static void main(String[] args) {
        // Future 에 대한 코드는 비효율적인 부분이 있다.
        // 첫번쨰 작업이 늦게 처리된다면, 다른 작업에 대한 로그도 늦게 출력이 된다.

        //  작업이 끝날 때 BlockingQUeue 에결과를 추가하고, 메인쓰레드에서 Queue를 기다리면된다.
        //  BlockingQueue 객체는 동시성을 보장하도록 구현되어있습니다.

        ParallelExcutorService service = new ParallelExcutorService();
        service.submit("job1");
        service.submit("job2");
        service.submit("job3");
        service.submit("job4");

        for (int i = 0 ; i < 4; i++) {
            String result = service.take();
            System.out.println(result);
        }

        System.out.println("end");
        service.close();
    }

    private static class ParallelExcutorService {
        private final int maxCore = Runtime.getRuntime().availableProcessors();
        private final ExecutorService executor = Executors.newFixedThreadPool(maxCore);
        private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        public ParallelExcutorService() {
        }

        public void submit(String job) {
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("finished " + job);
                String result = job + ", " + threadName;
                try {
                    queue.put(result);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        public String take() {
            try {
                return queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }

        public void close() {
            List<Runnable> unfinishedTasks = executor.shutdownNow();
            if (!unfinishedTasks.isEmpty()) {
                System.out.println("Not all tasks finished before calling close: " + unfinishedTasks.size());
            }
        }
    }
}
