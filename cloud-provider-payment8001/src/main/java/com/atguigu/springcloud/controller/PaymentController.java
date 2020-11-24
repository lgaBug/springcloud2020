package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: Andy
 * @Date: 2020/11/24 11:21
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
            int result = paymentService.create(payment);
            log.info("****插入结果："+result);
            if (result > 0) {
                return CommonResult.successCommonResult("插入成功", result);
            }
        return CommonResult.errorCommonResult("插入失败", result);
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果："+result);
        if (result != null) {
            return CommonResult.successCommonResult("查询成功", result);
        }
        return CommonResult.errorCommonResult("没有对应记录，查询id:"+id, result);
    }


}
