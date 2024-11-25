package com.learn.zhaoyulearn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ServiceFirst {
    @Autowired
    @Lazy
    private ServiceSecond serviceSecond;
    public String print() {
        return "service first print";
    }

    public String invokeServiceSecondPrint() {
//        ServiceSecond serviceSecond = new ServiceSecond();
        return serviceSecond.print();
    }


}
