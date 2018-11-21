package com.honeypeng.activemq;/*
package com.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

*/
/**
 * Created by 08754 on 2018/11/6.
 *//*

@Component(value = "springBootActivemqComsumer")
public class SpringBootActivemqComsumer {

    */
/*点对点*//*

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
        return "还给你的垃圾信息";
    }

    */
/*发布订阅模式*//*

    @JmsListener(destination = "test.topic", containerFactory = "myJmsContainerFactory")
    public void subscribe(String text) {
        System.out.println("===========<<<<<<<<收到订阅的消息" + text);
    }
}
*/
