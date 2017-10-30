package com.smart.chapter6.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * MailSender
 *
 * @author ascend
 * @date 2017/10/30 11:06
 */
public class MailSender implements ApplicationContextAware {
    private ApplicationContext context;

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void sendMail(String to) {
        System.out.println("MailSender:模拟发送邮件...");
        MailSendEvent mailSendEvent = new MailSendEvent(this.context, to);
        // 向容器中所有的事件监听器发送事件
        context.publishEvent(mailSendEvent);
    }
}
