package com.atweigou.springcloud.dao;

import com.atweigou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author : RenChunMing
 * @Date : 2020/8/19 14:37.
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
