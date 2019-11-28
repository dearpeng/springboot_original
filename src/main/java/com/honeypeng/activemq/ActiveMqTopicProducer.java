package com.honeypeng.activemq;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by 08754 on 2018/11/2.
 */

public class ActiveMqTopicProducer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory; // 连接工厂，用来生产Connection
        Connection connection = null; // 连接
        Session session; // 会话，接收或者发送消息的线程
        Destination destination; // 消息的目的地
        MessageProducer messageProducer; // 消息发送者

        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        try {
            connection = connectionFactory.createConnection(); // 通过连接工厂获取连接
            connection.start();  // 启动连接
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); // 获取Session
            destination = session.createTopic("FirstTopic111"); // 创建消息队列，名为FirstTopic1
            messageProducer = session.createProducer(destination); // 创建消息生产者
            sendMessage(session, messageProducer); // 发送消息
            session.commit(); // 因为上面加了事务Boolean.TRUE表示有事务，所以要commit
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

/**
     * @param session
     * @param messageProducer
     * @throws JMSException
     * @Description 发布消息*/


    public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {
        for (int i = 0; i < 6; i++) {
            TextMessage message = session.createTextMessage("ActiveMQ 发布的消息11111" + i);
            System.out.println("ActiveMQ 发布的消息111" + i);
            messageProducer.send(message);
        }
    }

}
