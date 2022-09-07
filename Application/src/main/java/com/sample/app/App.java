package com.sample.app;

import com.sample.AdviceAgent.advices.AdviceMethodAddition;
import com.sample.InterceptorAgent.intercept.MethodAddition;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Main: Hello World!");

        System.out.println("Calling Method Addition from main");

        // to check advice agent
//        System.out.println("getting response from methodAdding4Advice of AdviceMethodAddition: " + new AdviceMethodAddition().methodAdding4Advice());

        // to check interceptor agent
        System.out.println("getting response from methodAdding of MethodAddition: " + new MethodAddition().methodAdding());
    }
}
