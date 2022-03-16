package com.example.springAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> getAll(){
		List<Employee> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}
	
	public Employee getById(int id) {
		return repo.findById(id).get();
	}
	
	public void postData(Employee emp) {
		repo.save(emp);
	}
	
	public void putData(Employee emp) {
		repo.save(emp);
	}
	
	public void deleteData(int id) {
		repo.deleteById(id);
	}

	public List<Employee> sortBySalary() {
		List<Employee> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		Collections.sort(list);
		return list;
	}
}
