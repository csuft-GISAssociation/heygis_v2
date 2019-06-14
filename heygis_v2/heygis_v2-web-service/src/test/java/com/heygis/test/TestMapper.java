package com.heygis.test;

import java.util.List;

import com.heygis.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.heygis.HeyGisServiceApp;
import com.heygis.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HeyGisServiceApp.class)
public class TestMapper {

	@Autowired
	private  UserMapper userMapper;

	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	
	@Test
	public void test(){
		List<Users> list = userMapper.queryUserList();
		System.out.println(list);
	}

	@Test
	public void redisTest(){
		String loginStatus = redisTemplate.boundValueOps("loginStatus").get();
		if(loginStatus==null){
			redisTemplate.boundValueOps("loginStatus").set("login");
		}
		System.out.println(loginStatus);
	}


	
	
}
