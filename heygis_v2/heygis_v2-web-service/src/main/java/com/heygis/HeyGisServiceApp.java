package com.heygis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * Service工程启动类
 * @author Administrator
 *
 */
@SpringBootApplication
public class HeyGisServiceApp {
	
	public static void main(String[] args) { 
		SpringApplication.run(HeyGisServiceApp.class, args);
	}

}
