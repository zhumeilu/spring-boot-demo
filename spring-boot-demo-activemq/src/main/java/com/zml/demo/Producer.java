package com.zml.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import javax.jms.Destination;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/6
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
@Service("producer")
public class Producer {
    //@Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
   // private JmsMessagingTemplate jmsTemplate;
    @Autowired
    private JmsTemplate jmsTemplate2;
    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        jmsTemplate2.convertAndSend(destination, message);
    }
}
