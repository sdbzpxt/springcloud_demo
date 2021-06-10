package com.peng.springcloud.service.feign;

import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.util.ServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFeignFallBack.class)
public interface PaymentFeignService {

    @GetMapping("/payment/getOK/{id}")
    public ServiceResult<Payment> getOK(@PathVariable("id") Integer id);

    @GetMapping("/payment/getTimeOut/{id}/{timeout}")
    public ServiceResult<Payment> getTimeOut(@PathVariable("id") Integer id,@PathVariable("timeout") Integer timeout);
}
