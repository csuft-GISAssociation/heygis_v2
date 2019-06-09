package com.snake.vue.mapper;

import com.snake.vue.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户持久层
 */
@Mapper
public interface UserMapper {


    @Select("select * from users")
    List<User> queryAll();

    @Select("select * from users where id = #{id}")
    User queryUserById(Integer id);

    @Update("update users set username=#{username},password=#{password},sex=#{sex}," +
            "age=#{age},email=#{email} where id = #{id}")
    void updateUser(User user);

}
