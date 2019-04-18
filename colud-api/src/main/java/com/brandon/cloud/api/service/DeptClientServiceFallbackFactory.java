package com.brandon.cloud.api.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brandon.cloud.api.entities.Dept;

import feign.hystrix.FallbackFactory;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {

			@Override
			public boolean addDept(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Dept findById(Long id) {
				// TODO Auto-generated method stub
				Dept dept = new Dept();
				dept.setDbSource("no this database in mysql");
				dept.setDeptno(id);
				dept.setDname("此刻服务信息已经停止，没有相关信息===@HystrixCommand id：" + id);
				return dept;
			}

			@Override
			public List<Dept> findAll() {
				// TODO Auto-generated method stub
				return null;
			}};
	}

}
