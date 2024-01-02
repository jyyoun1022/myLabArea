package org.jaeyeal.lab.app.redis.repository;

import org.jaeyeal.lab.app.redis.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person, String> {
}
