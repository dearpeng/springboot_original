package com.honeypeng.component.pipeline;

/**
 * Created by PengWX on 2019/4/11.
 */
public class SecondValve implements Valve {
    protected Valve next = null;

    @Override
    public Valve getNext() {
        return next;
    }

    @Override
    public void invoke(String handling) {
        handling = handling.replaceAll("11", "22");
        System.out.println("Second阀门处理完后：" + handling);
        getNext().invoke(handling);
    }

    @Override
    public void setNext(Valve valve) {
        this.next = valve;
    }
}
