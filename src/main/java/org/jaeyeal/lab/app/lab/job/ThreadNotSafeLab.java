package org.jaeyeal.lab.app.lab.job;

public class ThreadNotSafeLab {
    private static long count = 0;

    /**
     * synchronized 키워드를 사용하면 해당 블럭의 액세스를 동기화 시킬 수 있다.
     * synchronized가 선언된 블럭에는 동시에 하나의 스레드만 접근할 수 있다.
     *
     * 특정 스레드는 syncronized 메서드에 접근시 블록 전체에 lock을 건다.
     * 따라서 해당 스레드가 블럭을 빠져나가기 전까지 다른 스레드들은 동기화 처리된 블록에 접근할 수 없다.
     * 하지만 다른 스레드들은 아무런 작업을 하지못하고 기다릴 수 밖에 없어 자원의 낭비가 발생할 수 있다.
     */
    public static synchronized long plus() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {

        }
        return ++count;
    }
    public static void main(String[] args) throws InterruptedException {
        int maxCount = 1000;

        for (int i =0; i < maxCount; i++) {
            new Thread(() -> {
                System.out.println(plus());
            }).start();
        }

        Thread.sleep(100);
        /**
         * 다수의 스레드들은 공유자원 static long count 을 참조하여 값을 증가시킨다.
         * 하지만 값을 증가시키는 count++연산이 원자성을 보장하지 않는다.
         */


    }
}
