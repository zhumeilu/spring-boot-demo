package com.zml.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/6
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Customer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
    }
}
