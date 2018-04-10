package com.smart.chapter17.groovy

/**
 * HelloGroovy
 *
 * @author ascend
 * @date 2018/4/9 14:28.
 */
class HelloGroovy {
    public String userName

    static void main(String[] args) {
        println "HelloGroovy.sayHi"
    }

    static String sayHi(Binding binding) {
        println "HelloGroovy.sayHi"
        def userName = binding.getVariable("userName")
        println userName
        return "hi "+ userName
    }

    String getUserName() {
        return userName
    }

    void setUserName(String userName) {
        this.userName = userName
    }

    String sayHello(String name) {
        return "hello " + name
    }
}
