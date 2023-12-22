package org.jaeyeal.lab.app.redis.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jaeyeal.lab.app.redis.dto.TestDto;
import org.jaeyeal.lab.app.redis.service.TestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    /**
     * value = 저장될 value 로써 API 리턴 데이터인 TestDto 객체로 선언
     * key   = #id : 이 API 에서 id에 따라 응답값이 달라지므로 저장된 key 로 id 파라미터 값을 선언
     * cacheManager = cacheConfig에 작성한 cacheManager를 사용
     * unless = #id  : id 가 "" 일때 캐시를 저장하지 않음
     * condition = #id.length > 2  : id 의 length가 3이상일 때만 캐시저장
     */
    @GetMapping("/api/v1/test")
    @Cacheable(value = "TestDto", key = "#id", cacheManager = "redisCacheManager", unless = "#id == ''", condition = "#id.length > 2")
    public TestDto getData(String id) {
        return testService.getTestSvc(id);
    }

    @GetMapping("/api/v1/test2")
    public ResponseEntity<String> getTest(@RequestParam(value = "ids") String ids) {
        return ResponseEntity.ok(ids);
    }

    @GetMapping("/api/v2/test")
    @Cacheable(value = "TestDto", key = "#id", cacheManager = "redisCacheManager")
    public TestDto getData2(String id) {
        return testService.getTestSvc(id);
    }


}
