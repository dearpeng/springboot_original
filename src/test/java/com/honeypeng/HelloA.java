package com.honeypeng;

/**
 * Created by PengWX on 2019/10/23.
 */
public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }

    { System.out.println("I'm A class"); }

    static { System.out.println("static A"); }
}
