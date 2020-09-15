package com.sample.agent;

import net.bytebuddy.asm.Advice;

public class MethodAdvice {

    @Advice.OnMethodExit
    static void getAllMethods(@Advice.Origin String method) throws Exception {
        System.out.println(method);
    }
}