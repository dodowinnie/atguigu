package com.brandon.cloud.dept.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced // 开启ribbon负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 自定义算法----随机算法
	 * @return
	 */
//	@Bean
//	public IRule myRule() {
//		return new RandomRule();
//		return new RetryRule();
//	}

}
