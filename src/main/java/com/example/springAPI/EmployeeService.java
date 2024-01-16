package com.example.springAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.springAPI.constants.Sort;
import jakarta.persistence.EntityNotFoundException;
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
	
	public Employee getById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee with id: " + id + " is not found"));
	}
	
	public void postData(Employee emp) {
		repo.save(emp);
	}
	
	public void putData(Employee emp) {
		repo.save(emp);
	}
	
	public void deleteData(Long id) {
		repo.deleteById(id);
	}

	public List<Employee> sortBy(String sort) {
		List<Employee> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		switch(sort) {
			case Sort.BY_EMP_ID:
				list.sort(Comparator.comparingLong(Employee::getEmpId));
				break;
			case Sort.BY_NAME:
				list.sort(Comparator.comparing(Employee::getName));
				break;
			case Sort.BY_DEPARTMENT:
				list.sort(Comparator.comparing(Employee::getDepartment));
				break;
			case Sort.BY_SALARY:
				list.sort(Comparator.comparingDouble(Employee::getSalary));
				break;
			default:
				break;
		}

		return list;
	}

	public List<Employee> sortBySalary() {
		List<Employee> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		list.sort(Comparator.comparingDouble(Employee::getSalary));
		return list;
	}
}
