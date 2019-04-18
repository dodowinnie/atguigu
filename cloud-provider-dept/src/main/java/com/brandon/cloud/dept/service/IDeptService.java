package com.brandon.cloud.dept.service;

import java.util.List;

import com.brandon.cloud.api.entities.Dept;

public interface IDeptService {

	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();

}
