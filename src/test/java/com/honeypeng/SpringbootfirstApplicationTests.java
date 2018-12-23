package com.honeypeng;


import com.honeypeng.bean.Person;
import com.honeypeng.component.MultiThreadTest;
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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootfirstApplicationTests {
    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext context;

//    @Autowired
//    private ThreadPoolExecutor taskExecutor;

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

//    @Test
//    public void testThreadPool() {
//        int n = 20;
//        for (int i = 0; i < n; i++) {
//            taskExecutor.execute(new MultiThreadTest());
//            System.out.println("int i is " + i + ", now threadpool active threads totalnum is " + taskExecutor.getActiveCount());
//        }
//    }

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
    public void nioTest() {
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

    @Test
    public void threadTest() throws Exception {
// sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        // busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        // 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(2);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is "
                + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "
                + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }


    @Test
    public void thread1Test() throws Exception {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        //新建三个线程
        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");
        //让线程依次开始
        t1.start();
        //让线程休眠
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }
}

class SyncThread implements Runnable {
    private Object obj1;
    private Object obj2;

    //构造函数
    public SyncThread(Object o1, Object o2) {
        this.obj1 = o1;
        this.obj2 = o2;
    }

    @Override
    public void run() {
        //获取并当前运行线程的名称
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on " + obj1);


        synchronized (obj1) {
            System.out.println(name + " acquired lock on " + obj1);
            work();
            System.out.println(name + " acquiring lock on " + obj2);
            synchronized (obj2) {
                System.out.println(name + " acquired lock on " + obj2);
                work();
            }
            System.out.println(name + " released lock on " + obj2);
        }
        System.out.println(name + " released lock on " + obj1);
        System.out.println(name + " finished execution.");
    }

    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
