package com.example.springAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;
	

	@GetMapping("/")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") int id){
		return employeeService.getById(id);
	}
	
	@PostMapping("/")
	public void postData(@RequestBody Employee emp){
		employeeService.postData(emp);
	}
	
	@PutMapping("/update/{id}")
	public void updateData(@RequestBody Employee emp){
		employeeService.putData(emp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id){
		employeeService.deleteData(id);
	}
	
	@GetMapping("/sort-by-sal")
	public List<Employee> sortBySalary(){
		return employeeService.sortBySalary();
	}
}
