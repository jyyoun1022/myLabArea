package org.jaeyeal.lab.app.messageQueue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueManager {

    @Bean
    public CommandLineRunner run(MessageSender sender) {
        return args -> {
            sender.sendMessage("Hello , RabbitMq!");
        };
    }
}
