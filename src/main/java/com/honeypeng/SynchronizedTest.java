// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SynchronizedTest.java

package com.honeypeng;


import com.honeypeng.bean.L;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.openjdk.jol.info.ClassLayout;

public class SynchronizedTest {

    public SynchronizedTest() {
    }

    public synchronized void doSth() {
        System.out.println("Hello World");
    }

    public void doSth1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        L l = new L();
        System.out.println("start");
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        synchronized (l) {
            System.out.println("locked");
        }
        System.out.println("end");

    }
    //方式一
       /* //一个数学表达式
        JEP jep = new JEP();
        //给变量赋值
        String exp = "((a+b)*(c+b))/(c+a)/b";
        jep.addVariable("a", 16);
        jep.addVariable("b", 5);
        jep.addVariable("c", 66);
        try { //执行
            jep.parseExpression(exp);
            Object result = jep.getValue();
            System.out.println("计算结果： " + result);
        } catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());
        }*/
    //方式二
        /*try {
            String exp = "((a+b)*(c+b))/(c+a)/b";
            JEP jep = new JEP();
            jep.addVariable("a", 16);
            jep.addVariable("b", 11);
            jep.addVariable("c", 66);
            Node parse = jep.parse(exp);
            Object evaluate = jep.evaluate(parse);
            System.out.println(evaluate);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
}
