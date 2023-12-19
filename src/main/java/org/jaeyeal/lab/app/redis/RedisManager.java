package org.jaeyeal.lab.app.redis;

import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class RedisManager {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOps;
    private String checkedSuffix = "-checked";

    public boolean isServerDown(String serverName) {
        final String value = valueOps.get(serverName);
        log.info("valueOps 에서 가져오는 서버네임의 값 = {}",value);
        if (StringUtils.isBlank(value)) {
            setServerStatus(serverName, "UP");
            valueOps.set(serverName + checkedSuffix, "", Duration.ofHours(2));
            return false;
        }
        final String checked = valueOps.get(serverName + checkedSuffix);
        return value.equals("DOWN") && StringUtils.isBlank(checked);
    }

    public void setServerStatus(String serverName, String status) {
        valueOps.set(serverName, status, Duration.ofHours(2));
    }

    public void setSendChecked(String serverName) {
        valueOps.set(serverName + checkedSuffix, "checked", Duration.ofHours(2));
    }

    public boolean setServerDown(String serverName) {
        final String value = valueOps.get(serverName);
        log.info("SerServerDown = {}", value);
        if (StringUtils.isBlank(value)) {
            valueOps.set(serverName, "DOWN",Duration.ofHours(2));
            return true;
        } else {
            return false;
        }
    }




}
