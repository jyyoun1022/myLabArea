package org.jaeyeal.lab.app.rabbitMq;

import org.springframework.stereotype.Service;

public interface ProducerService {

    // 메시지를 큐로 전송
    void sendMessage(MessageDto messageDto);
}
