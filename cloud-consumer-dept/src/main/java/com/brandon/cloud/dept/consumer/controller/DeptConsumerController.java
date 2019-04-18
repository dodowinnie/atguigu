package com.brandon.cloud.dept.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brandon.cloud.api.entities.Dept;

@RestController
@RequestMapping("/dept_consumer")
public class DeptConsumerController {

//	private static final String URL_PREFIX = "http://localhost:8001";
	private static final String URL_PREFIX = "http://cloud-dept";

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;

	@PostMapping("/add")
	public boolean addDept(Dept dept) {
		return restTemplate.postForObject(URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@GetMapping("/get/{id}")
	public Dept findById(@PathVariable("id") Long id) {
		return restTemplate.getForObject(URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/all")
	public List<Dept> findAll() {
		return restTemplate.getForObject(URL_PREFIX + "/dept/all", List.class);
	}

	
	@GetMapping("/getDiscovery")
	public Object discovery() {
		return restTemplate.getForObject(URL_PREFIX + "/dept/discovery", Object.class);
	}

}
