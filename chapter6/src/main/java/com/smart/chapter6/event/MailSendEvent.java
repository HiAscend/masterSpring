package com.smart.chapter6.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * MailSendEvent
 *
 * @author ascend
 * @date 2017/10/30 10:59
 */
public class MailSendEvent extends ApplicationContextEvent{
    private String to;

    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }
}
