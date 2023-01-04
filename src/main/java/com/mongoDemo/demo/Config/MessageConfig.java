package com.mongoDemo.demo.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public Queue queue() {
        return new Queue(config.MYQUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(config.MYEXCHANGE);
    }

    @Bean
    public Binding bindingBuilder(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(config.ROUTING_KEY);
    }

    @Bean
    public MessageConverter JsonConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(JsonConverter());
        return rabbitTemplate;
    }
}
