package com.smart.chapter5.dynamic;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * UserServiceNamespceHandler
 * Created by zziaa on 2017/10/12.
 */
public class UserServiceNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user-service", new UserServiceDefinitionParser());
    }
}
