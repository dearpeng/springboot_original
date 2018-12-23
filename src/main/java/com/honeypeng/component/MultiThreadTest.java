package com.honeypeng.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by PengWX on 2018/12/7.
 */
public class MultiThreadTest implements Runnable {
    private Logger logger = LoggerFactory.getLogger(MultiThreadTest.class);

    @Override
    public void run() {
        logger.debug("MultiThreadProcessService-processSomething" + Thread.currentThread() + "......start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.debug("MultiThreadProcessService-processSomething" + Thread.currentThread() + "......end");
    }
}
