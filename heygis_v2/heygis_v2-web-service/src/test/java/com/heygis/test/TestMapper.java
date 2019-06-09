package com.heygis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.heygis.HeyGisServiceApp;
import com.heygis.mapper.UserMapper;
import com.heygis.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HeyGisServiceApp.class)
public class TestMapper {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test(){
		List<User> list = userMapper.queryUserList();
		System.out.println(list);
	}
	
	
}
