package com.atweigou.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : RenChunMing
 * @Date : 2020/8/20 14:52.
 */
@Configuration
public class ApplicationContextConfig {
 @Bean
 @LoadBalanced//负载均衡能力
    public RestTemplate getRestTemplate(){
     return new RestTemplate();
    }
}
