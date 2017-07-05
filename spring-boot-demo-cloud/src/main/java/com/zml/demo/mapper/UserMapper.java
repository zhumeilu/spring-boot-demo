package com.zml.demo.mapper;

import com.zml.demo.model.User;
import com.zml.demo.query.UserQueryObject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/6/30
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
@Component  //为了消除Controller里面的红线警告
@Mapper
public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    List<User> listAll();

    @Select("select * from user where id = #{id}")
    User get(Long id);

}
