package com.honeypeng;

/**
 * Created by PengWX on 2019/10/23.
 */
public class HelloB extends HelloA{
    public HelloB() {
        System.out.println("HelloB");
    }

    /**
     * 构造代码块
     */
    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("static B");
    }

    /**
     * 执行结果:(父类子类从上到下依次执行静态代码块,在执行构造代码块,再执行构造函数)
     * static A
     * static B
     * I'm A class
     * HelloA
     * I'm B class
     * HelloB
     * @param args
     */
    public static void main(String[] args) {
        new HelloB();
    }
}
