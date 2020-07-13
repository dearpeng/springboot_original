package com.honeypeng;


import com.honeypeng.bean.Person;
import com.honeypeng.config.AppConfig;
import com.honeypeng.config.MyConfig;
import com.honeypeng.service.impl.EmployeeServiceImpl;
import com.honeypeng.utils.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootfirstApplicationTests {
    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private DataSource dataSource;





    @Autowired
    private HttpServletRequest request;
    @Test
    public void test111(){
        System.out.println("============================");

       /* System.out.println(context);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/
        /*System.out.println("============================");
        Object myFactory1 = context.getBean("myFactory");
        Object myFactory2 = context.getBean("myFactory");
        System.out.println(myFactory1 == myFactory2);
        //此时我们的bean类型是我们创建factory里面那个对象的类型.可以通过加上  &符号获取到myFactory本身类型
        System.out.println(myFactory1.getClass());
        Object myFactory3 = context.getBean("&myFactory");
        System.out.println(myFactory3.getClass());*/

    }

    @Test
    public void testInnit() {
//        new ClassPathXmlApplicationContext("spring.xml");
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean(EmployeeServiceImpl.class));
    }

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource);
        System.out.println("=========================");
        System.out.println(dataSource.getConnection());
    }

//    @Autowired
//    private ThreadPoolExecutor taskExecutor;

	/*@Autowired
    private ActivemqProducer producer;

	@Autowired
	private SpringBootActivemqProducer springBootActivemqProducer;*/


    @Test
    public void downloadFile() {
       /* ServletContext ctx = request.getServletContext();
        String path = ctx.getRealPath("/uploadfile");
        String fileName = UUID.randomUUID().toString();*/
//        downloadImage("http://img.zahuiyin.com/zahy/cls/secondhand_car/2019/1/7/92aa5bca-abef-4307-8c5a-c601126858c1.pdf", path);
//        downLoadFromUrl("http://img.zahuiyin.com/zahy/cls/secondhand_car/2019/1/7/92aa5bca-abef-4307-8c5a-c601126858c1.pdf", path);
        Integer integer = new Integer(1);
        System.out.println(Objects.equals(integer, 1));

//        delAllFile(path);
//        download("http://img.zahuiyin.com/zahy/cls/secondhand_car/2019/1/7/92aa5bca-abef-4307-8c5a-c601126858c1.pdf", path,fileName);
    }

    /**
     * 删除单个文件
     *
     * @param fileName 被删除文件的文件名
     * @return 单个文件删除成功返回true, 否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.isFile() && file.exists()) {
            file.delete();
            System.out.println("删除单个文件" + fileName + "成功！");
            return true;
        } else {
            System.out.println("删除单个文件" + fileName + "失败！");
            return false;
        }
    }


    // 删除指定文件夹下所有文件
    // param path 文件夹完整绝对路径
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
//                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }


    public static void downloadImage(String Imageurl, String path) {
        try {
            URL url = new URL(Imageurl);
            //打开网络输入流
            DataInputStream dis = new DataInputStream(url.openStream());
            String fileName = UUID.randomUUID().toString();
            String newImageName = path + "\\" + fileName + ".pdf";
            //建立一个新的文件
            FileOutputStream fos = new FileOutputStream(new File(newImageName));
            byte[] buffer = new byte[1024];
            int length;
            //开始填充数据
            while ((length = dis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            dis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void download(String urlString, String savePath, String filename) {
        InputStream is = null;
        OutputStream os = null;
        HttpURLConnection con = null;
        try {
            // 构造URL
            URL url = new URL(urlString);
            // 打开连接
            con = (HttpURLConnection) url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("connection", "keep-alive");
            con.setReadTimeout(30000);
            con.setUseCaches(false);
            con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            con.connect();
            is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1048576];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf = new File(savePath);
            if (!sf.exists()) {
                sf.mkdirs();
            }
            os = new FileOutputStream(sf.getPath() + "\\" + filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            if (Objects.nonNull(os)) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(is)) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                con.disconnect();
            }

        }

    }


    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String savePath) {
        FileOutputStream fos = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(urlStr);
            String fileName = UUID.randomUUID().toString();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            //得到输入流
            inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName + ".pdf");
            fos = new FileOutputStream(file);
            fos.write(getData);

            System.out.println("info:" + url + " download success");
            try {
                java.lang.Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            deleteFile(saveDir + File.separator + fileName + ".pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


    public static File saveUrlAs(String url, String filePath, String method) {
        //System.out.println("fileName---->"+filePath);
        //创建不同的文件夹目录
        File file = new File(filePath);
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            // 建立链接
            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {

                filePath += "/";

            }
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            String uuid = UUID.randomUUID().toString();
            fileOut = new FileOutputStream(filePath + uuid + ".pdf");
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[4096];
            int length = bis.read(buf);
            //保存文件
            while (length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常！！");
        }

        return file;

    }


    @Test
    public void testHello() {
        boolean helloService = context.containsBean("helloService");
        System.out.println(helloService);
        System.out.println("=============================================");
    }

    @Test
    public void testHello1() {
        System.out.println("--------------------------------------------------");
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        System.out.println(MD5.md5Hex("123456", s));
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
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
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
