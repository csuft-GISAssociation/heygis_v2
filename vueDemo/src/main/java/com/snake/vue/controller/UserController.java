package com.snake.vue.controller;

import com.snake.vue.pojo.User;
import com.snake.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return  userService.queryAll();
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/findUserById/{id}")
    public  User findUserById(@PathVariable String id){
        //System.out.println(id);
        return  userService.queryUserById(Integer.parseInt(id));
    }

    /**
     * 根据用户id更新用户
     * @param user
     */
    @RequestMapping("/updateUser")
    public  void updateUser(@RequestBody  User user){
        userService.updateUser(user);
    }


}
