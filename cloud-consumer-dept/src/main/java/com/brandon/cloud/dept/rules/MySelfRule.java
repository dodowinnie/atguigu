package com.brandon.cloud.dept.rules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {
	
	@Bean
	public IRule getMySelfRule() {
		return new MyRule(); // 自定义轮询算法
	}

}
