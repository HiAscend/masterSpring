package com.smart.chapter6.event;

import org.springframework.context.ApplicationListener;

/**
 * MailSendListener
 *
 * @author ascend
 * @date 2017/10/30 11:02
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        System.out.println("MailSendListener:向" + event.getTo() + "发送完一封邮件");
    }
}
