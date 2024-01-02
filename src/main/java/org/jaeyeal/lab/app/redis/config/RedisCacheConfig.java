//package org.jaeyeal.lab.app.redis.config;
//
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.time.Duration;
//
//@Configuration
//@EnableCaching
//@Slf4j
//public class RedisCacheConfig {
//    /**
//     * Data 를 가져오고 보낼 때, 만든 도메인 모델을 Serialize 해주기 위해 설정이 필요
//     * 생성한 redisCacheManager 메서드를 앞으로 사용할 레디스 어노테이션에 명시 해주어야 한다.
//     * entryTtl 옵션으로 캐시 유효 시간을 30분으로 제한
//     */
//    @Bean
//    public CacheManager redisCacheManager(RedisConnectionFactory cf) {
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
////                .prefixCacheNameWith("Test:"); // key Prefix 로 Test: 붙여 저장
//                .entryTtl(Duration.ofMinutes(30L));  // 캐시 수명 30분
//
//
//
//        return RedisCacheManager
//                .RedisCacheManagerBuilder
//                .fromConnectionFactory(cf)
//                .cacheDefaults(redisCacheConfiguration)
//                .build();
//    }
//
//    @PostConstruct
//    public void init() {
//        log.info("RedisCacheManager is Active");
//    }
//}
