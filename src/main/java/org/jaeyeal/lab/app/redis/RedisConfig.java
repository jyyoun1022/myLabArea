package org.jaeyeal.lab.app.redis;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

@PropertySource("classpath:redis.properties")
@Configuration
@Slf4j
@ConfigurationProperties(prefix = "spring.redis")
@EnableRedisRepositories(basePackages = "org.jaeyeal.lab")
@Setter
public class RedisConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    private String host;
    private int port;
    private String password;
//    private int database;
    // 추가설정 필요



    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        System.out.println("host = " + host);
        System.out.println("port = " + port);
        System.out.println("password = " + password);
//        System.out.println("database = " + database);
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);
        redisStandaloneConfiguration.setPassword(password);
//        redisStandaloneConfiguration.setDatabase(database);

        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        return redisMessageListenerContainer;
    }

    /**
     *
     * key값은 항상 String이므로 String, Value는 와일드카드 or Object를 사용해서,
     * 다양한 객체를 저장할 수 있도록 해줍니다.
     */
    @Bean
    RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        /**
         * StringRedisSerializer
         * String 키와 값의 직렬 변환
         */
        // 일반적인 Key: Value 의 경우 Serializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        /**
         * Jackson2JsonRedisSerializer
         * Jackson 2 를 이용하여 객체를 JSON으로 직렬 변환
         */
        // Hash 를 사용할 경우 Serializer
        redisTemplate.setHashKeySerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));

        return redisTemplate;
    }


}
