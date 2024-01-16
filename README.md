# RabbitMQ-Demo




## 项目介绍
本项目主要是 rabbitmq 入门案例，从零到一使用 rabbitmq

## docker 安装 RabbitMQ
```docker 
docker run -e RABBITMQ_DEFAULT_USER=itheima  \
           -e RABBITMQ_DEFAULT_PASS=123456 \
           -v mq-plugins:/plugins \
           --name mq --hostname mq \
           -p 15672:15672 -p 5672:5672  \
           -d rabbitmq:3.8-management
```

## 消息队列模型
### work 模型
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/37e098a3-da6d-4235-8cf8-c39e6dd76c88)

## 交换机类型

![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/be028621-76e6-44db-95ad-dd40cc32d4eb)

### Fanout 交换机（广播）
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/bde345b5-25ed-4d6a-a76b-14c7ad9811d5)
