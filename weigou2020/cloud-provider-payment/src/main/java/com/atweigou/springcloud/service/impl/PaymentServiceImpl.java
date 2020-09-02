package com.atweigou.springcloud.service.impl;

import com.atweigou.springcloud.dao.PaymentDao;
import com.atweigou.springcloud.entities.Payment;
import com.atweigou.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author : RenChunMing
 * @Date : 2020/8/19 15:02.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
