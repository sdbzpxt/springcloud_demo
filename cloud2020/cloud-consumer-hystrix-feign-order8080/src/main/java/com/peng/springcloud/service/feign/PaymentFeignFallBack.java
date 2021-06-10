package com.peng.springcloud.service.feign;

import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.util.ServiceResult;
import org.springframework.stereotype.Component;

/**
 * 服务降级处理
 */
@Component
public class PaymentFeignFallBack implements PaymentFeignService{
    @Override
    public ServiceResult<Payment> getOK(Integer id) {
        return new ServiceResult<>(500,"getOK服务降级处理");
    }

    @Override
    public ServiceResult<Payment> getTimeOut(Integer id, Integer timeout) {
        return new ServiceResult<>(500,"getTimeOut服务降级处理");
    }
}
