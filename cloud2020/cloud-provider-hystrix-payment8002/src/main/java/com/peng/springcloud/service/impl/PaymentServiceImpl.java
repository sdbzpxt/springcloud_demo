package com.peng.springcloud.service.impl;

import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.mapper.PaymentMapper;
import com.peng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Descript 交费记录业务实现类类
 *
 * @author sdbzpxt
 * @date 2021/5/16
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int add(Payment payment) {
        return paymentMapper.add(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentMapper.getPaymentById(id);
    }
}
