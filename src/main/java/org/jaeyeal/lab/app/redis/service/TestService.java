package org.jaeyeal.lab.app.redis.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jaeyeal.lab.app.redis.dto.TestDto;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    public TestDto getTestSvc(String id) {
        log.info("ID = {}",id);
        System.out.println("[id:" + id + "] Service 에서 연산을 수행합니다");
        return TestDto.builder()
                .id(id)
                .text(id + " 님, 안녕하세요.")
                .build();
    }

    @PostConstruct
    public void init() {
        log.info("TestService INIT");
    }
}
