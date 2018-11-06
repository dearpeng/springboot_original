package com.honeypeng;

import com.honeypeng.bean.Person;
import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootfirstApplicationTests {
	@Autowired
	private Person person;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private ActivemqProducer producer;

	@Autowired
	private SpringBootActivemqProducer springBootActivemqProducer;

	@Test
	public void testHello(){
		boolean helloService = context.containsBean("helloService");
		System.out.println(helloService);
		System.out.println("=============================================");
	}
	@Test
	public void testHello1() {
		System.out.println("--------------------------------------------------");
		System.out.println(Objects.equals("111", null));
	}

	@Test
	public void testActiveMq(){
		ActiveMQQueue queue = new ActiveMQQueue("my-destination");
		for (int i = 0; i < 5; i++) {
			producer.sendMessage(queue,"springboot 测试activemq");
		}
	}

	@Test
	public void contextLoad() throws InterruptedException {
		Destination destination = new ActiveMQQueue("mytest.queue");

		for(int i=0; i<10; i++){
			springBootActivemqProducer.sendMessage(destination, "这是什么东子!!!");
		}
	}

	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			springBootActivemqProducer.publish("test.topic", "Topic Message " + i);
		}
	}
}
