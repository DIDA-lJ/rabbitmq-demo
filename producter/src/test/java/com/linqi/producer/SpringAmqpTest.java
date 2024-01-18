package com.linqi.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author linqi
 * @version 1.0.0
 * @description
 */
@SpringBootTest
@Slf4j
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
        String message = "hello, spring amqp 【direct.queue】";
        rabbitTemplate.convertAndSend(exchangeName,"red",message);
    }

    @Test
    void testSendTopic(){
        String exchangeName = "hmall.topic";
        String message = "hello, spring amqp 【topic.queue】";
        rabbitTemplate.convertAndSend(exchangeName,"china.news",message);
    }

    @Test
    void testSendQueue(){
        String exchangeName = "object.queue";
        Map<String,Object> message = new HashMap<String,Object>(2);
        message.put("name","jack");
        message.put("age",21);
        rabbitTemplate.convertAndSend(exchangeName,message);
    }

    @Test
    void testConfirmCallback() throws InterruptedException {
        //1.创建 cd
        CorrelationData cd = new CorrelationData(UUID.randomUUID().toString());
        //2.添加 ConfirmCallback
        cd.getFuture().addCallback(new ListenableFutureCallback<CorrelationData.Confirm>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("消息回调失败",ex);
            }

            @Override
            public void onSuccess(CorrelationData.Confirm result) {
                log.debug("收到confirm callback 回执");
                if (result.isAck()){
                    log.debug("消息发送成功,收到 ACK");
                }else {
                    log.debug("消息发送失败，收到 nack,原因:{}",result.getReason());
                }
            }
        });

        rabbitTemplate.convertAndSend("hmall.direct","red","hello world",cd);

        Thread.sleep(2000);
    }
}
