package com.heygis.cms.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式环境之Controller测试
 * @author Administrator
 *
 */
@RestController
public class TestController {

	@RequestMapping("/test")
	public String test(){
		return "test success";
	}
	
}
