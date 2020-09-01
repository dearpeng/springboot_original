package com.honeypeng.service.impl;

import com.honeypeng.service.IDubboTestService;

/**
 * Created by PengWX on 2020/9/1.
 */
public class DubboTestServiceImpl implements IDubboTestService {

    @Override
    public String test() {
        return "测试dubbo spi";
    }
}
