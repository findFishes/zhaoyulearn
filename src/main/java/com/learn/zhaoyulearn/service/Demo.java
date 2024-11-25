package com.learn.zhaoyulearn.service;

public class Demo {
    public static ServiceFirst serviceFirst = new ServiceFirst();
    public static ServiceSecond serviceSecond = new ServiceSecond();

    public static void main(String[] args) {


        System.out.println("===============>>>" + serviceFirst.invokeServiceSecondPrint());


        System.out.println("===============>>>" + serviceSecond.invokeServiceFirstPrint());



    }
}
