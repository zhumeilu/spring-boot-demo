package com.zml.demo3; /**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/3
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */

import com.zml.demo3.model.User;
import com.zml.demo3.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/3
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo3Test {

    private Logger logger = LoggerFactory.getLogger(SpringBootDemo3Test.class);

    @Autowired
    private IUserService userService;
    @Test
    public void testLog(){
        logger.info("logger启动了");
    }
   // @Before
    public void before(){
        User user = new User();
        user.setName("hello");
        user.setUsername("hello");
        user.setPassword("123");
        userService.save(user);
    }
    @Test
    public void cacheTest(){
        User user = userService.get(6L);
        User user2 = userService.get(6L);

    }
}
