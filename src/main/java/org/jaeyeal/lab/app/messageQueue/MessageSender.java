package org.jaeyeal.lab.app.messageQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private AmqpTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("exchange", "routingKey",message);
        System.out.println("message sent : " + message);
    }
}
