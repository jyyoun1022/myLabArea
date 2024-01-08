package org.jaeyeal.lab.app.lab.java;

public class SharedResource {
    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    sharedResource.increment();
                    System.out.println(sharedResource.getCount());
                }
            }).start();
        }

        // 모든 스레드가 종료될 때까지 기다린 후 getCount 호출
        try {
            Thread.sleep(2000); // 예시로 적절한 대기 시간 설정
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + sharedResource.getCount());
    }
}


