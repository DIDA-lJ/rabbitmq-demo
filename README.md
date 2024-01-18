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

## 交换机概述
### 交换机作用
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/51c82504-8a2c-48aa-8a66-fb76fe80f5c0)

### 交换机类型
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/be028621-76e6-44db-95ad-dd40cc32d4eb)

### Fanout 交换机（广播）
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/bde345b5-25ed-4d6a-a76b-14c7ad9811d5)

### Direct 交换机
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/66e432c9-5f86-4c57-8880-f8afb3b9d90d)

### Topic 交换机
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/e8179c11-a8d5-4214-9fde-e11cf8081097)

## 声明队列和交换机
### 方式一
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/80f35784-9133-472e-9cc4-f90d97068f30)

### 方式二
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/52550ee7-b570-4b05-8363-788da2e90297)


