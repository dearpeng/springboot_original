package com.honeypeng.future;


import java.util.concurrent.*;

/**
 * Created by PengWX on 2020/8/7.
 */
public class FutureTest {

    private static final ExecutorService excutor = Executors.newSingleThreadExecutor();

    public static Future calculate(Integer input) {
        return excutor.submit(() -> {
            Thread.sleep(100);
            return input * input;
        });
    }

    public static void main(String[] args) {
        Future calculate = calculate(200);
        Object o = null;
        try {
            o = calculate.get(2, TimeUnit.MICROSECONDS);
            System.out.println(o);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(calculate.isDone());;
    }


}
