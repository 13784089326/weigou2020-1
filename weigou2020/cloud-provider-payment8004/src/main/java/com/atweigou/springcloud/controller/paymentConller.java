package com.atweigou.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * @Author : RenChunMing
 * @Date : 2020/8/24 9:57.
 */
@RestController
@Slf4j
public class paymentConller {

    @Value("${server.port}")
    private String serverPort;//服务端口
    @RequestMapping(value = "payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();//流水号
    }
}
