package com.snake.vue.service;

import com.snake.vue.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户业务层
 */
public interface UserService {

    List<User> queryAll();


    User queryUserById(Integer id);

    
    void updateUser(User user);
}
