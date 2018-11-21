package com.honeypeng;


import com.honeypeng.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

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

        String[] regulation = {"鲁班", "诸葛亮", "貂蝉", "吕布"};
        final List<String> regulationOrder = Arrays.asList(regulation);
        String[] ordered = {"貂蝉", "诸葛亮", "吕布", "貂蝉", "鲁班", "诸葛亮", "貂蝉", "鲁班", "诸葛亮"};
        List<String> orderedList = Arrays.asList(ordered);
        Collections.sort(orderedList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                int io1 = regulationOrder.indexOf(o1);
                int io2 = regulationOrder.indexOf(o2);
                return io1 - io2;
            }
        });
        System.out.println(orderedList);
        String[] tiMu = new String[20];
        for (int i = 0; i < tiMu.length; i++) {
            tiMu[i] = "第" + (i + 1) + "题";
        }
        String[] temp = new String[10];
        //开始抽取题目
        //产生10个随机数
        List<Integer> list = new ArrayList<Integer>();
        int i;
        while (list.size() < 10) {
            i = (int) (Math.random() * 20);
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        for (int j = 0; j < list.size(); j++) {
            temp[j] = tiMu[list.get(j)];
        }
        for (int iloop = 0; iloop < temp.length; iloop++) {
            System.out.print(temp[iloop] + "   ");
        }
    }

}
