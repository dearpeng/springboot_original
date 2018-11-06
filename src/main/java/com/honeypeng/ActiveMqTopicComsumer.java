package com.honeypeng;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * Created by 08754 on 2018/11/2.
 */
public class ActiveMqTopicComsumer {
    /*public static void main(String[] args) {
        ConnectionFactory connectionFactory; // 连接工厂，用来生产Connection
        Connection connection = null; // 连接
        Session session; // 会话，接收或者发送消息的线程
        Destination destination; // 消息的目的地
        MessageConsumer messageConsumer; // 消息消费者
        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory("admin", "admin123", "tcp://localhost:61616");
        try {
            connection = connectionFactory.createConnection(); // 通过连接工厂获取连接
            connection.start();  // 启动连接
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // 获取Session，不需要加事务了
            destination = session.createTopic("FirstTopic1"); // 创建消息队列，名为FirstTopic1
            messageConsumer = session.createConsumer(destination); // 创建消息消费者
            //注册消息监听
            messageConsumer.setMessageListener(new Listener());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/


    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("FirstTopic111");

        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage tm = (TextMessage) message;
                try {
                    System.out.println("收到的消息为: " + tm.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
//      session.close();
//      connection.stop();
//      connection.close();
    }
}
