package com.brandon.cloud.dept.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.brandon.cloud"})
@ComponentScan(basePackages= {"com.brandon.cloud"})
public class DeptConsumerFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeignApplication.class, args);
	}

}
