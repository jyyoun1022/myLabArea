package org.jaeyeal.lab.app.lab.java;

public class StringBufferLab {
    /**
     * StringBuffer는 동기화가 되어있다.
     * 따라서 여러 쓰레드가 동시에 StringBuffer 객체에 접근하더라도 안전하게 사용할 수 있다.
     * 동기화로 인해 여러 쓰레드가 StringBuffer의 메서드를 호출할 때,
     * 하나의 쓰레드만이 접근가능하며, 다른 쓰레드들은 대기
     *
     * * 멀티 쓰레드 환경에서 안전한 문자열 연산이 필요한 경우 StringBuffer를 사용할 수 있다.
     */

    public static void stringBufferFunc() throws InterruptedException {
        StringBuffer synchronizedBuffer = new StringBuffer();

        Runnable synchronizedRunnable = () -> {
            synchronized (synchronizedBuffer) {
                for (int i = 0; i < 1000; i++) {
                    synchronizedBuffer.append("A");
                }
            }
        };

        Thread thread1 = new Thread(synchronizedRunnable);
        Thread thread2 = new Thread(synchronizedRunnable);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Synchronized Result: " + synchronizedBuffer.length()); // 예상 결과: 2000
    }
    /**
     *  StringBuilder는 비동기화 되어있다.
     *  따라서 여러 스레드가 동시에 StringBuilder 객체에 접근하면 데이터 무결성이 보장되지 않습니다.
     *  StringBuilder는 StringBuffer보다 빠르게 동작하며, 단일 스레드 환경에서 문자열을 조작할 때 주로 사용된다.
     */

    public static void stringBuilderFunc() throws InterruptedException {
        StringBuilder nonSynchronizedBuilder = new StringBuilder();

        Runnable nonSynchronizedRunnable = () -> {
            for (int i = 0; i < 1000; i++) {
                nonSynchronizedBuilder.append("B");
            }
        };

        Thread thread3 = new Thread(nonSynchronizedRunnable);
        Thread thread4 = new Thread(nonSynchronizedRunnable);

        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();

        System.out.println("Non-Synchronized Result: " + nonSynchronizedBuilder.length()); // 예상 결과: 다양함
    }
    public static void main(String[] args) throws InterruptedException {
        stringBufferFunc();
        stringBuilderFunc();
    }
}
