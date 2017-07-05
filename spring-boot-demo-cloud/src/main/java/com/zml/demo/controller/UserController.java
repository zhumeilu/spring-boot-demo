package com.zml.demo.controller;

import com.zml.demo.mapper.UserMapper;
import com.zml.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    private UserMapper userMapper;

    @RequestMapping("/users/{id}")
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user = userMapper.get(id);
        System.out.println("abcd");
        return user;
    }

    @RequestMapping("/users")
    @ResponseBody
    public List<User> list() {
        List<User> userList = userMapper.listAll();
        return userList;
    }
}
