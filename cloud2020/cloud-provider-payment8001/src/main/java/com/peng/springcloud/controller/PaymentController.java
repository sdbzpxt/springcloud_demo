package com.peng.springcloud.controller;

import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.service.PaymentService;
import com.peng.springcloud.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Descript 交费信息控制层类
 *
 * @author sdbzpxt
 * @date 2021/5/16
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/add")
    public ServiceResult add(@RequestBody Payment payment){
        log.info("PaymentController======>add,the port is "+port);
        log.info("PaymentController======>add,the param:"+payment);
        if(payment==null){
            return new ServiceResult(300,"参数为空!");
        }
        int result = paymentService.add(payment);
        if(result>0){
            return new ServiceResult(200,"操作成功",null,port);
        }
        return new ServiceResult(400,"操作失败",null,port);
    }

    @GetMapping("/payment/get/{id}")
    public ServiceResult<Payment> get(@PathVariable("id") Integer id){
        log.info("PaymentController======>add,the port is "+port);
        log.info("PaymentController======>get,the param id:"+id);
        if(id==null){
            return new ServiceResult(300,"参数为空!");
        }
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new ServiceResult(200,"操作成功",payment,port);
        }
        return new ServiceResult(400,"信息不存在",null,port);
    }
}
