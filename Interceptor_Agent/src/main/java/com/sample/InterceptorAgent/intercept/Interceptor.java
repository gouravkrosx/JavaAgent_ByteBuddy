package com.sample.InterceptorAgent.intercept;

import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;


public class Interceptor {

    public Interceptor() {
        System.out.println("Interceptor was called");
    }

    public static Integer log(@SuperCall Callable callable) throws Exception {
        System.out.println("Inside Interceptor after method delegation");
        Integer i = Integer.valueOf(12);
        return i + (Integer) callable.call();
    }
//    public static void interceptorMethod() {
//        System.out.println("This is new method : inside Interceptor");
//    }
}
