package org.jaeyeal.lab.app.redis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogService {

    /**
     * @Cacheable
     *     => 리턴 값을 기준으로 데이터가 캐시에 있으면 그대로 반환, 없으면 저장 후 반환
     *     => 보통 조회와 같은 API 에 많이 사용
     *
     * - cacheName : 캐시 이름 (설정 메서드 리턴값이 저장되는)                                    String[]
     * - value : cacheName 의 alias                                                         String[]
     * - key : 동적인 키 값을 사용하는 SpEL 표현식                                              String
     * - condition : SpEL 표현식이 참일 경우에만 캐싱 적용                                      String
     *             : or, and 등 조건식, 논리연산 가능
     * - unless : 캐싱을 막기 위해 사요되는  SpEL 표현식                                          String
     *          : condition과 반대로 참일 경우에만 캐싱이 적용되지 않음
     * - cacheManager : 사용할 CacheManager 지정                                              String
     *                : (EhCacheManager, RedisCacheManger 등)
     * - sync : 여러 스레드가 동일한 키에 대한 값을 로드하려고 할 경우, 기본 메서드의 호출을 동기화      BOOLEAN
     *           즉, 캐시 구현체가 Thread safe 하지 않는 경우, 캐시에 동기화를 걸 수있는 속성
     */
    /**
     ex) EhCache 일 때 ,
     @Cacheable(value = "SystemService.getSystem", sync = true, keyGenerator = "customCacheKeyGenerator", cacheManager = "ehCacheCacheManager")
     */

    @Cacheable(cacheNames = "searchAll", key = "#root.target + #root.methodName", sync = true, cacheManager = "redisCacheManager")
    public List<Object> searchAll() {
        List<Object> response = new ArrayList<Object>();
        return response;
    }

    /**
     * @CacheEvict
     *      => 메서드가 호출될 때 캐시에 있는 데이터가 삭제
     *      => 보통 삭제와 같은 API 에 많이 사용
     *
     * - cacheName : 제거할 캐시 이름
     * - value : cacheName 의 alias
     * - key : 동적인 키 값을 사용하는 SpEL 표현식
     *       : 동일한 cache name 을 사용하지만 구분될 필요가 있을 경우 사용되는 값
     * - allEntries : 캐시 내의 모든 리소스를 삭제할지의 여부
     * - condition : SpEL 표현식이 참일 경우에만 삭제 진행
     *             : or , and 등 조건식, 논리연산 가능
     * - cacheManager : 위와 동일
     * - beforInvocation : true 일 때, 메서드 수행 이전 캐시 리소스 삭제
     *                   : false 일 때, 메서드 수행 후 캐시 리소스 삭제
     */

    /**
     * ex ) EhCache 일 때,
     * @CacheEvict(value = "SystemService.listOfSystemAccess", allEntries = true)
     */





    @CacheEvict(cacheNames = "searchAll", allEntries = true, beforeInvocation = true, cacheManager = "redisCacheManager")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void removeAll() {
        log.info("searchAll method cache removeAll");
    }

}
