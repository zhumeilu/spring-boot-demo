package com.zml.demo.controller;/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/4
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */

import com.zml.demo.mapper.UserMapper;
import com.zml.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/4
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/users/{id}")
    @ResponseBody
    public User get(@PathVariable Long id){
        User user = userMapper.get(id);
        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "user_"+id;
        if (!this.template.hasKey(key)) {
            ops.set(key,user.getUsername());
        }
        return user;
    }
}
