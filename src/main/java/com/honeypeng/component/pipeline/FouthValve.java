package com.honeypeng.component.pipeline;

/**
 * Created by PengWX on 2019/4/11.
 */
public class FouthValve implements Valve{
    protected Valve next = null;

    @Override
    public Valve getNext() {
        return next;
    }

    @Override
    public void invoke(String handling) {
        handling = handling.replaceAll("zz", "yy");
        System.out.println("fouth阀门处理完后：" + handling);
        getNext().invoke(handling);
    }

    @Override
    public void setNext(Valve valve) {
        this.next = valve;
    }
}
