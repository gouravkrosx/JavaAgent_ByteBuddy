package com.sample.AdviceAgent.advices;

import net.bytebuddy.asm.Advice;

public class MethodAdvice {

    @Advice.OnMethodEnter
    static void enterMethods(@Advice.Origin String method) throws Exception {
        System.out.println("Inside onMethodEnter advice-> " + method);
    }

    @Advice.OnMethodExit
    static void exitMethods(@Advice.Origin String method) throws Exception {
        System.out.println("Inside OnMethodExit advice -> " + method);
    }
}