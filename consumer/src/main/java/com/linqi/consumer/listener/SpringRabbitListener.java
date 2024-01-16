package com.linqi.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Component;

/**
 * @author linqi
 * @version 1.0.0
 * @description
 */
@Slf4j
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.queue")
    public  void listenSimpleQueueMessage(String msg){
        log.info("接收到消息：{}",msg);
        log.info("消息处理完成!");
    }

    @RabbitListener(queues = "work.queue")
    public  void listenWorkerQueueMessage1(String msg) throws InterruptedException {
        log.info("work.queue 1 接收到消息：{}",msg);
        Thread.sleep(20);
        log.info("work.queue 1消息处理完成!");
    }

    @RabbitListener(queues = "work.queue")
    public  void listenWorkerQueueMessage2(String msg) throws InterruptedException {
        log.error("work.queue 2 接收到消息：{}",msg);
        Thread.sleep(200);
        log.error("work.queue 2 消息处理完成!");
    }

    @RabbitListener(queues = "fanout.queue1")
    public  void listenFanoutQueueMessage1(String msg) throws InterruptedException {
        log.info("消费者1:【fanout.queue 1 收到消息：{}】",msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public  void listenFanoutQueueMessage2(String msg) throws InterruptedException {
        log.error("消费者2:【fanout.queue 2 收到消息：{}】",msg);
    }
}
