package com.atweigou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author : RenChunMing
 * @Date : 2020/8/21 9:50.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain9529 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain9529.class,args);
    }
}
