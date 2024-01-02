package org.jaeyeal.lab.app.rabbitMq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    /**
     * 생성자(producer)가 메시지를 전송합니다.
     */
    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDto messageDto) {
        String result = "";

        producerService.sendMessage(messageDto);

        return ResponseEntity.ok(result);
    }
}
