package com.peng.springcloud.mapper;

import com.peng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Descript 接口
 *
 * @author sdbzpxt
 * @date 2021/5/16
 */
@Mapper
public interface PaymentMapper {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
