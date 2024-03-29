package com.linqi.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author linqi
 * @version 1.0.0
 * @description
 */
@Slf4j
@Configuration
public class CommonConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 1.获取 RabbitTemplate
        RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);
        // 2.设置回调
        rabbitTemplate.setReturnCallback((message,replyCode,replyText,exchange,routingKey) -> {
            log.info("消息发送失败，应答码:{},原因:{},交换机:{},路由键:{},消息:{}",
                    replyCode,replyText,exchange,routingKey,message.toString());
        });
    }
}
