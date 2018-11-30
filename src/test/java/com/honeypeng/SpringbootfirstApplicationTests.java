package com.honeypeng;


import com.honeypeng.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootfirstApplicationTests {
    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext context;

	/*@Autowired
    private ActivemqProducer producer;

	@Autowired
	private SpringBootActivemqProducer springBootActivemqProducer;*/

    @Test
    public void testHello() {
        boolean helloService = context.containsBean("helloService");
        System.out.println(helloService);
        System.out.println("=============================================");
    }

    @Test
    public void testHello1() {
        System.out.println("--------------------------------------------------");
        System.out.println(Objects.equals("111", null));
    }

    //activemq 注释
    /*@Test
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
	}*/

    @Test
    public void randomQuestion() {
        String s = "请问您现在是否需要在我行申请一笔信用卡购车分期付款业务？您对此分期付款业务情况是否了解？";
        System.out.println("===========================");
        System.out.println(s.charAt(11));
    }


    @Test
    public void nioTest(){
        File file = new File("D:\\data.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            FileChannel channel = outputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String string = "hello java nio";
            buffer.put(string.getBytes());
            buffer.flip();     //此处必须要调用buffer的flip方法
            channel.write(buffer);
            channel.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
