package org.jaeyeal.lab.app;


import lombok.extern.slf4j.Slf4j;
import org.jaeyeal.lab.app.redis.util.RedisUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class RedisManagerTest {

    @Autowired
    private RedisUtils redisUtils;

    private final String serverName = "labServer";

    @Test
    @DisplayName(value = "isServerDown Test")
    void redisTest() {
        boolean test = redisUtils.isServerDown(serverName);
        log.info(String.valueOf(test));

//        redisUtils.setServerStatus("ss","ss");
    }

    @Test
    @DisplayName("setServerStatus Test")
    void redisTest2() {
        redisUtils.setServerStatus(serverName,String.valueOf(true));
    }

    @Test
    @DisplayName("setSendChecked")
    void redisTest3() {
        redisUtils.setSendChecked(serverName);
    }

    @Test
    @DisplayName("serServerDown")
    void redisTest4() {
        System.out.println(redisUtils.setServerDown(serverName));
    }
}
