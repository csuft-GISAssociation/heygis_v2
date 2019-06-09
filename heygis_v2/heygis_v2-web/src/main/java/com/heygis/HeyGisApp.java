package com.heygis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class HeyGisApp {
	
	public static void main(String[] args) {
		SpringApplication.run(HeyGisApp.class, args);
	}

}
