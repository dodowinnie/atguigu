package com.brandon.clou.dept.cient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.clou.dept.cient.dao.DeptDao;
import com.brandon.clou.dept.cient.service.IDeptService;
import com.brandon.cloud.api.entities.Dept;
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
