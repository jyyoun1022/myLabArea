package org.jaeyeal.lab.app.lab.java;

public class StreamTerminalOperationLab {
    // 스트림의 종결 처리는 Stream 안의 데이터를 모아 반환하는 역할을 한다.
    // 중간처리 작업은 바로바로 실행이 되는 것이 아니라 종결 처리의 실행이
    // 필요할 때서야 비로소 중간 처리가 실행(Lazy Evaluation)

    /**
     *  Optional<T> max(Comparator<? super T> comparator);
     *  - max
     *      : Stream 안의 데이터 중 최대값을 반환한다.
     *      : Stream이 비어 있다면 빈 Optional 을 반환한다.
     *  Optional<T> min(Comparator<? super T> comparator);
     *  - min
     *      : Stream 안의 데이터 중 최소값을 반환
     *      : Stream이 비어 있다면 빈 Optional 을 반환
     *  long count();
     *  - count : Stream 안의 데이터 개수를 반환
     */
    public static void main(String[] args) {


    }
}
