package com.linqi.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
    public  void listenFanoutQueueMessage1(String msg)  {
        log.info("消费者1:【fanout.queue 1 收到消息：{}】",msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public  void listenFanoutQueueMessage2(String msg) throws InterruptedException {
        log.error("消费者2:【fanout.queue 2 收到消息：{}】",msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name="direct.queue1",declare = "true"),
            exchange = @Exchange(name = "hmall.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public  void listenDirectQueueMessage1(String msg) throws InterruptedException {
        log.info("消费者1:【direct.queue 1 收到消息：{}】",msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name="direct.queue2",declare = "true"),
            exchange = @Exchange(name = "hmall.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public  void listenDirectQueueMessage2(String msg) throws InterruptedException {
        log.error("消费者2:【direct.queue 2 收到消息：{}】",msg);
    }

    @RabbitListener(queues = "topic.queue1")
    public  void listenTopicQueueMessage1(String msg) throws InterruptedException {
        log.info("消费者1:【topic.queue 1 收到消息：{}】",msg);
    }

    @RabbitListener(queues = "topic.queue2")
    public  void listenTopicQueueMessage2(String msg) throws InterruptedException {
        log.error("消费者2:【topic.queue 2 收到消息：{}】",msg);
    }

    @RabbitListener(queues = "object.queue")
    public  void listenObjectQueueMessage(String msg) throws InterruptedException {
        log.error("消费者2:【topic.queue 2 收到消息：{}】",msg);
    }
}
