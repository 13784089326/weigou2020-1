package com.atweigou.springcloud.controller;

import com.atweigou.springcloud.entities.CommonResult;
import com.atweigou.springcloud.entities.Payment;
import com.atweigou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : RenChunMing
 * @Date : 2020/8/19 15:12.
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;//服务端口
    @Resource
    private DiscoveryClient discoveryClient;//服务发现
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("------------插入结果："+result);
        if (result > 0){
            return new CommonResult(200,"插入数据成功,serverPort"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("------------查询结果 ："+payment);
        if (payment != null){
            return new CommonResult(200,"查询数据成功,serverPort"+serverPort,payment);
        }else{
            return new CommonResult(444,"无记录，查询ID"+id,null);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//服务列表
        for (String element : services){
            log.info("*********element"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");//通过微服务名称进一步获得服务的相关信息（微服务名称下的全部具体实例）
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
