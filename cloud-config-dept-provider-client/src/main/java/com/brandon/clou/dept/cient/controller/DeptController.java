package com.brandon.clou.dept.cient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.clou.dept.cient.service.IDeptService;
import com.brandon.cloud.api.entities.Dept;

@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private IDeptService deptService;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@PostMapping("/add")
	
	public boolean addDept(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}
	
	@GetMapping("/get/{id}")
	public Dept findById(@PathVariable("id") Long id) {
		return deptService.findById(id);
	}
	
	@GetMapping("/all")
	public List<Dept> findAll(){
		return deptService.findAll();
	}
	
	@GetMapping("/discovery")
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		System.out.println("*************" + list);

		List<ServiceInstance> srvList = discoveryClient.getInstances("cloud-dept");
		for (ServiceInstance instance : srvList) {
			System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t"
					+ instance.getUri());
		}
		return discoveryClient;
	}

}
