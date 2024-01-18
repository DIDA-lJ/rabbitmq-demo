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

## 消息转换器
默认的序列化方式不安全，所以需要重新配置消息转换器
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/b5e810d1-398e-4dfd-a523-7c7507b09ae3)

## MQ 高级：生产者可靠性
### 生产者重连
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/7831846c-2f67-4262-a070-cd5cb094cc0b)
### 生产者确认
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/0b3d5fe5-98c3-4689-a0a8-d4aa97c90882)
![image](https://github.com/DIDA-lJ/rabbitmq-demo/assets/97254796/e3e60e46-c51b-42b3-95c6-5f8d9f241c72)


