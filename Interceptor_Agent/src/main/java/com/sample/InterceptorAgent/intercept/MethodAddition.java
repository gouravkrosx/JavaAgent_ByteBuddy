package com.sample.InterceptorAgent.intercept;

public class MethodAddition {

    public MethodAddition() {
        System.out.println("MethodAddition Constructor was called");
    }

    public Integer methodAdding() {
        System.out.println("This is new method : methodAdding");
        return 10;
    }
}
