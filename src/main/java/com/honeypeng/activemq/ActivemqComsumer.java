package com.honeypeng.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Created by 08754 on 2018/10/22.
 */
@Component("comsumer")
public class ActivemqComsumer {
    //@JmsListener是Spring 4.1为我们提供的一个新特性，用来简化JMS开发。我们只需在这个注解的属性destination指定要监听的目的地，即可接收该目的地发送的消息。此例监听my
    //-destination目的地发送的消息。
    @JmsListener(destination = "my-destination")
    @SendTo(value = "outMq")
    public String receiveMessage(String message) {
        System.out.println("接受到: <" + message + ">");
        return "消费生产者的消息完成,返回";

    }


    public static void main(String[] args) throws JMSException {

        //1.建立ConnectionFactory工厂对象，需要填入用户名、密码以及ActiveMQ地址，默认端口为tcp://localhost:61616
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin",
                "tcp://localhost:61616");
        //2.通过ConnectionFactory工厂对象创建Connection连接，并调用Connection对象的start方法开启连接，默认为关闭状态
        Connection connection = factory.createConnection();
        connection.start();
        //3.通过Connection对象创建Session会话（上下文环境对象），用于接收和发送消息，参数一：是否开启事务，参数二：签收模式，一般设置为自动签收
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //4.通过Session对象创建Destination对象，用来指定生产消息和消费消息来源的对象，在PTP中，Destination被称为Queue（队列），
        //在Publish/Subscribe模式，Destination被称为Topic（主题）。程序中可以有多个Queue和Topic。
        Destination destination = session.createQueue("queue66"); //这里的名字需要与生产者的一样
        //5.通过Session对象创建消息的发送和接收对象（生产者和消费者）MessageProducer和MessageConsumer
        MessageConsumer consumer = session.createConsumer(destination);

        while (true) {//循环的监听，一有消息就处理
            //该方法会阻塞，直到接收到消息，还有receive(long l)阻塞指定的时间，receiveNoWait()不阻塞
            TextMessage message = (TextMessage) consumer.receive(2);
            System.out.println("================================"+message);
            if(message == null) {
                break;
            }
            System.out.println("接收到：" + message.getText());
        }

        //不要关闭就能在mq管理平台看到消费者
//        if(connection != null) {
//            connection.close();
//        }
    }
}
