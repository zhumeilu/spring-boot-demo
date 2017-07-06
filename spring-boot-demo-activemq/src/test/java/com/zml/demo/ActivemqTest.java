package com.zml.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;


/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/6
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivemqTest {
    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("mytest.queue");

        for(int i=0; i<10; i++){
            producer.sendMessage(destination, "myname is hello!!!");
        }
    }

}
