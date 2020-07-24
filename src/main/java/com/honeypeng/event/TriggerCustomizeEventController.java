package com.honeypeng.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by PengWX on 2020/7/23.
 */
@Controller
public class TriggerCustomizeEventController {

    @Autowired
    private CustomizeEventPublisher customizeEventPublisher;

    @RequestMapping("publish")
    @ResponseBody
    public void publishEvent(){
        customizeEventPublisher.publishEvent();
    }
}

