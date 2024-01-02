package org.jaeyeal.lab.app.rabbitMq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService{


    @Override
    public void sendMessage(MessageDto messageDto) {
        try {
            // 객체를 JSON으로 변환
            ObjectMapper om = new ObjectMapper();
            String objectToJson = om.writeValueAsString(messageDto);

//            rabbitTemplate.convertAndSend("hello.exchange", "hello.key", objectToJson);
        } catch (JsonProcessingException jpe) {
            System.out.println("ParsingError to Occur");
        }

    }
}
