package com.zml.demo.controller;

import com.zml.demo.mapper.UserMapper;
import com.zml.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/4
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
@Api(value = "用户管理",description="用户列表，用户增删改查")
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @ApiOperation("根据id获取用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        User user = userMapper.get(id);
        System.out.println("abcd");
        return user;
    }
    @ApiOperation("用户列表")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> list() {
        List<User> userList = userMapper.listAll();
        return userList;
    }
}
