//package org.jaeyeal.lab.app.rabbitMq;
//
//import com.rabbitmq.client.impl.AMQImpl;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//
//
////@Configuration
//@Slf4j
//public class RabbitmqConfig {
//
//    @Value("${spring.rabbitmq.host}")
//    private String host;
//
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//
//    @Value("${spring.rabbitmq.port}")
//    private int port;
//
//    /**
//     * 1. Exchange를 구성
//     *  "hello.exchange 라는 이름으로 direct exchange 형태로 구성
//     */
////    @Bean
//    DirectExchange directExchange() {
//        return new DirectExchange("hello.exchange");
//    }
//
//    /**
//     * 2. 큐를 구성
//     *  "hello.queue" 라는 이름으로 큐를 구성
//     */
////    @Bean
//    Queue queue() {
//        return new Queue("hello.queue", false);
//    }
//
//    /**
//     * 3. 큐와 DirectExchange를 바인딩
//     * "hello.key" 라는 이름으로 바인딩을 구성
//     */
////    @Bean
//    Binding binding(DirectExchange directExchange, Queue queue) {
//        return BindingBuilder.bind(queue).to(directExchange).with("hello.key");
//    }
//
//    /**
//     * 4. RabbitMq 와의 연결을 위한 ConnectionFactory를 구성
//     * Application.yml의 rabbitMq의 사용자 정보를 가져와 RabbitMQ와의 연결에 필요한 ConnectionFactory를 구성
//     */
////    @Bean
//    ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(this.host);
//        connectionFactory.setPort(this.port);
//        connectionFactory.setUsername(this.username);
//        connectionFactory.setPassword(this.password);
//
//        return connectionFactory;
//    }
//
//    /**
//     * 5. 메세지를 전송하고 수신하기 위한 JSON 타입으로 메시지를 변경합니다.
//     * Jackson2JsonMessageConverter를 사용하여 메시지 변환을 수행 JSON 형식으로 메시지를 전송하고 수신할 수 있습니다
//     */
////    @Bean
//    MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//
//    /**
//     * 6.구성한 ConnectionFactory, MessageConverter를 통해 템플릿을 구성
//     */
////    @Bean
//    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(messageConverter);
//        return rabbitTemplate;
//    }
//    @PostConstruct
//    public void postConstruct() {
//        log.info("RabbitMqConfig Configuration is complete. Can Access RabbitMq");
//    }
//}
