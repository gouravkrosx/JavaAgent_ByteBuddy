package com.sample.agent.advices;

import net.bytebuddy.asm.Advice;

public class MethodAdvice {

    @Advice.OnMethodEnter
    static void enterMethods(@Advice.Origin String method) throws Exception {
    }

    @Advice.OnMethodExit
    static void exitMethods(@Advice.Origin String method) throws Exception {
        System.out.println(method);
    }
}