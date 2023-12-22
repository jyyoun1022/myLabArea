package org.jaeyeal.lab.app.redis.cache;

public class CacheStudy {
    /**
     * - 캐시 저장소는 메모리를 사용하므로 그 크기가 한정적이다.
     *
     * - 항상 CacheManager 구현체를 설정하기 전에 구현체가 최대 데이터 개수와 데이터 유효기간을 설정할 수 있는지 확인
     * - EhCacheCacheManger 와 CaffeineCacheManager 는 최대 데이터 개수와 유효 기간을 설정할 수 있으나,
     * - RedisCacheManager 는 유효기간을 설정할 수는 있으나, 최대 데이터 개수는 직접 구현해야 한다.
     *
     * - 일반적으로 캐시마다 최대 데이터 개수를 설정하는데, 최대 데이터 개수를 초과하면 캐시프레임 워크는 저장된 데이터 중 초과된 개수만큼 삭제
     * - 이렇게 캐시에서 데이터를 삭제하는 과정을 Evict(퇴출) 이라고 한다.
     * - 삭제 대상 데이터는 페이지 교체 알고리즘으로 결정 된다.
     *  - FIFO : First In First Out (가장 먼저 캐시된 데이터 삭제)
     *  - LFU : Least Frequently Used (참조된 횟수가 가장 적은 데이터 삭제(= 사용 빈도가 적은 데이터 삭제)
     *  - LRU : Least Recently Used (참조된 시간이 가장 오래된 데이터 삭제 , 참조 시간이 오래된 데이터는 사용 빈도가 적으므로 삭제, 간단한 구조라 가장 많이 사용하는 알고리즘)
     *
     * - 유효 기간을 설정할 수 있는 CacheManager 인 경우 유효 기간 설정 시 오래된 데이터를 삭제하는 별도의 데몬이나 스케줄 프로그램을 구현할 필요가 없다.
     *  So, 그래서 캐시 데이터 저장소의 크기를 일정하게 유지할 수 있고, 오래된 데이터가 자동 Evict 되어 새로운 데이터가 다시 캐시될 수 있다.
     *
     *
     * - 로컬 캐시 아키텍처
     *      - 자바 애플리케이션에 cache 시스템 구성
     *      - 애플리케이션은 각각의 캐시 시스템을 가지며, 1:1 방식으로 사용
     *      - 따라서 로컬 캐시들은 데이터를 서로 공유할 수 없음
     *      - 같은 이름의 데이터라도 각 서버마다 관리하고 있는 캐시 데이터들은 다를 수 있음
     * - 원격 캐시 아키텍처
     *      - 애플리케이션 외부에 독립 메모리 저장소를 별도로 구축하여 모든 인스턴스가 네트워크를 사용하여 데이터를 캐시
     *      - EhCache 서버를 구축하거나, 레디스 서버를 사용
     *      - 로컬 캐시 방식보다 I/O 시간 만큼 서버 리소스의 시간이 더 소요됨
     *      - 네트워크를 사용하므로 외부 환경에 의해 캐시 성능이 영향을 받음
     *      - 하지만 한 곳에 데이터가 저장되므로 모든 서버가 같은 데이터를 사용할 수 있음
     *
     */

}