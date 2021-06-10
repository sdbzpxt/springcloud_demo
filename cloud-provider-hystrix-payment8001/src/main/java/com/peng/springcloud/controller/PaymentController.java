package com.peng.springcloud.controller;

import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.service.PaymentService;
import com.peng.springcloud.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/getOK/{id}")
    public ServiceResult<Payment> getOK(@PathVariable("id") Integer id){
        log.info("PaymentController======>getOK,the port is "+port);
        log.info("PaymentController======>getOK,the param id:"+id);
        if(id==null){
            return new ServiceResult(300,"参数为空!");
        }
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new ServiceResult(200,"操作成功",payment,port);
        }
        return new ServiceResult(400,"信息不存在",null,port);
    }

    @GetMapping("/payment/getTimeOut/{id}/{timeout}")
    public ServiceResult<Payment> getTimeOut(@PathVariable("id") Integer id,@PathVariable("timeout") Integer timeout){
        log.info("PaymentController======>getTimeOut,the port is "+port);
        log.info("PaymentController======>getTimeOut,the param id:"+id +" timeout:"+timeout);
        if(id==null){
            return new ServiceResult(300,"参数为空!");
        }
        if (timeout!=null && timeout.intValue()>0) {
            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Payment payment = paymentService.getPaymentById(id);
        log.info("PaymentController======>getTimeOut,payment:"+payment);
        if(payment!=null){
            return new ServiceResult(200,"操作成功,耗时"+timeout+"秒",payment,port);
        }
        return new ServiceResult(400,"信息不存在",null,port);
    }
}
