package com.brandon.clou.dept.cient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ConfigDeptClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigDeptClientApplication.class, args);
	}

}
