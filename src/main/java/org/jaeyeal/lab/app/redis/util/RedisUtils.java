package org.jaeyeal.lab.app.redis.util;

import io.micrometer.common.util.StringUtils;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisUtils {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valueOps;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;


    public void setData(String key, Object value) {
        valueOps.set(key,value);
    }

    public void setData(String key, Object value, Long timeout, TimeUnit timeUnit) {
        valueOps.set(key, value,timeout, timeUnit);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void expire(String key) {
        redisTemplate.expire(key,1, TimeUnit.SECONDS);
    }

    public Object getData(String key) {
        return valueOps.get(key);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("RedisUtils init is complete [Can use RedisUtils]");
    }





    private String checkedSuffix = "-checked";

    /** 테스트용 **/
    public boolean isServerDown(String serverName) {
        final String value = String.valueOf(valueOps.get(serverName));
        log.info("valueOps 에서 가져오는 서버네임의 값 = {}",value);
        if (StringUtils.isBlank(value)) {
            setServerStatus(serverName, "UP");
            valueOps.set(serverName + checkedSuffix, "", Duration.ofHours(2));
            return false;
        }
        final String checked = String.valueOf(valueOps.get(serverName + checkedSuffix));
        return value.equals("DOWN") && StringUtils.isBlank(checked);
    }

    public void setServerStatus(String serverName, String status) {
        valueOps.set(serverName, status, Duration.ofHours(2));
    }

    public void setSendChecked(String serverName) {
        valueOps.set(serverName + checkedSuffix, "checked", Duration.ofHours(2));
    }

    public boolean setServerDown(String serverName) {
        final String value = String.valueOf(valueOps.get(serverName));
        log.info("SerServerDown = {}", value);
        if (StringUtils.isBlank(value)) {
            valueOps.set(serverName, "DOWN",Duration.ofHours(2));
            return true;
        } else {
            return false;
        }
    }
    /** 테스트용 끝**/





}
