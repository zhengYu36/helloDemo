package com.example.demo.controller;

import com.example.demo.config.MqttGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * date: 2020/04/26 14:58
 *
 * @author unreal
 */
@RestController
@RequestMapping("/api")
public class MqttController {
    @Autowired
    MqttGateWay mqttGateWay;

    @PostMapping("/publish")
    public String publish(String toplic, String message) {
        System.out.println(toplic + ":" + message);
        mqttGateWay.sendToMqtt(toplic, message);
        return "success";
    }


}

