package com.honeypeng.component.pipeline;

/**
 * Created by PengWX on 2019/4/11.
 */
public class StandardPipeline implements Pipeline {
    protected Valve first = null;
    protected Valve basic = null;

    @Override
    public void addValve(Valve valve) {
        if (first == null) {
            first = valve;
            //basic作为最后节点
            valve.setNext(basic);
        } else {
            Valve current = first;
            while (current != null) {
                //第一个节点的时候设置过后一个是basic
                if (current.getNext() == basic) {
                    //设置下一个节点
                    current.setNext(valve);
                    valve.setNext(basic);
                    break;
                }
                current = current.getNext();
            }
        }
    }

    @Override
    public Valve getBasic() {
        return basic;
    }

    @Override
    public Valve getFirst() {
        return first;
    }

    @Override
    public void setBasic(Valve valve) {
        this.basic = valve;
    }
}
