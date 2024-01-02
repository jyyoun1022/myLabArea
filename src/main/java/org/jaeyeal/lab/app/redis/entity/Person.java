package org.jaeyeal.lab.app.redis.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@Data
@RedisHash(value = "people", timeToLive = 300)
public class Person {

    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime createAt;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.createAt = LocalDateTime.now();
    }
}
