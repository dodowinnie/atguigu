package com.brandon.cloud.dept.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.brandon.cloud.dept.rules.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="cloud-dept",configuration=MySelfRule.class)
public class DeptConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerApplication.class, args);
	}

}
