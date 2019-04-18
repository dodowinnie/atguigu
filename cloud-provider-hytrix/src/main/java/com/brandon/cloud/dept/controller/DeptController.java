package com.brandon.cloud.dept.controller;

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

import com.brandon.cloud.api.entities.Dept;
import com.brandon.cloud.dept.service.IDeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	// 一旦调用服务方法失败并抛出错误信息，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
//	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept findById(@PathVariable("id") Long id) {
		
		Dept dept = deptService.findById(id);
		if(dept == null) {
			throw new RuntimeException("未查到相关信息，id:" + id);
		}
		return dept;
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
	
	
	public Dept processHystrix_Get(@PathVariable("id") Long id){
		Dept dept = new Dept();
		dept.setDbSource("no this database in mysql");
		dept.setDeptno(id);
		dept.setDname("没有相关信息===@HystrixCommand id：" + id);
		return dept;
	}

}
