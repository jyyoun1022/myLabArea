package org.jaeyeal.lab.app;

import org.jaeyeal.lab.app.redis.entity.Person;
import org.jaeyeal.lab.app.redis.repository.PersonRedisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private PersonRedisRepository personRedisRepository;

    @Test
    void test() {
        Person person = new Person("Park", 29);

        Person save = personRedisRepository.save(person);
        System.out.println(save);
        //save

        Person entity = personRedisRepository.findById(person.getId()).orElseThrow();
        System.out.println(entity);
        // keyspace: id 값을 가져옴

//        personRedisRepository.count();
        // @RedisHash에 정의되어 있는 keyspace에 속한 키의 개수 반환

//        personRedisRepository.delete(person);
    }
}
