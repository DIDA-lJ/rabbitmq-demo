package com.linqi.producer;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class PublisherApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(PublisherApplication.class, args);
    }

    /**
     * rabbitmq 消息对内消息转换器配置
     * @return 消息转换器
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
