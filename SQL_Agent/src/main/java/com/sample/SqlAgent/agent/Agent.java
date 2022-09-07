package com.sample.SqlAgent.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static net.bytebuddy.matcher.ElementMatchers.named;

public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Premain: Start Advice Agent to get running methods");
        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .type(ElementMatchers.named("com.mysql.jdbc.MysqlIO"))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) -> {
                    System.out.println("Inside Sql Transformer");
                    return builder.method(isFinal().and(named("sqlQueryDirect"))
                                    .and(returns(named("com.mysql.jdbc.ResultSetInternalMethods"))))
                            .intercept(MethodDelegation.to());
//                        .defineMethod("getAllMethods", void.class, Visibility.PUBLIC)
//                        .intercept(MethodDelegation.to(MethodAddition.class))
//                        .method(ElementMatchers.nameContains("method2"))
//                        .intercept(SuperMethodCall.INSTANCE
//                                           .andThen(MethodCall.invoke(ElementMatchers.nameContains("getAllMethods"))))
                }).installOn(instrumentation);
    }
}