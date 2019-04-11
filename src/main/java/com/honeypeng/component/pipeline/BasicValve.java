package com.honeypeng.component.pipeline;


/**
 * Created by PengWX on 2019/4/11.
 */
public class BasicValve implements Valve {
    protected Valve next = null;

    @Override
    public Valve getNext() {
        return next;
    }

    @Override
    public void invoke(String handling) {
        handling = handling.replaceAll("aa", "bb");
        System.out.println("基础阀门处理完后：" + handling);
    }

    @Override
    public void setNext(Valve valve) {
        this.next = valve;
    }
}