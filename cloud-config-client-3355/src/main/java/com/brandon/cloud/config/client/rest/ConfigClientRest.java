package com.brandon.cloud.config.client.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	
	@Value("${spring.application.name}")
	private String applicactionName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServer;
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	public String getConfig() {
		String str = "applicactionName:" + applicactionName + "\t eurekaServer:" + eurekaServer + "\t port:" + port;
		System.out.println("=====str:" + str);
		return str;
	}

}
