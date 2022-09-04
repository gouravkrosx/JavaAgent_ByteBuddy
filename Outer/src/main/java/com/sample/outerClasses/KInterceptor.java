package com.sample.outerClasses;


import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;


public class KInterceptor {

    public KInterceptor() {
        System.out.println("KInterceptor was called");
    }

    public static Integer log(@SuperCall Callable callable) throws Exception {
        System.out.println("Inside KInterceptor after method delegation : yes it's working surprisingly");
        Integer i = Integer.valueOf(12);
        return i + (Integer) callable.call();
    }
//    public static void kinterceptorMethod() {
//        System.out.println("This is new method : inside kInterceptor");
//    }
}
