package com.honeypeng.component.pipeline;


/**
 * Created by PengWX on 2019/4/11.
 */
public interface Pipeline {
    public Valve getFirst();
    public Valve getBasic();
    public void setBasic(Valve valve);
    public void addValve(Valve valve);
}
