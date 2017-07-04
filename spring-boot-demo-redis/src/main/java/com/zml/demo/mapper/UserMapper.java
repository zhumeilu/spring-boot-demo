package com.zml.demo.mapper;

import com.zml.demo.model.User;
import com.zml.demo.query.UserQueryObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "users")//缓存名称
public interface UserMapper {

    /**
     * 使用缓存
     * @param id
     * @return
     */
    @Cacheable
    User get(Long id);

    void insert(User user);
    void update(User user);
    List<User> list(UserQueryObject qo);
    void delete(Long id);
    User findByUsername(String username);
    Set<String> getRoleNamesByUserId(Long userId);
    Set<String> getPermissionsNameByRoleNames(@Param("roleNames") Set<String> roleNames);
}
