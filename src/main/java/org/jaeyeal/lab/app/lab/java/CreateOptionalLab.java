package org.jaeyeal.lab.app.lab.java;

import java.util.Optional;

public class CreateOptionalLab {
    /** Optional<T> 생성법
     *
     * public static <T> Optional<T> of(T value)
     *  - Null 이 아닌 오브젝트를 이용하여 Optional 을 만들 때 사용
     *  - 만약 Null을 넘기게 되면 에러가 발생
     *
     * public static<T> Optional<T> empty()
     *  - 빈 Optional 상자를 만들 때 사용한다.
     *
     * public static <T> Optional<T> ofNullable(T value)
     *  - Null 을 허용하는 빈상자라는 의미로, 객체가 Null인지 아닌지 알지 못하는 오브젝트
     */

    /** Optional 확인 & 꺼내는법
     *
     * public boolean isPresent()
     *  - 안의 오브젝트가 NULL 인지 아닌지 체크하여 해당 여부를 BOOLEAN으로 반환
     *
     * public T get()
     *  - Optional 안의 값을 강제로 추출
     *  - Null 이라면 에러가 발생합니다. [NoSuchElementException]
     *
     * public T orElse(T other)
     *  - Optional이 null이 아니라면 Optional안의 값을 반환한다.
     *  - null 이라면 other 로 공급된 값을 반환
     *
     * public T orElseGet(Supplier<? extends T> supplier)
     *  - Optional이 null이 아니라면 Optional 안의 값을 반환
     *  - null 이라면 supplier 로 공급되는 값을 반환합니다.
     *
     * public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
     *  - null 이라면 ExceptionSupplier로 공급되는 exception을 던진다.
     *
     */

    public static void main(String[] args) {

        String email = "test@email.com";
        String nullEmail = null;

        // Optional 생성
        Optional<String> email1 = Optional.of(email);
        Optional<String> email2 = Optional.empty();
        Optional<String> email3 = Optional.ofNullable(email);
        Optional<String> email4 = Optional.ofNullable(nullEmail);

        // Optional 안의 값 꺼내기
        String resultEmail1 = email1.get();
        System.out.println("resultEmail1 = " + resultEmail1);

        // Optional 안의 값이 존재하는 지 확인
        if (email2.isPresent()) {
            System.out.println("email2 = " + email2.get());
        }

        String defaultEmail = "default@email.com";
        String resultEmail2 = email2.orElse(defaultEmail);
        System.out.println("resultEmail2 = " + resultEmail2);


        String resultEmail3 = email2.orElseGet(() -> defaultEmail);
        System.out.println("resultEmail3 = " + resultEmail3);

        // 안에 값의 null 이라면 예외를 던짐
        String resultEmail4 = email4.orElseThrow(() -> new RuntimeException("email is not present"));
        System.out.println("resultEmail4 = " + resultEmail4);

    }
}
