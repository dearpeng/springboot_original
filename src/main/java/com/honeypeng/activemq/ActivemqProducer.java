package com.honeypeng.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Created by 08754 on 2018/10/23.
 */
@Component("producer")
public class ActivemqProducer {
    @Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsMessagingTemplate jmsTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    //双向队列
    @JmsListener(destination = "outMq")
    public void testProducerComsumeMessage(String message) {
        for (int i = 0; i < 3; i++) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) throws JMSException {
        //1.建立ConnectionFactory工厂对象，需要填入用户名、密码以及ActiveMQ地址，默认端口为tcp://localhost:61616
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        //2.通过ConnectionFactory工厂对象创建Connection连接，并调用Connection对象的start方法开启连接，默认为关闭状态
        Connection connection = factory.createConnection();
        //3.通过Connection对象创建Session会话（上下文环境对象），用于接收和发送消息，参数一：是否开启事务，参数二：签收模式，一般设置为自动签收
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //4.通过Session对象创建Destination对象，用来指定生产消息和消费消息来源的对象，在PTP中，Destination被称为Queue（队列），
        //在Publish/Subscribe模式，Destination被称为Topic（主题）。程序中可以有多个Queue和Topic。
        Destination destination = session.createQueue("queue66");
        //5.通过Session对象创建消息的发送和接收对象（生产者和消费者）MessageProducer和MessageConsumer
        MessageProducer producer = session.createProducer(destination);
        //6.使用MessageProducer的setDeliveryMode方法设置持久化特性或非持久化。
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //7.使用JMS规范的TextMessage形式创建数据（通过Session对象创建），并用MessageProducer的send方法发送数据。客户端使用receive方法接收数据
        TextMessage message = new ActiveMQTextMessage();
        for (int i = 0; i < 5; i++) {
            message.setText("发送mq消息：" + i);
            producer.send(destination, message);
        }
        //8.关闭Connection
        if (connection != null) {
            connection.close();
        }
    }
}