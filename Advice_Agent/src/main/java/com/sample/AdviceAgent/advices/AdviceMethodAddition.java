package com.sample.AdviceAgent.advices;

public class AdviceMethodAddition {

    public AdviceMethodAddition() {
        System.out.println("AdviceMethodAddition Constructor was called");
    }

    public Integer methodAdding4Advice() {
        System.out.println("MethodAddition: Inside methodAdding4Advice()");
        return 10;
    }
}
