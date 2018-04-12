package com.smart.chapter17.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.concurrent.TimeUnit;

/**
 * MyWebSocketHandler
 *
 * @author ascend
 * @date 2018/4/12 11:47.
 */
public class MyWebSocketHandler  extends AbstractWebSocketHandler{
    private static final Logger LOG = LoggerFactory.getLogger(MyWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOG.debug("connection establish success!");
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 处理文本消息
        LOG.debug("收到消息：{}", message.getPayload());
        // 模拟延时
        TimeUnit.SECONDS.sleep(2);
        // 发送文本消息
        LOG.debug("发送文本消息：Hello client");
        session.sendMessage(new TextMessage("Hello client"));
        super.handleTextMessage(session, message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOG.debug("connection closed!");
        super.afterConnectionClosed(session, status);
    }
}
