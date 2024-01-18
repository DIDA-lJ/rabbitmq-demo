package com.linqi.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linqi
 * @version 1.0.0
 * @description
 */
@Configuration
public class FanoutConfiguration {

    @Bean
    public FanoutExchange fanoutExchange() {
//        ExchangeBuilder.fanoutExchange("hmall.fanout2").build();
        return new FanoutExchange("hmall.fanout2");
    }

    @Bean
    public Queue fanoutQueue3(){
//        QueueBuilder.durable("fanout.queue3").build();
        return new Queue("fanout.queue3");
    }

    @Bean
    public Binding fanoutBinding3(Queue fanoutQueue3,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }
}
