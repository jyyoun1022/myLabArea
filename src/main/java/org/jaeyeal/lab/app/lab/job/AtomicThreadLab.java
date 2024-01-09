package org.jaeyeal.lab.app.lab.job;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicThreadLab {
    private static long startTime = System.currentTimeMillis();
    private static int maxCnt = 1000;
    private static long count = 0;
    private static AtomicLong count2 = new AtomicLong();
    public  void threadNotSafe1() throws Exception{
        for (int i = 0; i <maxCnt; i++) {
            new Thread(this::plus).start();
        }
    }
    private  synchronized void plus() {
        if (++count == maxCnt) {
            System.out.println(System.currentTimeMillis() - startTime);
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void threadNotSafe2() throws Exception {
        for (int i =0; i < maxCnt; i++) {
            new Thread(this::plus2).start();
        }
        Thread.sleep(2000);
    }
    private void plus2() {
        if (count2.incrementAndGet() == maxCnt) {
            System.out.println(System.currentTimeMillis() - startTime);
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        AtomicThreadLab atomicThreadLab = new AtomicThreadLab();
//        atomicThreadLab.threadNotSafe1(); // 2468
        atomicThreadLab.threadNotSafe2(); // 43


    }
}
