//package com.learn.zhaoyulearn.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoginCheckAspect {
//
//    //private HttpSession session = null;
//
////    public LoginCheckAspect() {
////        this.session =null;int b = 0;
////    }
//
//    @Pointcut("execution(* com.learn.zhaoyulearn.controller.UserController.userList(..))")
//    public void pt(){}
//
//    @Before("pt()")
//    public void checkLogin(JoinPoint joinPoint) {
//        if (session.getAttribute("user") == null) {
//            throw new RuntimeException("请先登录");
//        }
//    }
//}
