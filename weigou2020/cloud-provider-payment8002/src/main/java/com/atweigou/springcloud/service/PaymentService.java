package com.atweigou.springcloud.service;

import com.atweigou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author : RenChunMing
 * @Date : 2020/8/19 15:07.
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
