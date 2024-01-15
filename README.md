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