package com.learn.zhaoyulearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ServiceSecond {
    @Autowired
    @Lazy
    private ServiceFirst serviceFirst;

    public String print() {
        return "service second print";
    }

    public String invokeServiceFirstPrint() {
//        ServiceFirst serviceFirst = new ServiceFirst();
        return serviceFirst.print();
    }
}
