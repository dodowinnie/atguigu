package com.brandon.cloud.api.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brandon.cloud.api.entities.Dept;


@FeignClient(value="cloud-dept", fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@GetMapping(value="/dept/add")
	public boolean addDept(Dept dept);

	@GetMapping(value = "/dept/get/{id}")
	public Dept findById(@PathVariable("id") Long id);

	@GetMapping(value="/dept/all")
	public List<Dept> findAll();

}
