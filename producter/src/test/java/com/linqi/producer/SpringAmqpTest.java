package com.linqi.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author linqi
 * @version 1.0.0
 * @description
 */
@SpringBootTest
public class SpringAmqpTest {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    void testSendMessage2Queue(){
        String queueName = "simple.queue";
        String message = "hello, spring amqp ";
        rabbitTemplate.convertAndSend(queueName,message);
    }


    @Test
    void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName = "work.queue";
        for (int i = 1; i <= 50;i++){
            String message = "hello, worker,message_" + i;
            rabbitTemplate.convertAndSend(queueName,message);
            Thread.sleep(20);
        }

    }

    @Test
    void testSendFanout(){
        String exchangeName = "hmall.fanout";
        String message = "hello, spring amqp 【fanout.queue】";
        rabbitTemplate.convertAndSend(exchangeName,null,message);
    }

    @Test
    void testSendDirect(){
        String exchangeName = "hmall.direct";
        String message = "hello, spring amqp 【topic.queue】";
        rabbitTemplate.convertAndSend(exchangeName,"blue",message);
    }

    @Test
    void testSendTopic(){
        String exchangeName = "hmall.topic";
        String message = "hello, spring amqp 【topic.queue】";
        rabbitTemplate.convertAndSend(exchangeName,"china.news",message);
    }
}
