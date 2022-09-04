package com.sample.InterceptorAgent;

import com.sample.InterceptorAgent.intercept.Interceptor;
import com.sample.outerClasses.KInterceptor;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Premain: Start InterceptorAgent to get running methods");

        String typeClass = "com.sample.InterceptorAgent.intercept.MethodAddition";
        String interceptedM = "methodAdding";

//------------------------------------------------------------------------------
//        ByteBuddyAgent.install();
//        new ByteBuddy()
//                .redefine(MethodAddition.class)
//                .method(named("methodAdding"))
//                .intercept(MethodDelegation.to(Interceptor.class))
//                .make()
//                .load(
//                        MethodAddition.class.getClassLoader(),
//                        ClassReloadingStrategy.fromInstalledAgent()
//                );
// ----------------------------------------------------------------------------------

// to add listener -> .with(AgentBuilder.Listener.StreamWriting.toSystemOut());

        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith(typeClass))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) ->
                        {
                            ClassFileLocator.Compound compound = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader),
                                    ClassFileLocator.ForClassLoader.ofSystemLoader());

                            System.out.println("Transforming method inside transformer");
                            return builder.method(ElementMatchers.named(interceptedM))
//                                    .intercept(MethodDelegation.to(TypePool.Default.of(compound).describe(interceptor).resolve()));
                                    //Intercepting method in outside package.
                                    .intercept(MethodDelegation.to(KInterceptor.class));
                                    //Intercepting method in current package.
//                                    .intercept(MethodDelegation.to(Interceptor.class));
                        }
                ).installOn(instrumentation);
    }
}