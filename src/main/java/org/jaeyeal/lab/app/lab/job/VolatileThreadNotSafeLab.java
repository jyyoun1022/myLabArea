package org.jaeyeal.lab.app.lab.job;

public class VolatileThreadNotSafeLab {
    private static volatile long count = 0;

    public static void main(String[] args) throws InterruptedException {
        int maxCnt = 1000;

        for(int i = 0; i < maxCnt; i++) {
            new Thread(() -> {
                count++;
                System.out.println(count);
            }).start();
        }

        Thread.sleep(100);
    }
}
