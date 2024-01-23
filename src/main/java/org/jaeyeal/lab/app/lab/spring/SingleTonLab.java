package org.jaeyeal.lab.app.lab.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Configuration
public class SingleTonLab {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderService(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        System.out.println(memoryMemberRepository);
        return memoryMemberRepository;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new DiscountPolicy();
    }

    @RequiredArgsConstructor
    public static class MemberServiceImpl implements MemberService {
        private final MemberRepository memberRepository;
    }

    public interface MemberService {

    }

    @RequiredArgsConstructor
    public static class OrderService {
        private final MemberRepository memberRepository;
        private final DiscountPolicy discountPolicy;
    }

    public static class DiscountPolicy {

    }
    public interface MemberRepository {

    }

    public static class MemoryMemberRepository implements MemberRepository {
    }

    public static void main(String[] args) {
        /** 1. 싱글톤
         *
         * 스프링 컨테이너는 알아서 코드를 짜주면서 자동으로 싱글톤 방식으로 데이터를 저장
         * 따라서, 스프링 컨테이너에서 꺼내서 쓰는 데이터는 필요할 때마다 새로운 인스턴스를 만들어서
         * 서로 다른 인스턴스를 가져오는게 아니라, 하나의 인스턴스를 참조하는것.
         */

        /** 2. 싱글톤 주의점
         *
         *  싱글톤 패턴은 여러 클라이언트가 하나의 같은 객체를 공유하기 때문에 싱글톤 객체는 상태를 유지하게 설게하면 안된다.(stateless 하게 해야함)
         *  - 특정 클라이언트에 의존적인 필드가 있으면 안된다.
         *  - 값을 변경할 수 있는 필드가 있으면 안된다.
         *  - 필드 대신 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
         *
         *  예시) 멀티쓰레드
         *  사용자 1이 싱글톤 객체 필드에 값을 1로 저장해두고, 10분 뒤에 값을 불러왔다고 하자
         *  하지만 그 10분 사이에 사용자 2가 실글톤 객체의 필드값을 0으로 수정했다면,
         *  사용자 1은 불러올 값을 1로 예상했지만 실제로는 0을 가져오게 된다.
         *  싱글톤 패턴 즉, 객체를 공유하고 있기 때문에 이런 문제가 발생하는 것이다.
         *  따라서 싱글톤 객체의 필드는 작성하지 않는게 좋다.
         *
         */


        ApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonLab.class);
        SingleTonLab bean = ac.getBean(SingleTonLab.class);
        System.out.println("bean.getClass() = " + bean.getClass());

        /**  AnnotationConfigApplicationContext의 파라미터로 SingletonLab.class 를 넘기면서
         * 자동으로 스프링 빈에 등록이 된다. 이것을 꺼내서 출력해보면 단순한 클래스가 아니라
         *스프링이 CGLIB라는 바이트 코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받아 override한 임의의 다른 클래스를 만들고 그 클래스를 스프링 빈으로 등록한 것
         */
    }
}
