package com.heygis.controller.test;

import java.util.List;

import com.heygis.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.service.UserService;

/**
 * 分布式环境之Controller测试
 * @author Administrator
 *
 */
//@RestController
@Controller
public class TestController {

	//引入User服务
	@Reference
	private UserService userService;

	/**
	 * 测试框架
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public List<Users> test(){
		return userService.queryUserList();
	}

	/*@RequestMapping("/vueTest")
	public  String vueTest(){
		return  "VueTest";
	}*/
	
}
