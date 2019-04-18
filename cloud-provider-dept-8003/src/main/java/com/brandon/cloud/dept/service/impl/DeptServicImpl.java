package com.brandon.cloud.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.cloud.api.entities.Dept;
import com.brandon.cloud.dept.dao.DeptDao;
import com.brandon.cloud.dept.service.IDeptService;
@Service
public class DeptServicImpl implements IDeptService{
	
	@Autowired
	private DeptDao deptDao;

	@Override
	public boolean addDept(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept findById(Long id) {
		Dept dept = deptDao.findById(id);
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}

}
