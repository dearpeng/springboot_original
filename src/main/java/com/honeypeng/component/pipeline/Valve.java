package com.honeypeng.component.pipeline;


/**
 * Created by PengWX on 2019/4/11.
 */
public interface Valve{
    public Valve getNext();
    public void setNext(Valve valve);
    public void invoke(String handling);
}
