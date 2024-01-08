package org.jaeyeal.lab.app.lab.java;

import com.sun.tools.javac.Main;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentAccessLab {
    private static int t;
    public static synchronized int view() {
        return t++;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    System.out.println(view());
                }

            }).start();
        }
    }
    /**
     * 코드를 보면 1부터 100000까지 출력할 것  같지만 실제로는 그렇지 않다.
     * 여러 개의 스레드가 공유자원에 접근하면서 값을 바꿔버리기에 순서가 보장되지 않는다.
     *
     * 자바의 동시성 해결책
     * synchronized : 안전하게 동시성을 보장할 수 있다. 하지만 비용이 가장 크다.
     * volatile : volatile 키워드가 붙은 자원은 read, write 작업이 CPU cache Memory가 아닌 main Memory에서 이루어진다.
     * 즉, 자원을 저장하는 메모리는 하나가 되기 때문에 같은 공유자원에 대해 각각 메모리별로 다른 값을 가지는 경우가 없다.
     * 하지만 여러 쓰레드에서 수정하게 되면, 계산값이 덮어씌워지게 되므로, 동시 접근 문제를 해결할 수는 없다.
     * 정리하자면 , 가시성 문제는 해결할 수 있지만, 동시 접근 문제는 해결할 수 없다.
     *
     */
}
