package org.jaeyeal.lab.app;


import lombok.extern.slf4j.Slf4j;
import org.jaeyeal.lab.app.redis.RedisManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class RedisManagerTest {

    @Autowired
    private RedisManager redisManager;

    private final String serverName = "labServer";

    @Test
    @DisplayName(value = "isServerDown Test")
    void redisTest() {
        boolean test = redisManager.isServerDown(serverName);
        log.info(String.valueOf(test));

//        redisManager.setServerStatus("ss","ss");
    }

    @Test
    @DisplayName("setServerStatus Test")
    void redisTest2() {
        redisManager.setServerStatus(serverName,String.valueOf(true));
    }

    @Test
    @DisplayName("setSendChecked")
    void redisTest3() {
        redisManager.setSendChecked(serverName);
    }

    @Test
    @DisplayName("serServerDown")
    void redisTest4() {
        System.out.println(redisManager.setServerDown(serverName));
    }
}
