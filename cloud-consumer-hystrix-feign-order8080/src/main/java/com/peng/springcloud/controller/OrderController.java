package com.peng.springcloud.controller;

import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.service.feign.PaymentFeignService;
import com.peng.springcloud.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/order/payment/getOK/{id}")
    public ServiceResult<Payment> getOK(@PathVariable("id") Integer id){
        log.info("PaymentController======>getOK,the port is "+port);
        ServiceResult<Payment> result = paymentFeignService.getOK(id);
        log.info("/order/payment/getOK/"+id+"--"+result);
        return result;
    }

    @GetMapping("/order/payment/getTimeOut/{id}/{timeout}")
    public ServiceResult<Payment> getTimeOut(@PathVariable("id") Integer id,@PathVariable("timeout") Integer timeout){
        log.info("PaymentController======>getTimeOut,the port is "+port+"id="+id+" timeout="+timeout);
        ServiceResult<Payment> result = paymentFeignService.getTimeOut(id,timeout);
        log.info("/order/payment/getTimeOut/"+id+"--"+result);
        return result;
    }
}
