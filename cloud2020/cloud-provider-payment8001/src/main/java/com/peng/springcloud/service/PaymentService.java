package com.peng.springcloud.service;

import com.peng.springcloud.entities.Payment;

/**
 * Descript 交费业务层接口接口
 *
 * @author sdbzpxt
 * @date 2021/5/16
 */
public interface PaymentService {

    public int add(Payment payment);

    public Payment getPaymentById(Integer id);
}
