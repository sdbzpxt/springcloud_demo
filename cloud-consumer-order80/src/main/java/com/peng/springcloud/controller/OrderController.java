package com.peng.springcloud.controller;

import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.util.Constant;
import com.peng.springcloud.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Descript 订单控制层类
 *
 * @author sdbzpxt
 * @date 2021/5/16
 */
@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/payment/add")
    public ServiceResult add(Payment payment){
        log.info("PaymentController======>add,the port is "+port);
        ServiceResult result = restTemplate.postForObject(Constant.ORDER_SERVICE_URL+"/payment/add",payment,ServiceResult.class);
        log.info("/order/payment/add--"+result);
        return result;
    }

    @GetMapping("/order/payment/get/{id}")
    public ServiceResult<Payment> get(@PathVariable("id") Integer id){
        log.info("PaymentController======>add,the port is "+port);
        ServiceResult<Payment> result = restTemplate.getForObject(Constant.ORDER_SERVICE_URL+"/payment/get/"+id,ServiceResult.class);
        log.info("/order/payment/get/"+id+"--"+result);
        return result;
    }
}
