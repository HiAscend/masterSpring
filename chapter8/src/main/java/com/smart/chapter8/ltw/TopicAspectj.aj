package com.smart.chapter8.ltw;

public aspect TopicAspectj {
    private pointcut tracedCall():execution(* Topic.setTitle(..));
    before(): tracedCall() {
        System.out.println("---调用Topic.setTitle()-----");
        System.out.println("message:" + message);
        System.out.println("---调用Topic.setTitle()-----");
    }
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "message:" + this.message;
    }
}
