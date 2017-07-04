package com.zml.demo; /**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/3
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */

import com.zml.demo.mapper.UserMapper;
import com.zml.demo.model.User;
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
public class SpringBootDemoTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootDemoTest.class);

  @Autowired
  private UserMapper userMapper;
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
        userMapper.insert(user);
    }
    @Test
    public void cacheTest(){
        User user = userMapper.get(6L);
        User user2 = userMapper.get(6L);

    }
}
