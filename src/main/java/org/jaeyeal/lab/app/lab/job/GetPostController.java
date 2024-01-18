package org.jaeyeal.lab.app.lab.job;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GetPostController {

    @GetMapping("/test1")
    public ResponseEntity<?> test1 (@RequestBody Test test) {
        log.info("test", test);

        return ResponseEntity.ok(test);
    }

    @PostMapping("/test2")
    public ResponseEntity<?> test2 (@RequestBody Test test) {
        log.info("test", test);

        return ResponseEntity.ok(test);
    }

    @Data
    public static class Test {
        private String id;
        private String password;
    }


}
