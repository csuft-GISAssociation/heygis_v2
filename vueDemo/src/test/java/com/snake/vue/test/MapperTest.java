package com.snake.vue.test;

import com.snake.vue.VueApp;
import com.snake.vue.mapper.UserMapper;
import com.snake.vue.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Mapper测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VueApp.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        System.out.println(userMapper.queryAll());
    }

    @Test
    public void testFindUserById(){
        System.out.println(userMapper.queryUserById(1));
    }

    @Test
    public void updateUser(){
       User user = userMapper.queryUserById(1);
       user.setAge(44);
       userMapper.updateUser(user);
    }


}
