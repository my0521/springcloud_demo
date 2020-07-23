package com.leslie.springcloud_demo.service.impl;

import com.leslie.springcloud_demo.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_Ok(Integer id) {
        return "线程池:\t"+Thread.currentThread().getName()+"\tpaymentInfo_Ok,id:\t"+id;
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {

        //手动控制睡眠秒数，用来模拟复杂程序的情况
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //模拟运行时错误
//        int temp = 10 / 0;

        return "线程池:\t"+Thread.currentThread().getName()+"\tpaymentInfo_Timeout,id:\t"+id;
    }

}
