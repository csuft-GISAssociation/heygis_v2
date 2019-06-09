package com.snake.vue.service.impl;

import com.snake.vue.mapper.UserMapper;
import com.snake.vue.pojo.User;
import com.snake.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
