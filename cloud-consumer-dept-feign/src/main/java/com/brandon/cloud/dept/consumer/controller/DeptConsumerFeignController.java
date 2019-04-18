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
import com.brandon.cloud.api.service.DeptClientService;


@RestController
@RequestMapping("/feign")
public class DeptConsumerFeignController {

	@Autowired
	private DeptClientService deptClientService;
	
	
	@PostMapping("/add")
	public boolean addDept(Dept dept) {
		return deptClientService.addDept(dept);
	}

	@GetMapping("/get/{id}")
	public Dept findById(@PathVariable("id") Long id) {
		return deptClientService.findById(id);
	}

	@GetMapping("/all")
	public List<Dept> findAll() {
		return deptClientService.findAll();
	}
}
